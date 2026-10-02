#!/usr/bin/env python3
"""Regenera el árbol de carpetas dentro del README.md.

Reemplaza todo lo que haya entre los marcadores:
<!-- TREE:START --> y <!-- TREE:END -->
"""
import re
from pathlib import Path

# Carpetas que no quieres que aparezcan en el árbol
IGNORE = {".git", ".github", "target", "nbproject", "build", "dist",
          ".idea", ".vscode", "node_modules"}

START = "<!-- TREE:START -->"
END = "<!-- TREE:END -->"


def build(path: Path, prefix: str = "") -> list[str]:
    # Primero carpetas, luego archivos, ambos en orden alfabético
    entries = sorted(
        (p for p in path.iterdir() if p.name not in IGNORE),
        key=lambda p: (p.is_file(), p.name.lower()),
    )
    lines = []
    for i, p in enumerate(entries):
        last = i == len(entries) - 1
        branch = "└── " if last else "├── "
        lines.append(f"{prefix}{branch}{p.name}{'/' if p.is_dir() else ''}")
        if p.is_dir():
            lines += build(p, prefix + ("    " if last else "│   "))
    return lines


root = Path(".")
tree = "```text\n" + root.resolve().name + "/\n" + "\n".join(build(root)) + "\n```"

readme = Path("README.md")
text = readme.read_text(encoding="utf-8")

pattern = re.compile(re.escape(START) + r".*?" + re.escape(END), re.S)
if not pattern.search(text):
    raise SystemExit("No se encontraron los marcadores TREE:START / TREE:END en el README.")

new_text = pattern.sub(lambda m: f"{START}\n{tree}\n{END}", text)

if new_text != text:
    readme.write_text(new_text, encoding="utf-8")
    print("Árbol actualizado.")
else:
    print("Sin cambios.")
