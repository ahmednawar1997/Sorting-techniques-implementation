package nlogn_techniques;

import sorting_interface.ConcreteSortingTechnique;

/**
 *
 * @author ahmed
 */
public class QuickSort extends ConcreteSortingTechnique{

    public QuickSort(int[] dataArray) {
        this.dataArray = dataArray;
    }

    @Override
    public void sort() {
        startTime = System.nanoTime();
        quickSort(dataArray, 0, dataArray.length - 1);
        endTime = System.nanoTime();
    }

    public void quickSort(int[] dataArray, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(dataArray, low, high);

        quickSort(dataArray, low, pivotIndex - 1);
        quickSort(dataArray, pivotIndex + 1, high);

    }

    private int partition(int[] dataArray, int low, int high) {

        int pivotIndex = randomPivot(high, low);
        swap(dataArray, pivotIndex, high);
        int k = low;

        for (int i = low; i < high; i++) {
            if (dataArray[i] < dataArray[high]) {
                swap(dataArray, i, k);
                k++;
            }
        }
        swap(dataArray, k, high);
        return k;
    }

    @Override
    public void printArray() {
        System.out.print("Quick Sort:     ");
        for (int item : dataArray) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    @Override
    public void printTimeTaken() {
        System.out.printf("%-35s","Time taken for Quick Sort: ");
        System.out.println(endTime - startTime + " nano sec");
    }

    private int randomPivot(int max, int min) {
        return (int) (Math.random() * (max - min)) + min;
    }

    private void swap(int[] dataArray, int first, int second) {
        int temp = dataArray[first];
        dataArray[first] = dataArray[second];
        dataArray[second] = temp;
    }

}
