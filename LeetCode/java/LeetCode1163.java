public class LeetCode1163{
    class Node{
        public int key;
        public int first;
        public int second;

        public Node(int key,int first,int second){
            this.key = key;
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString(){
            return "key : " + key + " first: " + first + " second: " + second;
        }
    }

    private Node[] nodes;

    /**
     * 目标字符串,假设全部为小写英文字符
     */
    private String str;

    /**
     * 目标字符串长度
     */
    private int strLen;

    private int[] getMax(){
        int[] max = new int[2];
        max[0] = nodes[0].first;
        max[1] = nodes[0].second;
        for (Node n : nodes){
            max[0] = Math.max(max[0], n.first);
            max[1] = Math.max(max[1], n.second);
        }
        return max;
    }

    private void baseSort(){  
        int[] max = getMax();
        List<List<Node>> bucket = new ArrayList<>(max[1] + 1);
        for (int i = 0;i < max[1] + 1;i++){
            bucket.add(new ArrayList<>());
        }
        for (int i = 0;i < strLen;i++){
            bucket.get(nodes[i].second).add(nodes[i]);
        }
        int pos = 0;
        for (List<Node> ln : bucket){
            for (Node n : ln){
                nodes[pos] = n;
                pos++;
            }
        }
        // 根据第一关键字排序
        bucket = new ArrayList<>(max[0] + 1);
        for (int i = 0;i < max[0] + 1;i++){
            bucket.add(new ArrayList<>());
        }
        for (int i = 0;i < strLen;i++){
            bucket.get(nodes[i].first).add(nodes[i]);
        }
        pos = 0;
        for (List<Node> ln : bucket){
            for (Node n : ln){
                nodes[pos] = n;
                pos++;
            }
        }
    }

    public void getSuffixArray(){
        baseSort();
        for (int i = 1;i <= strLen;i *= 2){
            // 由 SuffixArray 求 firstRank
            int[] temp = new int[strLen];
            int pos = 0;
            temp[0] = pos;
            for (int j = 1;j < strLen;j++){
                if (nodes[j].first == nodes[j - 1].first && nodes[j].second == nodes[j - 1].second){
                    temp[j] = pos;
                } else {
                    pos++;
                    temp[j] = pos; 
                }
            }
            for (int j = 0;j < strLen;j++){
                nodes[j].first = temp[j];
            }
            Arrays.sort(nodes,(n1,n2) -> {
                return n1.key - n2.key;
            });
            
            // 更新 secondRank
            for (int j = 0;j < strLen;j++){
                nodes[j].second = (j + i < strLen) ? nodes[j + i].first : 0;
            }

            baseSort();
        }
    }


    // 超时
    public String lastSubstringTimes(String s) {
        this.str = s;
        this.strLen = str.length();
        nodes = new Node[strLen];
        for (int i = 0;i < strLen;i++){
            int f = str.charAt(i) - 'a';
            nodes[i] = new Node(i, f, f);
        }
        getSuffixArray();
        return this.str.substring(this.nodes[strLen - 1].key);
    }

    // 最大表示法
    public String lastSubstring(String s) {
        s = s + '.';
        char[] chs = s.toCharArray();
        int len = chs.length;
        int left = 0;
        int right = 1;
        int equal = 0;
        while (left < len && right < len && equal < len){
            char l = chs[(left + equal) % len];
            char r = chs[(right + equal) % len];
            if (l == r){
                equal++;
            } else {
                if (l < r){
                    left = left + equal + 1;
                } else {
                    right = right + equal + 1;
                }       
                if (left == right){
                    right++;
                }
                equal=0;
            } 
            
        }
        int p = Math.min(left, right);
        return s.substring(p,len - 1);
    }
}