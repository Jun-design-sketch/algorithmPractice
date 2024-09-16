package practice.generic;

public class Main {
    public static void main(String[] args) {
        MyContainer<String> a = new MyContainer<>();
        MyContainer<Integer> b = new MyContainer<>();
        a.set("test10test");
        b.set(9999);
        System.out.println(a.get());
        System.out.println("a type is "+a.get().getClass().getName());
        System.out.println(b.get());
        System.out.println("b type is "+b.get().getClass().getName());

        System.out.println(a.genericMethod(100l));
    }
}

class MyContainer<T> {
    private T element;
    void set(T element) {
        this.element = element;
    }

    T get() {
        return element;
    }

    // メソッド単位で指定も可能
    <E> E genericMethod(E o){
        return o;
    }
}
