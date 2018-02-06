# CallCenter
Ejercicio de entrevista practico para Almundo.com.
Los test de la aplicacion se encuentran el la clase AppTest, un metodo por test unitario que se necesitó. Se utilizo la libreria de Junit 3.8.1.

## Explicacion

El sistema de llama **CallCenter**. El objeto principal del sistema es el CallCenter, el callcenter esta compuesto por un conjunto ordenado de empleados y un dispatcher que se encarga de manejar las llamdas que van entrando.
Los empleados son modelados con el objecto abstracto **Employee**, que tiene tres implementaciones concretas **Operator**, **Supervisor** y **Director**. Cada una implementa de distinta manera el metodo *getPriority()* que sirve para ordenar a los empleados por jerarquia. Esto es usado por el dispatcher.
El dispatcher es implementado por el objeto **Dispatcher**. El objeto tiene un metodo *distpach()* que recibe una llamada y  asigna a un empleado para atenderla. Para desacoplar la politica de asignacion de esa llamada el dispatcher tiene un objeto que implementa **Selector** que tendra la responsabilidad de elegir de un conjunto empleados al proximo empleado que este libre.
La llamda esta representada con el objeto **Call** y la recibe el CallCenter como parametro del metodo *incomingCall( Call c )*. La llamda implementa *Runnable* para poder correr un *Thread* dedicado a ella y asi poder atender de manera concurrente y asincronica la llegada de las mismas.
Al terminar el ciclo de ejecucion del call center se debe invocar al metodo *releaseDispatcher()* del Dispatcher para que se espere la finalizacion de las llamadas en curso y luego se termine el hilo principal del programa.

#### Cuestiones de Diseño

Se opta por mantener un conjunto ordenado de empleados dado que es mucho mas performante tardar log(n) cada vez que ingresa un nuevo empleado y luego un orden constante al obtener (linael cuando todos los empleados estan ocupados) el proximo a asignar, que buscar en todo el conjunto de empleados tantas veces como jerarquias se tenga cada vez que se quiere asignar. Es ademas mas flexible el diseño a la hora de agregar una nueva jerarquia (por ej Subdirector). Dado que el Selector no esta acoplado a las implementaciones de Employee, solo deberia agregar la implemetacion Subdirector y asignarle una prioridad que este entre las de Director y Supervisor.

### Diagrama de Clases

Este es el diagrama de clases que contiene los metodos principales para un fin meramente ilustrativo del diseño.

![alt text](https://github.com/crack57ar/callcenter/blob/master/callcenter.jpg)

