# **PRÁCTICA CALIFICADA 4**
## **Pregunta 1**

### **Se incorporará una nueva característica del producto en el entorno SOA que se muestra en la figura**

[![busa.jpg](https://i.postimg.cc/wxb877cS/busa.jpg)](https://postimg.cc/kD8hHMHc?style=centerme)


### **Responde a las siguientes preguntas:**

### **¿Se necesita la infraestructura SOA para integrar los dos nuevos servicios?**

Consideremos que  SOA es un enfoque para la integración de sistemas basado en la creación de servicios web. Estos servicios se basan en estándares web como HTTP, XML y SOAP, y se pueden invocar por otros sistemas y aplicaciones para compartir datos y funcionalidades.

En el caso práctico, necesitamos incorporar un servicio para la creación y ejecución de campañas y otro para evaluar los resultados de una campaña, considerando que esta característica del producto será incorporado en el entorno SOA, si es necesario una infraestructura SOA para permitir que estos dos servicios se integren en nuestro entorno existente y para conseguirlo, se deberán crear y publicar como servicios web y utilizar la infraestructura SOA para invocarlos y comunicarse con ellos, teniendo en cuenta aspectos como la seguridad, la escalabilidad y la disponibilidad para garantizar el correcto funcionamiento del sistema.



<br>

### **El servicio de evaluación de campañas necesita manejar una gran cantidad de datos.**

 ### **¿Sería mejor utilizar la replicación de datos, la integración a nivel de interfaz de usuario o las llamadas de servicio para acceder a grandes cantidades de datos?**

 
### **¿Cuál de estas opciones de integración suele ofrecer SOA?** 

Cada una de estas opciones para acceder a grandes cantidades de datos en nuestro sistema, en general, brindan sus propias ventajas y desventajas individualmente y la mejor opción dependerá de las necesidades y requisitos específicos del sistema. A continuación, se describen algunos de los principales aspectos a tener en cuenta:

>**Replicación de datos:** consiste en el proceso de copiar los datos de un sistema a otro para su uso y análisis. Esta opción es adecuada cuando se necesita acceder a grandes cantidades de datos de forma rápida y segura, y cuando es importante tener una copia de seguridad de los datos. Sin embargo, puede llegar a ser bastante costosa al requerir una gran cantidad de ancho de banda y almacenamiento.

>**Integración a nivel de interfaz de usuario:** esta implica la conexión directa de un sistema con otro a través de una interfaz gráfica de usuario (GUI). Esta opción es adecuada cuando se necesita una integración rápida y sencilla, y cuando los sistemas son compatibles con una GUI común. Sin embargo, esta integración puede ser menos flexible y escalable que otras opciones.

>**Llamadas de servicio:** son invocaciones de un servicio web que permiten a los sistemas compartir datos y funcionalidades. Esta opción es adecuada cuando se necesita una integración más flexible y escalable, y cuando los sistemas se basan en estándares web comunes. La desventaja es que pueden ser más complicadas de configurar y mantener que otras opciones, pero ofrecen una mayor flexibilidad y escalabilidad.

Ahora, necesitamos escoger uno que sea congruente al enfoque SOA de nuestro contexto. Recordemos que SOA se basa en la creación y uso de servicios web para integrar sistemas y aplicaciones, caracterizado por la independencia de plataforma, la reutilización de servicios y la composición de servicios en aplicaciones más grandes.

 La replicación de datos implica copiar y mantener una copia de seguridad de los datos en un segundo sistema, y no se basa en la creación y uso de servicios web. La integración a nivel de interfaz de usuario involucra la integración de las interfaces de usuario de dos sistemas para permitir la comunicación y el intercambio de datos, y tampoco se basa en la creación y uso de servicios web. Por lo tanto, ambas opciones no forman parte de SOA, porque no utilizan los principios y estándares que caracterizan a SOA.

Entonces, finalmente podemos decir que las llamadas de servicio es la mejor opción para acceder a grandes cantidades de datos para nuestro caso y que son la opción de integración más utilizada comúnmente en el contexto de una arquitectura orientada a servicios o SOA. 
 
<br>

### **¿Debe el servicio integrarse al portal existente o tener su propia interfaz de usuario?**

 Esta decisión depende de las necesidades y requisitos del sistema. Algunas de las consideraciones a tener en cuenta podrian ser: 

> Cantidad de usuarios: Si el servicio va a ser utilizado por un grupo amplio de usuarios, puede ser conveniente tener una interfaz de usuario dedicada para facilitar el acceso y la navegación. En cambio, si el servicio es para uso interno o para un grupo reducido de usuarios, puede ser más adecuado integrarlo al portal existente.

> Funcionalidades: Si el servicio ofrece funcionalidades complejas o múltiples pasos, puede ser conveniente tener una interfaz de usuario dedicada solo para facilitar la utilización del servicio. En cambio, si el servicio ofrece una funcionalidad sencilla o puede integrarse fácilmente en el flujo de trabajo del portal existente, puede ser más adecuado integrarlo a este portal.

>Integración: Si el servicio se integra fácilmente al portal existente y se pueden mantener en sincronía las actualizaciones y cambios, puede ser conveniente integrarlo al portal existente. En cambio, si el servicio requiere una integración más compleja o se prevé que haya cambios frecuentes en el servicio, puede ser más adecuado tener una interfaz de usuario dedicada.

>Costos y recursos: Si el servicio requiere una gran cantidad de recursos o es costoso desarrollar y mantener una interfaz de usuario dedicada, puede ser más conveniente integrarlo al portal existente. En cambio, si el servicio es independiente y se puede desarrollar y mantener de forma sencilla, puede ser más adecuado tener una interfaz de usuario dedicada.

En nuestro caso, para nuestros servicios, es necesario evaluar todo el sistema en sí y las necesidades que implican los requisitos de este. Considero que sería adecuado analizar cuán escalable será nuestro sistema y si se dispondrán de los recursos necesarios para llegar a alcanzar lo requerido. 

Yo sugiriría una propia interfaz de usuario si es que se dispone de lo necesario, ya que puede traer más ventajas al incluir más funcionalidades.

<br>

### **¿Cuáles son los argumentos a favor de cada opción?**

En la pregunta anterior se describieron algunos argumentos a favor de cada opción, pero a continuación resaltamos lo siguiente:

- Integración al portal existente:

    >Facilita el acceso y la navegación para los usuarios, ya que no tienen que salir del portal para acceder al servicio Permite aprovechar la funcionalidad y diseño del portal existente, reduciendo el tiempo y costo de desarrollo. Facilita la integración con otras funcionalidades del portal y el flujo de trabajo existente. Puede ser más eficiente en términos de recursos y costos si el servicio es sencillo y no requiere una interfaz de usuario dedicada.

- Interfaz de usuario dedicada:

    >Ofrece una experiencia de usuario más centrada y personalizada para el servicio. Permite diseñar la interfaz de usuario de acuerdo a las necesidades específicas del servicio. Puede ser más adecuada para servicios complejos o que ofrecen múltiples funcionalidades. Ofrece mayor flexibilidad y escalabilidad para adaptarse a futuros cambios y actualizaciones.

<br>

### **¿Debería implementar la nueva funcionalidad, el equipo de CRM?**

Eso depende, es cierto que es muy probable que sean la opción más adecuada para implementar la nueva funcionalidad, pero deberíamos considerar las habilidades, recursos y responsabilidades del equipo. 
Recordemos que el enunciado indica que el CRM no tiene soporte para campañas de correo electrónico.
Es importante tener en cuenta que la implementación de esta nueva funcionalidad puede ser un proyecto complejo que requiere la consideración de muchos factores, como el alcance, la arquitectura, la integración, el tiempo y los recursos. Es posible que sea necesario evaluar la viabilidad de la implementación antes de tomar una decisión. 
Entonces, para tomar una decisión informada, es recomendable considerar todos los factores relevantes y me parecería ideal el considerar un equipo multidisciplinario o una colaboración entre equipos para implementarlo adecuadamente, pero centrandonos en la integración más que nada.

<br>

## Pregunta 2
 **En un sistema basado en microservicios puede haber diferentes tipos de comunicación; sin embargo, debe haber un tipo de comunicación predominante. ¿Cuál escogerías?¿Qué otros están permitidos además?¿En qué situaciones? ¿Utilizarías la replicación de datos en un sistema basado en microservicios?¿En qué áreas?¿Cómo lo implementarías?**
<p></p>

<div style="text-align: justify;">En un sistema basado en microservicios, para elegir un tipo de comunicación predominante, es importante elegir uno que sea escalable, confiable y fácil de implementar. Algunos de los tipos de comunicación más comunes utilizados en estos sistemas basados en microservicios son: REST API, Mensajería asíncrona, RPC.
<p> </p>
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





