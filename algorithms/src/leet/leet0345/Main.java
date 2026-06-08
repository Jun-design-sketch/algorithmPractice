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
    // 今度two pointerでやってみる
    public String reverseVowels(String s) {
        Set<Integer> vowels = new HashSet<>(Arrays.asList(65, 69, 73, 79, 85, 97, 101, 105, 111, 117));

        // Characterを直接入れても良い
        // Set<Character> vowels = new HashSet<>(
        //  Arrays.asList('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U')
        // );

        // Setにせず、Stringでも判定できる
        // private boolean isVowel(char ch) {
        //  return "aeiouAEIOU".indexOf(ch) >= 0;
        // }

        Deque<Character> stack = new ArrayDeque<>();
        // int[]でなくとも、boolean[]で十分
        // int[] indexes = new int[s.length()];
        boolean[] isVowelIndex = new boolean[s.length()];

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(vowels.contains((int) ch)) {
                isVowelIndex[i] = true;
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(isVowelIndex[i] != true) sb.append(s.charAt(i));
            else sb.append(stack.pop());
        }

        return sb.toString();
    }
}
