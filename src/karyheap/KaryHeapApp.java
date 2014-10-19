/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package karyheap;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author thaddeuspaulfadrigalan
 */
public class KaryHeapApp {
    
    public static KaryHeap heap;
    
    public static void main(String[] args) {
        try{
            heap = new KaryHeap();
            heap.setK(2);
            Scanner fin = new Scanner(new File("karyHeap-input.txt"));
            
            while(fin.hasNext()){
                int key;
                if(fin.next().compareTo("IN")==0){
                    key = fin.nextInt();
                    heap.insert(key);
                }
                else
                    System.out.println(heap.extractMin());
            }
            
            fin.close();
        }
        catch(IOException e){
            System.out.println("Unable to process file");
            System.exit(90);
        }
        
}
}
