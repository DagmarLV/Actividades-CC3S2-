# Examen Final - Parte 2

### Responde e implementa cada una de las siguientes preguntas relacionadas a las actividades desarrolladas en clase. (para puntuar debes responder todas las preguntas).

1. **(0.5 puntos ) Ejecuta CouchDB como un contenedor de Docker y publica su puerto, de la siguiente manera: <br>
a. Ejecuta el contenedor.<br>
b. Publica el puerto de CouchDB.<br>
c. Abre el navegador y verifica que CouchDB esté disponible**
>>> Para esto, primero buscaremos la imagen de CouchDB mediante el comando `sudo docker search CouchDB`. 

>>>[![image.png](https://i.postimg.cc/Y9bP9tRr/image.png)](https://postimg.cc/3401f5zV)


>>>Al encontrarlo, tras conocer qué puerto es el que usa, podremos aplicar el comando `sudo docker run -e COUCHDB_USER=admin -e COUCHDB_PASSWORD=password -d -p 5984:5984 couchdb` que ejecuta el contenedor y publica el puerto correspondiente a CouchDB. 

>>>*Previamente usé el comando `sudo docker run couchdb`, así me di cuenta que se debía especificar un password y user*

>>>[![image.png](https://i.postimg.cc/mk1K603T/image.png)](https://postimg.cc/sGynMH0L)

>>>Al usar correctamente el comando:
>>>[![image.png](https://i.postimg.cc/4y1SYVgh/image.png)](https://postimg.cc/D48gDWm2)

>>>Podemos apreciar el estado del contenedor mediante `sudo docker ps`

>>>[![image.png](https://i.postimg.cc/zvw9T4nv/image.png)](https://postimg.cc/643jXjbx)

>>>Ahora podemos verificar que CouchDB esté disponible al acceder al localhost:5984, especificamente al http://localhost:5984/_utils/.

>>><img src=https://i.postimg.cc/1t3PRm6B/image.png height=220>

>>><img src=https://i.postimg.cc/sgJg30qV/image.pngg height=350>
<br>

2. **(1 punto) Crea una imagen de Docker con un servicio REST, respondiendo Hola Amigos CC-3S2 a
localhost:8080/hola. Utiliza el lenguaje y el framework que prefieras. Estos son los pasos que debe seguir:**

>>*Primero, creemos un directorio que será nuestro espacio de trabajo para almacenar los archivos importantes: Dockerfile y app.py*

>>a. Crea una aplicación de servicio web.
>>>La aplicación fue creada en Python, esta se llama app.py y se muestra el código a continuación:
```
from flask import Flask

app = Flask(__name__)

@app.route('/hola')
def hola():
    return "Hola Amigos CC-3S2"

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)

```

>>b. Crea un Dockerfile para instalar dependencias y librerías.
>>>El Dockerfile para poder completar todo lo necesario, va de la siguiente manera:
```
FROM python:3.8-slim

COPY . /app
WORKDIR /app

RUN pip install flask

EXPOSE 8080

CMD ["python", "app.py"]

```

>>c. Construye la imagen.
>>>Para construir la imagen utilizamos el comando `sudo docker build -t hola_py .`

>>><img src=https://i.postimg.cc/ZKsCNQjV/image.png>

>>d. Ejecuta el contenedor que publica el puerto.
>>>Ejecutaremos el contenedor mediante el comando `sudo docker run -d -p 8080:8080 hola_py`, así expondremos el puerto 8080 y utilizamos el tag previamente definido en la construcción de la imágen.

>>><img src=https://i.postimg.cc/ZnyDL2pp/image.png)](https://postimg.cc/1VsHmWW3)

>>e. Verifica que se esté ejecutando correctamente utilizando el navegador (o curl).
>>>Mediante el curl, obtenemos lo siguiente:
`curl http://localhost:8080/hola`

>>>[![image.png](https://i.postimg.cc/QxJvnLvJ/image.png)](https://postimg.cc/rKzhKHVD)

>>>Y al acceder al navegador, apreciamos que, efectivamente, se está ejecuando correctamente:

>>>[![image.png](https://i.postimg.cc/qvmS4sJt/image.png)](https://postimg.cc/yDZvTSSB)

3. **(1 punto) Crea un master de Jenkins y imágenes de agentes Docker y úsalos para ejecutar una
infraestructura de Jenkins capaz de crear proyectos de Ruby:**
>>*Primero, crearemos dos directorios para que almacenemos los Dockerfile correspondientes para el agente y el maestro*

>>a. Crea el Dockerfile del master de Jenkins, que instala automáticamente el complemento de Docker.
>>>El Dockerfile que instalará el plugin es de la siguiente manera:
```
FROM jenkins/jenkins:lts-jdk11
RUN jenkins-plugin-cli --plugins docker-plugin github-branch-source:1.8

```
>>b. Crea la imagen master y ejecuta la instancia de Jenkins.
>>>Creamos la imagen mediante el comando `sudo docker build -t jenkins/master .` y ejecutamos su instancia mediante `sudo docker run -p 8080:8080 jenkins/master`

>>><img src=https://i.postimg.cc/bvrJw914/image.png>

>>><img src=https://i.postimg.cc/hjpfr4VQ/image.png>

>>c. Crea el Dockerfile del agente (adecuado para el aprovisionamiento dinámico del agente), que instala el intérprete de Ruby.
>>>Con el siguiente Dockerfile que instalará se podrá instalar el intérprete de Ruby:
```
FROM jenkins/agent
USER root
RUN apt-get update && \
    apt-get install -y ruby
USER jenkins
```

>>d. Crea la imagen del agente.
>>>`sudo docker build -t agenteruby  .`

>>>[![image.png](https://i.postimg.cc/t4B6k5y4/image.png)](https://postimg.cc/K1g4vtR6)

>>e. Cambia la configuración en la instancia de Jenkins para usar la imagen del agente.

>>>Tenemos que configurar un agente de Jenkins para usar la imagen Docker que acabamos de crear "agenteruby" en lugar de la imagen predeterminada de Jenkins. Esto se hace a través de la interfaz de administración de Jenkins al agregar un nuevo nodo que se pueda activar mediante: "Launch agent by connecting it to the controller" y tenga como "Remote root directory" a nuestra imagen "agenteruby".

>>>Tras configurarlo correctamente, podremos ver que nuestro agente se encuentra activo 

>>>[![image.png](https://i.postimg.cc/9Xgv33pd/image.png)](https://postimg.cc/qgnmn5Wq)

>>>*Nota: Para lograr esto debemos tener un contenedor corriendo con la imagen "agenteruby" en nuestro sistema, por lo que antes, empleamos el comando `sudo docker run -d --name agenteruby agenteruby`*




4. **(1 punto) Crea un pipeline que ejecuta un script de Ruby que imprima Hola Mundo desde Ruby:**
>>a. Crea un nuevo pipeline.

>>b. Utiliza el siguiente comando de shell para crear el script hola.rb sobre la marcha:
sh "echo \"puts 'Hola Mundo en Ruby'\" > hola.rb"

>>c. Agregue el comando para ejecutar hola.rb , utilizando el intérprete de Ruby.
>>>El pipeline creado fue denominado como HolamundoconRuby y los pasos b. y c. se ven reflejados en el pipeline que se ve de la siguiente manera:

>>>[![image.png](https://i.postimg.cc/rFqhnM7y/image.png)](https://postimg.cc/qgZXgVkW)

>>d. Ejecuta la construcción y observa la salida de la consola.

>>>Al realizar la construcción, podremos observar que resultó exitosa

>>>[![image.png](https://i.postimg.cc/Z5cwt2tP/image.png)](https://postimg.cc/hXXLVCGh)

>>> Al ver el console output, podemos afirmar que todos los pasos han sido llevados a cabo de forma correcta.

>>>[![image.png](https://i.postimg.cc/85svJrrn/image.png)](https://postimg.cc/tZQJ8Jkh)


5. **(1 punto) Crea un programa de Python que multiplique, sume, reste, divida dos números pasados como parámetros de línea de comandos. Agrega pruebas unitarias y publica el proyecto en GitHub:**
>>a. Crea dos archivos:calculador.py y test_calculador.py.
>>>Ambos archivos se encuentran en un repositorio de GitHub llamado CalculadorFinal, que puede ser accedido mediante el siguiente link: https://github.com/DagmarLV/CalculadorFinal

>>b. Puedes usar la biblioteca unittest en https://docs.python.org/3/library/unittest.html.

>>c. Ejecuta el programa y la prueba unitaria.

>>>[![image.png](https://i.postimg.cc/rw1PDwd5/image.png)](https://postimg.cc/PCq4chQq)

6. **(1 punto) Crea el pipeline de integración continua para el proyecto de calculadora de Python:**
>>a. Usa Jenkinsfile para especificar el pipeline.

>>b. Configura el trigger para que el pipeline se ejecute automáticamente en caso de que se
haga commit en el repositorio.

>>c. El pipeline no necesita el paso Compile ya que Python es un lenguaje interpretable.

>>>El pipeline descrito en nuestro archivo Jenkinsfile, siguiendo los puntos anteriores, va de la siguiente manera:
```
pipeline {
    agent any
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage("Unit test") {
            steps {
                sh "python test_calculador.py"
            }
        }
    }
}
```

>>d. Ejecuta el pipeline y observa los resultados.

>>>Al realizar la construcción tras haber configurado lo necesario, resulta exitosa.

>>[![image.png](https://i.postimg.cc/6322wXNg/image.png)](https://postimg.cc/Q9DxkvCJ)

>>>*Nota: Si antes presenté contrucciones fallidas es porque no había configurado correctamente un agente de python para ejecutar las instrucciones que le involucran, para ello procedí de manera similar como con ruby*

>>e. Intenta hacer commit el código que rompe la construcción del pipeline y observa cómo se visualiza en Jenkins.

>>>Podemos cambiar la función de test_dividir del archivo  test_calculador.py, para que produzca una excepción cuando se proceda a dividir por 0, lo que generará error.

>>>>[![image.png](https://i.postimg.cc/cLw6Gxy2/image.png)](https://postimg.cc/PCfdmkqQ)

>>>Tras hacer commit, la construcción se realiza automáticamente y podemos ver que resulta fallida.

>>>[![image.png](https://i.postimg.cc/v8tzbyM1/image.png)](https://postimg.cc/PNNZQBCh)

>>>Al revisar el console output, vemos que se produció la excepción correspondiente que rompe la construcción del pipeline.

>>>[![image.png](https://i.postimg.cc/RhZnvjQf/image.png)](https://postimg.cc/9RsfpgkF)

>>>Para que vuelva a ser una construcción exitosa, solamente modificamos la función previamente modificada.

>>>[![image.png](https://i.postimg.cc/vB3t770r/image.png)](https://postimg.cc/YGLFMFK0)

7. **(0.5 puntos) Ejecuta una aplicación Hola Amigos CC-3S2 en el clúster de Kubernetes:**

>>a. La aplicación Hola Amigos CC-3S2 puede verse exactamente igualmente al ejercicio 2
>>>Usaremos la aplicación app.py del ejercicio 2.

>>b. Implementa la aplicación con tres réplicas.
>>>Para realizar esta implementación, primero necesitamos construir la imagen de la aplicación y subirla a Docker Hub, luego tendremos que definir un archivo .yaml 

>>>[![image.png](https://i.postimg.cc/ZnZnD4NS/image.png)](https://postimg.cc/TL7TK8Q7)

>>>[![image.png](https://i.postimg.cc/q737JzXr/image.png)](https://postimg.cc/gwGp4cTt)


>>c. Exponga la aplicación con el servicio NodePort.
>>>EL archivo deployment.yaml se verá de la siguiente manera:
```
apiVersion: apps/v1
kind: Deployment
metadata:
 name: holapy
 labels:
  app: holapy
spec:
 replicas: 3
 selector:
  matchLabels:
   app: holapy
 template:
  metadata:
   labels:
    app: holapy
  spec:
   containers:
    - name: holapy
      image: dagmarlezama/hola_py
      ports:
      - containerPort: 8080
---
apiVersion: v1
kind: Service
metadata:
  name: holapy
spec:
  type: NodePort
  selector:
    app: holapy
  ports:
  - port: 8080

```
>>>Usaremos `kubectl apply -f deployment.yaml` para realizar el despliegue del clúster de Kubernetes a partir de nuestro archivo

>>>[![image.png](https://i.postimg.cc/MTv2Q22q/image.png)](https://postimg.cc/7G8QFRZW)

>>>Luego usaremos `kubectl get pods` para ver el estado de nuestros pods generados

>>>[![image.png](https://i.postimg.cc/DfSnWsnL/image.png)](https://postimg.cc/141L28g3)

>>d. Realiza una solicitud (usando curl ) a la aplicación.
>>>Para realizar la solicitud  la operación curl, obtendremos los valores de la dirección del nodo y del puerto mediante los comandos:
`minikube kubectl get service holapy` y `minikube ip`
[![image.png](https://i.postimg.cc/vHLYMyGN/image.png)](https://postimg.cc/F7z5g2dy)
[![image.png](https://i.postimg.cc/HLjdQ7Xq/image.png)](https://postimg.cc/Nyh3tFND)

>>>Así el comando curl será de la forma: `curl 192.168.59.100:30227/hola`
[![image.png](https://i.postimg.cc/R0wGpg7K/image.png)](https://postimg.cc/xkTKcyF1)

>>>Por lo visto, la aplicación funciona correctamente, esto también puede ser verificado accediendo a la dirección en nuestro navegador.

>>>[![image.png](https://i.postimg.cc/kGGQCsbj/image.png)](https://postimg.cc/PvGpzmKZ)

8. **(1 punto) Implementa una nueva función, Nos vemos!, e implementa mediante una actualización continua:**

>>a. Esta característica se puede agregar como un nuevo punto final, /bye , que siempre devuelve Nos vemos!.
>>>Modificamos el archivo app.py agregando la funcion despedida() que imprima Nos vemos!, este será de la siguiente manera:
```
from flask import Flask

app = Flask(__name__)

@app.route('/hola')
def hola():
    return "Hola Amigos CC-3S2"
    
@app.route("/bye")
def despedida():
    return "Nos vemos!"
    
if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080)
```
>>b. Reconstruye una imagen de Docker con una nueva etiqueta de versión.
>>>Para realizar esta implementación, también necesitamos construir la imagen de la aplicación y subirla a Docker Hub, luego tendremos que modificar un archivo .yaml 

>>>`sudo docker build -t dagmarlezama/hola_py:1 .`

>>>`sudo docker push dagmarlezama/hola_py:1`

>>>[![image.png](https://i.postimg.cc/bYbgyys8/image.png)](https://postimg.cc/F1r3GQyn)

>>>[![image.png](https://i.postimg.cc/6QyVDwDk/image.png)](https://postimg.cc/R3xntrCd)

>>c. Usa la estrategia RollingUpdate y readinessProbe

>>>EL archivo deployment.yaml se verá de la siguiente manera:

```
apiVersion: apps/v1
kind: Deployment
metadata:
 name: holapy
 labels:
  app: holapy
spec:
 replicas: 3
 strategy:
   type: RollingUpdate
   rollingUpdate:
     maxUnavailable: 1
     maxSurge: 1
 selector:
  matchLabels:
   app: holapy
 template:
  metadata:
   labels:
    app: holapy
  spec:
   containers:
    - name: holapy
      image: dagmarlezama/hola_py:1
      ports:
      - containerPort: 8080
      readinessProbe:
        httpGet:
          path: /health
          port: 8080
        initialDelaySeconds: 5
        periodSeconds: 5
---
apiVersion: v1
kind: Service
metadata:
  name: holapy
spec:
  type: NodePort
  selector:
    app: holapy
  ports:
  - port: 8080

```
>>d. Observa el procedimiento de actualización continua.
>>>Usaremos `kubectl apply -f deployment.yaml` para realizar el despliegue del clúster de Kubernetes a partir de nuestro archivo

>>>[![image.png](https://i.postimg.cc/LX7mNkzd/image.png)](https://postimg.cc/nj48LDRT)
>>>Luego usaremos `kubectl get pods` para ver el estado de nuestros pods generados

>>>[![image.png](https://i.postimg.cc/RFGgBGg8/image.png)](https://postimg.cc/xJJvGGDy)

>>e. Realiza una solicitud (usando curl) a la aplicación.
>>>Para realizar la solicitud  la operación curl, debemos tener los valores de la dirección del nodo y del puerto mediante los comandos `minikube kubectl get service holapy` y `minikube ip`, como el valor de este último es el mismo, aplicaremos el primero solamente.

>>>[![image.png](https://i.postimg.cc/NjffG0Gz/image.png)](https://postimg.cc/hf6qpcdL)

>>>Así el comando curl será de la forma: `curl 192.168.59.100:31164/bye`
[![image.png](https://i.postimg.cc/CLvpNsYc/image.png)](https://postimg.cc/0bJ45mzS)

>>>Por lo visto, la aplicación funciona correctamente, esto también puede ser verificado accediendo a la dirección en nuestro navegador.

>>>[![image.png](https://i.postimg.cc/NfFzgqqx/image.png)](https://postimg.cc/ppNZZSd9)

>>>Para finalizar, es propicio realizar limpieza al eliminar el despliegue y sus recursos asociados.

>>>[![image.png](https://i.postimg.cc/ryP9ND3S/image.png)](https://postimg.cc/xqLH010C)


