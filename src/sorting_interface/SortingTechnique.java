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
public interface SortingTechnique {
    public void sort();
    public void printArray();
    public void printTimeTaken();
    public long getTimeTaken();
    
}
