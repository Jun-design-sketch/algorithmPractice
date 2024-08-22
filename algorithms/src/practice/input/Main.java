package practice.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.CharBuffer;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        // Java : (in memory) strings are encoded UTF-16
        // when transmission or reception -> serialization(UTF-8)
        // when input or output string -> OS default set, or user setting
        // 1~127 : ASCII codeVal == UTF-8, UTF-16, CP949, MS949..

        // UTF-8 : english(1byte)
        // UTF-16 : almost 2byes

        // Scanner sc = new Scanner(System.in);
        // System.in ?
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Stream
        // 水道のようにAからBまで移動する水の流れ
        // fileData, HttpResponseData, KeyboardInput
        // keyboard -> inputStream -> program -> outputStream -> monitor

        // java default input stream -> inputStream -> System.in == inputStream type field
//        try {
//            Field field = System.class.getField("in");
//            System.out.println(field); // public static final java.io.InputStream java.lang.System.in
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        }
//
//        InputStream inputStream = System.in;
//        int a = inputStream.read(); // 1
//        System.out.println(a); // 49(1のASCII. UTF-8もUTF-16も127までの表現はASCIIと共有する)

        // InputStream.read() : 入力されたデータはint型で保存され、
        // 該当文字のシステムまたはOSエンコード形式の10進数で変数に格納する
        // そのうち1byteのみ読み込む

        // 複数の文字を読み込みたければ？
//        InputStream inputStream1 = System.in; // 1234567890
//        byte[] b = new byte[10];
//        inputStream1.read(b);
//        for(byte val: b){
//            System.out.println(val); // 49,59,51,52,53,54,55,56,57,48
//        }

        // Scanner
//        InputStream inputStream = System.in;
//        Scanner sc = new Scanner(inputStream);
//        int c = sc.nextInt();
//        System.out.println(c);
        // see source
//            public Scanner(InputStream source) {
//            this(new InputStreamReader(source), WHITESPACE_PATTERN);
//        }
        // move here again
//            private Scanner(Readable source, Pattern pattern) {
//            assert source != null : "source should not be null";
//            assert pattern != null : "pattern should not be null";
//            this.source = source;
//            delimPattern = pattern;
//            buf = CharBuffer.allocate(BUFFER_SIZE);
//            buf.limit(0);
//            matcher = delimPattern.matcher(buf);
//            matcher.useTransparentBounds(true);
//            matcher.useAnchoringBounds(false);
//            useLocale(Locale.getDefault(Locale.Category.FORMAT));
//        }

        // InputStreamReader: bridge from byte streams to character stream
//        InputStreamReader sr = new InputStreamReader(System.in);
//        int d = sr.read(); // あ
//        System.out.println((char)d); // あ
//        System.out.println(d); // 12354

        // ここまでで、InputStreamはbyte単位で入力される
        // また、入力データをchar単位で処理するためにInputStreamReaderが使用される
        // しかし、InputStreamReaderは「文字」を処理する。「文字列」ではない
        // 毎回毎回配列を宣言して文字列を読み取る訳にはいかない
//        InputStreamReader sr1 = new InputStreamReader(System.in);
//        char[] ch = new char[10];
//        sr1.read(ch); // あえいおうかab가나
//        for(char val:ch){
//            System.out.println(val);
//        }

        // だからBufferに文字を溜めておいて、一度に文字列のように流す。馴染みのあるこれが出てくる
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Byte Type = InputStream
        // Char Type = InputStreamReader
        // Char Type Serialization = BufferedReader
        // Scannerとは違って、正規表現による検査を実施しない。だからScannerより速い〜なんて言われる（事実）
        // *Serialization直列化：オブジェクトの状態を特定形式に変換し保存・転送できるようにする。
        // 直列化：オブジェクトをbyteStreamに変換し保存・転送
        // 逆直列化：byteStreamをオブジェクトに変換し元の状態に戻す

        BufferReadTest brt = new BufferReadTest();
//        brt.test1();
//        brt.test2();
//        brt.test3();
        brt.test4();
    }
}

class BufferReadTest {
    protected void test1() throws IOException {
        // read int value with while
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int read;
        while((read = br.read()) >= 0){ // br.read() when eof == return -1
            char ch = (char)read;
            System.out.println(ch);
        }
        // intellij: cmd+d(eof)
        br.close();
    }

    protected void test2() throws IOException {
        // br.read() EOF is -1
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int read;
        if(br.read() == -1){ // cmd+d
            System.out.println("br.read EOF == return -1");
        };
    }

    protected void test3() throws IOException {
        // readLine with while
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read;
        while((read = br.readLine()) != null){
            System.out.println(read);
        }
        br.close();
    }

    protected void test4() throws IOException {
        // readLine EOF test
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if(br.readLine()== null){
            System.out.println("br.readLine EOF == return null");
        }
        br.close();
    }
}
