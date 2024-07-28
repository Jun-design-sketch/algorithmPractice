package ifOvenTimer;

import java.util.Scanner;

public class Main {
    public static final int ALL_HOUR = 24;
    public static final int ALL_MIN = 60;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        int duration = sc.nextInt();
        // currentTime
        int curHour = Integer.parseInt(str[0]);
        int curMin = Integer.parseInt(str[1]);
        // durationTime
        int durHour = duration / 60;
        int durMin = duration % 60;
        // endTime
        int endHour = 0;
        int endMin = 0;

        if(curMin + durMin < ALL_MIN){
            endMin = curMin + durMin;
        }else if(curMin + durMin == ALL_MIN){
            endHour += 1;
        }else{
            endHour += 1;
            endMin = (curMin + durMin) - ALL_MIN;
        }
        if(endHour + curHour + durHour < ALL_HOUR){
            endHour += curHour + durHour;
        }else if(endHour + curHour + durHour == ALL_HOUR){
            endHour = 0;
        }else{
            endHour = (endHour + curHour + durHour) % ALL_HOUR;
        }
        System.out.print(endHour + " " + endMin);
    }
}
