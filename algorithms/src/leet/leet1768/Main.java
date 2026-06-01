package leet.leet1768;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String wordQ1 = "abc";
        String wordQ2 = "pqr";
        System.out.println(main.mergeAlternately(wordQ1, wordQ2));
        System.out.println(main.mergeAlternatelyTwo(wordQ1, wordQ2));

        String wordQ3 = "ab";
        String wordQ4 = "pqrs";
        System.out.println(main.mergeAlternately(wordQ3, wordQ4));
        System.out.println(main.mergeAlternatelyTwo(wordQ3, wordQ4));

        String wordQ5 = "abcd";
        String wordQ6 = "pq";
        System.out.println(main.mergeAlternately(wordQ5, wordQ6));
        System.out.println(main.mergeAlternatelyTwo(wordQ5, wordQ6));
    }

    public String mergeAlternately(String word1, String word2) {
        // 不要な宣言：str.charAt()で良い
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        // 可読性：ループの終了条件を冒頭に書いていない
        while(true) {
            // 曖昧だけど：空文字列を作る必要はない
            String a = i >= w1.length ? "" : String.valueOf(w1[i]);
            String b = i >= w2.length ? "" : String.valueOf(w2[i]);
            if(a.isEmpty() && b.isEmpty()) break;

            sb.append(a).append(b);
            i++;
        }

        return sb.toString();
    }

    public String mergeAlternatelyTwo(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // ループの終了条件で文字列長さを条件にすることと明示
        while (i < word1.length() || i < word2.length()) {
            // 有れば足すだけ
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}
