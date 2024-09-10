package practice.compare;

public class ComparableTest {
    public static void main(String[] args) {
        Student a = new Student(17, 4);
        Student b = new Student(22, 2);
        Student c = new Student(24, 1);

        int isBig = a.compareTo(b);
        if(isBig > 0){
            System.out.println("a > b");
        }else if(isBig == 0){
            System.out.println("a == b");
        }else{
            System.out.println("a < b");
        }

    }
}
// ComparableもComparatorも、整列に使われるものだ。
// ただ、primitive型だったら即時>,<,>=..してできるけれど
// Objectの比較は如何に行うものか？
// それを可能にすることが、ComparableとComparator

// 以下のようなStudentがあったら、プログラムにageとclassNumberどれを見るべきか
// どうやって決める？

// Comparable interfaceを拡張する。<T>はStudentを比較したいのだから<Student>となる
class Student implements Comparable<Student> {
    int age;
    int classNumber;

    Student(int age, int classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }

    // Comparableはinterfaceなので、implementsするとメソッドを具現しないといけない
    // 以前sortingの練習問題で既にComparatorはOverrideしたことがあるけど
    // ComparableのcompareToメソッドは自分自身と他の１つを比較する。
    @Override
    public int compareTo(Student o) {
        // 単に値の間で引き算するだけでも判定はできる。が
        // 使用している型によって,intだったらInteger.MAX_VALUE(2^31-1)まで
        // 限度を超えるとoverflowし真逆の結果が得られてしまう。
        // 安牌はこんな感じになる
        if(this.age > o.age){
            return 1;
        }else if(this.age == o.age){
            return 0;
        }else{
            return -1;
        }
    }
}
