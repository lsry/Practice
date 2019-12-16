import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode0970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> li = new HashSet<>();
        List<Integer> xnum = new ArrayList<>();
        xnum.add(1);
        if (x == 0) {
            xnum.add(0);
        }
        List<Integer> ynum = new ArrayList<>();
        ynum.add(1);
        if (y == 0) {
            ynum.add(0);
        }
        for (int i = 1;;i++) {
            int t = (int)Math.pow(x, i);
            if (t <= bound && t > xnum.get(xnum.size() - 1)) {
                xnum.add(t);
            } else {
                break;
            }
        }
        for (int i = 1;;i++) {
            int t = (int)Math.pow(y, i);
            if (t <= bound && t > ynum.get(ynum.size() - 1)) {
                ynum.add(t);
            } else {
                break;
            }
        }
        for (int xn : xnum) {
            for (int yn : ynum) {
                if (xn + yn <= bound) {
                    li.add(xn + yn);
                }
            }
        }
        return new ArrayList<>(li);
    }
}