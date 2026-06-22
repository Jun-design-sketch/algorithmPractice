package leet.leet0443;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        char[] ch1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(main.compress(ch1)); // 6
        System.out.println(ch1);

        char[] ch2 = {'a'};
        System.out.println(main.compress(ch2)); // 1
        System.out.println(ch2);

        char[] ch3 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(main.compress(ch3)); // 4
        System.out.println(ch3);
    }

    // 例は英語小文字だけど、chars[i]は大文字も数字も記号も入れる
    // 1 <= chars.length <= 2000
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);

        int count = 1;
        char before = chars[0];

        for(int i=1; i<chars.length; i++) {
            if(before == chars[i]){
                count++;
            } else {
                if(count > 1) sb.append(count);
                count = 1;
                sb.append(chars[i]);
                before = chars[i];
            }
        }

        if(count > 1) sb.append(count);
        System.out.println(sb);
        return sb.length();
    }

    // sbを用いるとcharsの編集でグチャになる。charsを新たに作るのはNG
    // sbを使わず、charsを編集する方向に進む
    // sbに書き込んだものをcharsに反映するときに面倒なことは書き込む位置
    // 書き込む位置と読み取りの位置は、必ずしも等しくはない：ここで詰んだ

    // ポインターを２つ使用する
    // 読み取るポインターは、常に書き込むポインターと同じかより先である
    public int compressMK2(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char current = chars[read];
            int count = 0;
            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }

            chars[write] = current;
            write++;

            if (count > 1) {
                String countStr = String.valueOf(count);
                for (int i = 0; i < countStr.length(); i++) {
                    chars[write] = countStr.charAt(i);
                    write++;
                }
            }
        }
        return write;
    }
}
