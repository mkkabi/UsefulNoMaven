package wordGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
  
class Combination { 
  
  static void combinationUtil(List<Integer> list, List<Integer> data, int start, int end, int index, int r) {
    // Current combination is ready to be printed, print it
    if (index == r) {
        for (int j = 0; j < r; j++)
            System.out.print(data.get(j) + " ");
        System.out.println("");
        return;
    }

    // replace index with all possible elements. The condition
    // "end-i+1 >= r-index" makes sure that including one element
    // at index will make a combination with remaining elements
    // at remaining positions
    for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
        data.set(index, list.get(i));
        combinationUtil(list, data, i + 1, end, index + 1, r);
    }
}

// The main function that prints all combinations of size r
// in list of size n. This function mainly uses combinationUtil()
static void printCombination(List<Integer> list, int n, int r) {
    // A temporary array to store all combination one by one
    List<Integer> data = new ArrayList<>(Collections.nCopies(r, 0));

    // Print all combination using temporary array 'data'
    combinationUtil(list, data, 0, n - 1, 0, r);
}

public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    int r = 3;
    int n = list.size();
    printCombination(list, n, r);
}
} 