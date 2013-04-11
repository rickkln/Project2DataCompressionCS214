/*************************************************************************
 * PF (Rick) Kleinhans - 16959787
 * 
 * Custom heap sort to sort int array.
 * Uses String called "read" to sort int array based on alphabetical order
 * of substrings in read which match int index and are half the length of read.
 *************************************************************************/

public class HeapInt {

	/**
	 * Standard heap sort method, but using read String.
	 * @param pq
	 * @param read
	 */
    public static void sort(int[] pq, String read) {
        int N = pq.length;
        for (int k = N/2; k >= 1; k--)
            sink(pq, k, N, read);
        while (N > 1) {
            exch(pq, 1, N--);
            sink(pq, 1, N, read);
        }
    }

    /**
     * Helper functions to restore the heap invariant.
     * Customized to use read string
     * @param pq
     * @param k
     * @param N
     * @param read
     */
    private static void sink(int[] pq, int k, int N, String read) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(pq, j, j+1, read)) j++;
            if (!less(pq, k, j, read)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    /**
     * Helper functions for comparisons and swaps.
     * Indices are "off-by-one" to support 1-based indexing.
     * Read string added.
     * @param pq
     * @param i
     * @param j
     * @param read
     * @return
     */
    private static boolean less(int[] pq, int i, int j, String read) {
        return read.substring(pq[i-1], pq[i-1]+(read.length()/2)).compareTo(read.substring(pq[j-1], pq[j-1]+(read.length()/2))) < 0;
    }

    /**
     * Standard exhange method from Algorithms 4.
     * @param pq
     * @param i
     * @param j
     */
    private static void exch(int[] pq, int i, int j) {
        int swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
        
    public static void main(int[] args) {
    }
}