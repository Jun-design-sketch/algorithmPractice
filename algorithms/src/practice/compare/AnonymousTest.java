package practice.compare;

public class AnonymousTest {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        System.out.println(rec.get());

        // Shapeを拡張して、depth追加とget()を再定義する
        Shape anonymous = new Shape() {

            int depth = 40;
            @Override
            public int get() {
                return width * height * depth;
            }
        };
        System.out.println(anonymous.get());
    }
}

class Rectangle implements Shape {
    int depth = 40;
    @Override
    public int get() {
        return width * height * depth;
    }
}

interface Shape {
    int width = 10;
    int height = 20;
    int get();
}
