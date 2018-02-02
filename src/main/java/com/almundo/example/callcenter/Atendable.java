package com.almundo.example.callcenter;

/**
 * Interfaz a ser implementada por cualquier objeto que sea capaz de atender 
 * una llamada. 
 * 
 ****/

public interface Atendable {
	
	public boolean isOcupaid();
	
	public void setOcupaid(boolean o);

}
