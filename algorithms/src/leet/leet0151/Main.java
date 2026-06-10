package leet.leet0151;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String q1 = "the sky is blue";
        System.out.println(main.reverseWordsMK2(q1)); // "blue is sky the"

        String q2 =  " hello world  ";
        System.out.println(main.reverseWords(q2)); // "world hello"

        String q3 = "a good   example";
        System.out.println(main.reverseWords(q3)); // "example good a"
    }

    // 時間複雑度：
    // split、ループ内のappend、toStringがそれぞれ最大O(n)
    // 合計 O(3n) = O(n)
    // 空間複雑度：
    // splitで生成される配列、StringBuilder、返却用Stringがそれぞれ最大O(n)
    // 合計 O(3n) = O(n)
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = strArr.length - 1; i >= 0; i--) {
            // if(!strArr[i].isEmpty)の方が直観的
            if(!strArr[i].equals("")) sb.append(strArr[i]).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    public String reverseWordsMK2(String s) {
        // trim()で前後の空白文字を消し、空白(\s)を1回以上(+)繰り返したものを基準で分割
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            // 初回以外空白を足す
            if (sb.length() > 0) {
                sb.append(" ");
            }

            sb.append(words[i]);
        }

        return sb.toString();
    }
}
