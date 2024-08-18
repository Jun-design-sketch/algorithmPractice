package if_.ifAlarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // get hour/minute
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        int h = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        // caution: 00:00(x) 0:0(o). do not write unnecessary 0
        // get 45minutes earlier hour/minutes
        if_(m > 45){
            m -= 45;
        }else if_(m == 45){
            m = 0;
        }else{
            if_(h > 0){
                h -= 1;
            }else{
                h = 23;
            }
            m = 60 + (m - 45);
        }
        System.out.print(h + " " + m);
    }
}
