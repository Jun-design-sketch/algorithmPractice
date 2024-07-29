package iterationLong;

import java.util.Scanner;

public class Main {
    // C++ long int = 4byte
    // C++ long long int = 8byte?
    // C++ N byte = long long long long...? int? too long for GCC?
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n/4; i++){
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);
    }
}
