import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Combinations{
    public static int cnum(int n,int k){
        if(n == k || k == 0){
            return 1;
        } else if (n < k){
            return 0;
        } else {
            return cnum(n - 1,k) + cnum(n-1, k-1);
        }
    }

    public static boolean find(int[] arr,int key){
        for (int a : arr){
            if (a == key){
                return true;
            }
        }
        return false;
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> conbination = new LinkedList<>();
        if (n < k || n <= 0 || k <= 0){
            return conbination;
        }
        int[] arr = new int[k + 1];
        List<Integer> temp = new ArrayList<>(k); 
        for(int i = 1;i < k + 1;i++){
            arr[i] = i;
            temp.add(i);
        }
        conbination.add(temp);
        int num = cnum(n, k);
        for (int i = 2;i <= num;i++){
            temp = new ArrayList<>(k); 
            int[] rs = new int[]{0,0};        
            for (int t = 1; t < k + 1;t++){
                int index = t;
                int elem = arr[t] + 1;
                if (find(arr, elem) || elem > n){
                    continue;
                } 
                if (elem >= rs[1]){
                    rs[0] = index;
                    rs[1] = elem;
                }
            }
            int m = 1;
            int add = arr[rs[0]];
            for (int x = rs[0];x < k + 1;x++){
                arr[x] = add + m;
                m = m + 1;
            }
            for (int y = 1; y < k + 1;y++){
                temp.add(arr[y]);               
            }
            conbination.add(temp);
        }
        return conbination;
    }

    public static void main(String[] args) {
        var list = combine(1,1);
        System.out.println("[");
        for (var ls : list){
            System.out.print("[");
            for (var i : ls){
                System.out.print(i + ", ");
            }
            System.out.print("]\n");
        }
        System.out.println("]");
    }
}