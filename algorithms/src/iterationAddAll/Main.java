package iterationAddAll;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1 <= n <= 10000
        int n = sc.nextInt();
        sc.close();
        // add all: from 1 to n
        int answer = n % 2 == 0 ?
                (1 + n) * (n / 2) :
                (1 + n) * (n / 2) + ((1 + n) / 2);
        System.out.print(answer);
    }
}
