package nsquared_techniques;

import sorting_interface.ConcreteSortingTechnique;

/**
 *
 * @author ahmed
 */
public class InsertionSort extends ConcreteSortingTechnique{


    public InsertionSort(int[] dataArray) {
        this.dataArray = dataArray;
    }

    @Override
    public void sort() {
        startTime = System.nanoTime();
        insertionSort(dataArray);
        endTime = System.nanoTime();
    }

    @Override
    public void printArray() {
        System.out.print("Insertion Sort: ");
        for (int item : dataArray) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    @Override
    public void printTimeTaken() {
        System.out.printf("%-35s", "Time taken for Insertion Sort: ");
        System.out.println(endTime - startTime + " nano sec");
    }

    private void insertionSort(int[] dataArray) {
        for (int i = 1; i < dataArray.length; i++) {
            int j = i - 1;
            int key = dataArray[i];
            while (j >= 0 && dataArray[j] > key) {
                dataArray[j + 1] = dataArray[j];
                j--;
            }
            dataArray[j + 1] = key;
        }
    }

}
