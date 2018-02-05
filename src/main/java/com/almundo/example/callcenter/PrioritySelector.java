package com.almundo.example.callcenter;

import java.util.Set;

/**
 * Implementacion de Selector que asume tener el conjunto de empleados ordenado 
 * por prioridad. Selecciona el priemro libre. Si no tiene ninguno devuelve un valor 
 * Nulo.
 **/

public class PrioritySelector implements Selector {

	/* 
	 * Metodo que busca los empleados de prioridad 30 o 20 o 10 en ese orden. 
	 * El Set se asume ordenado por prioridad. Solo debo encontrar el primero libre.
	 */
	public Atendable select(Set<Employee> employees) {
		
		Atendable selected = null;
		
		for (Atendable employee : employees) {
			if(!employee.isOcupaid()) {
				selected = employee;
			}
		}
		
		return selected;
	}

}
