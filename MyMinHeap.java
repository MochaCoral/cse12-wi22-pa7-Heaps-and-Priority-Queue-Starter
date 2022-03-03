
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

import java.util.ArrayList;
import java.util.Collection;

/**
 * TODO: Add class header
 */
public class MyMinHeap<E extends Comparable<E>> implements MinHeapInterface <E>{
    
    public ArrayList<E> data;
    
    public MyMinHeap() {
        this.data = new ArrayList<E>();
    }

    public MyMinHeap(Collection<? extends E> collection) throws NullPointerException{
        if(collection == null || collection.contains(null)) {
            throw new NullPointerException();
        }
        this.data = new ArrayList<E>(collection);
        for(int i = this.data.size() - 1; i >= 0; i--) {
            this.percolateDown(i);
        }

    }

    protected void swap(int from, int to) {
        E temp = this.data.get(from);
        this.data.set(from, this.data.get(to));
        this.data.set(to, temp);

    }

    protected int getParentIdx(int index) {
        int  parentIdx = (index - 1) / 2;
        return parentIdx;
    }

    protected int getLeftChildIdx(int index) {
        int leftChildIdx = 2 * index + 1;
        return leftChildIdx;
    }

    protected int getRightChildIdx(int index) {
        int rightChildIdx = 2 * index + 2;
        return rightChildIdx;
    }

    protected int getMinChildIdx(int index) {
        if(2 * index + 1 > this.size()) { //if child index is out of bounds, ergo index is a leaf node
            return -1;
        }
        else {
            E rightChild = this.data.get(getRightChildIdx(index));
            E leftChild = this.data.get(getLeftChildIdx(index));
            if(leftChild.compareTo(rightChild) > 0) {
                return getRightChildIdx(index);
            }
            else if(leftChild.compareTo(rightChild) < 0) {
                return getLeftChildIdx(index);
            }
            else {
                return getLeftChildIdx(index);
            }
        }
    }

    protected void percolateUp(int index) {
        int nodeIdx = index;
        int parentIdx;
        while(nodeIdx > 0) {
            parentIdx = this.getParentIdx(nodeIdx);
            if(this.data.get(nodeIdx).compareTo(this.data.get(parentIdx)) > 0) {
                continue;
            }
            else {
                this.swap(nodeIdx, parentIdx);
                nodeIdx = parentIdx;
            }
        }
    }

    protected void percolateDown(int index) {
        int nodeIdx = index;
        int childIdx = this.getLeftChildIdx(nodeIdx);
        int minIdx;
        E val = this.data.get(nodeIdx);
        E minVal;

        while(childIdx < this.data.size()) {
            minVal = val;
            minIdx = -1;

            for(int i = 0; i < 2 && i + childIdx < this.size(); i++) {
                if(this.data.get(i + childIdx).compareTo(minVal) < 0) {
                    minVal = this.data.get(i + childIdx);
                    minIdx = i + childIdx;
                }
            }

            if(minVal.compareTo(val) == 0) {
                continue;
            }
            else {
                this.swap(nodeIdx, minIdx);
                nodeIdx = minIdx;
                childIdx = getLeftChildIdx(nodeIdx);
            }

        }
    }

    protected E deleteIndex(int index) {
        if(index == 0) {
            return this.data.remove(index);
        }
        else {
            E val;
            this.swap(index, this.data.size() - 1);
            val = this.data.remove(this.data.size() - 1);
            this.percolateDown(index);
            return val;
        }
    }

    @Override
    public void insert(E element) throws NullPointerException {
        if(element == null) {
            throw new NullPointerException();
        }
        this.data.add(element);
        this.percolateUp(this.data.size() - 1);
    }

    @Override
    public E getMin() {
        if(this.data.size() == 0) {
            return null;
        }
        else {
            return this.data.get(0);
        }
    }

    @Override
    public E remove() {
        if(this.size() == 0) {
            return null;
        }
        else { 
            return this.deleteIndex(0);
        }
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public void clear() {
        this.data = new ArrayList<E>();
    }
}