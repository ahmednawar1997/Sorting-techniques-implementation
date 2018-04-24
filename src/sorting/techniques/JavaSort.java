package sorting.techniques;

import java.util.Arrays;
import sorting_interface.ConcreteSortingTechnique;

/**
 *
 * @author ahmed
 */
public class JavaSort extends ConcreteSortingTechnique{


    public JavaSort(int[] dataArray) {
        this.dataArray = dataArray;
    }

    @Override
    public void sort() {
        startTime = System.nanoTime();
        Arrays.sort(dataArray);
        endTime = System.nanoTime();
    }

    @Override
    public void printArray() {
        System.out.print("Java Sort:      ");
        for (int item : dataArray) {
            System.out.print(item + " ");
        }
        System.out.println("");
    }

    @Override
    public void printTimeTaken() {
        System.out.printf("%-35s", "Time taken for Java Sort: ");
        System.out.println(endTime - startTime + " nano sec");
    }
}
