import java.util.ArrayList;
import java.util.List;

public class LeetCode0678 {
    public boolean checkValidString(String s) {
        int star = 0;
        List<Integer> li = new ArrayList<>();  // 左括号后面的 '*' 个数
        for (char c : s.toCharArray()) {
            if (c == '*') {
                star++;
                if (!li.isEmpty()) {
                    add(li,1);
                }
            } else if (c == '(') {
                li.add(0);
            } else {
                if (!li.isEmpty()) {
                    li.remove(li.size() - 1);
                } else if (star != 0) {
                    star--;
                    if (!li.isEmpty()) {
                        add(li,-1);
                    }
                } else {
                    return false;
                }
            }
        }
        while (!li.isEmpty()) {
            if (li.get(li.size() - 1) > 0) {
                li.remove(li.size() - 1);
                add(li, -1);
            } else {
                return false;
            }
        }
        return true;
    }

    private void add(List<Integer> li,int x) {
        for (int i = 0;i < li.size();i++) {
            li.set(i, li.get(i) + x);
        }
    }

    public static void main(String[] args) {
        LeetCode0678 ls = new LeetCode0678();
        System.out.println(ls.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*") == false);
        System.out.println(ls.checkValidString("((*)") == true);
    }
}