package com.almundo.example.callcenter;


public class Call implements Runnable{

	private Employee employee;
	
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
				Thread.sleep(1000);
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
