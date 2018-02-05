package com.almundo.example.callcenter;

import java.util.Set;

/**
 * Implementacion de un selector que extiende a un PrioritySelector 
 * para agregarle la funcionalidad de seleccionar una maquina contestadora 
 * en caso de no tener mas empleados. 
 * 
 * **/

public class AnswerMachineSelector extends PrioritySelector {
	
	@Override
	public Atendable select(Set<Employee> employees) {
		Atendable atender = super.select(employees);
		if(atender == null) {
			atender = new AnswerMachine("Mensaje chulo!");
		}		
		return atender;		
	}

}
