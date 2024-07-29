package iterationAdd5;

import java.io.*;

// EOF(end of file)
public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        String str = "";
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

                while((str = br.readLine()) != null){
                    int[] arr = main.strToInt(str);
                    int answer = arr[0] + arr[1];
                    bw.write("" + answer + "\n");
                }
                // when EOF
                bw.flush();
                bw.close();
            } catch (IOException e) {
                throw new IOException(e.getMessage());
            }
    }

    protected int[] strToInt(String eachLine){
        String convStr[] = eachLine.split(" ");
        int a = Integer.parseInt(convStr[0]);
        int b = Integer.parseInt(convStr[1]);
        int[] arr = {a, b};
        return arr;
    }
}

