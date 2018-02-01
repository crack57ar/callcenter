package com.almundo.example.callcenter;

public class Supervisor extends Employee {

	public Supervisor(String name) {
		super(name);		
		super.setPriority(2);
	}
	
	@Override
	public String toString() {
		return "Supervisor [" + this.getName() +  "]";
	}
	
}
