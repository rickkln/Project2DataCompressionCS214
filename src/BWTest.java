import java.lang.String;
import java.util.Arrays;

public class BWTest{ 

	public static void encode(){
  	String read=BinaryStdIn.readString();
  	String[] sufs=new String[read.length()];
  	String readdbl=read+read;
  	
  	for(int i=0; i<read.length(); i++)
  		sufs[i]=(String)readdbl.subSequence(i, i+read.length());
  	
  	HeapString.sort(sufs);
  		
		int num=Arrays.binarySearch(sufs, read);
		BinaryStdOut.write(num);
		
		for(int i=0; i<sufs.length; i++)
			BinaryStdOut.write(sufs[i].charAt(read.length()-1));
		
  	BinaryStdOut.close();
  }
	
	public static char[] readSorted; 
	
  public static void decode(){
    int key=BinaryStdIn.readInt();
		String read=BinaryStdIn.readString();
		char [] readT = read.toCharArray();
  	//for(int i=0; i<read.length(); i++)
  	//	StdOut.printf(readT[i] + "");
		readSorted=read.toCharArray();
		HeapChar.sort(readSorted); 
		int count1 = 0;
		int count2 = 0;
		int row = 0;
		boolean found = false;
  	Integer next[]= new Integer [read.length()];

		//StdOut.printf("\n");
  	for(int i=0; i<read.length();i++) {
  		//StdOut.printf(readSorted[i] + "");	
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

  	for(int i=0; i<read.length(); i++){}
  		//StdOut.printf("\n" + next[i]);

		//StdOut.printf("\n");
  
  	int nextToPrint=key;
  	for(int i=0; i<read.length(); i++){
  		BinaryStdOut.write(readSorted[nextToPrint]);
  		nextToPrint=next[nextToPrint];
  	}

  	BinaryStdOut.close();
  }

	public static void main(String[] args) {
		Stopwatch stop = new Stopwatch();
		if(args[0].charAt(0)=='-'){
			encode();
			System.out.println(stop.elapsedTime());
		}else if(args[0].charAt(0)=='+'){
			decode();
		}
	}
}
