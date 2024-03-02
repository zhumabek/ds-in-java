package Heap;


import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>>  {
    private final ArrayList<T> items;

    public MaxHeap(){
        this.items = new ArrayList<>();
    }

    public Integer size(){
        return this.items.size();
    }

    private Integer getParentNodeIndex(Integer currentNodeIndex){
        return (currentNodeIndex - 1) / 2;
    }

    private void heapify(Integer currentNodeIndex){
        if(currentNodeIndex == 0){
            return;
        }

        var currentNode = this.items.get(currentNodeIndex);

        var parentNodeIndex = getParentNodeIndex(currentNodeIndex);
        var parentNode = this.items.get(parentNodeIndex);

        if(currentNode.compareTo(parentNode) < 0){
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
                    parent.compareTo(leftChild) < 0 &&
                    parent.compareTo(rightChild) < 0
                ){
                    swapIndex = rightChild.compareTo(leftChild) > 0 ? rightChildIndex : leftChildIndex;
                } else if(parent.compareTo(leftChild) < 0){
                    swapIndex = leftChildIndex;
                } else if (parent.compareTo(rightChild) < 0) {
                    swapIndex = rightChildIndex;
                } else {
                    break;
                }
            } else if (leftChildIndex < size() && parent.compareTo(this.items.get(leftChildIndex)) < 0) {
                swapIndex = leftChildIndex;
            } else if (rightChildIndex < size() && parent.compareTo(this.items.get(rightChildIndex)) < 0) {
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

    public void display(){
        StringBuilder result = new StringBuilder();
        this.items.forEach((i) -> {
            result.append(i + ", ");
        });
        System.out.println(result);
    }
    
}
