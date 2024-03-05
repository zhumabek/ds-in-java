package PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQueue<T> {

    private final Comparator<T> comparator;
    private final ArrayList<T> items;

    public PriorityQueue(Comparator<T> comparator){
        this.items = new ArrayList<>();
        this.comparator = comparator;
    }

    public Integer size(){
        return this.items.size();
    }

    private Integer getParentNodeIndex(Integer currentNodeIndex){
        return (currentNodeIndex - 1) / 2;
    }

    private Integer compare(T var1, T var2){
        return comparator.compare(var1, var2);
    }

    private void heapify(Integer currentNodeIndex){
        if(currentNodeIndex == 0){
            return;
        }

        var currentNode = this.items.get(currentNodeIndex);

        var parentNodeIndex = getParentNodeIndex(currentNodeIndex);
        var parentNode = this.items.get(parentNodeIndex);

        if(compare(parentNode, currentNode) < 0){
            return;
        }


        this.items.set(parentNodeIndex, currentNode);
        this.items.set(currentNodeIndex, parentNode);

        heapify(parentNodeIndex);
    }

    public void insert(T val){
        this.items.add(val);

        if(size() == 1){
            return;
        }

        var currentNodeIndex = size() - 1;
        heapify(currentNodeIndex);
    }

    private void sinkDown(){
        var idx = 0;

        while(idx < size()){
            var parent = this.items.get(idx);
            var leftChildIndex = (idx * 2) + 1;
            var rightChildIndex = (idx * 2) + 2;
            int swapIndex;

            if(leftChildIndex < size() && rightChildIndex < size()){
                var leftChild = this.items.get(leftChildIndex);
                var rightChild = this.items.get(rightChildIndex);
                if(
                    compare(parent, leftChild) > 0 &&
                            compare(parent, rightChild) > 0
                ){
                    swapIndex = compare(rightChild, leftChild) < 0 ? rightChildIndex : leftChildIndex;
                } else if(compare(parent, leftChild) > 0){
                    swapIndex = leftChildIndex;
                } else if (compare(parent, rightChild) > 0) {
                    swapIndex = rightChildIndex;
                } else {
                    break;
                }
            } else if (leftChildIndex < size() && compare(parent, this.items.get(leftChildIndex)) > 0) {
                swapIndex = leftChildIndex;
            } else if (rightChildIndex < size() && compare(parent, this.items.get(rightChildIndex)) > 0) {
                swapIndex = rightChildIndex;
            } else {
                break;
            }

            this.items.set(idx, this.items.get(swapIndex));
            this.items.set(swapIndex, parent);

            idx = swapIndex;
        }

    }

    public T poll(){
        if(size() == 0){
            return null;
        }
        var max = this.items.getFirst();

        if(size() == 1){
            this.items.removeLast();
            return max;
        }


        this.items.set(0, this.items.getLast());
        this.items.removeLast();
        this.sinkDown();

        return max;
    }

    public T peek(){
        if(size() == 0){
            return null;
        }

        return this.items.getFirst();
    }

    public ArrayList<T> getItems(){
        return this.items;
    }

}
