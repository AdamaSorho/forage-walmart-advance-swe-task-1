public class Main {
    public static void main(String[] args) {
        PowerOfTwoMaxHeap heap = new PowerOfTwoMaxHeap(3);

        heap.insert(4);
        heap.insert(1);
        heap.insert(3);
        heap.insert(2);
        heap.insert( 16);
        heap.insert(10);
        heap.insert(14);
        heap.insert(8);
        heap.insert(7);

        System.out.println("Max-Heap array: ");
        System.out.println(heap);

        System.out.println("Find max " + heap.peek());

        System.out.println("Pop max " + heap.pop());
        System.out.println("After popping: ");
        System.out.println(heap);
    }
}
