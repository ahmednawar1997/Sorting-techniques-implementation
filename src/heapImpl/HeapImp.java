package heapImpl;

import java.util.ArrayList;
import sorting_interface.ConcreteSortingTechnique;

/**
 *
 * @author ahmed
 */
public class HeapImp extends ConcreteSortingTechnique{

    private ArrayList<Integer> dataArray;


    public HeapImp() {
        this.dataArray = new ArrayList<>();
    }

    private void maxHeapify(int parent, int arraySize) {
        int leftChild = getLeftChild(parent);
        int rightChild = getRightChild(parent);
        int maxElem = parent;

        if (leftChild < arraySize && dataArray.get(leftChild) > dataArray.get(parent)) {
            maxElem = leftChild;
        }
        if (rightChild < arraySize && dataArray.get(rightChild) > dataArray.get(maxElem)) {
            maxElem = rightChild;
        }

        if (maxElem != parent) {
            swap(parent, maxElem);
            maxHeapify(maxElem, arraySize);
        }
    }

    private void heapifyAfterAdd(int key) {

        if (key == 0) {
            return;
        }
        int parent = getParent(key);
        if (dataArray.get(parent) < dataArray.get(key)) {
            swap(parent, key);
            heapifyAfterAdd(parent);
        }
    }

    public void buildMaxHeap(int[] list) {
        dataArray.clear();
        for (int i = 0; i < list.length; i++) {
            dataArray.add(list[i]);
        }
        for (int i = list.length / 2; i >= 0; i--) {
            maxHeapify(i, dataArray.size());
        }
    }

    private void heapSort() {
        int arraySize = dataArray.size();

        for (int i = arraySize - 1; i > 0; i--) {
            swap(0, i);
            arraySize--;
            maxHeapify(0, arraySize);
        }
    }

    public void add(int newItem) {
        dataArray.add(newItem);
        if (dataArray.size() > 1) {
            heapifyAfterAdd(dataArray.size()-1);
        }
    }

    private void swap(int first, int second) {
        int temp = dataArray.get(first);
        dataArray.set(first, dataArray.get(second));
        dataArray.set(second, temp);
    }

    private int getParent(int child) {
        if (child % 2 == 0) {
            return child / 2 - 1;
        }
        return child / 2;
    }

    private int getLeftChild(int parent) {
        return parent * 2 + 1;
    }

    private int getRightChild(int parent) {
        return parent * 2 + 2;
    }

    @Override
    public void sort() {
        startTime = System.nanoTime();
        heapSort();
        endTime = System.nanoTime();
    }

    @Override
    public void printArray() {
        System.out.print("Heap Sort:      ");
        for (int item : dataArray) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    @Override
    public void printTimeTaken() {
        System.out.printf("%-35s","Time taken for heap sort: ");
        System.out.println(endTime - startTime + " nano sec");
    }

}
