package leet.leet0605;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] flowerbed1 = {1,0,0,0,1};
        int n1 = 1;
        System.out.println(main.canPlaceFlowersMK2(flowerbed1, n1));

        int[] flowerbed2 = {1,0,0,0,1};
        int n2 = 2;
        System.out.println(main.canPlaceFlowersMK2(flowerbed2, n2));

        int[] flowerbed3 = {1,0,0,0,1,0,0};
        int n3 = 2;
        System.out.println(main.canPlaceFlowersMK2(flowerbed3, n3));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        if(flowerbed.length == 1) return (flowerbed[0] == 0 && n == 1);

        for(int i = 0; i < flowerbed.length; i++) {
            if(i == 0){
                if(flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }else if(i == flowerbed.length - 1) {
                if(flowerbed[i-1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else {
                if(flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            if(n == 0) return true;
        }
        return false;
    }

    public boolean canPlaceFlowersMK2(int[] flowerbed, int n) {
        // エッジケースのため追加していたコードが不要になったので削除

        // 時間複雑度：O(flowerbed.length)
        // １回配列の長さ分を巡回
        // 空間複雑度：O(1)：与えられる配列がいかに大きくなるも、変数の数は増えない
        // inputのflowerbed[]が増えるけど、外部からの入力は含まない
        for(int i = 0; i < flowerbed.length; i++) {
            // 変数名をより明確にする
            boolean leftEmpty = i > 0 ? flowerbed[i-1] == 0 : true;
            boolean currentEmpty = flowerbed[i] == 0;
            boolean rightEmpty = i < flowerbed.length - 1 ? flowerbed[i+1] == 0 : true;

            if(leftEmpty && currentEmpty && rightEmpty) {
                flowerbed[i] = 1;
                n--;
            }
            // 好みによるが、すぐ[return true]しても良い
            if(n == 0) break;
        }
        // なぜならそうすると、ここで明確に[return false]できるから
        return n == 0;
    }
}
