package com.almundo.example.callcenter;

/**
 * Objeto que representa al manejador de llamadas en espera.
 * Es creado por el Dispatcher y llamada con el mismo como referencia al
 * momento de creacion. Su funcion es esperar que la cola de llamdas on wait 
 * tenga llamadas y se liberen la cantidad de llamdas en curso por debajo de 
 * el maximo de concurrencia para pedirle al Dispatcher que despache la primer
 * llamdas de la cola.
 * 
 ***/

public class OnWaitCallManager implements Runnable{

	private volatile boolean RUNNING = false;
	private Dispatcher dispatcher;	
	
	public OnWaitCallManager(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}
	
	@Override
	public void run() {
		RUNNING = true;
		System.out.println("[OnWaitCallManager] Starting...");
		while(RUNNING) {			
			if(dispatcher.hasOnWait() && Dispatcher.ON_COURSE_CALLS < Dispatcher.CONCURRENT_CALLS) {
				dispatcher.dispatchOnWait();
			}
		}		
	}
	
	public void stopManager() {
		System.out.println("[OnWaitCallManager] Stoping...");
		RUNNING = false;		
	}

}
