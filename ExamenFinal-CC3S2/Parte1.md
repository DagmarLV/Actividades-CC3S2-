# Examen Final - Parte 1

### Responde con las soluciones y los requerimientos de estas soluciones de las siguientes preguntas relacionadas a microservicios


1. **(1 punto)¿Cómo pueden los clientes encontrar microservicios y sus instancias?<br>
A las instancias de microservicios normalmente se les asignan direcciones IP dinámicas cuando
se inician, por ejemplo, cuando se ejecutan en contenedores. Esto dificulta que un cliente realice
una solicitud a un microservicio que, por ejemplo, expone una API REST a través de HTTP.
Considera el siguiente diagrama:**

>><img src=https://i.postimg.cc/wT3yCqPT/image.png) height=200>
<br>

>>Se pueden utilizar servicios de descubrimiento de servicios (service discovery), como Eureka o Consul, que registran y buscan instancias de microservicios, de forma que  pueda ser empleado por los clientes como ellos requieran, como realizar el seguimiento o solicitudes de los microservicios y las IP de sus instancias.

>>Cada instancia de un microservicio debe registrarse en el servicio de registro de servicios al iniciarse. Esto debe ser automatizado mediante la configuración de la infraestructura de contenedores u alguna otra opción conveniente para el cliente.<br>
Los clientes deben tener la capacidad de buscar y acceder a las instancias de los microservicios a través del servicio de registro de servicios. <br>
Es importante monitorear el servicio de registro de servicios y las instancias de los microservicios registrados para detectar posibles  problemas y fallos.<br>
También, deberíamos asegurar que el servicio de registro de servicios y la comunicación entre los clientes y el servicio estén protegidos mediante autenticación y cifrado.

<br>

2. **(2 puntos) En un entorno de sistema de microservicios, en muchos casos es deseable exponer
algunos de los microservicios al exterior del entorno del sistema y ocultar los microservicios
restantes del acceso externo. Los microservicios expuestos deben estar protegidos contra
solicitudes de clientes malintencionados.**

>>Podríamos usar un gateway de API o un Edge Server, pero por motivos de rendimiento, flexibilidad, escalabilidad y otros, recomiendo la segunda opción, que es un componente que se sitúa en la frontera del sistema de microservicios y maneja todas las solicitudes entrantes, este se encarga de filtrar y enrutar las solicitudes a los diferentes microservicios y podemos emplearlo de acuerdo a nuestros requerimientos, expresados en el enunciado, que incluyen:

>>Asegurarnos que solo los servicios internos que deben estar disponibles para las solicitudes externas sean expuestos, y al mismo tiempo proteger estos servicios expuestos de solicitudes maliciosas mediante el uso de protocolos de seguridad estándar que nos brinden una forma de autenticar y autorizar a los clientes que acceden a los microservicios.
En otras palabras, solo se permiten solicitudes a los microservicios configurados para recibir solicitudes externas y se garantiza que los clientes que acceden a estos servicios son confiables mediante la implementación de medidas de seguridad adecuadas
También, sería formidable contar con una manera de monitorear el rendimiento del Edge Server para detectar problemas y tomar medidas correctivas.

<br>


3. **(2 puntos) Tradicionalmente, como desarrolladores de Java, estamos acostumbrados a
implementar la comunicación sincrónica mediante el bloqueo de E/S, por ejemplo, una API
RESTful JSON sobre HTTP. El uso de una E/S de bloqueo significa que se asigna un subproceso
desde el sistema operativo durante la duración de la solicitud. Si aumentas la cantidad de
solicitudes simultáneas, un servidor podría quedarse sin subprocesos disponibles en el sistema
operativo, lo que provocaría problemas que van desde tiempos de respuesta más prolongados
hasta fallas en los servidores. El uso de una arquitectura de microservicios suele empeorar aún
más este problema, donde normalmente se utiliza una cadena de microservicios cooperativos
para atender una solicitud. Cuantos más microservicios participen en la atención de una
solicitud, más rápido se agotarán los subprocesos disponibles**

>>Una solución a los problemas de escalabilidad y rendimiento causados por el uso de E/S de bloqueo en una arquitectura de microservicios, es el uso de E/S no bloqueantes (non-blocking I/O). La programación con E/S no bloqueante permite que varias tareas se ejecuten de manera simultánea sin bloquear el hilo actual, lo que permite que el servidor maneje una mayor cantidad de solicitudes simultáneas y existan menos posibilidades de saturación de los hilos.

>>La idea es siempre tratar de utilizar un modelo de programación asíncrono, en el cual se envían mensajes sin esperar a que el receptor los procese y diseñar los microservicios para ser escalables y capaces de manejar una mayor carga de trabajo, considerando también que puedan ser capaces de producir una respuesta incluso si falla un servicio del que dependen, y recuperarse una vez que el servicio que falló vuelve a estar operativo.


4. **(2 puntos) Tradicionalmente, una aplicación se implementa junto con su configuración, por
ejemplo, un conjunto de variables de entorno y/o archivos que contienen información de
configuración. Ante un panorama de sistemas basado en una arquitectura de microservicios, es
decir, con una gran cantidad de instancias de microservicios desplegadas, surgen algunas dudas:**

>>● **¿Cómo obtengo una imagen completa de la configuración que existe para todas las instancias de microservicio en ejecución?**

>>● **¿Cómo actualizar la configuración y me aseguro de que todas las instancias de microservicio afectadas se actualicen correctamente?**

>>>La solución para obtener una imagen completa de la configuración y actualizarla de forma segura en un sistema basado en microservicios es agregar un servidor de configuración como un nuevo componente al sistema.

>>>Se debe tener la posibilidad de tener diferentes configuraciones para distintos entornos, pues permitirá que los desarrolladores puedan probar y depurar el código en un entorno de desarrollo, mientras que las configuraciones de producción se mantienen separadas y seguras, lo que ayuda a garantizar que los cambios en un entorno no afecten a otros y hacer una gestión más sencilla de las configuraciones y su versionado.<br>
Junto con esto, es necesario tener la capacidad de almacenar la información de las configuraciones en un solo lugar. Esto podría incluir cosas como las credenciales de acceso a la base de datos, el puerto en el que se ejecuta el servicio, y otras configuraciones específicas del sistema. Además de eso, sería útil disponer de una forma de actualizar la configuración en tiempo real y notificar a las instancias de microservicio afectadas para que recuperen la nueva configuración.

<br>

5. **(3 puntos) Tradicionalmente, una aplicación escribe eventos logs en archivos logs que se
almacenan en el sistema de archivos local del servidor en el que se ejecuta la aplicación. Dado un
panorama de sistema basado en una arquitectura de microservicios, es decir, con una gran
cantidad de instancias de microservicios implementadas en una gran cantidad de servidores más pequeños, podemos hacernos las siguientes preguntas:**

>>● **¿Cómo se obtiene una descripción general de lo que sucede en el entorno del sistema
cuando cada instancia de microservicio escribe en su propio archivo log local?**

>>● **¿Cómo averiguo si alguna de las instancias de microservicio tiene problemas y
comienza a escribir mensajes de error en sus archivos logs?**

>>● **Si los usuarios finales comienzan a informar problemas,¿cómo puedo encontrar mensajes logs relacionados? es decir,¿cómo puedo identificar qué instancia de
microservicio es la causa raíz del problema? El siguiente diagrama ilustra el problema:**

>><img src=https://i.postimg.cc/NjZbSPjL/image.png height=250>

>>>Una solución para estos problemas es implementar un sistema de registro centralizado, como el sistema de registro de Elasticsearch, Logstash y Kibana (ELK) u otros.
Estos sistemas permiten recopilar los eventos de registro de todas las instancias de microservicio en un lugar centralizado y luego indexarlos, buscarlos y analizarlos fácilmente.

 >>>Debemos tener la capacidad de detectar automáticamente nuevas instancias de microservicios que se estén ejecutando en el sistema, y recopilar los eventos de registro de estas instancias. Esto podría incluir cosas como las solicitudes que se están haciendo al servicio, las respuestas que está dando, los errores que se están produciendo, entre otras. Una vez recopilados estos eventos, se deben interpretar y almacenar de forma estructurada y con capacidad de búsqueda en una base de datos. Esto permitirá a los desarrolladores y administradores tener una visión completa de lo que está sucediendo en el sistema en tiempo real, y así podrán buscar y analizar eventos específicos, de modo que puedan  tomar decisiones en tiempo real respecto a cualquier situación que se presente.


<br>

6. **(3 puntos) Debe ser posible rastrear solicitudes y mensajes que fluyen entre microservicios
mientras se procesa una solicitud externa al entorno del sistema. Algunos ejemplos de
escenarios de falla son los siguientes:**

>>● **Si los usuarios finales comienzan a presentar casos de soporte con respecto a una falla
específica,¿cómo podemos identificar el microservicio que causó el problema, es decir, la causa raíz?**

>>● **Si un caso de soporte menciona problemas relacionados con una entidad específica, por
ejemplo, un número de pedido específico,¿cómo podemos encontrar mensajes de
registro relacionados con el procesamiento de este pedido específico, por ejemplo,
mensajes logs de todos los microservicios que estuvieron involucrados en su
procesamiento?**

>>● **Si los usuarios finales comienzan a presentar casos de soporte relacionados con un
tiempo de respuesta inaceptablemente largo,¿cómo podemos identificar qué
microservicio en una cadena de llamadas está causando la demora?**

>>**El siguiente diagrama representa esto:**

>><img src=https://i.postimg.cc/sfSB46tw/image.png) height=250>

>>>Una posible solución para rastrear solicitudes y mensajes que fluyen entre microservicios mientras se procesa una solicitud externa al entorno del sistema, sería utilizar un sistema de monitoreo y seguimiento distribuido. Esto permitiría recopilar eventos de registro de cada microservicio y enviarlos a una plataforma centralizada para su análisis. La plataforma debe proporcionar herramientas para buscar y analizar estos eventos de registro, con el objetivo de identificar problemas y encontrar las causas raíz.

>>>También se podría implementar un sistema de seguimiento de transacciones distribuido, como el sistema de seguimiento de transacciones de OpenTracing o Zipkin. Estos sistemas permiten rastrear las transacciones a través de los diferentes microservicios, lo que permite identificar problemas y causas raíz de problemas, así como encontrar mensajes de registro relacionados con una entidad específica o un problema de tiempo de respuesta.

>>>Además, como otra alternativa, se podría implementar un sistema de registro centralizado, que se enfoca en recopilar y almacenar registros de eventos generados por diferentes aplicaciones y servicios en un lugar central para su fácil acceso y análisis. Esto permite una mejor comprensión de lo que está sucediendo en el sistema y ayuda a encontrar problemas.


>>>Algunos de los requerimientos de la solución podrían ser:

>>>- La capacidad de recopilar eventos de registro de todas las instancias de microservicios en tiempo real. <br>
>>>- Disponer de la posibilidad de buscar y analizar estos eventos de registro para identificar problemas y encontrar causas raíz.
>>>- La capacidad de detectar y alertar en caso de problemas en el sistema
>>>- Contar con una Interfaz de usuario intuitiva y fácil de usar para buscar y analizar los eventos de registro requeridos por el cliente.
