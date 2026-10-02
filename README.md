<h1 style = "font-size: 16 px; font-family = Courier New, Consolas, Monaco;" >SINCELAB</h1> 

![Badge en Desarollo](https://img.shields.io/badge/STATUS-EN%20DESAROLLO-green)

## Inicializar el repositorio

Para inicializar el repositorio es **necesario** [instalar](https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Instalaci%C3%B3n-de-Git) `Git`;
al finalizar debe abrir la terminar o bash y asignar:

```bash
git --version
```

Si el proceso no da errores, la descarga fue correcta.
Luego de esto, se debe hacer el registro y configuracion de la `cuenta` de GitHub:

```bash
git config --global user.name "Tu Nombre"
git config --global user.email "tu-correo@ejemplo.com"
git config --global init.defaultBranch main
```
Al terminar el registro de la cuenta, traeremos el repositorio a nuestro dispositivo en el lugar donde queramos guardarlo:

```bash
git clone https://github.com/Jose-rade121/Sincelab.git
```

Ingresamos al proyecto con:
```bash
cd sincelab
```
Comprobamos que todo quedo bien:
```bash
git remote -v
```
<img href = "">

En caso de que el comando `remote` no muestre nada escribiremos:
```bash
git remote add origin URL
```
Si muestra una `URL` Equivocada:
```bash
git remote set-url origin URL
```




<img src="https://raw.githubusercontent.com/Mayur-Pagote/README_Design_Kit/main/public/Assets/Star%20Light%20Line.gif" width="100%">

## Estructura del proyecto

```
SINCELAB
|-src
|  |-java
|    |-ui
|     |-Header.java
|     |-MainWindow.java
|     |-PrincipalFont.java
|     |-Themes.java
|    |-Main.java
|  |-resources
|    |-fonts
|      |-Bestime.otf
|      |-Bestime.ttf
|      |-Hey_Comic.otf
|      |-Hey_Comic.ttf
|    |-icons
|      |-astronaunt-icon.png
|      |-guardado.png
|      |-icon.png
|      |-moon_black.png
|      |-moon_white.png
|-.gitignore
|-README.md
|-nb-configuration.xml
|-pom.xml
```
<img src="https://raw.githubusercontent.com/Mayur-Pagote/README_Design_Kit/main/public/Assets/Star%20Light%20Line.gif" width="100%">

![Pixel Cat](https://raw.githubusercontent.com/Mayur-Pagote/README_Design_Kit/main/public/Assets/Pixel%20Cat.gif) 
