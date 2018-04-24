package sorting.techniques;

import sorting_interface.SortingTechnique;
import linear_techniques.RadixSort;
import heapImpl.*;
import helper.RandomArray;
import java.util.ArrayList;
import java.util.Arrays;
import nlogn_techniques.*;
import nsquared_techniques.*;
import linear_techniques.CountSort;

/**
 *
 * @author ahmed
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> listOfN = new ArrayList<>();
        listOfN.add(10);
        listOfN.add(100);
        listOfN.add(1000);
        listOfN.add(10000);
        listOfN.add(100000);
        

        for (int i = 0; i < listOfN.size(); i++) {
            int[] dataArray = RandomArray.generate(listOfN.get(i), 10000);
            System.out.println(Arrays.toString(dataArray));

            ArrayList<SortingTechnique> list = new ArrayList<>();

            list.add(new QuickSort((int[]) dataArray.clone()));
            list.add(new MergeSort((int[]) dataArray.clone()));
            HeapImp heap = new HeapImp();
            heap.buildMaxHeap((int[]) dataArray.clone());
            list.add(heap);
            list.add(new BubbleSort((int[]) dataArray.clone()));
            list.add(new SelectionSort((int[]) dataArray.clone()));
            list.add(new InsertionSort((int[]) dataArray.clone()));
            list.add(new RadixSort((int[]) dataArray.clone()));
            list.add(new JavaSort((int[]) dataArray.clone()));
            list.add(new CountSort((int[]) dataArray.clone()));

            for (SortingTechnique algo : list) {
                algo.sort();
            }

            for (SortingTechnique algo : list) {
                algo.printArray();
            }
            System.out.println("");
            System.out.println("For array size: " + listOfN.get(i));
            for (SortingTechnique algo : list) {
                algo.printTimeTaken();
            }
        }
        
        
        
//        for (int i = 0; i < dataArray.length; i++) {
//            heap.add(dataArray[i]);   
//        }
    }
}
