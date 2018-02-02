package com.almundo.example.callcenter;

public class OnWaitCallManager implements Runnable{

	private volatile boolean RUNNING = false;
	private Dispatcher dispatcher;	
	
	public OnWaitCallManager(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}
	
	@Override
	public void run() {
		RUNNING = true;
		System.out.println("empiezo a correr....");
		while(RUNNING) {			
			if(dispatcher.hasOnWait() && Dispatcher.LLAMADAS_EN_CURSO < Dispatcher.LLAMADAS_CONCURRENTES) {
				dispatcher.dispatchOnWait();
			}
		}
		System.out.println("dejo a correr, ojo!....");
	}
	
	public void stopManager() {
		System.out.println("deteniendo el OnWaitManager...");
		RUNNING = false;		
	}

}
