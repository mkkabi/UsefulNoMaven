package Algorithms_Sedgewick.Sorting;

import java.util.Arrays;


/*
Selection sort uses N 2/2 compares and N exchanges to sort an array of length N.

Selection sort One of the simplest sorting algorithms works as follows: First, find
the smallest item in the array and exchange it with the first entry (itself if the first entry
is already the smallest). Then, find the next smallest item and exchange it with the second entry. Continue in this way until the entire array is sorted. This method is called
selection sort because it works by repeatedly selecting the smallest remaining item.
 */
public class Selection {

    public static void sort(Comparable[] a) { // Sort a[] into increasing order.
        int N = a.length; // array length
        for (int i = 0; i < N; i++) { // Exchange a[i] with smallest entry in a[i+1...N).
            int min = i; // index of minimal entr.
            for (int j = i + 1; j < N; j++) {
                if (Example.less(a[j], a[min])) {
                    min = j;
                }
            }
            Example.exch(a, i, min);
        }
    }
// See page 245 for less(), exch(), isSorted(), and main().

}
