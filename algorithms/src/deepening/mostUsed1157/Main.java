package deepening.mostUsed1157;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
//        main.firstSolution();
//        main.secondSolution();
        main.thirdSolution();
    }

    // system.in.readにより変換が不要になる
    public void thirdSolution() throws IOException{
        int[] arr = new int[26];
        // input == only alphabets
        int eachNum = System.in.read(); // byte val 0~255, compatible with ASCII
        // make alphabet array
        while(eachNum>64){
            if(eachNum<91){
                // A:65 Z:90
                arr[eachNum-65]++;
            }else{
                // a:97 z:122
                arr[eachNum-97]++;
            }
            eachNum = System.in.read();
        }
        // get max key-value pair
        int max = 0;
        int key = 0;
        boolean alone = true;
        for(int i=0; i<26; i++){
            if(arr[i] > max){
                max = arr[i];
                key = i;
            }else if(arr[i] != 0 && arr[i] == max){
                alone = false;
                break;
            }
        }
        // make ascii value, convert char
        int answer = alone ? (key+65) : 63; // ?:63
        System.out.println((char)answer);
    }

    // 最大値の最大値のキーを同時に出せなかった
    public void secondSolution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ASCII A:65~Z:90
        char[] wordArr = br.readLine().toUpperCase().toCharArray();
        int[] countArr = new int[26];
        for(int i=0; i<wordArr.length; i++){
            int asciiVal = (int)wordArr[i];
            int key = asciiVal-65; // 'A' == countArr[0]
            countArr[key] += 1;
        }
        // maximum value
        int max = Arrays.stream(countArr).max().getAsInt();
        int[] arr = Arrays.stream(countArr).filter(el -> el == max).toArray();
        // output
        if(arr.length > 1){
            bw.write("?");
        }else{
            // find maximum key
            for(int i=0; i<countArr.length; i++){
                if(max == countArr[i]){
                    int asciiAns = i+65;
                    bw.write(""+(char)asciiAns);
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    // 難しく考えすぎた…。
    public void firstSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine().toUpperCase();
        String[] wordArr = word.split("");
        br.close();

        // count
        HashMap<String, Integer> keyMap = new HashMap<>();
        int checker = 0;
        for(int i=0; i<wordArr.length; i++){
            try{
                checker = keyMap.put(wordArr[i], 1);
                if(checker != 0){
                    keyMap.merge(wordArr[i], checker, Integer::sum);
                }
            }catch(NullPointerException e){}
        }

        // max
        int[] valArr = new int[keyMap.size()];
        Set<String> keySet = keyMap.keySet();
        int j = 0;
        String maxKey = "";
        int maxVal = 0;
        for(String key : keySet){
            valArr[j] = keyMap.get(key);
            if( maxVal < valArr[j]){
                maxKey = key;
                maxVal = valArr[j];
            }
            j++;
        }

        // duplicate
        int duplicateChecker = 0;
        for(int k=0; k<valArr.length; k++){
            if(valArr[k] == maxVal){
                duplicateChecker++;
                if(duplicateChecker > 1){
                    break;
                }
            }
        }

        // output
        if(duplicateChecker > 1){
            bw.write("?");
        }else{
            bw.write(""+maxKey);
        }
        bw.flush();
        bw.close();
    }
}
