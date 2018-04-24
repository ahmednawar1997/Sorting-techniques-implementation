package nsquared_techniques;

import sorting_interface.ConcreteSortingTechnique;

/**
 *
 * @author ahmed
 */
public class SelectionSort extends ConcreteSortingTechnique{

    public SelectionSort(int[] dataArray) {
        this.dataArray = dataArray;
    }

    @Override
    public void sort() {
        startTime = System.nanoTime();
        selectionSort(dataArray);
        endTime = System.nanoTime();
    }

    @Override
    public void printArray() {
        System.out.print("Selection Sort: ");
        for (int item : dataArray) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    @Override
    public void printTimeTaken() {
        System.out.printf("%-35s", "Time taken for Selection Sort: ");
        System.out.println(endTime - startTime + " nano sec");
    }

    private void selectionSort(int[] dataArray) {
        for (int i = 0; i < dataArray.length - 1; i++) {
            swap(dataArray, findMin(dataArray, i, dataArray.length - 1), i);
        }
    }

    private void swap(int[] dataArray, int first, int second) {
        int temp = dataArray[first];
        dataArray[first] = dataArray[second];
        dataArray[second] = temp;
    }

    private int findMin(int[] dataArray, int minIndex, int maxIndex) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = minIndex; i <= maxIndex; i++) {
            if (dataArray[i] < min) {
                min = dataArray[i];
                index = i;
            }
        }
        return index;
    }

}
