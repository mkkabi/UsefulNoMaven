package wordGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordChecker {

    public static boolean check_for_word(String word) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("wordsEn.txt"));
            return in.lines().anyMatch(t -> t.toLowerCase().equals(word));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public static boolean checkWordStream(String word) {
        List<String> list = getFileAsList("wordsEn.txt");
        return list.stream().anyMatch(t -> t.toLowerCase().equals(word));
    }
    
    public static boolean checkWordParallelStream(String word) {
        List<String> list = getFileAsList("wordsEn.txt");
        return list.parallelStream().anyMatch(t -> t.toLowerCase().equals(word));
    }

    public static boolean checkWordAlgorithm(String word) {
        List<String> list = getFileAsList("wordsEn.txt");
        return contains(list, word);
    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList();
//        try {
//            BufferedReader in = new BufferedReader(new FileReader("wordsEn.txt"));
//            String str;
//            while ((str = in.readLine()) != null) {
//                list.add(str);
//              in.close();
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(WordChecker.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(WordChecker.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(contains(list, "friend"));

        System.out.println(check_for_word("friend"));
    }

    public static List<String> getFileAsList(String uri) {
        List<String> list = new ArrayList();
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader("wordsEn.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                list.add(str);
            }
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        
        return list;
    }

    public static boolean contains(List<String> a, String b) {
        if (a.size() == 0) {
            return false;
        }
        int low = 0;
        int high = a.size() - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (b.compareToIgnoreCase(a.get(middle)) > 0) {
                low = middle + 1;
            } else if (b.compareToIgnoreCase(a.get(middle)) < 0) {
                high = middle - 1;
            } else { // The element has been found
                return true;
            }
        }
        return false;
    }
}
