package Algorithms_Sedgewick.Sorting;

import Algorithms_Sedgewick.Sorting.Insertion;
import Algorithms_Sedgewick.Sorting.Selection;
import Algorithms_Sedgewick.Sorting.tools.StdOut;
import Algorithms_Sedgewick.Sorting.tools.StdRandom;
import Algorithms_Sedgewick.Sorting.tools.Stopwatch;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortCompare {

    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) {
            Insertion.sort(a);
        }
        if (alg.equals("Selection")) {
            Selection.sort(a);
        }
        if (alg.equals("Shell")) {
            Shell.sort(a);
        }
        if (alg.equals("Merge")) {
            Merge.sort(a);
        }
        if (alg.equals("Quick")) {
            Quick.sort(a);
        }
        if (alg.equals("Heap")) {
            Heap.sort(a);
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) { // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) { // Perform one experiment (generate and sort an array).
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static List<String> getFileAsList(String uri) {
        List<String> list = new ArrayList();

        try (BufferedReader in = new BufferedReader(new FileReader(uri));) {
            String str;
            while ((str = in.readLine()) != null) {

                list.add(str.toLowerCase());
            }
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return list;
    }
 

    public static void main(String[] args) {
        /*        
        String alg1 = "Selection";
        String alg2 = "Shell";
        int N = 250;
        int T = 120;
        double t1 = timeRandomInput(alg1, N, T); // total for alg1
        double t2 = timeRandomInput(alg2, N, T); // total for alg2
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
        
         */

        List<String> doct = getFileAsList("/src/Resources/wordsRu.txt");
    }

}
