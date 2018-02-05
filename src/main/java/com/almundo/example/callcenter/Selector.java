package com.almundo.example.callcenter;

import java.util.Set;

/**
 * La interfaz Selector representa a los objetos capaces de selecionar un empleado de 
 * un conjunto a partir de cierto criterio.
 * 
 * **/
public interface Selector {

	Atendable select (Set<Employee> employees);
	
}
