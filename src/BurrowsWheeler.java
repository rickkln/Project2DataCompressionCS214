import java.lang.String;

public class BurrowsWheeler{ 
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

  public static char[] readSorted; 
  public static Stopwatch stop;
  
  public static void decode(){
	/*StdOut.println("Encoded");
    StdOut.println(stop.elapsedTime());
    int key=BinaryStdIn.readInt();
    String read=BinaryStdIn.readString();
    char [] readT = read.toCharArray();
    readSorted=read.toCharArray();
    HeapChar.sort(readSorted); 
    StdOut.println("\nSortedChar");
    StdOut.println(stop.elapsedTime());
    int count1 = 0;
    int count2 = 0;
    int row = 0;
    boolean found = false;
    Integer next[]= new Integer [read.length()];

    for(int i=0; i<read.length();i++) {
      for(int j=0; j<read.length();j++) {     
        if((readSorted[i] == readT[j])&&(!found)) {
          if(count2<count1)
            count2++;
          else {
            row = j;
            found=true;
          }
        } 
      } 
      next[i]= row;
      count2 = 0;
      found = false;
      if(i < read.length()-1) {
        if(readSorted[i+1] == readSorted[i])
          count1++;
        else 
          count1 = 0;
      }
    }
    
    StdOut.println("\nNextArrayConstructed");
    StdOut.println(stop.elapsedTime());
    int nextToPrint=key;
    for(int i=0; i<read.length(); i++){
      //BinaryStdOut.write(readSorted[nextToPrint]);
      nextToPrint=next[nextToPrint];
    }
    StdOut.println("\nTotal");
    StdOut.println(stop.elapsedTime());

    BinaryStdOut.close();*/
  }

  public static void main(String[] args) {
    stop = new Stopwatch();
    if(args[0].charAt(0)=='-'){
      encode();
      StdOut.println(stop.elapsedTime());
    }else if(args[0].charAt(0)=='+'){
      decode();
    }
  }
}
