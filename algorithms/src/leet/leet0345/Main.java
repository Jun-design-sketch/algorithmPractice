package leet.leet0345;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String str1 = "IceCreAm";
        System.out.println(main.reverseVowels(str1)); // "AceCreIm"

        String str2 = "leetcode";
        System.out.println(main.reverseVowels(str2)); // "leotcede"

        System.out.println(Integer.valueOf("A".charAt(0)));
        System.out.println(Integer.valueOf("E".charAt(0)));
        System.out.println(Integer.valueOf("I".charAt(0)));
        System.out.println(Integer.valueOf("O".charAt(0)));
        System.out.println(Integer.valueOf("U".charAt(0)));
    }

    // 母音だけ洗い出して文字列内で位置をひっくり返す
    public String reverseVowels(String s) {
        // 母音のindexを保存（順番を保持）
        // 母音はascii値比較でOK
        //  大文字小文字で１０個で面倒
        //  一番楽で軽い比較
        return "";
    }
}
