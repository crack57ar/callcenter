package com.almundo.example.callcenter;

/**
 * Objeto que representa un empleado, implementa Atendable para poder
 * atender llamadas. Tienen un numero de legajo auto-incremental, un nombre 
 * y una prioridad que cambia segun la implementacion. Cada implementacion de 
 * un empleado tendra una prioridad acorde a su jerarquia.
 * 
 * **/

public abstract class Employee implements Atendable{
	
	private static int EMPLOYEE_NUMBER = 0;
	private String name;
	private int socialId;
	private int priority;
	private boolean ocupaid; 
	
	public Employee(String name) {
		this.name = name;
		EMPLOYEE_NUMBER++;
		this.socialId = EMPLOYEE_NUMBER;
		this.ocupaid = false;
	}
	
	public boolean isOcupaid() {
		return ocupaid;
	}
	
	public void setOcupaid(boolean o) {
		ocupaid = o;
	}
	
	public String getName() {
		return name;
	}

	public int getSocialId() {
		return socialId;
	}

	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
}
