package basicMathematics.snail2869;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        // solution.sol1();
        // solution.sol2();
        solution.sol3();
    }
}

class Solution {
    // パターンをより単純化できるためループ文削除
    // ①昼の上りだけで完結（1日）
    // ②昼の上り、夜の下りを繰り返し、昼の上りで完結（2日以上）
    // 以下の式が成立する
    // x == durationDay
    // height = (dayClimb-nightDescend) * x + dayClimb;
    protected void sol3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        int dayClimb = Integer.parseInt(st.nextToken());
        int nightDescend = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        if(height == dayClimb){
            System.out.println(1); // ①
        }else{
            // x = height-dayClimb / (dayClimb-nightDescend)
            // ただし、dayClimbの値によって右編が左編の値を超過する場合があり得る。というのも
            // 마지막 날에 올라간 거리는 유동적이다. (일별상승-일별하락) <= 마지막날거리 == 남은거리 <= 올라갈 수 있는 거리
            // 여기서 아는것은? (일별상승-일별하락), 올라갈수있는거리. 남은거리를 구하는 방법은?
            // 총 거리 = (일별상승-일별하락) * x + [] 인데,
            // []가 반드시 (일별상승-일별하락)의 %인것은 아니다.
            // 0<[]<=올라갈수있는거리...

            // ** int finalDay = height % dayClimb;

            int bottom = dayClimb-nightDescend; // nightDescend < dayClimb
            int top = height-dayClimb; // dayClimb <= height
            int durationDay = top/bottom;
            System.out.println(durationDay+1);//　②durationDayは最終日の上りのみ1日を含めない
        }
    }

    // while、firstDay削除
    // 相変わらず時間超過する
    // br,st,parseが消費する時間が長すぎる？ bufferedReaderとかで事足りるはず…
    protected void sol2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        int dayClimb = Integer.parseInt(st.nextToken());
        int nightDescend = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int durationDay = 0;
        int climbed = 0;
        for(int i=0; i<height; i++){
            durationDay++;
            climbed += dayClimb;
            if(climbed>=height)break;
            climbed -= nightDescend;
        }
        System.out.println(durationDay);
    }

    // 答えは正しく出る
    // 時間超過で失敗した。。
    protected void sol1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        int dayClimb = Integer.parseInt(st.nextToken());
        int nightDescend = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int durationDay = 1;
        int climbed = dayClimb;
        boolean firstDay = true;
        while(climbed < height){
            if(firstDay){
                climbed -= nightDescend;
                firstDay = false;
            }
            durationDay++;
            climbed += dayClimb;
            if(climbed >= height) break;
            climbed -= nightDescend;
        }
        bw.write(""+durationDay);
        bw.flush();
        bw.close();
    }
}