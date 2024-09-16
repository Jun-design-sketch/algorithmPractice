package numberTheory.tree2485;

import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
//    5
//    1
//    4
//    11
//    19
//    28
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] interval = new int[n-1];
        // 木を植えるとして、均一間隔に植えたいのであればどうするか？
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(i>0){
                interval[i-1] = arr[i]-arr[i-1];
            }
        }
        br.close();
        // 既に植えた木を引っこ抜けないので、既存木の間隔の最大公約数を求めれば良い
        // 複数の数のGCDを求めるには？
        Arrays.sort(interval);
        Main main = new Main();
        int allGcd = main.getGcd(interval);
        // あるべき間隔（最大公約数）が分かったので
        int first = arr[0];
        int last = arr[arr.length-1];
        int result = ((last - first) / allGcd) + 1;
        int realWorld = arr.length;

        System.out.println(result-realWorld);
    }

    private int getGcd(int[] arr){
        if(arr.length==1) return arr[0];

        TreeSet<Integer> gcdSet = new TreeSet<>();
        for(int j= arr.length-1; j>0; j--){
            int a = arr[j];
            int b = arr[j-1];
            while(b != 0){
                int tmp = a;
                a = b;
                b = tmp%b;
            }
            int gcd = a;
            gcdSet.add(gcd);
        }
        int[] remake = gcdSet.stream().mapToInt(Integer::intValue).toArray();
        // 再帰的呼び出しでは前回分の呼び出しではなく、しっかり今回分を返すように気をつけること。。
        // if文で囲って再帰的呼び出しをしたところで、その後にreturnがあるとreturnはされてしまうのだった
        // 42行なしでこうしてたから。。
        // if(arr.length!=1) getGcd(remake);
        // return remake[0];
        return getGcd(remake);
    }
}
