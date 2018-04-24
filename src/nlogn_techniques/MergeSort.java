package nlogn_techniques;

import sorting_interface.ConcreteSortingTechnique;

/**
 *
 * @author ahmed
 */
public class MergeSort extends ConcreteSortingTechnique{

    public MergeSort(int[] dataArray) {
        this.dataArray = dataArray;
    }

    public void setDataArray(int[] dataArray) {
        this.dataArray = dataArray;
    }

    @Override
    public void sort() {
        startTime = System.nanoTime();
        mergeSort(dataArray, 0, dataArray.length - 1);
        endTime = System.nanoTime();
    }

    @Override
    public void printArray() {
        System.out.print("Merge Sort:     ");
        for (int item : dataArray) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    private void merge(int[] dataArray, int leftIndex, int rightIndex, int middleIndex) {
        int[] mergedArray = new int[rightIndex - leftIndex + 1];

        int i = leftIndex;
        int j = middleIndex + 1;
        int k = 0;

        while (i <= middleIndex && j <= rightIndex) {
            if (dataArray[i] < dataArray[j]) {
                mergedArray[k++] = dataArray[i++];
            } else {
                mergedArray[k++] = dataArray[j++];
            }
        }

        while (i <= middleIndex) {
            mergedArray[k++] = dataArray[i++];
        }

        while (j <= rightIndex) {
            mergedArray[k++] = dataArray[j++];
        }

        copyArray(dataArray, mergedArray, leftIndex, rightIndex);
    }

    private void mergeSort(int[] dataArray, int leftIndex, int rightIndex) {

        if (rightIndex <= leftIndex) {
            return;
        }

        int middleIndex = (leftIndex + rightIndex) / 2;

        mergeSort(dataArray, leftIndex, middleIndex);
        mergeSort(dataArray, middleIndex + 1, rightIndex);
        merge(dataArray, leftIndex, rightIndex, middleIndex);
    }

    private void copyArray(int[] dataArray, int[] mergedArray, int leftIndex, int rightIndex) {
        int k = 0;
        for (int i = leftIndex; i <= rightIndex; i++) {
            dataArray[i] = mergedArray[k++];
        }
    }

    @Override
    public void printTimeTaken() {
        System.out.printf("%-35s","Time taken for Merge Sort: ");
        System.out.println(endTime - startTime + " nano sec");
    }
}
