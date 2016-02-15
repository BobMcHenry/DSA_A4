package ad325.data_structures;

import java.util.Arrays;

/**
 * Created by bobm on 2/12/16.
 */
public class PrioritizedWords implements PriorityStringQueueInterface {

    PQStringNode[] heap;
    int size;
    int numChildren;

    public PrioritizedWords() {
        size = 0;
        heap = new PQStringNode[10];
        numChildren = 3;
    }

    @Override
    public boolean add(String s, int p) {
        //Check array capacity against size, double if needed.
        if (size == heap.length-1){
            heap = Arrays.copyOf(heap, heap.length*2);
        }

        //Add to first open index, increment size
        heap[++size] = new PQStringNode(s, p);

        //Check parent for heapness
        if (p < getParentIndex(p)){
            return true;
        } else {
           return swap(p);
        }
    }

    @Override
    public String peek() {
        return heap[1].string;
    }

    @Override
    public void clear() {
        size = 0;
        heap = new PQStringNode[10];
    }

    @Override
    public String remove() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    public int getParentIndex(int childIndex){
        return (childIndex + numChildren - 2) / numChildren;
    }

    public boolean swap(int childIndex){
        PQStringNode temp = heap[childIndex];;
        heap[childIndex] = heap[getParentIndex(childIndex)];
        heap[getParentIndex(childIndex)] = temp;

        if (heap[childIndex].priority > heap[getParentIndex(childIndex)].priority){
            return swap(ch  ildIndex);
        } else {
            return true;
        }
    }
}

class PQStringNode{
    String string;
    int priority;

    PQStringNode(String s, int pri){
        string = s;
        priority = pri;
    }

}
