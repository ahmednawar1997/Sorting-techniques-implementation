/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting_interface;

/**
 *
 * @author ahmed
 */
public abstract class ConcreteSortingTechnique implements SortingTechnique {

    protected int[] dataArray;
    protected long startTime;
    protected long endTime;

    public long getTimeTaken() {
        return endTime - startTime;
    }
}
