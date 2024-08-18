package if_.ifCompare;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        if_(a > b){
            System.out.print(">");
        }else if_(a < b){
            System.out.print("<");
        }else{
            System.out.print("==");
        }
    }
}
