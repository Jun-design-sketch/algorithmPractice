package twoDimensionalArray.colorPaper2563;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int WIDTH_OF_PAPER  = 10;
    public static int HEIGHT_OF_PAPER = 10;
    public static int LIMITATION_OF_PAPER_NUMBER = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[][] space = new int[LIMITATION_OF_PAPER_NUMBER][LIMITATION_OF_PAPER_NUMBER];
        for(int i=0; i<num; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            int HorizontalFromZero = Integer.parseInt(st.nextToken());
            int VerticalFromZero = Integer.parseInt(st.nextToken());
            for(int j=HorizontalFromZero; j<HorizontalFromZero+WIDTH_OF_PAPER; j++){
                for(int k=VerticalFromZero; k<VerticalFromZero+HEIGHT_OF_PAPER; k++){
                    space[j][k] = 1;
                }
            }
        }
        br.close();
        int count=0;
        for(int i=0; i<LIMITATION_OF_PAPER_NUMBER; i++){
            for(int j=0; j<LIMITATION_OF_PAPER_NUMBER; j++){
                if(space[i][j]==1){
                    count++;
                }
            }
        }
        bw.write(""+count);
        bw.flush();
        bw.close();
    }
}
