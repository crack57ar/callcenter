package com.almundo.example.callcenter;


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
		Dispatcher.LLAMADAS_EN_CURSO--;
		System.out.println("llamada de " + atendable.toString() + " termino " + " [llamadas en curso: " + Dispatcher.LLAMADAS_EN_CURSO + "]");
		atendable.setOcupaid(false);
		atendable = null;
	}
	
	public void assignCall(Atendable e) {
		atendable = e;
		atendable.setOcupaid(true);
		Dispatcher.LLAMADAS_EN_CURSO++;
		System.out.println("llamada de " + atendable.toString() + " [llamadas en curso: " + Dispatcher.LLAMADAS_EN_CURSO + "]");
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
