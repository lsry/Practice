import java.util.ArrayList;
import java.util.List;

public class RadixSort{
    /**
     * 基数排序, 从个位到最高位进行排序
     * @param arr 待排序的数组
     */
    public void radixSort(int[] arr) {
        int digit = maxDigitOfValue(arr);
        for (int i = 0,mod = 10,dev = 1;i < digit;i++,dev *= 10,mod *= 10){
            // 创建桶
            List<List<Integer>> bucket = new ArrayList<>(20);
            for (int ij = 0;ij < 20;ij++){
                List<Integer> li = new ArrayList<>(arr.length/10 + 1);
                bucket.add(li);
            }
            // 按照对应位，将数字放到桶中
            for (int a : arr){
                int pos = (a % mod) / dev;
                bucket.get(pos + 9).add(a);
            }
            // 按照桶的顺序将数字复原到原来数组中
            int count = 0;
            for (List<Integer> li : bucket){
                for (int num : li){
                    arr[count] = num;
                    count ++;
                }
            }
        }
    }

    /**
     * 获得待排序的数组中最大的位数
     */
    private int maxDigitOfValue(int[] arr){
        int maxValue = Math.abs(arr[0]);
        for (int a : arr){
            maxValue = Math.max(Math.abs(a), maxValue);
        }
        if (maxValue == 0){
            return 1;
        }
        int dight = 0;
        for (int temp = maxValue;temp != 0;temp /= 10){
            dight++;
        }
        return dight;
    }
    public static void main(String[] args) {
        RadixSort rs = new RadixSort();
        int[] arr = new int[]{-100,25,67,2,-68904,89,104,267,245,198,0,-456826,2089};
        rs.radixSort(arr);
        for (int a : arr){
            System.out.print(a +  "\t");
        }
    }
}