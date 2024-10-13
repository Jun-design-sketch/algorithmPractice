package recursive.mergeSort24060;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int COUNTING = 0;
    public static int result = -1;
    public static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        temp = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(arr, 0, arr.length-1, k);

        if(COUNTING < k){
            System.out.print("-1");
        }
    }

    private static void merge_sort(int[] arr, int left, int right, int count) {
        if(left == right) return;
        int middle = (left + right) / 2;
        merge_sort(arr, left, middle, count);
        merge_sort(arr, middle+1, right, count);
        merge(arr, left, middle, right, count);
    }

    private static void merge(int[] arr, int left, int middle, int right, int count) {
        int l = left;
        int r = middle + 1;
        int index = left;
        while (l <= middle && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[index] = arr[l];
                index++;
                l++;
            } else {
                temp[index] = arr[r];
                index++;
                r++;
            }
            COUNTING++;
            if(COUNTING == count){
                result = temp[index-1];
                System.out.print(result);
                return;
            }
        }

        if (l > middle) {
            while (r <= right) {
                temp[index] = arr[r];
                index++;
                r++;
                COUNTING++;
                if(COUNTING == count){
                    result = temp[index-1];
                    System.out.print(result);
                    return;
                }
            }
        } else {
            while (l <= middle) {
                temp[index] = arr[l];
                index++;
                l++;
                COUNTING++;
                if(COUNTING == count){
                    result = temp[index-1];
                    System.out.print(result);
                    return;
                }
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}