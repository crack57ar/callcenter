package com.almundo.example.callcenter;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

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
		this.dispatcher = new Dispatcher(new PrioritySelector(),employees);		
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
		System.out.println("llamdas en curso: " + Dispatcher.LLAMADAS_EN_CURSO);
	}
	
	public void incomingCall(Call call) {
		dispatcher.dispatch(call);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.employees.toString();
	}
	
}
