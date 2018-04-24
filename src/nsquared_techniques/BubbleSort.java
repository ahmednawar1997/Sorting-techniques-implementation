package nsquared_techniques;

import sorting_interface.ConcreteSortingTechnique;

/**
 *
 * @author ahmed
 */
public class BubbleSort extends ConcreteSortingTechnique{

    public BubbleSort(int[] dataArray) {
        this.dataArray = dataArray;
    }

    @Override
    public void sort() {
        startTime = System.nanoTime();
        bubbleSort(dataArray);
        endTime = System.nanoTime();
    }

    @Override
    public void printArray() {
        System.out.print("Bubble Sort:    ");
        for (int item : dataArray) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    @Override
    public void printTimeTaken() {
        System.out.printf("%-35s", "Time taken for Bubble Sort: ");
        System.out.println(endTime - startTime + " nano sec");
    }

    private void bubbleSort(int[] dataArray) {
        boolean isSorted;
        for (int i = 0; i < dataArray.length - 1; i++) {
           isSorted = true;
            for (int j = 0; j < dataArray.length - i - 1; j++) {
                if (dataArray[j] > dataArray[j+1]) {
                    swap(dataArray, j, j+1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                return;
            }
        }
    }

    private void swap(int[] dataArray, int first, int second) {
        int temp = dataArray[first];
        dataArray[first] = dataArray[second];
        dataArray[second] = temp;
    }

}
