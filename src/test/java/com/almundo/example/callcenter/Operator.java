package com.almundo.example.callcenter;

public class Operator extends Employee {

	public Operator(String name) {
		super(name);		
		super.setPriority(3);
	}
	
	@Override
	public String toString() {
		return "Operator [" + getName() +  "]";
	}
	
	
}
