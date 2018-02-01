package com.almundo.example.callcenter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	CallCenter cc = new CallCenter();
    	Employee pepe = new Operator("pepe");
    	Employee juan = new Supervisor("juan");
    	cc.addEmployee(pepe);
    	cc.addEmployee(juan);
    	cc.startCallCenter();
    	
    	for (int i = 0; i < 3; i++) {
    		Call c = new Call();
    		cc.incomingCall(c);
    	}
    	
    	cc.stopCallCenter();
    }
}
