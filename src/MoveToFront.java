/*************************************************************************
 * PF (Rick) Kleinhans - 16959787
 * 
 * MoveToFront class 
 *************************************************************************/

public class MoveToFront{
  
  /**
   *  Given a text file in which sequences of the same character occur 
   *  near each other many times, convert it into a text file in which 
   *  certain characters appear more frequently than others.
   *  
   *  Depends on ASCII array.
   */
  public static void encode(){
    char [] ascii = new char[256];
    for(int i = 0; i < 256; i++) 
      ascii[i] = (char) i;
    
      while(!BinaryStdIn.isEmpty()){
        char next = BinaryStdIn.readChar();
        int count = 0; boolean found = false;
        while((count<256) && (!found)){
          if(ascii[count] == next) {
            found = true;
            BinaryStdOut.write((char)count);
          } 
          else  
            count++;  
      }
      for(int i=count; i>0; i--)
          ascii[i] = ascii[i-1];  
        ascii[0] = next;
      }
      BinaryStdOut.close();
  }
  
  /**
   * Decoding from an Move To Front encoded file.
   */
  public static void decode(){
    char [] ascii = new char[256];
    for(int i = 0; i < 256; i++) 
      ascii[i] = (char) i;
    
      while(!BinaryStdIn.isEmpty()){
        int index = BinaryStdIn.readChar();
        char next = ascii[index];
        BinaryStdOut.write(next);
        
        for(int i=index; i>0; i--)
          ascii[i] = ascii[i-1];  
        ascii[0] = next;
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
