package com.almundo.example.callcenter;

import java.util.SortedSet;

public interface Selector {

	Employee select (SortedSet<Employee> employees);
	
}
