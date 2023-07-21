# spring_boot_basic

This is a repository created with the purpose of teaching basic practices on spring



## Comenzando 🚀

Se debe seguir los siguientes pasos para obtener una copia del proyecto.

```
    1. git clone git@github.com:fdyrepositorios/yuugen-infrastructure.git
```

Mira **Despliegue** para conocer como desplegar el proyecto.

Contenido del proyecto

```
    1. Application: template base para balanceadores de carga

```

### Pre-requisitos 📋

Se debe tener las siguientes herramientas para usar el sofwate

```
    IntelliJ IDEA Community Edition
    Java 11
    Docker 24.0.2
```

## Despliegue 📦

Se debe realizar el siguiente proceso:

* Compilacion Codigo fuente

```sh
mvn clean package
```

* Compilacion Imagen docker

```sh
docker build -t fdymendo_spring_boot_basic:v1 .
```

* Ejecucion

```sh
docker run --name fdymendo_spring_boot_basic --rm -p 8080:8080 -d fdymendo_spring_boot_basic:v1
```

* Detener

```sh
docker stop fdymendo_spring_boot_basic
```

