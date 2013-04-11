
public class MoveToFrontInternet {
	  // apply move-to-front encoding, reading from standard input 
    // and writing to standard output
   public static char[] exascii;
	public static void encode(){
    	//StdOut.print("encode\n");
    	exascii=new char[256];
    	for(int i=0; i<exascii.length; i++){
    		exascii[i]=(char)i;
    	}
    	while(!BinaryStdIn.isEmpty()){
    		char read = BinaryStdIn.readChar();
    		char idx = toIndex(read);
    		move(read, idx);
    		BinaryStdOut.write(idx);
    	}
    	BinaryStdOut.close();
    }
	public static void move(char c, char idx) {
		char [] newexa= new char[exascii.length];
		newexa[0]=c;
		for(int i=1; i<=idx; i++)
			newexa[i]=exascii[i-1];
		for(int i=idx+1; i<exascii.length; i++)
			newexa[i]=exascii[i];
		exascii=newexa;
	}

	public static char toIndex(char c) {
		for(int i=0; i<exascii.length; i++){
			if(exascii[i]==c)
				return (char)i;
		}
		return (char)-1; //error not found;
	}
	public static char charFromIdx(char c) {
				return exascii[c];
	}

    // apply move-to-front decoding, reading from standard input 
    // and writing to standard output
    public static void decode(){
    	//StdOut.print("decode\n");
    	exascii=new char[256];
    	for(int i=0; i<exascii.length; i++){
    		exascii[i]=(char)i;
    	}
    	while(!BinaryStdIn.isEmpty()){
    		char read = BinaryStdIn.readChar();
    		char charOut = charFromIdx(read);
    		move(charOut, read);
    		BinaryStdOut.write(charOut);
    	}
    	BinaryStdOut.close();
    }

    // if args[0] is '-', apply move-to-front encoding
    // if args[0] is '+', apply move-to-front decoding
	public static void main(String[] args) {
			if(args[0].charAt(0)=='-')
				encode();
			else if(args[0].charAt(0)=='+')
				decode();
			
	}

}
