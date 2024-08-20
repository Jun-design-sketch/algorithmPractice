package deepening.univScoreAverage25206;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);
        int top = 0;
        int bottom = 0;
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            Convert convert = new Convert();
            // 학점
            int credit = Integer.parseInt(arr[1].replace(".",""));
            // 과목평점
            int courseGrade = convert.convertGrade(arr[2]);
            if(courseGrade != -1){
                // 분자
                top += credit*courseGrade;
                // 분모
                bottom += credit*10;
            }
        }
        BigDecimal bd1 = new BigDecimal(top);
        BigDecimal bd2 = new BigDecimal(bottom);
        BigDecimal answer = bd1.divide(bd2,6, RoundingMode.HALF_UP);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}

// hashmapを使っても良かった。。
class Convert {
    protected int convertGrade(String grade){
        int gradeInt = 0;
        if(grade.equals("A+")) gradeInt = 45;
        else if(grade.equals("A0")) gradeInt = 40;
        else if(grade.equals("B+")) gradeInt = 35;
        else if(grade.equals("B0")) gradeInt = 30;
        else if(grade.equals("C+")) gradeInt = 25;
        else if(grade.equals("C0")) gradeInt = 20;
        else if(grade.equals("D+")) gradeInt = 15;
        else if(grade.equals("D0")) gradeInt = 10;
        else if(grade.equals("F")) gradeInt = 0;
        else gradeInt = -1;
        return gradeInt;
    }
}
