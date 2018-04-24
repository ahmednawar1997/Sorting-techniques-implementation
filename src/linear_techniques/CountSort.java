/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linear_techniques;

import sorting_interface.ConcreteSortingTechnique;
/**
 *
 * @author ahmed
 */
public class CountSort extends ConcreteSortingTechnique{

    private int[] countArray;

    public CountSort(int[] dataArray) {
        this.dataArray = dataArray;
        int max = getMax();
        countArray = new int[max+1];
    }

    @Override
    public void sort() {
        startTime = System.nanoTime();
        countSort();
        endTime = System.nanoTime();
    }

    @Override
    public void printArray() {
        System.out.print("Count Sort:     ");
        for (int item : dataArray) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    @Override
    public void printTimeTaken() {
        System.out.printf("%-35s", "Time taken for Count Sort: ");
        System.out.println(endTime - startTime + " nano sec");
    }

    private void countSort() {
        for (int i = 0; i < dataArray.length; i++) {
            countArray[dataArray[i]]++;
        }

        for (int i = 0, k = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                dataArray[k++] = i;
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
