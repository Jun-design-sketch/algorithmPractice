package deepening.sprout25083;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        sb.append("         ,r\'\"7"+"\n");
        sb.append("r`-_   ,'  ,/"+"\n");
        sb.append(" \\. \". L_r'"+"\n");
        sb.append("   `~\\/"+"\n");
        sb.append("      |"+"\n");
        sb.append("      |"+"\n");

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
