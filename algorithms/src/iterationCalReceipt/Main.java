package iterationCalReceipt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalAmount = sc.nextInt(); // totalAmount in receipt
        int totalCategoryVal = sc.nextInt(); // number of category in receipt
        sc.nextLine(); // enter(\n)

        int calAllAmount = 0; // for validate totalAmount
        for(int i=0; i<totalCategoryVal; i++){
            String str[] = sc.nextLine().split(" ");
            calAllAmount += Integer.parseInt(str[0])*Integer.parseInt(str[1]);
        }

        String result = totalAmount == calAllAmount ? "Yes" : "No";
        System.out.println(result);

        sc.close();
    }
}
