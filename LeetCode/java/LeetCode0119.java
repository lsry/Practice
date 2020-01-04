import java.util.ArrayList;
import java.util.List;

public class LeetCode0119 {
    // 越界
    public List<Integer> getRow1(int rowIndex) {
        long[] factorials = new long[rowIndex + 1];
        factorials[0] = 1L;
        for (int i = 1;i <= rowIndex;i++){
            factorials[i] = factorials[i - 1] * i;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0;i <= rowIndex;i++){
            int value = (int)(factorials[rowIndex] / (factorials[i] * factorials[rowIndex - i]));
            result.add(value);
        }
        return result;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1;i <= rowIndex;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1;j < result.size();j++){
                temp.add(result.get(j - 1) + result.get(j));
            }
            temp.add(1);
            result = temp;
        }
        return result;
    }
}