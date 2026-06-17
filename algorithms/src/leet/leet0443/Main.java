package leet.leet0443;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        char[] ch1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(main.compress(ch1)); // 6

        char[] ch2 = {'a'};
        System.out.println(main.compress(ch2)); // 1

        char[] ch3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(main.compress(ch3)); // 4
    }

    // 例は英語小文字だけど、chars[i]は大文字も数字も記号も入れる
    // 1 <= chars.length <= 2000
    public int compress(char[] chars) {
        char first = chars[0];
        char second = '0';

        for(int i=1; i<chars.length; i++) {

        }

        if(second == '0') return 1;

        return 0;
    }
}
