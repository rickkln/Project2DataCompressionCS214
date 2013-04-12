/*************************************************************************
 * PF (Rick) Kleinhans - 16959787
 * 
 * BurrowsWheeler class
 *************************************************************************/

import java.lang.String;
import java.util.Arrays;

public class BurrowsWheeler{ 
  
  /**
   * Given a typical English text file, transform it into a text file 
   * in which sequences of the same character occur near each other many times.	
   * 
   * Using Custom Merge sort to sort files based on read2 string.
   */
  public static void encode(){
    String read = BinaryStdIn.readString();
    int[] sufs = new int[read.length()];
    String read2 = read+read;
    
    for(int i=0; i<read.length(); i++)
      sufs[i] = i;
    
    HeapInt.sort(sufs, read2);
      
    int num = 0; boolean found = false; 
    while(!found) {
      if(sufs[num]==0) found = true; 
      else num++;
    }
    BinaryStdOut.write(num);
    
    for(int i=0; i<sufs.length; i++)
    	BinaryStdOut.write(read2.charAt(sufs[i]+read.length()-1));
    
    BinaryStdOut.close();
  }
  
  /**
   * Decoding from an Burrows Wheeler encoded file.
   * Uses normal Array.sort.
   */
  public static void decode(){
	int first = BinaryStdIn.readInt();
	String read = BinaryStdIn.readString();
	char [] sort = read.toCharArray();
	Arrays.sort(sort);
	int length = sort.length;
	int [] indx = new int[256];
	int [] next = new int[length];
	
	for(int i=0; i<length; i++) {
		indx[(int) sort[i]] = i;
		while(i<length-1 && sort[i] == sort[i+1]) 
			i++;
	}
	
	for(int i=0; i<length; i++) {
		next[indx[(int) read.charAt(i)]] = i;
		indx[(int) read.charAt(i)]++;
	}
	
    for(int i=0; i<length; i++){
      BinaryStdOut.write(sort[first]);
      first=next[first];
    }

    BinaryStdOut.close();
  }

  public static void main(String[] args) {
	Stopwatch stop = new Stopwatch();
    if(args[0].charAt(0)=='-'){
      encode();
      StdOut.println("\n" + stop.elapsedTime());
    }else if(args[0].charAt(0)=='+'){
      decode();
      StdOut.println("\n" + stop.elapsedTime());
    }
  }
}
