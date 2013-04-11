/*************************************************************************
 * PF (Rick) Kleinhans - 16959787
 * 
 * Custom merge sort to sort int array.
 * Uses String called "read" to sort int array based on alphabetical order
 * of substrings in read which match int index and are half the length of read.
 *************************************************************************/

public class CustomMerge {

    /**
     * Stably merge a[lo .. mid] with a[mid+1 .. hi] using aux[lo .. hi]
     * @param a
     * @param aux
     * @param lo
     * @param mid
     * @param hi
     * @param read
     * 
     * Standard top-down merge method with comparisons using read string.
     */
    public static void merge(int[] a, int[] aux, int lo, int mid, int hi, String read) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(read.substring(aux[j], aux[j]+(read.length()/2)), read.substring(aux[i], a[i]+(read.length()/2))))   a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }

    /**
     * Mergesorts a[lo..hi] using auxiliary array aux[lo..hi]
     * @param a
     * @param aux
     * @param lo
     * @param hi
     * @param read
     * 
     * Functions recursively as per normal mergesort method. (Top-Down mergesort.)
     */
    private static void sort(int[] a, int[] aux, int lo, int hi, String read) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid, read);
        sort(a, aux, mid + 1, hi, read);
        merge(a, aux, lo, mid, hi, read);
    }

    /**
     * Initial sort method, called from BurrowsWheeler.
     * @param a is the array to be sorted (List of ints in initialized order.)
     * @param read Doubled version of input string to be used as a reference for indexes in int array.
     * (read functions as a circular string.)
     */
    public static void sort(int[] a, String read) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length-1, read);
    }

    /**
     * Checks if v is less than w.
     * @param v
     * @param w
     * @return True if v is less than w. 
     */
    private static boolean less(String v, String w) {
        return (v.compareTo(w) < 0);
    }

    public static void main(String[] args) {
    }
}