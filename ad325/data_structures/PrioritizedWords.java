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
        numChildren = 4;
    }

    @Override
    public boolean add(String s, int p) {
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

    private boolean bubbleUp(int childIndex){
        // Swap child and parent
        int parentIndex = getParentIndex(childIndex);
        swap(parentIndex, childIndex);

        //Check parent for swap
        if (parentIndex > 1 && hasSmallerChildren(parentIndex)){
            return bubbleUp(parentIndex);
        } else {
            return true;
        }
    }

    private boolean hasSmallerChildren(int parentIndex){
        return heap[parentIndex].priority < heap[getParentIndex(parentIndex)].priority;
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

        // pop top value off of heap and replace with value from heap[size]
        String output = peek();
        // Move last to top
        heap[1] = heap[size--];
        // Null old last value
        heap[size+1] = null;
        // Bubble value down
        bubbleDown(1);
        return output;
    }

    private void bubbleDown(int index) {
        // get left child index
        int leftChild = getLeftChildIndex(index);
        // Swap parent with child if parent priority is > child priority
        // Repeat until no children or no higher priority children.
        int lowestIndex = index;
        PQStringNode lower = heap[index];

        //get smallest child
        for (int i = leftChild; i < leftChild + numChildren; i++) {
            if (i < size && heap[i] != null && lower.priority > heap[i].priority) {
                lower = heap[i];
                lowestIndex = i;
            }
        }

        if (!lower.equals(heap[index])) {
            heap[lowestIndex] = heap[index];
            heap[index] = lower;
            bubbleDown(lowestIndex);
        }

    }

    private int getLeftChildIndex(int parentIndex){
        return (parentIndex * numChildren) - (numChildren - 2);
    }

    private PQStringNode getSmallestChild(PQStringNode parent){
        return null;
    }

    private void swap(int parent, int child){
        PQStringNode temp = heap[child];
        heap[child] = heap[parent];
        heap[parent] = temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(heap, heap.length);

    }

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
        return (priority + ":" + string);
    }
}
