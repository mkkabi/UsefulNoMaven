package Algorithms_Sedgewick.Sorting;

import static Algorithms_Sedgewick.Sorting.Example.exch;
import static Algorithms_Sedgewick.Sorting.Example.less;

/*
the running time of insertion sort depends on the initial order of the items in the input. For example, if the array is large and its entries are
already in order (or nearly in order), then insertion sort is much, much faster than if
the entries are randomly ordered or in reverse order.

Insertion sort uses N 2/4 compares and N 2/4 exchanges to sort
a randomly ordered array of length N with distinct keys, on the average. The worst
case is N 2/2 compares and N 2/2 exchanges and the best case is N  1 compares
and 0 exchanges.

 */
public class Insertion {

    public static void sort(Comparable[] a) { // Sort a[] into increasing order.
        int N = a.length;
        for (int i = 1; i < N; i++) { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

}
