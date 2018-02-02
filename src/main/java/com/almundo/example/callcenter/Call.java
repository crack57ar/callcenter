package com.almundo.example.callcenter;


public class Call implements Runnable{

	private Employee employee;
	public static final int MIN_DURATION = 5;
	public static final int MAX_DURATION = 10;
			
	
	private void endCall() {
		Dispatcher.LLAMADAS_EN_CURSO--;
		System.out.println("llamada de " + employee.toString() + " termino " + " [llamadas en curso: " + Dispatcher.LLAMADAS_EN_CURSO + "]");
		employee.setOcupaid(false);
		employee = null;
	}
	
	public void assignCall(Employee e) {
		employee = e;
		employee.setOcupaid(true);
		Dispatcher.LLAMADAS_EN_CURSO++;
		System.out.println("llamada de " + employee.toString() + " [llamadas en curso: " + Dispatcher.LLAMADAS_EN_CURSO + "]");
	}
	
	public boolean isAssigned() {
		return employee != null;
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

}
