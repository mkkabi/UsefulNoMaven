
package wordGame;

import java.util.ArrayList;
import java.util.List;

public class permute {

    static void permute(int level,String permuted,boolean used[], String original, List<String> result) {
//		 List<String> list = new ArrayList();
        int length = original.length();
        if (level == length) {
//            System.out.println(permuted);
				result.add(permuted);
        } else {
            for (int i = 0; i < length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    permute(level + 1, permuted + original.charAt(i),used, original,result);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
//       String s = "mhonwkbcidv"; 
		 String s = "mhonwkbcidv";
        boolean used[] = {false, false, false, false, false, false, false, false, false, false, false};
		  List<String> result = new ArrayList();
        permute(0, "", used, s, result);
		  
		  result.stream().filter(t->t.charAt(2)=='c'&& t.charAt(4) == 'o').forEach(System.out::println);
    }
}
