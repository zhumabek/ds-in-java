package Queue;

import java.util.ArrayList;

public class Queue<T> {

    private int size;
    private int start;
    private final ArrayList<T> items;

    public Queue(){
        this.items = new ArrayList<>();
        this.size = 0;
        this.start = 0;
    }

    public boolean isEmpty(){
        return this.size == this.start;
    }

    public int size(){
        return this.size - this.start;
    }

    public T peek() {
        return this.items.get(this.start);
    }

    public void enqueue(T val){
        this.size += 1;
        this.items.add(val);
    }

    public T dequeue(){
        if(this.size == this.start){
            throw new IllegalStateException("Queue is empty");
        }

        var poppedFromStart = this.items.get(this.start);

        this.items.set(this.start, null);
        this.start += 1;

        return poppedFromStart;
    }
}
