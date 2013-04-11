/*************************************************************************
 *  Compilation:  javac Heap.java
 *  Execution:    java Heap < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/24pq/tiny.txt
 *                http://algs4.cs.princeton.edu/24pq/words3.txt
 *  
 *  Sorts a sequence of strings from standard input using heapsort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Heap < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Heap < words3.txt
 *  all bad bed bug dad ... yes yet zoo   [ one string per line ]
 *  
  	sufs[i] = (String)read2.subSequence(i, i+read.length());
 *
 *************************************************************************/

public class HeapInt {

    public static void sort(int[] pq, String read2) {
        int N = pq.length;
        for (int k = N/2; k >= 1; k--)
            sink(pq, k, N, read2);
        while (N > 1) {
            exch(pq, 1, N--);
            sink(pq, 1, N, read2);
        }
    }

   /***********************************************************************
    * Helper functions to restore the heap invariant.
    **********************************************************************/

    private static void sink(int[] pq, int k, int N, String read2) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(pq, j, j+1, read2)) j++;
            if (!less(pq, k, j, read2)) break;
            exch(pq, k, j);
            k = j;
        }
    }

   /***********************************************************************
    * Helper functions for comparisons and swaps.
    * Indices are "off-by-one" to support 1-based indexing.
    **********************************************************************/
    private static boolean less(int[] pq, int i, int j, String read2) {
        return read2.substring(pq[i-1], pq[i-1]+(read2.length()/2)).compareTo(read2.substring(pq[j-1], pq[j-1]+(read2.length()/2))) < 0;
    }

    private static void exch(int[] pq, int i, int j) {
        int swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
        
    // Read strings from standard input, sort them, and print.
    public static void main(int[] args) {
    }
}