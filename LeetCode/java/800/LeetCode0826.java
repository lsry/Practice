import java.util.Arrays;

public class LeetCode0826{
    class Work implements Comparable<Work>{
        public int difficulty;

        public int profit;

        public Work(int d,int p){
            difficulty = d;
            profit = p;
        }

        @Override
        public int compareTo(Work work) {
            return this.difficulty - work.difficulty;
        }
        
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Work[] works = new Work[difficulty.length + 1];
        works[0] = new Work(0, 0);
        for (int i = 0;i < difficulty.length;i++){
            works[i + 1] = new Work(difficulty[i], profit[i]);
        }
        Arrays.sort(works);
        Arrays.sort(worker);

        int sumProfit = 0;
        int workIndex = 1;
        int maxProfit = 0;
        for (int i = 0;i < worker.length;i++){
            while (workIndex <= difficulty.length && worker[i] >= works[workIndex].difficulty){
                if (maxProfit < works[workIndex].profit){ // 需要记录当前可安排的最大收益的那一份工作
                    maxProfit = works[workIndex].profit;
                }
                workIndex++;
            }
            sumProfit += maxProfit;
        }

        return sumProfit;
    }
}