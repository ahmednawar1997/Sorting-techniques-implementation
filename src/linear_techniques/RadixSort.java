package linear_techniques;

import java.util.ArrayList;
import java.util.LinkedList;
import sorting_interface.ConcreteSortingTechnique;

/**
 *
 * @author ahmed
 */
public class RadixSort extends ConcreteSortingTechnique {

    private ArrayList<LinkedList<Integer>> countList;

    public RadixSort(int[] dataArray) {
        this.dataArray = dataArray;
        countList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            countList.add(new LinkedList<>());
        }
    }

    @Override
    public void sort() {
        startTime = System.nanoTime();
        radixSort();
        endTime = System.nanoTime();
    }

    @Override
    public void printArray() {
        System.out.print("Radix Sort:     ");
        for (int item : dataArray) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    @Override
    public void printTimeTaken() {
        System.out.printf("%-35s", "Time taken for Radix Sort: ");
        System.out.println(endTime - startTime + " nano sec");
    }

    private void radixSort() {
        int max = getMax();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(exp);
        }

    }

    private void countSort(int exp) {
        for (int i = 0; i < dataArray.length; i++) {
            int item = (dataArray[i] / exp) % 10;
            countList.get(item).add(dataArray[i]);
        }

        for (int i = 0, k = 0; i < countList.size(); i++) {
            int linkedListSize = countList.get(i).size();
            for (int j = 0; j < linkedListSize; j++) {
                dataArray[k++] = countList.get(i).removeFirst();
            }
        }

    }

    private int getMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i] > max) {
                max = dataArray[i];
            }
        }
        return max;
    }

}
