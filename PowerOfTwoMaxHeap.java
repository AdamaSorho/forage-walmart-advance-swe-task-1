import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class PowerOfTwoMaxHeap {
    private final List<Integer> heap;
    private final int nodeNumberChildren;

    public PowerOfTwoMaxHeap(int power) {
        this.nodeNumberChildren = (int) Math.pow(2, power);
        this.heap = new ArrayList<>(this.nodeNumberChildren);
    }

    public void insert(int number) {
        this.heap.add(number);
        if (this.heap.size() != 1) {
            this.heapification();
        }
    }

    public int peek() {
        if (this.heap.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.heap.get(0);
    }

    public int pop() {
        if (this.heap.isEmpty()) {
            throw new EmptyStackException();
        }
        int value = this.heap.remove(0);
        this.heapification();

        return value;
    }

    private void heapification() {
        for(int index = this.heap.size() / 2 - 1; index >= 0; --index) {
            heapify(index);
        }
    }

    private void heapify(int index) {
        int size = this.heap.size();
        int largestIndex = index;

        for (int i = 1; i <= this.nodeNumberChildren; ++i) {
            int childIndex = this.nodeNumberChildren * index + i;
            if (childIndex >= size) {
                break;
            }
            if (this.heap.get(childIndex) > this.heap.get(largestIndex))
                largestIndex = childIndex;
        }

        if (largestIndex != index) {
            int temp = this.heap.get(largestIndex);
            this.heap.set(largestIndex, this.heap.get(index));
            this.heap.set(index, temp);

            heapify(largestIndex);
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Integer element : this.heap) {
            output.append(element).append(" ");
        }

        return output.toString();
    }
}
