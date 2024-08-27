package bigO.runningTime24263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        MenOfPassion(A[], n) {
//            sum <- 0;
//            for i <- 1 to n
//            sum <- sum + A[i]; # 코드1
//            return sum;
//        }
        // 遂行数はn回
        // 多項式で表す時、最高次項の次数は1.(n^1やん)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(a);
        System.out.println(1);
    }
}
