package com.almundo.example.callcenter;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

/**
 * Implementacion de un dispatcher que pone on wait a las llamadas 
 * cuando llega al maximo de llamadas concurrentes.
 * */
public class Dispatcher {
	
	public static Integer LLAMADAS_EN_CURSO = 0;
	public static final int LLAMADAS_CONCURRENTES = 10;
	
	private Selector selector;
	private SortedSet<Employee> employees;
	private List<Thread> oncoursecalls;
	
	
	public Dispatcher(Selector selector, SortedSet<Employee> employees) {
		super();
		this.selector = selector;
		this.employees = employees;
		this.oncoursecalls = new ArrayList<Thread>();
	}
	
	public void dispatch(Call c) {
		Employee selected = selector.select(employees);
		if(selected != null) {
			synchronized (LLAMADAS_EN_CURSO) {
				if (LLAMADAS_EN_CURSO <= LLAMADAS_CONCURRENTES) {
					c.assignCall(selected);
					Thread oncoursecall = new Thread(c);
					oncoursecall.start();
					oncoursecalls.add(oncoursecall);
				}else {
					System.err.println("No se aceptan mas llamadas concurrentes, llamdas en curso: " + LLAMADAS_EN_CURSO);
				}
			}		
		}else {
			System.out.println("No hay empleados libres!");
		}
	}
	
	public Selector getSelector() {
		return selector;
	}

	public void setSelector(Selector selector) {
		this.selector = selector;
	}
	
	public void releaseDispatcher() {
		try {
			for (Thread oncoursecall : oncoursecalls) {
				oncoursecall.join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
