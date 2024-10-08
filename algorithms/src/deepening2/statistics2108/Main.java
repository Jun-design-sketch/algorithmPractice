package deepening2.statistics2108;

import java.io.*;
import java.util.*;

public class Main {
    // TODO: Case3, Case4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++){
            int element = Integer.parseInt(br.readLine());
            // ~Java7
            // if(!map.containsKey(element)) map.put(element, 1);
            // else map.put(element, (map.get(element)+1));
            // Java8~
            map.merge(element, 1, (k, v) -> map.get(element)+1);
            sum += element;
        }
        br.close();

        int average = sum / map.size();

        int mode = 0;
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        if(list.size() > 1){
            if(list.get(0).getValue() == list.get(1).getValue()) mode = list.get(1).getKey();
            else mode = list.get(0).getKey();
        }else{
            mode = list.get(0).getKey();
        }

        int range = 0;
        int maxVal = map.lastKey();
        int minVal = map.firstKey();
        range = maxVal - minVal;

        int middleVal = 0;
        int forMiddle = map.size() / 2;
        for(int i=0; i<forMiddle; i++){
            map.pollFirstEntry();
            map.pollLastEntry();
        }
        middleVal = map.pollFirstEntry().getKey();

        StringBuilder sb = new StringBuilder();
        sb.append(average + "\n");
        sb.append(middleVal + "\n");
        sb.append(mode + "\n");
        sb.append(range);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
