package wordGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import wordGame.WordChecker;
import static wordGame.WordChecker.check_for_word;

public class PermuteCleaner {

    public static void main(String[] args) throws Exception {

    }

    public static boolean containsChar(String str, int position, char c) {
        return str.charAt(position) == c;
    }

    public static List<String> cleanUpResults(List<String> list, int wordLength) {
        return list.stream().map(t -> t.substring(0, wordLength)).distinct().
                filter(t -> containsVowel(t.substring(0, 4)))
                .collect(Collectors.toList());
    }

    public static void doPerm(StringBuffer str, int index, List<String> result) {
        if (index <= 0) {
//			if ( ) {
            System.out.println(str);
            result.add(str.toString());
//			}
        } else { //recursively solve this by placing all other chars at current first pos
            doPerm(str, index - 1, result);
            int currPos = str.length() - index;
            for (int i = currPos + 1; i < str.length(); i++) {//start swapping all other chars with current first char
                swap(str, currPos, i);
                doPerm(str, index - 1, result);
                swap(str, i, currPos);//restore back my string buffer
            }
        }
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
