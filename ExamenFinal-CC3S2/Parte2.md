# Examen Final - Parte 2

### Responde e implementa cada una de las siguientes preguntas relacionadas a las actividades desarrolladas en clase. (para puntuar debes responder todas las preguntas).

1. **(0.5 puntos ) Ejecuta CouchDB como un contenedor de Docker y publica su puerto, de la siguiente manera: <br>
a. Ejecuta el contenedor.<br>
b. Publica el puerto de CouchDB.<br>
c. Abre el navegador y verifica que CouchDB esté disponible**
>>> Para esto, primero buscaremos la imagen de CouchDB mediante el comando `sudo docker search CouchDB`. Al encontrarlo, proseguiremos con el comando `sudo docker run couchdb` para ejecutar el contenedor, luego usamos  `sudo docker ps` para poder apreciar el puerto que tenemos que publicar.
Tras obtenerlo, eliminamos el contenedor creado y procedemos a emplear el comando `docker run -p 5984:5984 couchdb` que ejecuta el contenedor y publica el puerto correspondiente a CouchDB. Ahora podemos verificar que CouchDB esté disponible al acceder a http://localhost:5984/_utils/.

2. **(1 punto) Crea una imagen de Docker con un servicio REST, respondiendo Hola Amigos CC-3S2 a
localhost:8080/hola. Utiliza el lenguaje y el framework que prefieras. Estos son los pasos que debe seguir:**
>>*Primero, creemos un directorio que será nuestro espacio de trabajo para almacenar los archivos importantes: Dockerfile y app.py*

>>a. Crea una aplicación de servicio web.
>>>La aplicación fue creada en Python, esta se llama app.py y se muestra el código a continuación:
```


```

>>b. Crea un Dockerfile para instalar dependencias y librerías.
>>>El Dockerfile para poder completar todo lo necesario, va de la siguiente manera:
```


```

>>c. Construye la imagen.
>>>Para construir la imagen utilizamos el comando `sudo docker build -t hola_py .` 


>>d. Ejecuta el contenedor que publica el puerto.
>>>Ejecutaremos el contenedor mediante el comando `sudo docker run -d -p 8080:8080 hola_py`, así expondremos el puerto 8080 y utilizamos el tag previamente definido en la construcción de la imágen.


>>e. Verifica que se esté ejecutando correctamente utilizando el navegador (o curl).
>>>Mediante el curl, obtenemos lo siguiente:

>>>Y al acceder al navegador, apreciamos que, efectivamente, se está ejecuando correctamente

3. **(1 punto) Crea un master de Jenkins y imágenes de agentes Docker y úsalos para ejecutar una
infraestructura de Jenkins capaz de crear proyectos de Ruby:**

>>a. Crea el Dockerfile del master de Jenkins, que instala automáticamente el complemento de Docker.

>>b. Crea la imagen master y ejecuta la instancia de Jenkins.

>>c. Crea el Dockerfile del agente (adecuado para el aprovisionamiento dinámico del agente), que instala el intérprete de Ruby.

>>d. Crea la imagen del agente.

>>e. Cambia la configuración en la instancia de Jenkins para usar la imagen del agente.

4. **(1 punto) Crea un pipeline que ejecuta un script de Ruby que imprima Hola Mundo desde Ruby:**
>>a. Crea un nuevo pipeline.

>>b. Utiliza el siguiente comando de shell para crear el script hola.rb sobre la marcha:
sh "echo \"puts 'Hola Mundo en Ruby'\" > hola.rb"

>>c. Agregue el comando para ejecutar hola.rb , utilizando el intérprete de Ruby.

>>d. Ejecuta la construcción y observa la salida de la consola.
5. **(1 punto) Crea un programa de Python que multiplique, sume, reste, divida dos números pasados como parámetros de línea de comandos. Agrega pruebas unitarias y publica el proyecto en GitHub:**
>>a. Crea dos archivos:calculador.py y test_calculador.py.

>>b. Puedes usar la biblioteca unittest en https://docs.python.org/3/library/unittest.html.

>>c. Ejecuta el programa y la prueba unitaria.

6. **(1 punto) Crea el pipeline de integración continua para el proyecto de calculadora de Python:**
>>a. Usa Jenkinsfile para especificar el pipeline.

>>b. Configura el trigger para que el pipeline se ejecute automáticamente en caso de que se
haga commit en el repositorio.

>>c. El pipeline no necesita el paso Compile ya que Python es un lenguaje interpretable.

>>d. Ejecuta el pipeline y observa los resultados.

>>e. Intenta hacer commit el código que rompe la construcción del pipeline y observa cómo se visualiza en Jenkins.

7. **(0.5 puntos) Ejecuta una aplicación Hola Amigos CC-3S2 en el clúster de Kubernetes:**

>>a. La aplicación Hola Amigos CC-3S2 puede verse exactamente igualmente al ejercicio 2

>>b. Implementa la aplicación con tres réplicas.

>>c. Exponga la aplicación con el servicio NodePort.

>>d. Realiza una solicitud (usando curl ) a la aplicación.

8. **(1 punto) Implementa una nueva función, Nos vemos!, e implementa mediante una actualización continua:**

>>a. Esta característica se puede agregar como un nuevo punto final, /bye , que siempre devuelve Nos vemos!.

>>b. Reconstruye una imagen de Docker con una nueva etiqueta de versión.

>>c. Usa la estrategia RollingUpdate y readinessProbe

>>d. Observa el procedimiento de actualización continua.

>>e. Realiza una solicitud (usando curl) a la aplicación.