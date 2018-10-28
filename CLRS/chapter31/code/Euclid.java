public class Euclid{
    public static int recur_euclid(int a,int b){
        if (b == 0){
            return a;
        }else {
            return recur_euclid(b, a % b);
        }
    }

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
        System.out.print(a + "\t" + b + "\t");
        for(int x : arr){
            System.out.print(x + "\t");
        }
        System.out.println();
        return arr;
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
        System.out.println("a\tb\td\tx\ty");
        System.out.println(iter_euclid(899, 493));
    }
}