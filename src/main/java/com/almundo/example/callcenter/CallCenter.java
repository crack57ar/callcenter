package com.almundo.example.callcenter;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Objeto que representa la entidad principal del dominio del problema, 
 * un Call Center, contiene un conjunto de empleados ordenados por prioridad
 * y un dispatcher  
 ***/

public class CallCenter {
		
	private SortedSet<Employee> employees;
	private Dispatcher dispatcher;
	
	
	public CallCenter() {
		super();		
		Comparator<Employee> comp = new Comparator<Employee>() {

			public int compare(Employee o1, Employee o2) {
					int prio = o1.getPriority()-o2.getPriority();
				return prio == 0 ?  o1.getSocialId()-o2.getSocialId() : prio;
			}
		};
		this.employees = new TreeSet<Employee>(comp);
		this.dispatcher = new Dispatcher(new AnswerMachineSelector(),employees);		
	}

	public void startCallCenter() {
		//...
	}
	
	public void addEmployee(Employee e) {
		employees.add(e);
	}
	
	public void stopCallCenter() {
		//...
		dispatcher.releaseDispatcher();		
		System.out.println("llamdas en curso: " + Dispatcher.ON_COURSE_CALLS);
	}
	
	public void incomingCall(Call call) {
		dispatcher.dispatch(call);
	}
	
	@Override
	public String toString() {
		return this.employees.toString();
	}
	
}
