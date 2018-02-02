package com.almundo.example.callcenter;

public class Supervisor extends Employee {

	public Supervisor(String name) {
		super(name);		
		super.setPriority(20);
	}
	
	@Override
	public String toString() {
		return "Supervisor [" + this.getName() +  "]";
	}
	
}
