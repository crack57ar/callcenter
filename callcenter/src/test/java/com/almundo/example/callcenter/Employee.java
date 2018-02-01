package com.almundo.example.callcenter;

public abstract class Employee {
	
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
