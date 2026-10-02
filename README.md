<h1 style = "font-size: 16 px; font-family = Courier New, Consolas, Monaco;" >SINCELAB</h1> 

![Badge en Desarollo](https://img.shields.io/badge/STATUS-EN%20DESAROLLO-green)

<img src="https://raw.githubusercontent.com/Mayur-Pagote/README_Design_Kit/main/public/Assets/Star%20Light%20Line.gif" width="100%">

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
<img src = "src/main/resources/sincelab/assets/repo_images/GIT _REMOTE.PNG" width = 100%>

En caso de que el comando `remote` no muestre nada escribiremos:
```bash
git remote add origin URL
```
Si muestra una `URL` Equivocada:
```bash
git remote set-url origin URL
```

<img src="https://raw.githubusercontent.com/Mayur-Pagote/README_Design_Kit/main/public/Assets/Star%20Light%20Line.gif" width="100%">

## Añadir cambios al proyecto

### Terminal:

```bash
git status  #Que nuevos cambios hay
```
<img src = "src/main/resources/sincelab/assets/repo_images/GIT_STATUS.PNG" width = 100%>

---

```bash
git add .   #Prepara los cambios
```

```bash
git commit -m "Descripcion de los cambios"
```
<img src = "src/main/resources/sincelab/assets/repo_images/GIT_ADD_COMMIT.PNG" width = 100%>

---

```bash
git push    #Envia a GitHub
```
<img src = "src/main/resources/sincelab/assets/repo_images/GIT_PUSH.PNG" width = 100%>

---

```bash
git pull    #Trae los nuevos cambios
```
<img src = "src/main/resources/sincelab/assets/repo_images/GIT_PUSH.PNG" width = 100%>


#### Flujo de trabajo:
```bash
git pull    #Trae los nuevos cambios
git status  #Que nuevos cambios hay
git add .   #Prepara los cambios
git commit -m "Descripcion de los cambios"
git push    #Envia a GitHub
```


<img src="https://raw.githubusercontent.com/Mayur-Pagote/README_Design_Kit/main/public/Assets/Star%20Light%20Line.gif" width="100%">

## Estructura del proyecto

<!-- TREE:START -->
```text
Sincelab/
├── src/
│   └── main/
│       ├── java/
│       │   └── sincelab/
│       │       ├── storage/
│       │       │   ├── FolderCreate.java
│       │       │   └── Users.java
│       │       ├── ui/
│       │       │   ├── AboutWindow.java
│       │       │   ├── Header.java
│       │       │   ├── MainWindow.java
│       │       │   ├── PrincipalFont.java
│       │       │   ├── Themed.java
│       │       │   └── Themes.java
│       │       └── Main.java
│       └── resources/
│           └── sincelab/
│               └── assets/
│                   ├── fonts/
│                   │   ├── Bestime.otf
│                   │   ├── Bestime.ttf
│                   │   ├── Hey_Comic.otf
│                   │   └── Hey_Comic.ttf
│                   ├── icons/
│                   │   ├── astronaunt-icon.png
│                   │   ├── guardado.png
│                   │   ├── icon.png
│                   │   ├── moon_black.png
│                   │   └── moon_white.png
│                   └── repo_images/
│                       ├── GIT _REMOTE.PNG
│                       ├── GIT_ADD_COMMIT.PNG
│                       ├── GIT_PULL.PNG
│                       ├── GIT_PUSH.PNG
│                       └── GIT_STATUS.PNG
├── .gitignore
├── nb-configuration.xml
├── pom.xml
└── README.md
```
<!-- TREE:END -->

<img src="https://raw.githubusercontent.com/Mayur-Pagote/README_Design_Kit/main/public/Assets/Star%20Light%20Line.gif" width="100%">

![Pixel Cat](https://raw.githubusercontent.com/Mayur-Pagote/README_Design_Kit/main/public/Assets/Pixel%20Cat.gif) 
