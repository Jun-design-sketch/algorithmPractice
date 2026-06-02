package leet.leet1071;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String str1q1 = "ABCABC";
        String str2q1 = "ABC";
        System.out.println(main.gcdOfStrings(str1q1, str2q1)); // "ABC"

        String str1q2 = "ABABAB";
        String str2q2 = "ABAB";
        System.out.println(main.gcdOfStrings(str1q2, str2q2)); // "AB"

        String str1q3 = "LEET";
        String str2q3 = "CODE";
        System.out.println(main.gcdOfStrings(str1q3, str2q3)); // ""

        String str1q4 = "AAAAAB";
        String str2q4 = "AAA";
        System.out.println(main.gcdOfStrings(str1q4, str2q4)); // ""
    }

    public String gcdOfStrings(String str1, String str2) {
        int length = gcd(str1.length(), str2.length());
        String candidate = str1.substring(0, length);

        if(canBuild(str1, candidate) && canBuild(str2, candidate)) return candidate;
        return "";
    }

    // なぜ文字列長さのGCDを求めると十分なのか？
    // 1.とある文字列の中で繰り返されるパターンがある　＝　そのパターンの長さは、str.length()の約数である
    // 2.二つの文字列の中で共通されるパターンがある　＝　二つの文字列のlength()の公約数である
    // 3 最大公約数は、それより小さい約数で割り切られる
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public boolean canBuild(String str, String candidate) {
        for(int i = 0; i < str.length(); i++) {
            // i % (定数) にし、0〜(定数-1)をループ＆＆i番目との比較が成立する
            if(str.charAt(i) != candidate.charAt(i % candidate.length())) return false;
        }
        return true;
    }
}
