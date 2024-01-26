import LinkedList.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        var nums = new DoublyLinkedList<>();

        System.out.println(nums.size());

        nums.append(1);
        nums.append(2);
        nums.append(3);

        nums.display();

        nums.prepend(5);
        nums.prepend(6);
        nums.prepend(7);

        nums.display();

        nums.popFromHead();
        nums.popFromTail();
        nums.popFromTail();
        nums.popFromTail();
        nums.popFromTail();
        nums.popFromTail();

        nums.display();
    }
}