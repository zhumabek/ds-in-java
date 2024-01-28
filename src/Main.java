import Queue.Queue;

public class Main {
    public static void main(String[] args) {
        var queue = new Queue<Integer>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
            System.out.println(queue.size());
        }
    }
}