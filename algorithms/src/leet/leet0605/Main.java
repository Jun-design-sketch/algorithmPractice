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
        if(n == 0) return true;
        if(flowerbed.length == 1) return (flowerbed[0] == 0 && n == 1);

        for(int i = 0; i < flowerbed.length; i++) {
            boolean zero = i > 0 ? flowerbed[i-1] == 0 : true;
            boolean first = flowerbed[i] == 0;
            boolean second = i < flowerbed.length - 1 ? flowerbed[i+1] == 0 : true;

            if(zero && first && second) {
                flowerbed[i] = 1;
                n--;
            }
            if(n == 0) break;
        }

        return n == 0;
    }
}
