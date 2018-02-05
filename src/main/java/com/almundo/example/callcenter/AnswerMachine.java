package com.almundo.example.callcenter;

/** 
 * Objeto que implementa Atendable con la intencion de poder ser usado por un Selector 
 * y ser capaz de atender una llamada entrante. Es clasicamente un Mock de un contestador.
 * 
 **/

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
		return "Contestador [ mensaje : "+mensaje+" ]";
	}
	

}
