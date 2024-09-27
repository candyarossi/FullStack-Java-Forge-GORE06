# GIT vs GITHUB

`Git` es un sistema de control de versiones que permite gestionar y realizar un seguimiento de los cambios en tu código de forma local.

`GitHub` es una plataforma que permite almacenar repositorios Git en la nube. Ofrece herramientas para colaborar, gestionar proyectos y compartir código con otros desarrolladores.

## INSTALACIÓN

- **Windows**: Descarga e instala desde [git-scm.com](https://git-scm.com/download/win).
- **macOS**: Usa Homebrew: `brew install git`.
- **Linux**: Usa tu gestor de paquetes, por ejemplo: `sudo apt install git`.

### USANDO LA TERMINAL

- `LS`: Sirve para ver el contenido de una carpeta.
- `CD`: Sirve para entrar en una carpeta o salir de ella (CD ..).
- `TOUCH`: Sirve para crear archivos.
- `MKDIR`: Con este comando crearás una carpeta nueva.
- `RM`: Es el comando para eliminar un archivo. Recuerda que no irá a la Papelera, así que piensa muy bien antes de borrar algo. Y para eliminar carpeta usa el comando `RM -RF`.
- `CLEAR`: Limpia la consola.
- `EXIT`: Cierra la ventana de la línea de comandos o símbolo del sistema.

## GIT BASH

Para verificar que Git se haya instalado correctamente vamos a abrir **Git Bash** y utilizar el comando:

```bash
git --version
```

Luego debemos configurar nuestra identidad. Para esto, recomendamos utilizar tu nombre de usuario y correo electrónico con el que te registraste en **Github**, ya que esos son los datos que aparecerán como los de "autor" del código:

```bash
git config --global user.name "TuNombre"
git config --global user.email tuemail@example.com
```

Podemos comprobar si se guardo correctamente de esta forma:

```bash
git config --list
```

```bash
git config user.name
```

```bash
git config user.email
```

Si necesitas consultar el manual de Git lo podes hacer utilizando los comandos:

```bash
git help config
```

```bash
git config --help
```

### Creamos un repositorio en Github

1. Inicia sesión en tu cuenta de GitHub.
2. Haz clic en el botón "+" en la esquina superior derecha y selecciona "New repository".
3. Dale un nombre a tu repositorio y, opcionalmente, una descripción.
4. Elige si quieres que sea 'público' o 'privado'. Para hacer las entregas de las tareas Core, selecciona la opción 'público'.
5. Haz clic en "Create repository".

### Primera subida de archivos

Para inicializar un repositorio, accedemos a su directorio contenedor y usamos:

```bash
git init
```

> Este comando creará un archivo oculto `.git` donde se guardarán las versiones de nuestro proyecto.

Para agregar archivos al repositorio, usamos:

```bash
git add .
```

Para realizar un commit generando una nueva versión del proyecto, usamos:

```bash
git commit -m "Descripción de los cambios realizados"
```

Para ver el estado del repositorio, en cualquier momento, podemos usar:

```bash
git status
```

Si necesitamos ver el historial de cambios/commits:

```bash
git log --oneline
```

Una vez que hayas hecho commits, debemos enlazar el repositorio local con el remoto (el de Github) con este comando:

```bash
git remote add origin https://github.com/tuusuario/tu-repositorio.git
```

Y sube tus cambios a GitHub utilizando:

```bash
git push -u origin main/master
```

> **Nota**: Asegúrate de que la rama `main` sea la correcta (puede ser `master` u otra, dependiendo de la configuración).

### Actualizar contenido de un repositorio

1. `git add .`
2. `git commit -m "Mensaje descriptivo"`
3. `git push`

### Borrar un repositorio

En Github se borran los repositorios mediante su pestaña _Settings_.

Pero si quisieramos borrar el historial de versiones de un repositorio en nuestra computadora, deberíamos borrar el directorio `.git` que lo guarda.

```bash
rm -rf .git
```

### Clonar un repositorio

En la terminal, usa el siguiente comando para clonar el repositorio:

```bash
git clone https://github.com/tuusuario/tu-repositorio.git
```
