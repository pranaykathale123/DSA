package org.example.heap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      Heap heap = new Heap(10);
      for(int i=0; i<10; i++) {
          heap.insert(sc.nextInt());
      }
      heap.printHeap();
    }
}
