package if_.ifDice;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int ALL_MATCH_PRIZE = 10000;
    public static final int ALL_MATCH_MULTIPLE = 1000;
    public static final int TWO_MATCH_PRIZE = 1000;
    public static final int NOT_ALL_MATCH_MULTIPLE = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        // each dice value
        int[] numbers = {Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2])};
        Arrays.sort(numbers);

        int prizeResult;
        if(numbers[0] == numbers[2]){
            prizeResult = ALL_MATCH_PRIZE + ALL_MATCH_MULTIPLE * numbers[0];
        }else if(numbers[0] != numbers[1] && numbers[1] != numbers[2]){
            prizeResult = NOT_ALL_MATCH_MULTIPLE * numbers[2];
        }else{
            prizeResult = TWO_MATCH_PRIZE + NOT_ALL_MATCH_MULTIPLE * numbers[1];
        }
        System.out.print(prizeResult);
    }
}
