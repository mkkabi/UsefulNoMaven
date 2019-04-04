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

        int wordLength = 10;
        String letters = "cderotsigxniy";
        HashSet<String> result = new HashSet();
//        RandomAccessFile raf = new RandomAccessFile(new File("wordsEn.txt"), "r");
//        String str = sortString(letters);

        StringBuffer strBuf = new StringBuffer(letters);
        doPerm(strBuf, letters.length(), result, wordLength);

        System.out.println("==========RESULTS============");

        List<String> filtered = cleanUpResults(result, wordLength);

        System.out.println("number of raw results = " + result.size());
        System.out.println("number of filtered elements = " + filtered.size());
 
        List<String> list = getFileAsList("wordsEn.txt");
        filtered.parallelStream().filter(t->binaryLookupInList(list, t)).forEach(System.out::println);
//        filtered.parallelStream().filter(t->check_for_word(t)).forEach(System.out::println);

//List<String> tmp = new ArrayList();
//tmp.add("friend");
//        tmp.parallelStream().filter(t->binaryLookupInList(list, t)).forEach(System.out::println);
        
 

 
    }

    public static void doPerm(StringBuffer str, int index, HashSet<String> result, int wordLength) {
        if (index <= 0) {
            // && containsChar(str,,'')
//            int wordLength = 7;
//            String letters = "emstveghzon";
            //containsVowel(str.substring(0, wordLength)) && containsChar(str, 1, 'e') && containsChar(str, 3, 'm')) 
            if (containsVowel(str.substring(0, 4)) && containsChar(str,0,'d')) {
                //System.out.println(str);
                result.add(str.substring(0, wordLength));
            }
        } else { //recursively solve this by placing all other chars at current first pos
            doPerm(str, index - 1, result, wordLength);
            int currPos = str.length() - index;
            for (int i = currPos + 1; i < str.length(); i++) {//start swapping all other chars with current first char
                swap(str, currPos, i);
                doPerm(str, index - 1, result, wordLength);
                swap(str, i, currPos);//restore back my string buffer
            }
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
