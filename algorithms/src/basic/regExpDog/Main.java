package basic.regExpDog;

public class Main {
    public static void main(String[] args) {
        System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\""+"^"+"\"`    |");
        System.out.println("||_/=\\\\__|");
    }
}
// 上記問題で他の行はescape(\)だけでコンパイルできるが、
// 4行はcharacter literal(^)とString literal(残り）が混ざっているので
// 一筋縄でsysout()してはいけない

// ついでに
// constant : いわばconst, final
// varではないから変わらないということだけど、
// final Test test = new Test();
// test.el = 10; といった風にクラス内のデータは変化できる

// literal : データそのもの、変数に入れるための変わらないデータ
// final int i = 0; > literal is 0
// instanceは動的に使用するものだから、literalには普通なれないが
// object literalというものはある。 -> immutable class
// Objectを生成すると中のデータが変わらない。(String、Color）
// なのでStringをObject literalというのだ