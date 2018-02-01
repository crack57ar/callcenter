package com.almundo.example.callcenter;

public class Director extends Employee {
	
	public Director(String name) {
		super(name);
		super.setPriority(1);
	}
	
	@Override
	public String toString() {
		return "Director [" + getName() +  "]";
	}
}
