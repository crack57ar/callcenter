package com.almundo.example.callcenter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit tests 
 */
public class AppTest extends TestCase
{
    
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    private void testNCalls(int callAmount, int employeeAmount)
    {
    	CallCenter cc = new CallCenter();
    	
    	
    	for (int i = 0; i < (employeeAmount)/2; i++) {
    		Employee op = new Operator("EL SUFRIDO_"+i);    		    		
    		cc.addEmployee(op);    		    		
    	}
    	
    	for (int i = 0; i < (employeeAmount-employeeAmount/2)-1; i++) {    		
    		Employee sup = new Supervisor("EL VIGILANTE_"+i);    		    		
    		cc.addEmployee(sup);    		
    	}
    	Employee dir = new Director("EL JEFE");
    	cc.addEmployee(dir);
    	
    	System.out.println("---- Lista de empleados en orden de prioridad ----");
    	System.out.println(cc.toString());
    	System.out.println("");
    	
    	cc.startCallCenter();
    	
    	for (int i = 0; i < callAmount; i++) {
    		Call c = new Call();
    		cc.incomingCall(c);
    	}
    	
    	System.out.println("\n-------------- no mas llamadas entrantes ------------------\n");
    	
    	cc.stopCallCenter();
    }
    
    /**
     * Test con exactamente 10 llamadas y exactamente 10 empleados 
     */
    public void testTenCalls() {
    	testNCalls(10,10);
    }
    
    /**
     * Test con mas de 10 llamadas y exactamente 10 empleados 
     */
    public void testMorethanTenCalls() {
    	testNCalls(15,10);
    }
    
    /**
     * Test con menos de 10 llamadas y menos de 10 empleados 
     */
    
    public void testLessthanTenCalls() {
    	testNCalls(5,10);
    }
    
    /**
     * Test con exactamente 10 llamadas y sin suficintes empleados
     */
    public void testTenCallsNotEnoughtEmployees() {
    	testNCalls(10,8);
    }
    
    /**
     * Test con mas de 10 llamadas y exactamente 10 empleados 
     */
    public void testMorethanTenCallsEnoughtEmployees() {
    	testNCalls(15,15);
    }
    
    
}
