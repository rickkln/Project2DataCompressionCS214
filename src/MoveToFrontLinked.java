import java.util.LinkedList;

public class MoveToFrontLinked{
	
	public static void encode(){
		LinkedList<Character> ascii = new LinkedList<Character>();
		for(int i = 0; i < 256; i++) 
			ascii.add((char) i);
		
  	while(!BinaryStdIn.isEmpty()){
  		int indx = ascii.indexOf(BinaryStdIn.readChar());
  		ascii.addFirst(ascii.remove(indx));
  	  BinaryStdOut.write((char) indx);
  	}
  	BinaryStdOut.close();
	}
	
	public static void decode(){
		LinkedList<Character> ascii = new LinkedList<Character>();
		for(int i = 0; i < 256; i++) 
			ascii.add((char) i);
		
  	while(!BinaryStdIn.isEmpty()){
  		int index = BinaryStdIn.readChar();
  		ascii.addFirst(ascii.remove(index));
  	  BinaryStdOut.write(ascii.getFirst());
  	}
  	BinaryStdOut.close();
	}
	
	public static void main(String[] args){
		Stopwatch watch = new Stopwatch();
		if(args[0].charAt(0) == '-') 
			encode();
		else if(args[0].charAt(0) == '+') 
			decode();	
		StdOut.print("elapsed time \t\t = " + watch.elapsedTime());
	}
}
