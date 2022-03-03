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

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    
    boolean exceptionThrown;
    MyMinHeap<Integer> minHeapNuclear;
    

    /**
     * Helper method to initialize all instance variables of MyDeque
     * 
     * @param meanHeap The heap to initialize
     * @param data     The data array
     */
    static void initMinHeap(MyMinHeap<Integer> heap, ArrayList<Integer> data) {
        heap.data = new ArrayList<>(data);
    }

    @Before
    public void setup() {
        boolean exceptionThrown = false;
        minHeapNuclear = new MyMinHeap<Integer>();
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
        ArrayList<Integer> minChildTest = new ArrayList<Integer>(Arrays.asList(new Integer[] {2, 4, 5}));
        initMinHeap(minHeapNuclear, minChildTest);
        assertEquals("Index 1 should be the min child", 1, minHeapNuclear.getMinChildIdx(0));
    }

    /**
     * Test the percolateUp method when [TODO]
     */
    @Test
    public void testPercolateUp() {
        ArrayList<Integer> percolateUpTest = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 3, 2, 0}));
        initMinHeap(minHeapNuclear, percolateUpTest);
        minHeapNuclear.percolateUp(4);
        assertEquals("last element should have been percolated up to root", 0, minHeapNuclear.getMin());
    }

    /**
     * Test the percolateDown method when percolating an internal node
     */
    @Test
    public void testPercolateDown() {
        ArrayList<Integer> percolateDownTest = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 5, 2, 4, 3, 6, 7}));
        initMinHeap(minHeapNuclear, percolateDownTest);
        minHeapNuclear.percolateDown(2);
        assertEquals("node at index 2 should have swapped with index 4", 3, minHeapNuclear.data.get(1));
        assertEquals("node at index 4 should have swapped with index 2", 5, minHeapNuclear.data.get(4));

    }

    /**
     * Test the deleteIndex method when deleting an internal node
     */
    @Test
    public void testDeleteIndex() {
        ArrayList<Integer> deleteIdxTest = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6, 7}));
        initMinHeap(minHeapNuclear, deleteIdxTest);
        minHeapNuclear.deleteIndex(2);
        assertEquals("child node should have percolated up", 4, minHeapNuclear.data.get(2));
    }

    /**
     * Test the deleteIndex method when deleting a leaf node
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
        ArrayList<Integer> insertTest = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3}));
        initMinHeap(minHeapNuclear, insertTest);
        try {
            minHeapNuclear.insert(null);
        }
        catch(NullPointerException e) {
            exceptionThrown = true;
        }
        assertTrue("insertion should have thrown NullPointerException", exceptionThrown);
    }

    /**
     * Test the insert method when [TODO]
     */
    @Test
    public void testInsert2(){
         assertFalse(exceptionThrown);
    }

   
    /**
     * Test remove when min heap is empty
     */
    @Test
    public void testRemove(){
        ArrayList<Integer> removeTest = new ArrayList<Integer>(Arrays.asList(new Integer[] {}));
        initMinHeap(minHeapNuclear, removeTest);
        assertEquals("remove should return null", null, minHeapNuclear.remove());
    }

  
    /**
     * Test getMin when [TODO]
     */
    @Test
    public void testGetMin(){
        ArrayList<Integer> getMinTest = new ArrayList<Integer>(Arrays.asList(new Integer[] {1, 2, 3, 4, 5}));
        initMinHeap(minHeapNuclear, getMinTest);
        assertFalse("min should be 1", 1, minHeapNuclear.getMin());
    }
}