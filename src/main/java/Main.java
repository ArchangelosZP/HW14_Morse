import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] words1 = new String[] {"gin","zen","gig","msg"};
        System.out.println("Input: words = [\"gin\",\"zen\",\"gig\",\"msg\"]");
        System.out.println("Output: "+ ex1(words1));
        String[] words2 = new String[] {"a"};
        System.out.println("Input: words = [\"a\"]");
        System.out.println("Output: "+ ex1(words2));
        System.out.println();

        System.out.println("Input: 19, Output: "+ex2(19));
        System.out.println("Input: 2, Output: "+ex2(2));

    }

    public static int ex1(String[] strs){
        List mSet = new LinkedList();
        String[] mcode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",  "-", "..-", "...-",".--", "-..-", "-.--","--.." };
        char ch;
        String m = "";
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                ch = strs[i].charAt(j);
                m = m + mcode[ch - 97];
            }
            mSet.add(m);
            m = "";
        }
        Map result =
                (Map) mSet.stream().collect(
                    Collectors.groupingBy(
                            Function.identity()));
        return result.size();
    }

    public static Boolean ex2(int inp) {
        String inpS = "" + inp;
        List mL = new LinkedList<Integer>();
        for (int i = 0; i < inpS.length(); i++) {
            int ss = inpS.charAt(i)-'0';
            mL.add(ss);
        }
        Integer sum = 0;
        for (int i = 0; i < mL.size();  i++) {
            int zp = (int) mL.get(i);
            sum = sum + zp * zp;
        }
        if (sum == 1) {
            return true;
        } else {

            try {
               if (ex2(sum)==true) {return true;};
            } catch (StackOverflowError  e) {
                return false;
            }
        }
        return false;
    }
}

