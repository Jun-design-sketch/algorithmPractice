package deepening.croatianAlphabet2941;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int a = System.in.read();
        int b = 0;
        byte[] arr = new byte[102]; // maximum input: 100 + 2(i+2)
        while(44<a && a<123){
            arr[b] = (byte) a;
            b++;
            a = System.in.read();
        }
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                break;
            }else if(arr[i] == 100 && arr[i+1] == 122 && arr[i+2] == 61){ // dz=
                count++;
                i += 2;
            }else if(arr[i+1] == 45 && (arr[i] == 99 || arr[i] == 100)){ // c-, d-
                count++;
                i++;
            }else if(arr[i+1] == 106 && (arr[i] == 108 || arr[i] == 110)){ // lj, nj
                count++;
                i++;
            }else if(arr[i+1] == 61 && (arr[i] == 115 || arr[i] == 122 || arr[i] == 99)){ // c=, s=, z=
                count++;
                i++;
            }else{
                count++;
            }
        }
        System.out.println(count);
    }
}

// = : 61
// - : 45
// c : 99
// d : 100
// l : 108
// j : 106
// n : 110
// s : 115
// z : 122