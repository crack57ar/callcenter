package com.almundo.example.callcenter;

public class AnswerMachine implements Atendable {

	private String mensaje;
	
	public AnswerMachine(String mensaje) {
		this.mensaje = mensaje;
	}
	@Override
	public boolean isOcupaid() {
		// nunca estara ocupado el contestador
		return false;
	}

	@Override
	public void setOcupaid(boolean o) {
		//.. aqui no necesito hacer nada :D
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Contestador [ mensaje : "+mensaje+" ]";
	}
	

}
