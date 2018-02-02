package com.almundo.example.callcenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
	private Queue<Call> onwaitcalls;
	private Thread owmThread;
	private OnWaitCallManager owm;
	
	
	public Dispatcher(Selector selector, SortedSet<Employee> employees) {
		super();
		this.selector = selector;
		this.employees = employees;
		this.oncoursecalls = new ArrayList<Thread>();
		this.onwaitcalls = new LinkedList<Call>();
		this.owm = new OnWaitCallManager(this);
		this.owmThread = new Thread(owm);		
		this.owmThread.start();
	}
	
	
	/* Ahora nunca pasara que al seleccion del que atendera la llamada sea null, tendremos un contestador */
	public void dispatch(Call c) {
		Atendable selected = selector.select(employees);
		synchronized (LLAMADAS_EN_CURSO) {
			if (LLAMADAS_EN_CURSO < LLAMADAS_CONCURRENTES) {
				c.assignCall(selected);
				Thread oncoursecall = new Thread(c);
				oncoursecall.start();
				oncoursecalls.add(oncoursecall);
			}else {
				onwaitcalls.add(c);
				System.out.println("agrego a la cola de espera :" + onwaitcalls.toString());
			}
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
			for (int i = 0; i < oncoursecalls.size(); i++) {
				oncoursecalls.get(i).join();
			}
			this.owm.stopManager();
			this.owmThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void dispatchOnWait() {
		Call c = onwaitcalls.poll();
		System.out.println("saco llamada de la cola de espera :" + onwaitcalls.toString());
		dispatch(c);		
	}

	public boolean hasOnWait() {
		return !onwaitcalls.isEmpty();
	}

}
