public class UnionFind{
    private int count;
    private int[] ids;
    private int[] weights;

    public UnionFind(int N) {
        count = N + 1;
        ids = new int[N + 1];
        weights = new int[N + 1];
        for (int i = 0;i <= N;i++) {
            ids[i] = i;
            weights[i] = 1;
        }
    }

    public int getCount() {
        return count;
    }

    /**
     * quick-find
     */

    public int qf_find(int i) {
        return ids[i];
    }

    public void qf_union(int p,int q) {
        int pid = qf_find(p);
        int qid = qf_find(q);
        // 暴力标记 [p] 中每一个分量
        for (int i = 0;i < ids.length;i++) {
            if (qf_find(i) == pid) {
                ids[i] = qid;
            }
        }
        count--;
    }

    public boolean qf_connected(int p,int q) {
        return qf_find(p) == qf_find(q);
    }

    /**
     * quick-union
     */

    public int qu_find(int i) {
        while (i != ids[i]) {
            i = ids[i];
        }
        return i;
    }

    public void qu_union(int p,int q) {
        int pid = qu_find(p);
        int qid = qu_find(q);
        if (pid != qid) {
            ids[qid] = pid;
            count--;
        }
    }

    public boolean qu_connected(int p,int q) {
        return qu_find(p) == qu_find(q);
    }

    /** 
     * weight union find
     */

    public int weight_find(int i) {
        while (i != ids[i]) {
            i = ids[i];
        }
        return i;
    }

    public void weight_union(int p,int q) {
        int pid = weight_find(p);
        int qid = weight_find(q);
        if (pid != qid) {
            if (weights[p] < weights[q]) {
                ids[pid] = qid;
                weights[q] += weights[p];
            } else {
                ids[qid] = pid;
                weights[p] += weights[q];
            }
            count--;
        }
    }

    public boolean weight_connected(int p,int q) {
        return weight_find(p) == weight_find(q);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{2,3},{1,0},{0,4},{5,7},{6,2}};
        UnionFind qf = new UnionFind(7);
        for (int i = 0;i < arr.length;i++) {
            if (!qf.qf_connected(arr[i][0], arr[i][1])) {
                qf.qf_union(arr[i][0], arr[i][1]);
            }
        }
        System.out.println("separate num: " + qf.getCount());
        UnionFind qu= new UnionFind(7);
        for (int i = 0;i < arr.length;i++) {
            if (!qu.qu_connected(arr[i][0], arr[i][1])) {
                qu.qu_union(arr[i][0], arr[i][1]);
            }
        }
        System.out.println("separate num: " + qu.getCount());
        UnionFind qw = new UnionFind(7);
        for (int i = 0;i < arr.length;i++) {
            if (!qw.weight_connected(arr[i][0], arr[i][1])) {
                qw.weight_union(arr[i][0], arr[i][1]);
            }
        }
        System.out.println("separate num: " + qw.getCount());
    }
}