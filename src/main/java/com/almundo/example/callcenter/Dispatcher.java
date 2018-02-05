package com.almundo.example.callcenter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.SortedSet;

/**
 * Implementacion de un dispatcher que pone 'on wait' a las llamadas 
 * cuando llega al maximo de llamadas concurrentes y manda a un contestado 
 * a atender llamadas cuando no hay mas empleados disponibles.
 * Mientras la solucion orginial no tenia tratamiento para estos casos.
 * 
 * El dispatcher tiene un conjunto ordenado de empleados que se mantiene 
 * ordenado por prioridad. La prioridad es una cualidad de los empleados que me dice, 
 * dada una implementacion de empleado, su jerarquia a la hora de selecionar un 
 * candidato para atender una llamada entrante.  
 *   
 * */
public class Dispatcher {
	
	public static Integer ON_COURSE_CALLS = 0;
	public static final int CONCURRENT_CALLS = 10;
	
	private Selector selector;
	private SortedSet<Employee> employees;  
	private List<Thread> oncoursecalls;
	private Queue<Call> onwaitcalls; // una cola de llamadas, la primera en entrar sera la primera en ser atendida
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
	
	
	/* Metodo que despacha una llamada si es posible, teniendo en cuenta el maximo 
	 * de llamadas concurrentes y los empleados disponibles.
	 * Ahora nunca pasara que al seleccion del que atendera la llamada sea null, 
	 * tendremos un contestador 
	 */
	public void dispatch(Call c) {
		Atendable selected = selector.select(employees);
		synchronized (ON_COURSE_CALLS) {
			if (ON_COURSE_CALLS < CONCURRENT_CALLS) {
				c.assignCall(selected);
				Thread oncoursecall = new Thread(c);
				oncoursecall.start();
				oncoursecalls.add(oncoursecall);
			}else {
				onwaitcalls.add(c);
				System.out.println("Agrego a la cola de espera :" + onwaitcalls.toString());
			}
		}		
	}
	
	public Selector getSelector() {
		return selector;
	}

	public void setSelector(Selector selector) {
		this.selector = selector;
	}
	
	/* metodo que se debe llamar cuando se termina la operacion 
	 * para que no queden llamdas colgadas, lo unico que hara sera 
	 * esperar la terminacion de las llamadas y cerrar el manager de
	 * las llamadas en espera */
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

	/* metodo que es llamado ante el evento en que, habiendo llamadas pendientes, 
	 * se libera una posibilidad de atender una de ellas  */
	public void dispatchOnWait() {
		Call c = onwaitcalls.poll();
		System.out.println("saco llamada de la cola de espera :" + onwaitcalls.toString());
		dispatch(c);		
	}

	public boolean hasOnWait() {
		return !onwaitcalls.isEmpty();
	}

}
