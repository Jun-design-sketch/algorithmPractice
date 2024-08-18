package if_.ifQuadrant;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int x, y != 0
        int x = sc.nextInt();
        int y = sc.nextInt();
        // quadrant 1 : (+, +) quadrant 2: (-, +)
        // quadrant 3 : (-, -) quadrant 4: (+, -)
        boolean judgeX = x > 0 ? true : false;
        boolean judgeY = y > 0 ? true : false;
        if(judgeX && judgeY){
            System.out.print(1);
        }else if(judgeY){
            System.out.print(2);
        }else if(judgeX){
            System.out.print(4);
        }else{
            System.out.print(3);
        }
    }
}
