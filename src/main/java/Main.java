import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[] {"gin","zen","gig","msg"};
        System.out.println("Input: words = [\"gin\",\"zen\",\"gig\",\"msg\"]");
        System.out.println("Output: "+ ex1(words));

    }

    public static int ex1(String[] strs){
        char ch;
        String morse = "";
        Set morseSet = new HashSet();
        final String[] morsecode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",  "-", "..-", "...-",
                ".--", "-..-", "-.--","--.." };
        int i;
        for (i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                ch = strs[i].charAt(j);
                morse += morsecode[ch - 'a'];
            }
            morseSet.add(morse);
            morse = "";
        }
        return morseSet.size();
    }
}
