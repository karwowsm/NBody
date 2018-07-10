package Logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.lang.Math.sqrt;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateusz
 */
public class VectorTest {
    
    private Vector myinstance;
    
    @Before
    public void setUp() {
        myinstance = new Vector(3, 5, 6);        
    }
    
    @After
    public void tearDown() {
        myinstance = null;        
    }

    /**
     * Test of addVectors method, of class Vector.
     */
    @Test
    public void testAddVectors() {
        System.out.println("addVectors");
        Vector v = new Vector(2, 4, 5);
        Vector instance = myinstance;
        assertEquals(instance.addVectors(v), new Vector(5, 9, 11));
    }

    /**
     * Test of substractVectors method, of class Vector.
     */
    @Test
    public void testSubstractVectors() {
        System.out.println("substractVectors");
        Vector v = new Vector(5, 7, 8);
        Vector instance = myinstance;
        assertEquals(instance.substractVectors(v), new Vector(-2, -2, -2));
    }
    
    /**
     * Test of multiplyVector method, of class Vector.
     */
    @Test
    public void testMultiplyVector() {
        System.out.println("multiplyVector");
        double scalar = 3.0;
        Vector instance = myinstance;
        assertEquals(instance.multiplyVector(scalar), new Vector(9, 15, 18));
    }

    /**
     * Test of vectorLength method, of class Vector.
     */
    @Test
    public void testVectorLength() {
        System.out.println("vectorLength");
        Vector instance = myinstance;
        assertEquals(instance.vectorLength(), sqrt(70), 0.0);
    }
    
}
