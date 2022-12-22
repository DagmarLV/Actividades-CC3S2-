# PRÁCTICA CALIFICADA 4
## Pregunta 1

## Pregunta 2
<div style="text-align: justify; font-weight: bold; "> En un sistema basado en microservicios puede haber diferentes tipos de comunicación; sin embargo, debe haber un tipo de comunicación predominante.¿Cuál escogerías?¿Qué otros están permitidos además?¿En qué situaciones? ¿Utilizarías la replicación de datos en un sistema basado en microservicios?¿En qué áreas?¿Cómo lo implementarías?</div>
<p></p>

<div style="text-align: justify;">En un sistema basado en microservicios, para elegir un tipo de comunicación predominante, es importante elegir uno que sea escalable, confiable y fácil de implementar. Algunos de los tipos de comunicación más comunes utilizados en estos sistemas basados en microservicios son: REST API, Mensajería asíncrona, RPC.

Personalmente yo utilizaría REST API, estas utilizan el protocolo HTTP para realizar solicitudes y recibir respuestas en formato JSON, lo cual las hace fáciles de implementar y utilizar, ya que la mayoría de las plataformas y lenguajes de programación tienen librerías de cliente HTTP disponibles. Además, el protocolo HTTP es ampliamente conocido y bien documentado, lo que facilita la integración con otras aplicaciones y sistemas.
Justamente gracias al uso de este protocolo, las REST API llegan a ser tanto escalables como confiables, pues HTTP es ampliamente utilizado y probado. Por otro lado, las REST API son flexibles y permiten la creación de una amplia variedad de servicios y recursos. Podemos decir que las REST API son ideales en situaciones donde se necesita una comunicación a través de la red entre servicios o aplicaciones.

Yo recomiendo su utilización, ya que, fuera de ser una opción popular, justo como se ha descrito, esta es ampliamente utilizada y junto con su gran simplicidad, trae consigo escalabilidad, confiabilidad y facilidad de implementación, lo cual se ajusta totalmente a las características que mencioné inicialmente. 

Ahora, dependiendo de las necesidades específicas del sistema, como el tamaño y la complejidad del mismo o el rendimiento y la latencia requeridos, es posible que otro tipo de comunicación, como la mensajería asíncrona o el RPC, sea la elección más adecuada

- Mensajería asíncrona: La mensajería asíncrona permite que los servicios envíen y reciban mensajes a través de una cola de mensajes, lo que permite una comunicación asíncrona y sin conexión. Entonces, esta es ideal en situaciones que se requieran de esta comunicación asíncrona y sin conexión, lo cual puede ser útil en situaciones donde sea necesario procesar grandes cantidades de datos o realizar tareas en segundo plano.

- RPC: El Remote Procedure Call (RPC) es un tipo de comunicación que permite a los servicios llamar a procedimientos remotos a través de un protocolo específico, como HTTP o gRPC. Esto puede ser útil en situaciones donde se necesita una comunicación rápida y eficiente entre servicios, como cuando se necesitan realizar muchas llamadas a corto plazo.

<p> <br></p>

La replicación de datos implica duplicar los datos en múltiples servidores o nodos para aumentar la disponibilidad y el rendimiento del sistema, lo cual puede ser útil en algunos sistemas basados en microservicios, dependiendo de las necesidades de disponibilidad y rendimiento del sistema. 

La elección de la solución de replicación adecuada depende de las necesidades específicas del sistema y de cómo se utilizará la replicación. Algunos factores a considerar al elegir una solución de replicación son el tamaño, la complejidad del sistema, el rendimiento y la latencia requeridos o la facilidad de implementación y mantenimiento.

En algunas áreas, como la base de datos, los servicios de mensajería, los servicios de procesamiento en tiempo real o los de análisis de datos; la replicación de datos puede ser muy útil para aumentar la disponibilidad y el rendimiento del sistema. 

En otras áreas, como el almacenamiento de archivos, la replicación de datos también puede ser útil para aumentar la disponibilidad y el rendimiento del sistema. Sin embargo, es importante tener en cuenta que la replicación de datos puede ser costosa en términos de recursos y complejidad, por lo que es posible que sea más adecuado utilizar un sistema de almacenamiento distribuido que proporcione alta disponibilidad y rendimiento sin la necesidad de replicar los datos.

Debido a que la replicación de datos puede ser costosa en términos de recursos y complejidad, es importante evaluar si realmente es necesario replicar los datos en el sistema basado en microservicios. En algunos casos, puede ser más adecuado utilizar otras soluciones, como la replicación de procesos o la replicación de servicios, que permitan aumentar la disponibilidad y el rendimiento del sistema.

Entonces, justamente para implementarlo, primero es necesario identificar las áreas del sistema que necesitan de replicación de datos para aumentar la disponibilidad y el rendimiento del sistema. 

Posteriormente es necesario elegir una tecnología de replicación adecuada para el tipo de datos que se desea replicar. Por ejemplo, si se desea replicar una base de datos, es posible utilizar una tecnología de replicación de bases de datos, como MySQL Replication o MongoDB Replication. Si se desea replicar archivos, es posible utilizar un sistema de almacenamiento distribuido, como Ceph o Gluster.

Luego se procede a configurar la replicación en cada nodo del sistema utilizando la tecnología de replicación seleccionada. Esto puede incluir configurar la sincronización de datos entre nodos o la replicación de transacciones, etc.

Tras esto, es necesario probar y monitorear la replicación para asegurarse de que funciona correctamente y que los datos se replican correctamente entre los nodos.

</div>