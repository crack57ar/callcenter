package com.almundo.example.callcenter;

import java.util.SortedSet;

public class PrioritySelector implements Selector {

	public Atendable select(SortedSet<Employee> employees) {
		/* Metodo que busca los empleados de prio 1 o 2 o 3 en ese orden. 
		 * El Set se asume ordenado por prioridad. Solo debo encontrar el primero libre.
		 */
		Atendable selected = null;
		
		for (Atendable employee : employees) {
			if(!employee.isOcupaid()) {
				selected = employee;
			}
		}
		
		return selected;
	}

}
