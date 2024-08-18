package if_.ifLeapYear;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int naturalNumber = sc.nextInt();
        int answer = 0;
        if(naturalNumber % 4 == 0){
            if(naturalNumber % 100 != 0 || naturalNumber % 400 == 0){
                answer = 1;
            }
        }
        System.out.print(answer);
    }
}
