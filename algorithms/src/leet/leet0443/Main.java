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
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);

        int count = 1;
        char before = chars[0];

        for(int i=1; i<chars.length; i++) {
            if(chars[i-1] == before){
                count++;
            } else {
                if(count > 1) sb.append(count);

                count = 1;
                sb.append(chars[i]);
                before = chars[i];
            }
        }
        if(count > 1) sb.append(count);

        return sb.length();
    }
}
