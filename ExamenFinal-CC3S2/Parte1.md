# Examen Final - Parte 1

### Responde con las soluciones y los requerimientos de estas soluciones de las siguientes preguntas relacionadas a microservicios


1. **(1 punto)¿Cómo pueden los clientes encontrar microservicios y sus instancias?<br>
A las instancias de microservicios normalmente se les asignan direcciones IP dinámicas cuando
se inician, por ejemplo, cuando se ejecutan en contenedores. Esto dificulta que un cliente realice
una solicitud a un microservicio que, por ejemplo, expone una API REST a través de HTTP.
Considera el siguiente diagrama:**

[![image.png](https://i.postimg.cc/wT3yCqPT/image.png)](https://postimg.cc/WhL1rvTQ)

>>
2. **(2 puntos) En un entorno de sistema de microservicios, en muchos casos es deseable exponer
algunos de los microservicios al exterior del entorno del sistema y ocultar los microservicios
restantes del acceso externo. Los microservicios expuestos deben estar protegidos contra
solicitudes de clientes malintencionados.**

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
>>

4. **(2 puntos) Tradicionalmente, una aplicación se implementa junto con su configuración, por
ejemplo, un conjunto de variables de entorno y/o archivos que contienen información de
configuración. Ante un panorama de sistemas basado en una arquitectura de microservicios, es
decir, con una gran cantidad de instancias de microservicios desplegadas, surgen algunas dudas:**

>>● **¿Cómo obtengo una imagen completa de la configuración que existe para todas las instancias de microservicio en ejecución?**

>>● **¿Cómo actualizar la configuración y me aseguro de que todas las instancias de microservicio afectadas se actualicen correctamente?**

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

[![image.png](https://i.postimg.cc/NjZbSPjL/image.png)](https://postimg.cc/18cpNB6Z)

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

[![image.png](https://i.postimg.cc/sfSB46tw/image.png)](https://postimg.cc/qgJMkLB3)