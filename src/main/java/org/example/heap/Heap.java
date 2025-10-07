package org.example.heap;

public class Heap {
    private int[] heap;
    private int size;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Insert element into heap
    public void insert(int val) {
        if (size == capacity) {
            throw new RuntimeException("Heap is full");
        }
        heap[size] = val;
        int current = size;
        size++;

        // Bubble up
        while (current > 0 && heap[parent(current)] < heap[current]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Delete max element
    public int delete() {
        if (size <= 0) {
            throw new RuntimeException("Heap is empty");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return max;
    }

    // Heapify from index i
    public void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    // Build max heap
    public void buildHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    // Utility methods
    public int getSize() {
        return size;
    }

    public int[] getHeap() {
        return heap;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
