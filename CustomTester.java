/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    
    boolean exceptionThrown;

    @Before
    public void setup() {
        boolean exceptionThrown = false;
    }

    /**
     * Test the constructor when collection is null
     */
    @Test
    public void testMyMinHeapConstructor() {
        try {
            MyMinHeap<String> doomed = new MyMinHeap<String>(null);
        }
        catch (NullPointerException e){
            exceptionThrown = true;
        }
        assertTrue("null collection should throw NullPointerException", exceptionThrown);
    }

    /**
     * Test the getMinChildIdx method when called on root
     */
    @Test
    public void testGetMinChildIdx() {
        assertEquals("", 1, 1);
    }

    /**
     * Test the percolateUp method when [TODO]
     */
    @Test
    public void testPercolateUp() {
        assertFalse(exceptionThrown);
    }

    /**
     * Test the percolateDown method when [TODO]
     */
    @Test
    public void testPercolateDown() {
        assertFalse(exceptionThrown);
    }

    /**
     * Test the deleteIndex method when [TODO]
     */
    @Test
    public void testDeleteIndex() {
        assertFalse(exceptionThrown);
    }

    /**
     * Test the deleteIndex method when [TODO]
     */
    @Test
    public void testDeleteIndex2() {
        assertFalse(exceptionThrown);
    }

    /**
     * Test the insert method when [TODO]
     */
    @Test
    public void testInsert(){
        assertFalse(exceptionThrown);
    }

    /**
     * Test the insert method when [TODO]
     */
    @Test
    public void testInsert2(){
         assertFalse(exceptionThrown);
    }

   
    /**
     * Test remove when [TODO]
     */
    @Test
    public void testRemove(){
        assertFalse(exceptionThrown);
    }

  
    /**
     * Test getMin when [TODO]
     */
    @Test
    public void testGetMin(){
        assertFalse(exceptionThrown);
    }
}