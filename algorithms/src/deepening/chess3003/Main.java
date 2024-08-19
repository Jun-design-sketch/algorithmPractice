package deepening.chess3003;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // to complete: 1 king, 1 queen, 2 rook, 2 bishop, 2 knight, 8 pawn
        String[] currentPiece = br.readLine().split(" ");
        int[] originalPiece = {1,1,2,2,2,8};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<originalPiece.length; i++){
            sb.append(originalPiece[i]-Integer.parseInt(currentPiece[i]));
            if(i != originalPiece.length-1){
                sb.append(" ");
            }
        }
        bw.write(String.valueOf(sb));

        br.close();
        bw.flush();
        bw.close();
    }
}
