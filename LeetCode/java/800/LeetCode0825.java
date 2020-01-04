public class LeetCode0825{
    // exceed time limit
    public int numFriendRequestsDoubleIter(int[] ages) {
        int send = 0;
        for (int i = 0;i < ages.length;i++){
            for (int j = i + 1;j < ages.length;j++){
                if (isSend(ages[i], ages[j])){
                    send++;
                }
                if (isSend(ages[j], ages[i])){
                    send++;
                }
            }
        }
        return send;
    }

    public int numFriendRequests(int[] ages){
        int[] counts = new int[121];
        for (int i : ages){
            counts[i]++;
        }
        int send = 0;
        for (int i = 1;i < counts.length;i++){
            for (int j = 1;j < counts.length;j++){
                if(isSend(i, j)){
                    send += counts[i] * counts[j];
                    if (i == j){
                        send -= counts[i];
                    }   
                }       
            }
        }
        return send;
    }

    /**
     * A to B
     */
    public boolean isSend(int Aage,int Bage) {
        return !((Bage <= 0.5 * Aage + 7) || (Bage > Aage) || (Bage > 100 && Aage < 100));
    }

    public static void main(String[] args) {
        int[] ages = new int[]{20,30,100,110,120};
        System.out.println(new LeetCode0825().numFriendRequests(ages));
    }
}