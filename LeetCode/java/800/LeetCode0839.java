import java.util.ArrayList;
import java.util.List;

public class LeetCode0839{
    public int numSimilarGroupsError(String[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        List<List<String>> res = new ArrayList<>();
        List<String> one = new ArrayList<>();
        one.add(A[0]);
        res.add(one);
        for (int i = 1;i < A.length;i++) {
            differAndAdd(res,A[i]);
        }
        return res.size();
    }

    // error, 虽然某个字符串可能不和前面分组相似，但是当后面某个字符串加入后，就有可能加入当前某个分组
    private void differAndAdd(List<List<String>> res,String s) {
        boolean flag = true;
        for (int i = 0;i < res.size();i++) {
            boolean flag2 = false;
            List<String> ls = res.get(i);
            for (int j = 0;j < ls.size();j++) {
                if (differNum(ls.get(j), s) == 2) {
                    flag2 = true;
                    ls.add(s);
                    break;
                }
            }
            if (flag2) {
                flag = false;
                break;
            }
        }
        if (flag) {
            List<String> other = new ArrayList<>();
            other.add(s);
            res.add(other);
        }
    }

    private int differNum(String s1,String s2) {
        int num = 0;
        for (int i = 0;i < s1.length();i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                num++;
            }
        }
        return num;
    }

    class UF {
        public int[] ids;
        public int count;
        public int[] weight;

        public UF(int N) {
            count = N;
            ids = new int[N];
            weight = new int[N];
            for (int i = 0;i < N;i++) {
                ids[i] = i;
                weight[i] = 1;
            }
        }

        public int getCount() {
            return count;
        }

        public int find(int i) {
            while (ids[i] != i) {
                i = ids[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int id = find(i);
            int jd = find(j);
            if (id != jd) {
                if (weight[id] < weight[jd]) {
                    ids[id] = jd;
                    weight[jd] += weight[id];
                } else {
                    ids[jd] = id;
                    weight[id] += weight[jd];
                }
                count--;
            }
        }

        public boolean isConnect(int i,int j) {
            return find(i) == find(j);
        }
    }

    public int numSimilarGroups(String[] A) {
        if (A == null || A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return 1;
        }
        // 标记字符串之间的关系
        List<int[]> li = new ArrayList<>();
        for (int i = 1;i < A.length;i++) {
            for (int j = 0;j < i;j++) {
                int res = differNum(A[j], A[i]);
                if (res == 0 || res == 2) {
                    li.add(new int[]{i,j});
                }
            }
        }
        UF uf = new UF(A.length);
        for (int[] ar : li) {
            if (!uf.isConnect(ar[0], ar[1])) {
                uf.union(ar[0], ar[1]);
            }
        }
        return uf.getCount();
    }

    public static void main(String[] args) {
        String[] a = {"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc",
                      "sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"};
    }
}