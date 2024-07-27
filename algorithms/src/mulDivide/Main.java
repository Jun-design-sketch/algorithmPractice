package mulDivide;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        // (A+B)%C === ((A%C) + (B%C))%C ?
        //
        // (A×B)%C === ((A%C) * (B%C))%C ?

        //  (A+B)%C, ((A%C) + (B%C))%C, (A×B)%C, ((A%C) × (B%C))%C
        int firstCal = (a+b)%c;
        int secondCal = firstCal%c;
        int thirdCal = (a*b)%c;
        int fourthCal = thirdCal%c;
        System.out.println(firstCal);
        System.out.println(secondCal);
        System.out.println(thirdCal);
        System.out.println(fourthCal);
    }
}
