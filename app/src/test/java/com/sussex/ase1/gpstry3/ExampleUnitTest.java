package com.sussex.ase1.gpstry3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        MainActivity myUnit = new MainActivity();

        assertTrue (myUnit.validPostcode("QN1 9PE"));
    }
}