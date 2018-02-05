package com.almundo.example.callcenter;

/** 
 * Objeto que representa una llamada, implementa Runnable 
 * para poder correrlo dentro de un Hilo de ejecucion distinto.
 * La llamada es un mock que duerme un tiempo aleatorio entre 5 y 10 segundos.
 * Cada llamada tiene un id unico auto-incremental. 
 * Se modifica en contador de llamadas de la clase Dispatcher (ON_COURSE_CALLS) 
 * a medida que se comienzan y se terminan las llamdas.
 *  
 * **/

public class Call implements Runnable{

	private Atendable atendable;
	public static final int MIN_DURATION = 5;
	public static final int MAX_DURATION = 10;
	private static int CALL_AMOUNT = 0;
	private int callid;
			
	public Call() {
		CALL_AMOUNT++;
		callid = CALL_AMOUNT;		
	}
	
	public int getId() {
		return callid;
	}
	
	private void endCall() {
		Dispatcher.ON_COURSE_CALLS--;
		System.out.println("llamada de " + atendable.toString() + " termino " + " [llamadas en curso: " + Dispatcher.ON_COURSE_CALLS + "]");
		atendable.setOcupaid(false);
		atendable = null;
	}
	
	public void assignCall(Atendable e) {
		atendable = e;
		atendable.setOcupaid(true);
		Dispatcher.ON_COURSE_CALLS++;
		System.out.println("llamada de " + atendable.toString() + " [llamadas en curso: " + Dispatcher.ON_COURSE_CALLS + "]");
	}
	
	public boolean isAssigned() {
		return atendable != null;
	}

	public void run() {
		if(isAssigned()) {
			try {
				Thread.sleep((int)((Math.random()*(Call.MAX_DURATION-Call.MIN_DURATION)+Call.MIN_DURATION) * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.endCall();
			
		} else {
			System.err.println("llamada no asignada!");
		}
	}
	
	@Override
	public String toString() {	
		return "Llamada n° "+this.getId();
	}

}
