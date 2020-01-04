import java.util.ArrayList;
import java.util.List;

public class LeetCode0412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1;i <= n;i++){
            boolean three = i % 3 == 0;
            boolean five = i % 5 == 0;
            if (three && five){
                res.add("FizzBuzz");
            } else if (three){
                res.add("Fizz");
            } else if (five){
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}