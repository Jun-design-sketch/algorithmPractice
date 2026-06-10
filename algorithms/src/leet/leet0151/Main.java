package leet.leet0151;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String q1 = "the sky is blue";
        System.out.println(main.reverseWords(q1)); // "blue is sky the"

        String q2 =  " hello world  ";
        System.out.println(main.reverseWords(q2)); // "world hello"

        String q3 = "a good   example";
        System.out.println(main.reverseWords(q3)); // "example good a"
    }

    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = strArr.length - 1; i >= 0; i--) {
            if(!strArr[i].equals("")) sb.append(strArr[i]).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
