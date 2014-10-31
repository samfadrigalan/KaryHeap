//package karyheap;
import java.util.Scanner;
import java.io.*;
/**
 * @file KaryHeap.java
 * @author Samantha Fadrigalan and Kayla Thurman
 * Description: Kary Heap Implementation 
 * Course: CSC 3102
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
