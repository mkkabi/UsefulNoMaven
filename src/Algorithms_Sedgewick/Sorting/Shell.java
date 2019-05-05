package Algorithms_Sedgewick.Sorting;

import static Algorithms_Sedgewick.Sorting.Example.*;

/*
Shellsort gains efficiency by making a tradeoff between size and partial order in the
subsequences. At the beginning, the subsequences are short; later in the sort, the subsequences are partially sorted. 
*/

class Shell {

    public static void sort(Comparable[] a) { // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        }
        while (h >= 1) { // h-sort the array.
            for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
    
    public static void test(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h<N/3){
            h = 3*h+1;
            System.out.println("inside while h = "+h);
        }
        
        while (h >= 1) { // h-sort the array.
            for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                System.out.println("inside first for i = "+i);
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    System.out.println("inside second for j = "+j+" i = "+i+" h = "+h);
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    
        
    }

}
