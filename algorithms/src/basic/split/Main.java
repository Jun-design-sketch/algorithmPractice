package basic.split;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // condition: input could be larger than 10^12
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        long result = 0;
        for(String s : str){
            try {
                result += Long.parseLong(s);
            } catch(NumberFormatException e){
                break;
            }
        }
        System.out.println(result);
    }
}
