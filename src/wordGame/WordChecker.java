package wordGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordChecker {

    public static boolean check_for_word(String word) {
        try (BufferedReader in = new BufferedReader(new FileReader("wordsEn.txt"));) {
            return in.lines().anyMatch(t -> t.toLowerCase().equals(word));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return false;
    }

    

    public static boolean checkWordRandomAccessBinary(String word) {
        RandomAccessFile file;
        boolean result = false;
        try {
            file = new RandomAccessFile("wordsEn.txt", "r");
            result = searchRandomAccessFileBinary(file, word);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        return result;
    }

    // does not work properly
    public static boolean searchRandomAccessFileBinary(RandomAccessFile file, String target) throws IOException {
        final int size = (int) (file.length());
        int result = Collections.binarySearch(new AbstractList<String>() {
            public String get(int pIdx) {
                try {
                    file.seek(pIdx);
                    return file.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            public int size() {
                return size;
            }
        }, target, Comparator.comparing(String::toLowerCase)
        );
        return result == 0 ? true : false;
    }

    public static boolean checkWordStreamFromList(String word) {
        List<String> list = getFileAsList("wordsEn.txt");
        return list.stream().anyMatch(t -> t.toLowerCase().equals(word));
    }

    public static boolean checkWordParallelStreamFromList(String word) {
        List<String> list = getFileAsList("wordsEn.txt");
        return list.parallelStream().anyMatch(t -> t.toLowerCase().equals(word));
    }

    public static boolean checkWordBinaryAlgorithmFromList(List<String> list, String word) {
//        List<String> list = getFileAsList("wordsEn.txt");
        return binaryLookupInList(list, word);
    }

    public static List<String> getFileAsList(String uri) {
        List<String> list = new ArrayList();

        try (BufferedReader in = new BufferedReader(new FileReader("wordsEn.txt"));) {
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

    public static boolean binaryLookupInList(List<String> a, String b) {
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
            } else {
                return true;
            }
        }
        return false;
    }

}
