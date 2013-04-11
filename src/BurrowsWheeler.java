/*************************************************************************
 * PF (Rick) Kleinhans - 16959787
 * 
 * BurrowsWheeler class
 *************************************************************************/

import java.lang.String;
import java.util.Arrays;

public class BurrowsWheeler{ 
  
  /**
   * 	
   */
  public static void encode(){
    String read = BinaryStdIn.readString();
    int[] sufs = new int[read.length()];
    String read2 = read+read;
    
    for(int i=0; i<read.length(); i++)
      sufs[i] = i;
    
    CustomMerge.sort(sufs, read2);
      
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
   * 
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

  /**
   * 
   * @param args
   */
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
