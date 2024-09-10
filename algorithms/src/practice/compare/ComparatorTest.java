package practice.compare;

import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        Student2 a = new Student2(17, 2);
        Student2 b = new Student2(18,1);
        Student2 c = new Student2(19,0);
        int isBig = a.compare(b,c);
        if(isBig > 0){
            System.out.println("b > c");
        }else if(isBig == 0){
            System.out.println("b == c");
        }else{
            System.out.println("b < c");
        }
        // 偽名オブジェクトを使う
        Comparator<Student2> comp1 = new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                return o1.classNumber - o2.classNumber;
            }
        };
        comp1.compare(a,b);

    }

    public static Comparator<Student2> comp2 = new Comparator<Student2>() {
        @Override
        public int compare(Student2 o1, Student2 o2) {
            return o1.classNumber - o2.classNumber;
        }
    };
}

// Comparatorは２つの引数をお互い比較してくれる。
// Arrays.sort()の２番目の引数だったのもこのComparatorだった
class Student2 implements Comparator<Student2>{
    int age;
    int classNumber;

    Student2(int age, int classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }

    @Override
    public int compare(Student2 o1, Student2 o2) {
        // この前の問題のようにlimitが決まっているものであれば引き算でもよき
        return o1.classNumber - o2.classNumber;
    }
}
