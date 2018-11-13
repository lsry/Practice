public class OpenHash{
    /*
    * 返回探查值的函数
    * @param key 关键字
    * @param index 探查次数
    * @param length 存储容量
    */

    public static int linerProbe(int key,int index,int length){
        return (key + index) % length;
    }

    public static int quadraticProbe(int key,int index,int length){
        return (key + index + 3 * index * index) % length;
    }

    public static int doubleProbe(int key,int index,int length){
        return (key + index * (1 + (key % (length - 1)))) % length;
    }

    public static void main(String[] args) {
        int m = 11;
        int[][] arr= new int[3][m];
        for (int i = 0;i < 3;i++){
            for (int j = 0;j < m;j++){
                arr[i][j] = 0;
            }
        }
        int[] nums = {10 , 22 , 31 , 4 , 15 , 28 , 17 , 88 , 59};
        // liner insert
        System.out.println("LINER PROBE: ");
        for (int key : nums){
            System.out.print("key " + key + " : ");
            for (int i = 0;i < m;i++){
                int pos = linerProbe(key, i, m);                
                System.out.print(" probe " + pos + " , ");
                if (arr[0][pos] == 0) {
                    arr[0][pos] = key;
                    System.out.println(" end");
                    break;
                }
                System.out.print("  ");
            }
        }

        // second probe
        System.out.println("\nSECOND PROBE: ");
        for (int key : nums){
            System.out.print("key " + key + " : ");
            for (int i = 0;i < m;i++){
                int pos = quadraticProbe(key, i, m);
                System.out.print(" probe " + pos + " , ");
                if (arr[1][pos] == 0) {
                    arr[1][pos] = key;
                    System.out.println(" end");
                    break;
                }
                System.out.print("  ");
            }
        }

        // double probe
        System.out.println("\nDOUBLE PROBE: ");
        for (int key : nums){
            System.out.print("key " + key + " : ");
            for (int i = 0;i < m;i++){
                int pos = doubleProbe(key, i, m);
                System.out.print(" probe " + pos + " , ");
                if (arr[2][pos] == 0) {
                    arr[2][pos] = key;
                    System.out.println(" end");
                    break;
                }
                System.out.print("  ");
            }
        }

        System.out.println("result:");
        for (int[] ar : arr) {
            for (int a : ar) {
                System.out.print(a + "  ");
            }
            System.out.println();
        }
    }
}