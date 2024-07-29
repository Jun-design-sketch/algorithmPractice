package iterationAdd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputCount = sc.nextInt();
        sc.nextLine(); // because there is enter(\n)

        for(int i=0; i<inputCount; i++){
            String str[] = sc.nextLine().split(" ");
            System.out.println(Integer.parseInt(str[0])+Integer.parseInt(str[1]));
        }
        sc.close(); // explicit close
    }
}
