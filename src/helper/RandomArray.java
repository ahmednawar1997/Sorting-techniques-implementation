/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author ahmed
 */
public class RandomArray {

    public static int[] generate(int size, int maxNum) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * maxNum);
        }
        return array;
    }

}
