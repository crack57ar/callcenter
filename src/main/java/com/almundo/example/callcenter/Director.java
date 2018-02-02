package com.almundo.example.callcenter;

public class Director extends Employee {
	
	public Director(String name) {
		super(name);
		super.setPriority(10);
	}
	
	@Override
	public String toString() {
		return "Director [" + getName() +  "]";
	}
}
