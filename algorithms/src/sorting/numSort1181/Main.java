package sorting.numSort1181;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return o1.length()-o2.length();
                }else{
                    char[] o1Ch = o1.toCharArray();
                    char[] o2Ch = o2.toCharArray();
                    for(int i=0; i<o1Ch.length; i++){
                        if(o1Ch[i]!=o2Ch[i]){
                            return o1Ch[i]-o2Ch[i];
                        }
                    }
                }
                return 0;
            }
        });

        for(int i=0; i<n; i++){
            if(i<n-1 && !arr[i].equals(arr[i+1])){
                sb.append(arr[i]+"\n");
            }
            if(i==n-1){
                sb.append(arr[i]);
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
