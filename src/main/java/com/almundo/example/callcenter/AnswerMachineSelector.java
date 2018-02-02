package com.almundo.example.callcenter;

import java.util.SortedSet;

public class AnswerMachineSelector extends PrioritySelector {
	
	@Override
	public Atendable select(SortedSet<Employee> employees) {
		Atendable atender = super.select(employees);
		if(atender == null) {
			atender = new AnswerMachine("Mensaje chulo!");
		}		
		return atender;		
	}

}
