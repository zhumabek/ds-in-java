import Stack.Stack;
import Stack.StackWithLinkedList;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        var stack = new Stack<Integer>();

        for (int i = 0; i < 10000000; i++) {
            stack.push(i);
        }

        while(!stack.isEmpty()) stack.pop();
        long end = System.currentTimeMillis();

        long time1 = (end - start);

        long start2 = System.currentTimeMillis();
        var stack2 = new ArrayDeque<Integer>();

        for (int i = 0; i < 10000000; i++) {
            stack2.push(i);
        }

        while(!stack2.isEmpty()) stack2.pop();
        long end2 = System.currentTimeMillis();

        long time2 = (end2 - start2);

        System.out.println(time1 + " VS " + time2);


//        System.out.println("Doubly Linked List");
//        var nums = new DoublyLinkedList<>();
//
//        System.out.println(nums.size());
//
//        nums.append(1);
//        nums.append(2);
//        nums.append(3);
//
//        nums.display();
//
//        nums.prepend(5);
//        nums.prepend(6);
//        nums.prepend(7);
//
//        nums.display();
//
//        nums.popFromHead();
//        nums.popFromTail();
//        nums.popFromTail();
//        nums.popFromTail();
//        nums.popFromTail();
//        nums.popFromTail();
//
//        nums.display();
//
//        System.out.println("-----------------------");
//        System.out.println("Stack");
//
//        var stack = new Stack<Integer>();
//
//        stack.push(1);
//        stack.push(4);
//        stack.push(5);
//        stack.push(6);
//        stack.push(7);
//
//        System.out.println("Size: " + stack.size());
//        System.out.println(stack.peek());
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println("Size: " + stack.size());
//        System.out.println(stack.peek());
    }
}