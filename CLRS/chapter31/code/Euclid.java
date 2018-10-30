public class Euclid{
    public static int recur_euclid(int a,int b){
        if (b == 0){
            return a;
        }else {
            return recur_euclid(b, a % b);
        }
    }

    /*
    * 递归方法解出d = gcd(a , b), 
    * 满足ax' + by' = d 的所有整数解 x' , y'
    * @return arr : d = arr[0] , x' = arr[1] , y' = arr[2]
    */
    public static int[] recur_extend_euclid(int a,int b){
        int[] arr;
        if (b == 0){
            arr = new int[]{a,1,0};
        }else {
            arr = recur_extend_euclid(b , a % b);
            int temp = arr[1] - (a/b)*arr[2];
            arr[1] = arr[2];
            arr[2] = temp;   
        }
        return arr;
    }

    /*
    * 求解模线性方程 ax = b (mod n)
    */
    public static void modular_linear_equation(int a,int b,int n){
        int[] arr = recur_extend_euclid(a, n);
        if (b % arr[0] == 0){
            int x0 = (arr[1] * (b / arr[0])) % (n / arr[0]);
            for (int i = 0;i < arr[0];i++){
                System.out.print(((x0 + i * (n / arr[0])) % n) + "\t");
            }
            System.out.println();
        }else {
            System.out.println("no solutions");
        }
    }

    public static int iter_euclid(int a,int b){
        int temp = a;
        while(b != 0){
            int x = a % b;
            temp = b;
            b = x;
        }
        return temp;
    }

    public static void main(String[] args){
        modular_linear_equation(3, 6, 9);
        modular_linear_equation(1, 2, 9);

        modular_linear_equation(2, 3, 7);
        modular_linear_equation(4, 6, 7);
    }
}