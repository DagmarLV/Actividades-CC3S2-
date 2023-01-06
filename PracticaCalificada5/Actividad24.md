# Actividad 24
## **Clustering con Kubernetes**
**Instalación de Kubernetes**

**Cliente de Kubernetes**

Seguiremos los pasos de https://kubernetes.io/docs/tasks/tools/ para nuestro sistema operativo correspondiente
1. Descargamos la última versión con el comando:

>>`curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"`

2. Como validar el binario es opcional, procedemos con la instalación:

>>`sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl`

3. Probar para asegurarsnos de que la versión que se instaló esté actualizada:
>>`kubectl version --client`

>>[![image.png](https://i.postimg.cc/HsCtPXqF/image.png)](https://postimg.cc/fkBXVtTv)

>>Así vemos que tenemos la versión 4.5.7

**Servidor de Kubernetes**

**minikube**

Tras haber instalado minikube según los pasos proporcionados en https://minikube.sigs.k8s.io/docs/start/ para nuestro sistema operativo, podremos iniciar nuestro clúster de Kubernetes con el siguiente comando:

`minikube start`

[![image.png](https://i.postimg.cc/kGMWqv75/image.png)](https://postimg.cc/wyP1kJyK)

**Verificación de la configuración de Kubernetes**

`kubectl cluster-info`

[![image.png](https://i.postimg.cc/15k4KrbN/image.png)](https://postimg.cc/6yh9WnW9)

**Uso de Kubernetes**

**Implementación de una aplicación**

Para iniciar un contenedor Docker en Kubernetes, debemos preparar una configuración de implementación como un archivo YAML. Llamémoslo deployment.yaml


Para instalar la implementación, ejecuta el siguiente comando:

`kubectl apply -f deployment.yaml`

[![image.png](https://i.postimg.cc/5txzwmFS/image.png)](https://postimg.cc/5XRjJLgX)

Puedes verificar que se hayan creado los tres Pods, cada uno con un contenedor Docker:

`kubectl get pods`

[![image.png](https://i.postimg.cc/B6z1f97m/image.png)](https://postimg.cc/YG1SQVHF)


Cada Pod ejecuta un contenedor Docker. Podemos verificar sus registros usando el siguiente comando:

`kubectl logs pods/calculador-deployment-d6c58d594-f5ctp`

[![image.png](https://i.postimg.cc/4NkQYVwB/image.png)](https://postimg.cc/grsZ5wCZ)


Debería ver el familiar logotipo de Spring y los registros del servicio web Calculador.

**Implementación de un servicio de Kubernetes**

Llamémoslo service.yaml :

[![image.png](https://i.postimg.cc/V6K2Y4XG/image.png)](https://postimg.cc/k6tTsQ1K)



Para instalar el servicio, ejecute el siguiente comando:

`kubectl apply -f service.yaml`

[![image.png](https://i.postimg.cc/nhn5Q6TR/image.png)](https://postimg.cc/PPFKgVgY)

Luego puedes verificar que el servicio se implementa correctamente ejecutando el siguiente comando:

`kubectl get service calculador-service`

[![image.png](https://i.postimg.cc/wxh0cw1S/image.png)](https://postimg.cc/jCSHRQQX)

Para verificar que el servicio apunte a las tres réplicas de Pod que creamos en la sección anterior, ejecute
el siguiente comando:
`kubectl describe service calculador-service | grep Endpoints`

[![image.png](https://i.postimg.cc/gcqH6r5p/image.png)](https://postimg.cc/6Tqvk6tb)


**Exponiendo una aplicación**

Al volver a usar el comando `kubectl get service calculador-service` podemos ver que se seleccionó el puerto 31076 como puerto de nodo.
Y al usar el comando `minikube ip`, podemos obtener la  dirección IP del nodo en el que está ejecutando Minikube, nuestro nodo de Kubernetes 


[![image.png](https://i.postimg.cc/L6gf3XQh/image.png)](https://postimg.cc/D8F822TK)


Ahora para verificar que si podemos acceder a Calculador desde el exterior, tenemos que tener en cuenta ambos puertos mostrados, ya que la ruta sera de la forma: http://[dirección IP de Minikube]:[puerto expuesto] en la barra de direcciónes

`curl 192.168.59.100:31076/sum?a=1\&b=2`

[![image.png](https://i.postimg.cc/dVsFKWkC/image.png)](https://postimg.cc/9rnKdYBX)

Hicimos una solicitud HTTP a una de nuestras instancias de contenedor de Calculador y devolvió la
respuesta correcta, lo que significa que implementamos con éxito la aplicación en Kubernetes.
El comando kubectl ofrece un atajo para crear un servicio sin usar YAML. En lugar de la configuración
que usamos, podría ejecutar el siguiente comando:

$ kubectl expose deployment calculador-deployment --type=NodePort --name=calculador-service

## **Kubernetes avanzado**

**Escalar una aplicación**

Escalaremos la implementación Calculador a 5 instancias mediante:
`kubectl scale --replicas 5 deployment calculador-deployment`

Y podremos verificar la ampliación mediante: `kubectl get pods`

[![image.png](https://i.postimg.cc/W1zNQ2Hr/image.png)](https://postimg.cc/BjWfFGsQ)

**Actualización de una aplicación**

Haremos un cambio en deployment.yaml y agregaremos una nueva etiqueta a la plantilla Pod:

[![image.png](https://i.postimg.cc/DZSFM5pT/image.png)](https://postimg.cc/YGBJ4Nwn)

Ahora bien, si repetimos esto y aplicamos el mismo deployment, podemos observar lo que sucede con los
Pods:
Aplicando la configuración y verificando que Kubernetes finalizó los Pods antiguos y comenzó los nuevos:

`kubectl apply -f deployment.yaml `
`kubectl get pods`
[![image.png](https://i.postimg.cc/MGbjGZzT/image.png)](https://postimg.cc/QBCM439G)

**Actualizaciones continuas**

Modificando el deployment.yaml :

[![image.png](https://i.postimg.cc/Qdcqp3XL/image.png)](https://postimg.cc/4YNtgj7w)

Ya podemos aplicar el deployment y observar que los Pods se van actualizando uno a uno:

`kubectl apply -f deployment.yaml`
`kubectl get pods`

[![image.png](https://i.postimg.cc/wxJPwSxV/image.png)](https://postimg.cc/Yjrb9DWG)

Ahora realizaremos la limpieza para eliminar todos los recursos que creamos. Así eliminaremos el servicio y la
implementación que creamos:

`kubectl delete -f service.yaml`
`kubectl delete -f deployment.yaml`

[![image.png](https://i.postimg.cc/FK8WZx28/image.png)](https://postimg.cc/jW64qyq4)

**Dependencias de la aplicación**

**La resolución DNS de Kubernetes**

En el caso de la aplicación Calculador, necesitamos
Deployment y Services. Definiremos ambos en un archivo, hazelcast.yaml

[![image.png](https://i.postimg.cc/qvtHTrPC/image.png)](https://postimg.cc/mPG5Yv2b)

Ahora definiremos la configuración de Hazelcast mediante 

ERROR 

Tras este puto errore de mieradkjjfasf 
Decidí probar kind en lugar de minikube para levantar el cluster de kubernetes
[![image.png](https://i.postimg.cc/XJrvzwFZ/image.png)](https://postimg.cc/8JVDFfZD)

Así al aplicar, `sudo kubectl apply -f hazelcast.yaml`

[![image.png](https://i.postimg.cc/hvFKZNcw/image.png)](https://postimg.cc/5Y3c67Hq)

Ahora podemos verificar sus registros de Pod con el comando `sudo kubectl logs <NAME>`.

[![image.png](https://i.postimg.cc/x8bccK1r/image.png)](https://postimg.cc/5QbxrQzp)


**Descripción general del sistema multiaplicación**

**Implementación del sistema multiaplicación**

1. Agrega la librería del cliente Hazelcast a Gradle.

[![image.png](https://i.postimg.cc/8kLkwx8B/image.png)](https://postimg.cc/dDtKVHVL)

2. Agrega la configuración de caché de Hazelcast.

[![image.png](https://i.postimg.cc/htDGVFCP/image.png)](https://postimg.cc/6yPwNPJD)

También debemos eliminar la prueba de contexto de Spring creada automáticamente por Spring, src\test\java\com\checha\calculador\CalculadorApplicationTests.Java


3. Agrega el almacenamiento en caché de Spring Boot.

[![image.png](https://i.postimg.cc/9XLgcZv8/image.png)](https://postimg.cc/bd29TDYk)


4. Crea una imagen de Docker.

Ahora, podemos reconstruir la aplicación Calculador y la imagen de Docker con una nueva etiqueta.
Luego, lo enviaremos a Docker Hub una vez más:

./gradlew build

[![image.png](https://i.postimg.cc/x1KYq6Gy/image.png)](https://postimg.cc/CRL9QHQz)

docker build -t dagmarlezama/calculador:caching .

[![image.png](https://i.postimg.cc/vDFksdKR/image.png)](https://postimg.cc/2LG2QgmT)

docker push dagmarlezama/calculador:caching

[![image.png](https://i.postimg.cc/rwJVQhdy/image.png)](https://postimg.cc/VJJPNWB2)

**Pruebas del sistema multiaplicación**

Debes modificar la imagen en el archivo deployment.yaml:
image: checha/calculador:caching

Luego, aplica la implementación y el servicio de Calculador:

`sudo kubectl apply -f deployment.yaml`

`sudo kubectl apply -f service.yaml`

[![image.png](https://i.postimg.cc/L8ff5F0C/image.png)](https://postimg.cc/Mn6X3NwV)

Repitamos la operación curl que hicimos antes.
En este caso, como cambiamos a utilizar de minikube a kind, obtendremos los valores de la dirección del nodo y del puerto mediante los comandos:

`sudo kubectl get service calculador-service` 

`sudo kubectl get nodes -o jsonpath='{ $.items[*].status.addresses[?(@.type=="InternalIP")].address }'`

Así usaremos el siguiente comando
`curl 172.19.0.2:30232/sum?a=1\&b=2` y obtendremos un 3

[![image.png](https://i.postimg.cc/DZV2xmQF/image.png)](https://postimg.cc/SXrFsStt)

