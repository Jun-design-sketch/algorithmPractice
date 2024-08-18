package calculate.multipleProcess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // three-digit multiplication
        Scanner sc = new Scanner(System.in);
        int a,b;
        a = sc.nextInt();
        b = sc.nextInt();

        int firstCal = a * (b%10);
        int secondCal = a * ((b/10)%10);
        int thirdCal = a * (b/100);
        int result = firstCal + secondCal*10 + thirdCal*100;
        System.out.println(firstCal);
        System.out.println(secondCal);
        System.out.println(thirdCal);
        System.out.println(result);
    }
}
