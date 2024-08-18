package practice.sha256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Example {
    public static void main(String[] args) {
        String text = "Hello, World!";
        try {
            // MessageDigestClass: provide function messageDigestAlgorithms, SHA-1 or SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // input byte(8bit), get byteArray
            byte[] hashBytes = digest.digest(text.getBytes());
            // prepare
            StringBuilder sb = new StringBuilder();
            // each byte
            for(byte b : hashBytes) {
                // encrypt, hash, systemLevel things, memoryAddress, colorCode,.. : Hexadecimal is Standard
                String hex = Integer.toHexString(0xff & b);
                // if 1digit -> make 2 digits
                if(hex.length() == 1){
                    sb.append(0);
                }
                sb.append(hex);
            }
            System.out.println("SHA-256 Hash: " + sb.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
