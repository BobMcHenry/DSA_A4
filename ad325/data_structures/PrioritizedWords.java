package ad325.data_structures;

import java.util.Arrays;

/**
 * AD325: Assignment 4 - Check Version
 * Implement a min heap using pairs of integers to prioritize string values
 * @author Bob McHenry
 * @version 02/15/2016
 */
public class PrioritizedWords implements PriorityStringQueueInterface {

    PQStringNode[] heap;
    int size;
    int numChildren;

    public PrioritizedWords() {
        size = 0;
        heap = new PQStringNode[10];
        numChildren = 4;
    }

    @Override
    public boolean add(String s, int p) {
        if (s.equals(null) || s.equals("")){
            throw new IllegalArgumentException("String argument cannot be null or empty.");
        }

        //Check array capacity against size, double if needed.
        if (size == heap.length-1){
            heap = Arrays.copyOf(heap, heap.length*2);
        }

        //Add to first open index, increment size
        heap[++size] = new PQStringNode(s, p);

        //Check parent for heapness. If not first node of tree,
        // verify parent has lower priority value.
        if(size > 1){
            if (heap[size].priority > heap[getParentIndex(size)].priority){
                return true;
            } else {
               return bubbleUp(size);
            }
        }

        return true;
    }


    @Override
    public String peek() {
        if (size < 1){
            throw new IllegalStateException("Structure is empty.");
        }
        return heap[1].string;
    }

    @Override
    public void clear() {
        size = 0;
        heap = new PQStringNode[10];
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(heap, heap.length);

    }
    @Override
    public String remove() {
        if (size < 1){
            throw new IllegalStateException("Structure is empty.");
        }
        // pop top value off of heap and replace with value from heap[size]
        String output = peek();
        // Move last to top
        heap[1] = heap[size--];
        // Null old last value
        heap[size+1] = null;
        // Bubble value down
        bubbleDown();
        return output;
    }


    @Override
    public String toString(){
        PQStringNode[] out = (PQStringNode[])toArray();

        int index =1;
        int pow = 1;
        String s = index + ":   " + out[index++];

        while (index < size+1) {
            s += "\n" + index + ":   " + out[index++];
        }
        return s+"\n";
    }


    private boolean bubbleUp(int childIndex){
        // Swap child and parent
        int parentIndex = getParentIndex(childIndex);
        swap(parentIndex, childIndex);

        //Check parent for swap
        if (parentIndex > 1 && hasHigherPriorityParent(parentIndex)){
            return bubbleUp(parentIndex);
        } else {
            return true;
        }
    }
    private boolean hasHigherPriorityParent(int childIndex){
        int parentIndex = getParentIndex(childIndex);
        return heap[childIndex].priority < heap[parentIndex].priority;
    }

    private void bubbleDown() {
        // Swap parent with child if parent priority is higher than child priority
        // Repeat until no children or no higher priority children.
        int index = 1;
        boolean heapConditionNotMet = true;

        //check all children for lowest priority
        while (heapConditionNotMet){
            int childForSwap = getHighestPriorityChild(index);
            if (isValidIndex(childForSwap) && heap[index].priority > heap[childForSwap].priority){
                swap(index, childForSwap);
                index = childForSwap;
            } else {
                heapConditionNotMet = false;
            }
        }
    }

    // Highest priority is lowest number
    private int getHighestPriorityChild(int parInd){
        int leftChild = getLeftChildIndex(parInd);
        int rightChild = getrightChildIndex(parInd);
        int minChild = leftChild;

        for (int i = leftChild; i <= rightChild; i++){
            if (isValidIndex(i) && heap[i].priority < heap[minChild].priority){
                minChild = i;
            }
        }

        return minChild;
    }


    private int getLeftChildIndex(int parentIndex){
        return (parentIndex * numChildren) + (2 - numChildren);
    }

    private int getrightChildIndex(int parentIndex){
        return (parentIndex * numChildren) + (1 + numChildren);
    }


    private void swap(int parent, int child){
        PQStringNode temp = heap[child];
        heap[child] = heap[parent];
        heap[parent] = temp;
    }

    private boolean isValidIndex(int index){
        return  index <= size
                && heap[index] != null
                && index > 0;
    }

    private int getParentIndex(int childIndex){
        return (childIndex + numChildren - 2) / numChildren;
    }
}

class PQStringNode{
    String string;
    int priority;

    PQStringNode(String s, int pri){
        string = s;
        priority = pri;
    }

    public String toString(){
        return (priority + " : " + string);
    }
}
