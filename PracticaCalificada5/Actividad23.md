# Actividad 23
## **Pruebas de aceptación automatizadas**

**Introducción a las pruebas de aceptación (UAT)**

## **Instalación y uso del Docker registry**

**Instalación de un registro Docker**

**Registro Docker basado en la nube**

**Docker Hub**

Docker Hub está alojado en la nube, por lo que todo lo que se necesita hacer es crear una cuenta de Docker Hub, de la siguiente manera:

1. Abrir https://hub.docker.com/ en un navegador.
>>[![image.png](https://i.postimg.cc/63gR4xBg/image.png)](https://postimg.cc/yghW25gy)
2. En Sign Up, completar la contraseña, la dirección de correo electrónico y el identificador (ID) de Docker.
>>[![image.png](https://i.postimg.cc/qqHqdJJJ/image.png)](https://postimg.cc/qhQ4sd6S)
3. Después de recibir un correo electrónico y hacer clic en el enlace de activación, se crea una
cuenta.
>>[![image.png](https://i.postimg.cc/x1pKVzW9/image.png)](https://postimg.cc/Hr5JQVYN)

Nuestra cuenta ha sido creada con éxito

**Docker registry hospedado**

**Instalación de la aplicación de Docker registry**

Para iniciar el docker registry, ejecutaremos el
siguiente comando:

`sudo docker run -d -p 5000:5000 --restart=always --name registry registry:2 
`
[![image.png](https://i.postimg.cc/bJwSgbPX/image.png)](https://postimg.cc/f31bTVk5)


**Agregar un certificado de dominio**

`sudo docker run -d -p 443:443 --restart=always --name registry -v `pwd`/certs:/certs -e REGISTRY_HTTP_ADDR=0.0.0.0:443 -e REGISTRY_HTTP_TLS_CERTIFICATE=/certs/domain.crt -e REGISTRY_HTTP_TLS_KEY=/certs/domain.key registry:2`

[![image.png](https://i.postimg.cc/mgdPDkM8/image.png)](https://postimg.cc/18qm79vq)

**Agregar una restricción de acceso**

Creamos un usuario con una contraseña utilizando la herramienta htpasswd de la imagen del registro:

`mkdir auth`

`sudo docker run --entrypoint htpasswd httpd:2 -Bbn dagmarlezama aea > auth/htpasswd`

[![image.png](https://i.postimg.cc/q701kms8/image.png)](https://postimg.cc/0zWYn0HQ)

 Ejecutamos el registro con ese usuario autorizado para acceder a él, así: 
 

 `sudo docker run -d -p 443:443 --restart=always --name registry -v `pwd`/auth:/auth -e "REGISTRY_AUTH=htpasswd" -e "REGISTRY_AUTH_HTPASSWD_REALM=Registry Realm" -e REGISTRY_AUTH_HTPASSWD_PATH=/auth/passwords -v `pwd`/certs:/certs -e REGISTRY_HTTP_TLS_CERTIFICATE=/certs/domain.crt -e REGISTRY_HTTP_TLS_KEY=/certs/domain.key registry:2 `


[![image.png](https://i.postimg.cc/DZ0dZR8b/image.png)](https://postimg.cc/34MDfSjK)

*Nota: Es importante ir eliminando los contenedres previamente creados para evitar generar un error por el  nombre reusado*


**Uso del Docker registry**

**Construyendo una imagen**

Construiremos una imagen con Ubuntu y el intérprete de Python instalado. Creamos un nuevo directorio para crear un Dockerfile, de la siguiente manera: 
```
FROM ubuntu:20.04 
RUN apt-get update && \ 
apt-get install -y python 
```

Y para construir la imagen, usamos el siguiente comando:
`docker build -t ubuntu_with_python . `

[![image.png](https://i.postimg.cc/tgyssd83/image.png)](https://postimg.cc/G47LNDLt)

**Realizando un pushing de la imagen en el registro**

 Como tenemos configurada la restricción de acceso, primero debemos dar autorización mediante: ` sudo docker login --username dagmarlezama --password <password>`

 Y almacenamos la imagen en el registro usando el comando push: `sudo docker push dagmarlezama/ubuntu_with_python:1`

[![image.png](https://i.postimg.cc/7LfSHnzK/image.png)](https://postimg.cc/NyvKbTpX)

A continuación se muestra que el push fue exitoso

[![image.png](https://i.postimg.cc/63xVMG7z/image.png)](https://postimg.cc/7CXT6hnT)

**Realizamos un pulling de la imagen del registro**

Para demostrar cómo funciona el registro, eliminamos la imagen localmente y la recuperaremos del registro, así:
`docker rmi ubuntu_with_python dagmarlezama/ubuntu_with_python:1`

[![image.png](https://i.postimg.cc/FswxYq92/image.png)](https://postimg.cc/56qzGsQ3)

Podemos ver que la imagen ha sido eliminada usando el comando `sudo docker images`. 

[![image.png](https://i.postimg.cc/dVHwR8fP/image.png)](https://postimg.cc/jD7ptJKZ)

Luego, recuperemos la imagen del registro ejecutando lo siguiente: `docker pull dagmarlezama/ubuntu_with_python:1`

[![image.png](https://i.postimg.cc/43sFWdY6/image.png)](https://postimg.cc/219w6CFy)

Y vemos que al probar `sudo docker images` se ha descargado correctamente la imagen:

[![image.png](https://i.postimg.cc/d3syfb8S/image.png)](https://postimg.cc/k6HG6hYx)

## **Pruebas de aceptación en el pipeline de Jenkins**

**La etapa de construcción de Docker**

**Agregar un archivo Docker**

Creamos un Dockerfile en el directorio raíz del proyecto calculadora, de la siguiente manera:
```
FROM openjdk:11-jre
COPY build/libs/calculador-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
```

Ahora vamos a comprobar si la
aplicación se compila y se ejecuta ejecutando lo siguiente:

`./gradlew build`

`docker build -t calculador .`

`docker run -p 8080:8080 --name calculador calculador`

[![image.png](https://i.postimg.cc/hGXC2PTv/image.png)](https://postimg.cc/DWKdZhC3)

[![image.png](https://i.postimg.cc/wvcDVSf3/image.png)](https://postimg.cc/gXjwcBPP)

[![image.png](https://i.postimg.cc/pXynhhHm/image.png)](https://postimg.cc/cryJPJ6W)

Deberíamos poder abrir el navegador en http://localhost:8080/sum?a=1&b=2 y ver 3 como resultado, tal como se muestra:

[![image.png](https://i.postimg.cc/vmX08xy0/image.png)](https://postimg.cc/4K76Bdmc)

También podemos revisarlo así

[![image.png](https://i.postimg.cc/t4b0YP0b/image.png)](https://postimg.cc/crFkzv4k)

**Agregar la compilación de Docker al pipeline**

Agregando la etapa Docker build al Jenkinsfile de nuestro proyecto:

[![image.png](https://i.postimg.cc/9MdZXvyC/image.png)](https://postimg.cc/62QyYbHm)


**La etapa push de Docker**

Cuando la imagen esté lista, podemos almacenarla en el registro mediante lo siguiente

[![image.png](https://i.postimg.cc/6qTWbZWg/image.png)](https://postimg.cc/QKGZHHWJ)

Al subir el commit, el Jenkins lo detecta e inicia la construcción del pipeline, pero este termina resultando en error:

[![image.png](https://i.postimg.cc/sXbj8XM2/image.png)](https://postimg.cc/phYM5PYN)



Ya que estamos usando Jenkins como un contenedor de Docker, tenemos que asegurarnos de que el contenedor de Jenkins tenga el daemon de Docker instalado y que tenga acceso a la socket de Docker del host. Esto se puede hacer añadiendo las opciones -v /var/run/docker.sock:/var/run/docker.sock y -v /usr/bin/docker:/usr/bin/docker al comando docker run que se utiliza para iniciar el contenedor de Jenkins.

Para ello levanté otro contenedor de Jenkins, utilizando el comando docker run del siguiente modo:

`docker run -p 9090:8080 -p 50000:50000 -v /var/run/docker.sock:/var/run/docker.sock -v /usr/bin/docker:/usr/bin/docker jenkins/jenkins:lts`

Tras esto, nos guiaremos de lo siguiente:
https://medium.com/igorgsousa-tech/docker-in-docker-with-jenkins-permission-problem-637f45549947

Ahora, si reiniciamos nuestro contenedor, tendrá suficientes permisos para acceder a /var/run/docker.sock, lo que le permitirá usar el motor docker del host.

Finalmente solo tendríamos que dar las credenciales dentro de la consola del contenedor de jenkins para que acceda.

Así la construcción resultará correcta:

[![image.png](https://i.postimg.cc/T326tmt9/image.png)](https://postimg.cc/jL1m5W0w)

**La etapa de prueba de aceptación**

**Adición de una implementación provisional al pipeline**

Agregamos una etapa para ejecutar el contenedor de calculador, de la siguiente manera:

[![image.png](https://i.postimg.cc/50R5sc1q/image.png)](https://postimg.cc/LYjZsbJn)

Al detectar el commit, jenkins inicia la construcción del pipeline calculador y gracias a lo configurado previamente, la construcción resulta exitosa.

[![image.png](https://i.postimg.cc/x1nT8tb9/image.png)](https://postimg.cc/vc2dS7zK)

[![image.png](https://i.postimg.cc/VvGLdHdJ/image.png)](https://postimg.cc/0KSq4nGv)

**Agregar una prueba de aceptación al pipeline**

En el directorio raíz del proyecto, vamos a crear un archivo accept_test.sh, de la siguiente manera:

```
#!/bin/bash
test $(curl localhost:8765/sum?a=1\&b=2) -eq 3
```

Para hacer la construcción debemos eliminar el contenedor previamente creado porque sino, al construir nuevamente, se generará el error (esto sucede porque aun no añadimos la adición de la etapa de limpieza)

*Conflict. The container name "/calculador" is already in use by container* 


Agregamos una etapa Acceptance test de la siguiente manera:

[![image.png](https://i.postimg.cc/BnJmDBmq/image.png)](https://postimg.cc/jLk6YPV9)

Al realizar el commit, veremos que la construcción resulta exitosa:

[![image.png](https://i.postimg.cc/sxd7XxGB/image.png)](https://postimg.cc/KkfRpZNF)


**Adición de un entorno de etapa de limpieza** 

Para evitar el eliminar manualmente cuando queremos realizar otra construcción, añadimos la siguiente etapa el Jenkinsfile:

[![image.png](https://i.postimg.cc/cJ2qjyP1/image.png)](https://postimg.cc/hJL3zwSN)

Vemos que la construcción resultará exitosa:

[![image.png](https://i.postimg.cc/R0DRLvyd/image.png)](https://postimg.cc/VSXnYPY0)

## **Escribir pruebas orientadas al usuario**

**Uso de frameworks de pruebas de aceptación**

1. Crea criterios de aceptación

>>[![image.png](https://i.postimg.cc/CxFVfp3d/image.png)](https://postimg.cc/tYmcLwCH)

2. Crea definiciones de pasos

>>[![image.png](https://i.postimg.cc/gJJhc0qp/image.png)](https://postimg.cc/t1KJ2pMv)

3. Ejecución de una prueba de aceptación automatizada

>1. Agrega las librerías de Java Cucumber. En el archivo build.gradle, agrega el siguiente código a la
sección de dependencies:

>>[![image.png](https://i.postimg.cc/sDJYsb53/image.png)](https://postimg.cc/w77ykfWr)

>2. Agrega el objetivo de Gradle. En el mismo archivo, agrega el siguiente código:
>>[![image.png](https://i.postimg.cc/JzYD68Cd/image.png)](https://postimg.cc/DSsw0tZq)

>3. Agrega un JUnit Test Runner, agrega un nuevo archivo,
src/test/java/acceptance/AcceptanceTest.java, de la siguiente manera:

>>[![image.png](https://i.postimg.cc/0j7DFB0K/image.png)](https://postimg.cc/4HNYhwMX)

Luego de esta configuración, si el servidor se está ejecutando en el host local, podemos probarlo
ejecutando el siguiente código:

[![image.png](https://i.postimg.cc/QCVg4RQJ/image.png)](https://postimg.cc/kR3tDYh2)

Ahora podríamos agregar este comando en lugar de accept_test.sh. Esto haría que la prueba de aceptación de Cucumber se vaya a ejecutar en el pipeline de Jenkins.

[![image.png](https://i.postimg.cc/76hcznYC/image.png)](https://postimg.cc/VryDQMt1)

Tras varios errores, finalmente se logró realizar una construcción exitosa del pipeline:

[![image.png](https://i.postimg.cc/mkwXZxm9/image.png)](https://postimg.cc/FkYgG65F)

Aquí se muestra el console output, así verificamos que si se construyo correctamente:

[![image.png](https://i.postimg.cc/pTHnWfrm/image.png)](https://postimg.cc/yJLNnSFK)

*Nota: El problema fue solucionado al configurar correctamente el agente de Docker en Jenkins y hacer que este agente sea el indicado de realizar la construcción*


