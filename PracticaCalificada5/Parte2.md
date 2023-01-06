# PARTE 2

**Producción**
Staging
Control de calidad (QA)
Desarrollo

**Pregunta 1: Menciona diferentes enfoques para proporcionar a los agentes las credenciales del
servidor.**

Copiar al plugin esclavo de Jenkins. Utilizar las credenciales de Jenkins. Poner una clave SSH en la imagen del agente. Poner una clave SSH en el agente.

**Pregunta 2: Aprendimos mucho sobre los requisitos funcionales y las pruebas de aceptación
automatizadas. Pero,¿qué debemos hacer con los requisitos no funcionales? O aún más desafiante,¿qué
pasa si no hay requisitos?¿Deberíamos omitirlos en el proceso de CD?**

Respecto a los requisitos no funcionales, es importante tomarlos en cuenta, ya que a pesar de no estar directamente relacionados con el comportamiento esperado de la aplicación, estos refieren a aspectos como relevantes el rendimiento, la escalabilidad, la seguridad y la usabilidad, lo cual pueden representar posibles riesgos relevantes para el funcionamiento del sistema y por ello debe ser tratado con cuidado.
Ahora, teniendo esto en cuenta, las pruebas no funcionales son tan importantes como las funcionales, por lo que no debemos omitirlos en el proceso de CD y tenemos que buscar establecer claramente estos requisitos 
En caso no haya requisitos específicos establecidos, deberíamos trabajar con el equipo de desarrollo y el cliente para definir los requisitos no funcionales que, por lo visto, tienen gran relevancia para el proyecto


Tipos de prueba no funcional

**Pregunta 3: ¿Qué son las pruebas de rendimiento?,¿qué es el (RTT)?**

Las pruebas de rendimiento son un tipo de prueba que se utilizan para evaluar el rendimiento y la escalabilidad de una aplicación o sistema. O sea, que son pruebas no funcionales, estas pueden incluir pruebas de carga, que evalúan el rendimiento del sistema cuando se le somete a una gran cantidad de tráfico o solicitudes simultáneas, y pruebas de estrés, que evalúan cómo el sistema responde a situaciones de alta carga o a fallos en los componentes del sistema.

El tiempo de ida y vuelta (Round-trip time) es una medida del tiempo que tarda en enviarse y recibirse una solicitud a través de una red. Se mide en milisegundos o segundos y se utiliza a menudo como un indicador del rendimiento de la red. Un tiempo de RTT más bajo generalmente indica un rendimiento mejor de la red.


**Pregunta 4:¿Qué son las pruebas de carga?,¿en que ciclo del CD su uso es muy común?**

Las pruebas de carga son un tipo de prueba de rendimiento que se utilizan para evaluar cómo una aplicación o sistema responde a una gran cantidad de tráfico o solicitudes simultáneas. Estas pruebas se utilizan para simular el tráfico real y medir el rendimiento del sistema bajo cargas elevadas.
El uso de pruebas de carga es muy común en el  en el ciclo de integración y pruebas del proceso de CD. Estas pruebas se pueden ejecutar en cualquier momento durante el desarrollo del sistema, pero suelen ser más efectivas cuando se realizan justo antes de la implementación en producción. Las pruebas de carga pueden ayudar a identificar problemas de rendimiento y escalabilidad antes de que el sistema entre en producción, lo que puede evitar problemas inesperados una vez en producción.


**Pregunta 5:¿ Qué son las pruebas de estrés?,¿estas pruebas son adecuadas para el proceso CD?**

Las pruebas de estrés son un tipo de prueba de rendimiento que se utilizan para evaluar cómo una aplicación o sistema responde a situaciones de alta carga o a fallos en los componentes del sistema. Estas pruebas se utilizan para simular condiciones extremas y evaluar cómo el sistema maneja el estrés adicional.
Puede que estas pruebas no sean adecuadas para el proceso de CD, ya que, a pesar de que pueden ayudar a identificar problemas de rendimiento y escalabilidad que podrían no ser evidentes en condiciones normales de uso y ayudar a garantizar que un sistema sea resistente y pueda soportar situaciones de alta carga o fallos de componentes sin degradar el rendimiento o el servicio, estas pueden ser intensivas y requerir una gran cantidad de recursos, por lo que deben planificarse y ejecutarse cuidadosamente. Su uso debería ser empleado solamente en ciertos puntos clave del proceso de desarrollo y debería estar separado de Jenkins.


**Pregunta 6:¿Qué son las pruebas de escalabilidad?,¿estas pruebas son fáciles de incluir en el pipeline de CD ?¿por qué?**

Las pruebas de escalabilidad son un tipo de prueba de rendimiento que se utilizan para evaluar cómo una aplicación o sistema responde a cambios en el tamaño o la complejidad de la carga de trabajo. Estas pruebas se utilizan para evaluar cómo el sistema se comporta cuando se le somete a cargas crecientes o disminuyentes y para determinar su capacidad para adaptarse a cambios en la demanda.
Incluir pruebas de escalabilidad en el pipeline de CD puede ser un desafío, ya que estas pruebas a menudo requieren una gran cantidad de recursos y pueden ser difíciles de automatizar. Además, es posible que sea difícil predecir exactamente cómo el sistema responderá a cambios en la carga de trabajo, lo que puede dificultar la creación de un conjunto de pruebas adecuado. Sin embargo, aunque pueden ser difíciles de incluir en el pipeline de CD, las pruebas de escalabilidad son importantes ya que pueden ayudar a garantizar que el sistema es capaz de adaptarse a cambios en la demanda y proporcionar un servicio consistente a los usuarios. 


**Pregunta 7:¿Qué es un Soak test o pruebas de resistencia o pruebas de longevidad?,¿tiene sentido ejecutarlos dentro del pipeline CD?**

Un soak test o prueba de resistencia es un tipo de prueba de rendimiento que se utiliza para evaluar cómo una aplicación o sistema responde a una carga constante durante un período prolongado de tiempo. Estas pruebas se utilizan para evaluar la estabilidad del sistema a largo plazo y para detectar problemas de rendimiento o degradación del rendimiento que pueden no ser evidentes en pruebas más cortas, por ello el término longevidad.
No tiene mucho sentido añadirlas al proceso de CD en el pipeline pues estas pruebas están previstas para lograr que el sistema se encuentre en funcionamiento durante un largo periodo de tiempo.


**Pregunta 8:¿De qué tratan las pruebas de seguridad?.¿Las pruebas de seguridad deben incluirse en el
proceso de CD como una etapa del pipeline?,¿como se utilizan en el framework (BDD)?**

Las pruebas de seguridad se utilizan para evaluar la seguridad de una aplicación o sistema, estas pruebas pueden incluir la verificación de la protección de datos, la validación de la autenticación y la autorización, y la evaluación de la seguridad de la red y la infraestructura.
Las pruebas de seguridad deben incluirse en el proceso de CD como una etapa del pipeline, ya que la seguridad es un aspecto crítico de cualquier aplicación o sistema. Es importante asegurarse de que el sistema es seguro y protege adecuadamente los datos y la información de los usuarios.

En el framework de desarrollo basado en comportamiento (BDD), las pruebas de seguridad se pueden incluir como parte de las pruebas de aceptación automatizadas. Esto implica la definición de escenarios de prueba que evalúen el cumplimiento de los requisitos de seguridad del sistema y la verificación de que el sistema se comporta de manera segura en diferentes situaciones. Al igual que con otras pruebas de aceptación, estos escenarios de prueba deben basarse en la comprensión común entre el equipo de desarrollo y el cliente de lo que se espera del sistema en términos de seguridad.

**Pregunta 9:¿ De qué trata las pruebas de mantenibilidad?**

Las pruebas de mantenibilidad se utilizan para evaluar la facilidad de mantenimiento y mejora de una aplicación o sistema. Estas pruebas pueden incluir la verificación de la facilidad de entendimiento del código fuente, la verificación de la facilidad de realizar cambios y actualizaciones en el sistema, y la evaluación de la facilidad de depurar y solucionar problemas.

Las pruebas de mantenibilidad son importantes ya que pueden ayudar a garantizar que el sistema es fácil de mantener y mejorar a lo largo del tiempo. Esto puede reducir los costos de mantenimiento y mejora y hacer que sea más fácil agregar nuevas funcionalidades y mejorar el rendimiento del sistema. 

**Pregunta 10:¿ Qué son las pruebas de recuperación?¿Relaciona su uso con la herramienta Chaos Monkey ?**

Las pruebas de recuperación se utilizan para evaluar la capacidad de una aplicación o sistema para recuperarse de fallos o errores. Estas pruebas pueden incluir la verificación de la capacidad del sistema para recuperarse de fallos de componentes individuales, como servidores o bases de datos, y la evaluación de la capacidad del sistema para recuperarse de fallos más amplios, como interrupciones de la red o fallos en la infraestructura.
Justamente se relacionan, ya que Chaos Monkey es una herramienta de pruebas de recuperación, esta es parte del conjunto de herramientas de Netflix denominado Simian Army, que se utiliza para evaluar la resiliencia de los sistemas de Netflix, pues se ejecuta de forma automática en el entorno de producción de Netflix y simula fallos aleatorios en los componentes del sistema para evaluar cómo el sistema responde y se recupera de ellos. Esto ayuda a garantizar que el sistema es resiliente y capaz de recuperarse de fallos inesperados en producción.

**Pregunta 11: Completa toda la actividad indicando el Jenkinsfile y los pasos obtenidos en cada paso.
Explica tus resultados.**

**Versionado de aplicaciones**
**Estrategias de versionado**

**Control de versiones en el pipeline de Jenkins**

Instalamos el complemento Build Timestamp para establecer el formato de la marca de tiempo en la configuración de Jenkins 

[![image.png](https://i.postimg.cc/d02zPKhP/image.png)](https://postimg.cc/kV5jKzNf)

Luego configuramos con 

En los siguientes stage usamos la imagen de Docker, que ahora se encuentran con el sufijo de la etiqueta ${BUILD_TIMESTAMP}.

```
  stage("Docker build") {
                steps {
                    sh "docker build -t dagmarlezama/calculador:${BUILD_TIMESTAMP} ."
                }
          }
          
          stage("Docker push") {
                steps {
                    sh "docker push dagmarlezama/calculador:${BUILD_TIMESTAMP}"
                }
          }

          stage("Deploy to staging") {
                steps {
                    sh "docker run -d --rm -p 8765:8080 --name calculador dagmarlezama/calculador:${BUILD_TIMESTAMP}"
                }
          }
```

**Inventario**

Crearemos los clúster por nuestra cuenta:

[![image.png](https://i.postimg.cc/KY7pLZ2q/image.png)](https://postimg.cc/7C6Nrrb0)

Utilice los siguientes comandos para configurar lo de los clústers:
sudo kubectl config view --context kind-staging

`kubectl config set-cluster staging --server=<server-url> --certificate-authority=<ca-file> --embed-certs=true --context=staging`

`kubectl config use-context kind-staging --kubeconfig staging.config`


[![image.png](https://i.postimg.cc/XXSvL35p/image.png)](https://postimg.cc/xN5Yjwt2)

```
apiVersion: v1
clusters:
- cluster:
    certificate-authority-data: DATA+OMITTED
    server: https://127.0.0.1:36393
  name: kind-production
- cluster:
    certificate-authority-data: DATA+OMITTED
    server: https://127.0.0.1:40271
  name: kind-staging
- cluster:
    insecure-skip-tls-verify: true
    server: https://35.232.61.210
  name: production
- cluster:
    insecure-skip-tls-verify: true
    server: https://127.0.0.1:32769
  name: staging
contexts:
- context:
    cluster: kind-production
    user: kind-production
  name: kind-production
- context:
    cluster: kind-staging
    user: kind-staging
  name: kind-staging
- context:
    cluster: production
    namespace: production
    user: production
  name: production
- context:
    cluster: staging
    namespace: staging
    user: staging
  name: staging
current-context: kind-production
kind: Config
preferences: {}
users:
- name: kind-production
  user:
    client-certificate-data: DATA+OMITTED
    client-key-data: DATA+OMITTED
- name: kind-staging
  user:
    client-certificate-data: DATA+OMITTED
    client-key-data: DATA+OMITTED
    
```





**Versionado**

Agregamos el stage Update version al Jenkinsfile tras haber añadido `image: checha/calculador:{{VERSION}}` en el deployment.yaml:

```
stage("Update version") {
    steps {
        sh "sed -i 's/{{VERSION}}/${BUILD_TIMESTAMP}/g' deployment.yaml"
    }
} 
```

**El entorno de staging remoto**


**El entorno de las pruebas de aceptación**

Añadimos este stage al Jenkinsfile:

```
stage("Acceptance test") {
    steps {
        sleep 60
        sh "chmod +x acceptance-test.sh && ./acceptance-test.sh"
    }
}
```
El archivo acceptance-test.sh será de la siguiente manera:

```
#!/bin/bash
set -x
NODE_IP=$(kubectl get nodes -o jsonpath='{ $.items[0].status.
addresses[?
 (@.type=="ExternalIP")].address }')
NODE_PORT=$(kubectl get svc calculator-service -o=jsonpath='{.
spec.ports[0].nodePort}')
./gradlew acceptan
```

**Lanzamiento**

Agregamos al Jenkinsfile lo siguiente:
```
stage("Release") {
    steps {
        sh "kubectl config use-context production"
        sh "kubectl apply -f hazelcast.yaml"
        sh "kubectl apply -f deployment.yaml"
        sh "kubectl apply -f service.yaml"
    }
}
```

**Prueba de humo**

Agregamos al Jenkinsfile lo siguiente:
```
stage("Smoke test") {
    steps {
        sleep 60
        sh "chmod +x smoke-test.sh && ./smoke-test.sh"
    }
}
```

Finalmente, veremos la construcción finalizada, que no logró resultar exitosa:

[![image.png](https://i.postimg.cc/kGtrTbNy/image.png)](https://postimg.cc/n9ZwzMPs)

Se muestra el console output, que a pesar de intentar aplicar ciertos cambios, no logré solucionarlo. El error tiene que ver con la configuración de kubernetes.

[![image.png](https://i.postimg.cc/7hg4xzCZ/image.png)](https://postimg.cc/hQP6sfbk)