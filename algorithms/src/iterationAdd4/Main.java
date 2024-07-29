package iterationAdd4;

import java.io.*;


public class Main {
    // input 0 0 == end program
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        int a = 0;
        int b = 0;
        Main main = new Main();
        while(true) {
            try {
                str = br.readLine();
                if (!str.equals("0 0")) {
                    int[] arr = main.strToInt(str);
                    int answer = arr[0] + arr[1];
                    bw.write("" + answer + "\n");
                } else {
                    break;
                }
            } catch (IOException e) {
                throw new IOException(e.getMessage());
            }
        }
        bw.flush();
        bw.close();
    }

    protected int[] strToInt(String eachLine){
        String convStr[] = eachLine.split(" ");
        int a = Integer.parseInt(convStr[0]);
        int b = Integer.parseInt(convStr[1]);
        int[] arr = {a, b};
        return arr;
    }
}
