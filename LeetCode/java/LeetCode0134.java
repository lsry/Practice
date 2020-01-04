public class LeetCode0134 {
    // 如果一个数组的总和非负，那么一定可以找到一个起始位置，从他开始绕数组一圈，累加和一直都是非负的
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, tank = 0,sum = 0;
        for (int i = 0;i < gas.length;++i) {
            tank += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return sum >= 0 ? start : -1;
    }
}