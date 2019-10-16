public class LeetCode0605{
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int plants = 0;
        for (int i = 0;i < flowerbed.length;i++){
            if (flowerbed[i] == 0 && 
            (i - 1 < 0 || flowerbed[i - 1] == 0) && 
            (i + 1 >= flowerbed.length || flowerbed[i + 1] == 0)){
                plants++;
                flowerbed[i] = 1;
            }
        }
        return plants >= n;
    }
}