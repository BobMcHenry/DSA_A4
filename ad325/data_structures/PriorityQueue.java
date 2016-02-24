package ad325.data_structures;
import java.util.Arrays;
/**
 * Created by bobm on 2/11/16.
 * WIP
 */
@SuppressWarnings("unchecked")
public class PriorityQueue<E extends java.lang.Comparable<E>> implements PriorityQueueInterface<E>,
        ComparatorConstructorImplemented, BooleanConstructorImplemented,
        NaryTreeConstructorImplemented {

    /**
     * Number of elements in structure
     */
    int size;

    /**
     * Number of children per node in structure
     */
    int numChildren;

    /**
     * Array structure to hold PQ values as NodeData objects
     */
    E[] heap;

    /**
     *
     */
    boolean isMinHeap;

    /**
     * 4-ary constructor, creates an empty 4-ary heap
     * @param isMinHeap Boolean value. Creates min-heap if true, max heap if false.
     */
    public PriorityQueue(boolean isMinHeap){
        size = 0;
        numChildren = 4;
        //Init to 10 elements, double on fill
        heap = (E[])new Object[10];
        this.isMinHeap = isMinHeap;

    }
    /**
     *  Creates an empty n-ary heap.
     *
     *  @param nAry Number of children per node. Limited to 2-16 inclusive.
     *  @throws IllegalArgumentException when nAry valy is not in range 2-16 inclusive.
     */
    public PriorityQueue(int nAry, boolean isMinHeap){
        this(isMinHeap);

        // Input validation for numChildren range
        if (nAry > 16 || nAry < 2){
            throw new IllegalArgumentException("Value out of range. 2-16 inclusive.");
        }

        numChildren = nAry;
    }



    public boolean add(E e) {
        //Add to first empty index to maintain completeness.
        heap[++size] = e;
        //Check parent value, bubble up as needed.
        return false;
    }

    public E remove() {
        //Pull top val, replace index with last value, bubble down as necessary
        return null;
    }

    public E peek() {
        //Check for empty structure
        if (size == 0){
            throw new IllegalStateException("Empty Structure");
        }

        return heap[1];
    }

    public void clear() {
        size = 0;
        heap = (E[])new Object[10];
    }

    public int size() {
        return size;
    }

    public E[] toArray() {
        return null; //Arrays.copyOf(heap);
    }
}
