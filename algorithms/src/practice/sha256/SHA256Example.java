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
        // Hashは特定の数学論理で文字列を整形するけれど、決まった文字列からは決まったものしか出てこない。
        // 結果RainbowTableといった整形後のものの集合体があれば、大体のものは分かってしまう
        // 同じDigestが得られるまで、ハッシュ関数に無差別代入する？（時間はかかる）→　BruteForce

        // なので、original->hashFunc->digest->hashFunc->digest
        // 複数回回してしまうことでより安全にする → keyStretching

        // また、ハッシュ関数稼働前に任意の文字列を加える。→ salt
        // 各ユーザー毎のソルト、32bit以上にする。任意乱数生成で付与するなど

    }
}
