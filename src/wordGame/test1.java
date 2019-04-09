package wordGame;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static wordGame.WordChecker.check_for_word;
import static wordGame.WordChecker.checkWordBinaryAlgorithmFromList;
import static wordGame.WordChecker.getFileAsList;
import static wordGame.WordChecker.binaryLookupInList;

public class test1 {

    public static Predicate<String> equalsString(String compare) {
        return p -> p.equals(compare);
    }

    public static void main(String[] args) throws Exception {

        int wordLength = 6;
        String letters = "tocgrbquane";
        HashSet<String> result = new HashSet();

        StringBuffer strBuf = new StringBuffer(letters);
        List<String> list = getFileAsList("wordsEn.txt");
        
        generateCombinationsMod(strBuf, letters.length(), result, wordLength, list);
//        generateCombinations1(strBuf, letters.length(), result, wordLength);

        System.out.println("==========RESULTS============");

        List<String> filtered = cleanUpResults(result, wordLength);

        System.out.println("number of raw results = " + result.size());
        System.out.println("number of filtered elements = " + filtered.size());

        
        //filtered.parallelStream().filter(t -> binaryLookupInList(list, t)).forEach(System.out::println);
        

    }

    public static void generateCombinationsMod(StringBuffer str, int index, HashSet<String> result, int wordLength, List<String> dictionary) {
        if (index <= 0) {
            //&& containsChar(str, 2, 'n')
            if (containsVowel(str.substring(0, 4)) && containsChar(str,2,'c') && containsChar(str,5,'r')&& binaryLookupInList(dictionary, str.substring(0, wordLength)) ) {
                if(result.add(str.substring(0, wordLength)))
                    System.out.println(str.substring(0, wordLength));
            }
        } else { //recursively solve this by placing all other chars at current first pos
            generateCombinationsMod(str, index - 1, result, wordLength, dictionary);
            int currPos = str.length() - index;
            for (int i = currPos + 1; i < str.length(); i++) {//start swapping all other chars with current first char
                swap(str, currPos, i);
                generateCombinationsMod(str, index - 1, result, wordLength, dictionary);
                swap(str, i, currPos);//restore back my string buffer
            }
        }
    }

    public static void generateCombinations1(StringBuffer str, int index, HashSet<String> result, int wordLength) {
        if (index <= 0) {
            // && containsChar(str,,'')
//            int wordLength = 7;
//            String letters = "emstveghzon";
            //containsVowel(str.substring(0, wordLength)) && containsChar(str, 1, 'e') && containsChar(str, 3, 'm')) 
            if (containsVowel(str.substring(0, 4)) && containsChar(str, 2, 'n') && containsChar(str, 0, 'p')) {
                //System.out.println(str);
                result.add(str.substring(0, wordLength));
            }
        } else { //recursively solve this by placing all other chars at current first pos
            generateCombinations1(str, index - 1, result, wordLength);
            int currPos = str.length() - index;
            for (int i = currPos + 1; i < str.length(); i++) {//start swapping all other chars with current first char
                swap(str, currPos, i);
                generateCombinations1(str, index - 1, result, wordLength);
                swap(str, i, currPos);//restore back my string buffer
            }
        }
    }

    public static void generateCombinations2(int arraySize, ArrayList<String> possibleValues) {
        int carry;
        int[] indices = new int[arraySize];
        do {
            for (int index : indices) {
                System.out.print(possibleValues.get(index) + " ");
            }
            System.out.println("");

            carry = 1;
            for (int i = indices.length - 1; i >= 0; i--) {
                if (carry == 0) {
                    break;
                }

                indices[i] += carry;
                carry = 0;

                if (indices[i] == possibleValues.size()) {
                    carry = 1;
                    indices[i] = 0;
                }
            }
        } while (carry != 1); // Call this method iteratively until a carry is left over
    }

    static void generateCombinations3(String[] arr, int len, int startPosition, String[] result) {
        if (len == 0) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = startPosition; i <= arr.length - len; i++) {
            result[result.length - len] = arr[i];
            generateCombinations3(arr, len - 1, i + 1, result);
        }
    }

    public static boolean containsChar(String str, int position, char c) {
        return str.charAt(position) == c;
    }

    public static boolean containsChar(StringBuffer str, int position, char c) {
        return str.charAt(position) == c;
    }

    public static List<String> cleanUpResults(HashSet<String> list, int wordLength) {
        int lettersToCheck = wordLength >= 4 ? 4 : 3;
        return list.parallelStream().map(t -> t.substring(0, wordLength)).distinct().
                filter(t -> containsVowel(t.substring(0, lettersToCheck)))
                .collect(Collectors.toList());
    }

    public static void swap(StringBuffer str, int pos1, int pos2) {
        char t1 = str.charAt(pos1);
        str.setCharAt(pos1, str.charAt(pos2));
        str.setCharAt(pos2, t1);
    }

    public static boolean containsVowel(String str) {
        if (str.contains("e") || str.contains("y") || str.contains("u") || str.contains("i") || str.contains("o") || str.contains("a")) {
            return true;
        }
        return false;
    }

    public static String sortString(String inputString) {
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray();

        // sort tempArray 
        Arrays.sort(tempArray);

        // return new sorted string 
        return new String(tempArray);
    }
}
