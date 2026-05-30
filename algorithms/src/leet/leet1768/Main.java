package leet.leet1768;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String wordQ1 = "abc";
        String wordQ2 = "pqr";
        System.out.println(main.mergeAlternately(wordQ1, wordQ2));

        String wordQ3 = "ab";
        String wordQ4 = "pqrs";
        System.out.println(main.mergeAlternately(wordQ3, wordQ4));

        String wordQ5 = "abcd";
        String wordQ6 = "pq";
        System.out.println(main.mergeAlternately(wordQ5, wordQ6));
    }

    public String mergeAlternately(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(true) {
            String a = i >= w1.length ? "" : String.valueOf(w1[i]);
            String b = i >= w2.length ? "" : String.valueOf(w2[i]);
            if(a.isEmpty() && b.isEmpty()) break;

            sb.append(a).append(b);
            i++;
        }

        return sb.toString();
    }
}
