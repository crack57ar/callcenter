# callcenter (solucion alternativa)
Ejercicio de entrevista practico para Almundo.com

## Explicacion de las soluciones

Se piden dos soluciones:
* Cuando me quedo sin empleados: 

Para este caso se opta por una maquina contestadora, esta  atendera toda aquella llamada que no pueda ser atendida por un empleado. El unico limite sigue siendo la cantidad de llamdas concurrentes que puede atender el Dispatcher.
* Cuando me exedo en la cantidad de llamdas concurrentes: 

Para este caso se opto por el manejo de una cola de llamadas en espera. Existe un manager que revisa constantemente la cola de llamadas en espera. Se encola una llamada, cuando el **Dispatcher** esta exedido en llamdas concurrentes. El Manager ve una llamada y en cuanto se libera alguna llamada le pide al **Dispatcher** que realice un dispatch de dicha llamdas nuevamente.

## Diagrama de Clases
En el siguiente diagrama se ven en violeta las clases agregadas al modelo anterior. Se destacan los metodos mas importantes para mantener la simplicidad del diagrama.

![alt text](https://github.com/crack57ar/callcenter/blob/alternative_solution/callcenter.jpg)
