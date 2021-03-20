# AREP-LAB5-Virtualizacion
# Taller de de modularización con virtualización e Introducción a Docker y a AWS

En este taller que se desarrolla durante este documento tiene énfasis en la creación de una aplicación web usando
Spark Java a través de contenedores e imágenes diseñadas y desplegadas a través de docker, que posteriormente se desplegarán
en una máquina virtual creada en AWS. se crearán tres instancias, la primera ofrece un servicio de base de datos con MongoDB, la segunda ofrecerá un servicio de logService
en un servicio REST y en el último se creará una aplicación que implementa un balanceo de carga del algoritmo Round Robin, delegando el procesamiento del mensaje y el retorno
de la respuesta a cada instancia del servicio.

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

2. Compila el proyecto:


 
4. Documentación JavaDoc
 
> > POR TERMINAL DE COMANDOS

```
mvn javadoc:javadoc
```
> En Repositorio

[Apidocs](https://github.com/PaulaSanchez810/Lab2-AREP-Heroku/tree/master/site/apidocs)
## Ejecutando las pruebas ✅

> POR TERMINAL DE COMANDOS

```
mvn test
```

## Construido con 🛠️

* [Maven](https://maven.apache.org/install.html) 
* [Git](https://gitforwindows.org/)
* [Java](https://www.java.com/es/download/)
* [AWS](https://aws.amazon.com/es/education/awseducate/)
* [MongoDB](https://www.mongodb.com/es


## Autor ✒️

* Paula Andrea Guevara Sánchez

## Licencia 📄

Este proyecto está bajo la Licencia GNU General Public License - [LICENSE](https://github.com/PaulaSanchez810/AREP-LAB5-Virtualizacion/blob/master/LICENSE.md) 
