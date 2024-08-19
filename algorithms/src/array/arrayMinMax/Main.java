package array.arrayMinMax;

import java.io.*;
import java.util.Arrays;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstStr = br.readLine();
        String secondStr[] = br.readLine().split(" ");
        OptionalInt min = Arrays.stream(secondStr).mapToInt(Integer::parseInt).reduce((a, b) -> a<b ? a:b);
        OptionalInt max = Arrays.stream(secondStr).mapToInt(Integer::parseInt).reduce((a, b) -> a>b ? a:b);
        if(min.isPresent() && max.isPresent()){
            bw.write(""+min.getAsInt()+" "+max.getAsInt());
        }
        bw.flush();
        bw.close();
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int firstInt = Integer.parseInt(br.readLine());
//        String secondStr[] = br.readLine().basic.split(" ");
//        int[] intArr = new int[firstInt];
//        for(int i=0; i < secondStr.length; i++){
//            intArr[i] = Integer.parseInt(secondStr[i]);
//        }
//        Arrays.sort(intArr);
//        bw.write(""+intArr[0]+" "+intArr[firstInt-1]);
//        bw.flush();
//        bw.close();
//    }
}