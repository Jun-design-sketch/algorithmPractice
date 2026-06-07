package leet.leet0345;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String str1 = "IceCreAm";
        System.out.println(main.reverseVowels(str1)); // "AceCreIm"

        String str2 = "leetcode";
        System.out.println(main.reverseVowels(str2)); // "leotcede"
    }

    // 母音だけ洗い出して文字列内で位置をひっくり返す
    public String reverseVowels(String s) {
        Set<Integer> vowels = new HashSet<>(Arrays.asList(65, 69, 73, 79, 85, 97, 101, 105, 111, 117));
        Deque<Character> stack = new ArrayDeque<>();
        int[] indexes = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(vowels.contains((int) ch)) {
                indexes[i] = 1;
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(indexes[i] != 1) sb.append(s.charAt(i));
            else sb.append(stack.pop());
        }

        return sb.toString();
    }
}
