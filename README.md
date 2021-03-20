# AREP-LAB5-Virtualizacion
# Modularización con virtualización e Introducción a Docker y a AWS

Este Laboratorio  tiene énfasis en la creación de una aplicación web usando Spark Java a través de contenedores e imágenes diseñadas y desplegadas a través de docker, que posteriormente se desplegarán en una máquina virtual creada en AWS. se crearán tres instancias, la primera ofrece un servicio de base de datos con MongoDB, la segunda ofrecerá un servicio de logService en un servicio REST y en el último se creará una aplicación que implementa un balanceo de carga del algoritmo Round Robin, delegando el procesamiento del mensaje y el retorno de la respuesta a cada instancia del servicio.

![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/1.png)

## Información del proyecto 📁

Para ver detalle del darrollo de la práctica y concepto clave, puede consultar el documento del laboratorio que se creo en latex y esta en formato pdf:

> Para abrir informe del laboratorio [click acá](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/Taller-Docker.pdf)


### Pre-requisitos 📜

* [Maven](https://maven.apache.org/install.html) 
* [Git](https://gitforwindows.org/)
* [Java](https://www.java.com/es/download/)
* [AWS](https://aws.amazon.com/es/education/awseducate/)
* [MongoDB](https://www.mongodb.com/es)

Asegúrate de tener estos programas instalados correctamente y la versión que necesitamos con los siguientes comandos:

```
mvn --version
```
```
git --version 
```
```
java -showversion 
```
### Instalación 💿

1. Clonar el repositorio

```
git https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion.git
```

### Implementación
#### Contrucción  de imagen en Docker
##### creación de imagen logservice

![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/imagen-logservice.png)

##### creación de imagen logservice

![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/imagen-roundrobi.png)

##### verificación de imagen construida

![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/imagen-logservice-roundrobin.png)

##### contenedor dorcker enlazada a un puerto físico

> Logservice
![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/contenedorlogservice.png)

> roundrobin
![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/contenedor-roundrobin.png)

##### verificación contenedor corriendo

![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/contenedorlogservice-Run.png)

##### Creando referencia de imagen con el repositorio 

> logservice

![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/dockersubidologservice-repo.png)

> roundrobin

![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/dockersubidoroundrobin-repo.png)

##### Subiendo imagenes docker al repositorio 

> logservice

![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/dockersubidologservice-repo-push.png)

> docker hub logservice
![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/dockersubidologservice-repo-2.png)

> roundrobin

![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/dockersubidoroundrobin-repo-push.png)

> docker hub roundrobin 
![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/dockersubidoroundrobin-repo-2.png)

### Despliegue en ASW

#### inicio de maquina ASW por SSH en Windows
Para porder usar SSH en Windows, para ingresar a la maquina de ASW, debe utilizar PowerShell y ejecutar los siguinetes comandos:
> $path = ".\<llave privada de la maquina en Asw>"
##### Restablecer para eliminar permisos explícitos
> icacls.exe $path /reset
##### Dar permiso de lectura explícito al usuario actual
> icacls.exe $path /GRANT:R "$($env:USERNAME):(R)"
##### Deshabilite la herencia y elimine los permisos heredados
> icacls.exe $path /inheritance:r

![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/SSH-powershell.png)

#### conectando a la instancia AWS

![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/accediendo-AWS.png)

#### instacia de un contenedor docker

> logservice
![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/ASW-instanciadocker-logservice.png)

> roundrobin

![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/ASW-instanciadocker-roundrobin.png)

#### Resultado de la  pagina

![](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/img/Captura.PNG)

## Construido con 🛠️

* [Maven](https://maven.apache.org/install.html) 
* [Git](https://gitforwindows.org/)
* [Java](https://www.java.com/es/download/)
* [AWS](https://aws.amazon.com/es/education/awseducate/)
* [MongoDB](https://www.mongodb.com/es)


## Autor ✒️

* Paula Andrea Guevara Sánchez

## Licencia 📄

Este proyecto está bajo la Licencia GNU General Public License - [LICENSE](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/LICENSE.md) 
