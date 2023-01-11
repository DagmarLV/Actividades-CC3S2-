# Preguntas finales
## Introducción a la entrega continua
1. **¿Cuáles son las tres fases del proceso de entrega tradicional?**



2. **¿Cuáles son las tres etapas principales de un pipeline de CD?**

> - Integración continua : que consiste en integrar regularmente el código de los desarrolladores en un repositorio centralizado, con el objetivo de detectar problemas de integración temprana.

> - Pruebas de aceptación automatizadas: para verificar que el software cumple con los requisitos funcionales y no funcionales, previamente definidos.

> - Gestión de configuración: práctica de registro y control de cambios de configuración a lo largo del tiempo, lo que permite controlar los cambios en las configuraciones del sistema, y saber cómo estaban configuradas las cosas en el momento en que ocurrieron problemas.


3. **Menciona al menos tres beneficios de usar CD.**

>>Existen muchos beneficios al implementar CD, entre ellos tenemos:
>>* Mayor estabilidad en producción
>>* Mayor flexibilidad en la elección del momento del lanzamiento
>>* Mayor velocidad en la solución de problemas en producción
>>* Mayor capacidad de respuesta a los cambios de negocio
>>* Mayor rapidez en el proceso de corrección de errores
>>* Mayor transparencia en el proceso de entrega
>>* Mayor escalabilidad
>>* Mayor capacidad de pruebas

4. **¿Cuáles son los tipos de pruebas que deben automatizarse como parte del pipeline de CD?**

>> Existen varios tipos de pruebas que deben automatizarse como parte del pipeline de CD, entre las comunes se incluyen:

>>* Pruebas unitarias: para probar cada unidad individual de código (como una función o un método) para asegurar que funcionan de manera esperada.

>>* Pruebas de integración: Se utilizan para probar cómo diferentes unidades de código funcionan juntas en un sistema o aplicación completa.

>>* Pruebas de aceptación: Son utilizadas para comprobar si el software cumple con los requisitos funcionales y no funcionales, previamente definidos.

>>* Pruebas de rendimiento: Son utilizadas para evaluar el rendimiento, escalabilidad y estabilidad del sistema bajo carga.

>>* Pruebas de seguridad: Son utilizadas para evaluar la seguridad del sistema, detectando vulnerabilidades potenciales.

>>* Pruebas de regresión: Son utilizadas para asegurar que cambios recientes no hayan introducido errores en partes del sistema ya existentes.

>>* Pruebas exploratorias: Son realizadas para evaluar la funcionalidad del sistema de forma no estructurada, de forma manual, y detectar posibles problemas.

5. **¿Deberíamos tener más pruebas de integración o unitarias? Explicar por qué.**  

>> Es recomendable tener una mayor cantidad de pruebas unitarias que de pruebas de integración por varias razones, como se exhibe a continuación:

>> Ya que se enfocan en una sola unidad de código, son más fáciles de escribir, ejecutar y mantener.
Además proporcina una mayor confianza en el código, ya que provee una mayor cobertura de código. Esto a su vez ofrece un punto de referencia para las pruebas de integración y es importante resaltar la conveniente relación costo-beneficio que trae consigo.



6. **¿Qué significa el término DevOps?**
>>DevOps es un término acuñado para describir un enfoque de colaboración y comunicación entre el desarrollo y las operaciones de una organización. El objetivo de DevOps es mejorar la velocidad, calidad y fiabilidad del software al unir las actividades de los desarrolladores y las operaciones en un solo proceso de trabajo.

>>DevOps se centra en automatizar procesos de desarrollo y operaciones para mejorar la eficiencia y reducir el tiempo entre la concepción y la entrega del software. Esto incluye prácticas como CI/CD, infraestructura como código, automatización de pruebas y monitoreo en tiempo real.


## Docker
1. ¿Cuál es la principal diferencia entre la creación de contenedores (como con Docker) y la
virtualización (como con VirtualBox)?
2. ¿Cuáles son los beneficios de proporcionar una aplicación como una imagen de Docker? Nombra al menos dos.
3. ¿Se puede ejecutar el demonio Docker de forma nativa en Windows y macOS?
4. ¿Cuál es la diferencia entre una imagen Docker y un contenedor Docker?
5. ¿Qué significa cuando se dice que las imágenes de Docker tienen capas?

6. ¿Cuáles son dos métodos para crear una imagen de Docker?
7. **¿Qué comando se usa para crear una imagen de Docker a partir de un Dockerfile?**
>>El comando que se utiliza es `docker build`. Este comando toma como parámetro la ruta del directorio donde se encuentra el Dockerfile, y utiliza las instrucciones colocadas dentro del Dockerfile para construir la imagen.

>>La sintaxis básica del comando es la siguiente:

>>`docker build -t [NOMBRE DE LA IMAGEN]:[ETIQUETA] [RUTA DEL DOCKERFILE]`

>>Donde:

>>>`-t` especifica el nombre de la imagen y la etiqueta.

>>>`[NOMBRE DE LA IMAGEN]:[ETIQUETA]` especifica el nombre y la etiqueta de la imagen a crear.

>>>`[RUTA DEL DOCKERFILE]` especifica la ruta del directorio donde se encuentra el Dockerfile.

8. **¿Qué comando se usa para ejecutar un contenedor de Docker desde una imagen de Docker?**

>>El comando que se utiliza es docker run. Este comando toma como parámetro la imagen desde la cual se creará el contenedor y opcionalmente algunos parámetros adicionales.

>>La sintaxis básica del comando es la siguiente:

>>`docker run [OPCIONES] [NOMBRE DE LA IMAGEN]:[ETIQUETA]`

>>Donde:

>>>`[OPCIONES]` especifica cualquier opción adicional para ejecutar el contenedor.

>>>`[NOMBRE DE LA IMAGEN]:[ETIQUETA]` especifica el nombre y la etiqueta de la imagen desde la cual se creará el contenedor.

9. En la terminología de Docker,¿qué significa publicar un puerto?
10. ¿Qué es un volumen Docker?

## Jenkins
1. ¿Se proporciona Jenkins en forma de imagen de Docker?
2. ¿Cuál es la diferencia entre un maestro de Jenkins y un agente de Jenkins (esclavo)?
3. ¿Cuál es la diferencia entre el escalado vertical y horizontal?
4. ¿Cuáles son las dos opciones principales para la comunicación maestro-agente al iniciar un
agente Jenkins?
5. ¿Cuál es la diferencia entre configurar un agente permanente y un agente Docker permanente?
6. ¿Cuándo necesitarás crear una imagen de Docker personalizada para un agente de Jenkins?
7. ¿Cuándo necesitarás crear una imagen de Docker personalizada para un maestro de Jenkins?

## Pipelines
1. ¿Qué es un pipeline?
2. ¿Cuál es la diferencia entre un stage y un step en el pipeline?
3. ¿Qué es la sección post en el pipeline de Jenkins?
4. ¿Cuáles son las tres etapas más fundamentales del commit pipeline?
5. ¿Qué es un Jenkinsfile?
6. ¿Cuál es el propósito de la etapa de cobertura de código?
7. ¿Cuál es la diferencia entre los siguientes triggers de Jenkins: external y polling SCM ?
8. ¿Cuáles son los métodos de notificación de Jenkins más comunes? Nombra al menos tres.

9. ¿Cuáles son los tres flujos de trabajo de desarrollo más comunes?.
Pruebas de aceptación automatizadas
1. ¿Qué es el Docker Registry?
2. ¿Qué es Docker Hub?
3. ¿Cuál es la convención para nombrar las imágenes de Docker
4. ¿Cuál es el entorno staging?
5. ¿Qué comandos de Docker usaría para crear una imagen y enviarla (push) a Docker Hub?
6. ¿Cuál es el objetivo principal de los frameworks de prueba de aceptación como Cucumber y
FitNesse?
7. ¿Cuáles son las tres partes principales de una prueba de Cucumber?
8. ¿Qué es la aceptación TDD?

## Kubernetes
1. ¿Qué es un clúster de servidores?
2. ¿Cuál es la diferencia entre un plano de control de Kubernetes y un nodo de Kubernetes?
3. Menciona al menos tres plataformas en la nube que proporcionen un entorno de Kubernetes
listo para usar.
4. ¿Cuál es la diferencia entre una implementación y un servicio de Kubernetes?
5. ¿Cuál es el comando de Kubernetes para escalar implementaciones?

>>El comando en Kubernetes para escalar una implementación es `kubectl scale`. Este comando toma como parámetro el tipo de recurso y el nombre de la implementación, y opcionalmente el número de réplicas deseado.

>>La sintaxis básica del comando es la siguiente:

>>`kubectl scale [TIPO DE RECURSO] [NOMBRE DE LA IMPLEMENTACIÓN] --replicas=[NÚMERO DE RÉPLICAS]`

>>Donde:

>>>`[TIPO DE RECURSO]` especifica el tipo de recurso (p. ej. deployment, replicaset, etc.)

>>>`[NOMBRE DE LA IMPLEMENTACIÓN]` especifica el nombre de la implementación.

>>>`--replicas=[NÚMERO DE RÉPLICAS]` especifica el número de réplicas deseado

6. **Nombre al menos dos sistemas de administración de clústeres que no sean Kubernetes.**

>>* **Docker Swarm**, sistema de administración de clústeres de contenedores de Docker. Se integra con las herramientas existentes de Docker y permite a los usuarios escalar fácilmente sus aplicaciones en un clúster de Docker. Ofrece una interfaz similar a la de Docker Compose para definir y ejecutar aplicaciones en un clúster.

>>* **Apache Mesos**, sistema de administración de clústeres de alto rendimiento y escalabilidad. Es un sistema de planificación distribuido que permite a los usuarios ejecutar aplicaciones de forma transparente en un clúster. Es utilizado para la ejecución de aplicaciones en entornos de gran escala, como data centers o centros de cálculo.