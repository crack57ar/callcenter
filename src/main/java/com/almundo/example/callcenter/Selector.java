package com.almundo.example.callcenter;

import java.util.SortedSet;

public interface Selector {

	Atendable select (SortedSet<Employee> employees);
	
}
