package com.infoshareacademy.pomaranczowi.financialanalyser;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.assertj.core.util.VisibleForTesting;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

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
        assertTrue( true );
    }
}
