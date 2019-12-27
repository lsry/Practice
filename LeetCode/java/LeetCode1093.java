public class LeetCode1093 {
    public double[] sampleStats(int[] count) {
        long sum = 0;
        long num = 0;
        int mode = 0;
        int min = 256, max = -1;
        for (int i = 0;i < count.length;++i) {
            if (count[i] > 0) {
                sum += i * count[i];
                num += count[i];
                if (count[i] > count[mode]) {
                    mode = i;
                }
                if (i < min) {
                    min = i;
                }
                if (i > max) {
                    max = i;
                }
            }
        }
        double median = 0;
        if (num % 2 != 0) {
            int n = 0;
            for (int i = 0;i < count.length;++i) {
                if (count[i] > 0) {
                    n += count[i];
                    if (n >= (num / 2 + 1)) {
                        median = i;
                        break;
                    }
                }
            }
        } else {
            int n = 0;
            for (int i = 0;i < count.length;++i) {
                if (count[i] > 0) {
                    n += count[i];
                    if (n < (num / 2)) {
                        continue;
                    } else if (n == num / 2) {
                        int j = i + 1;
                        while (count[j] == 0) {
                            j++;
                        }
                        median = (i + j) / 2.0;
                        break;
                    } else {
                        median = i;
                        break;
                    }
                }
            }
        }
        return new double[]{min,max,sum * 1.0 / num,median,mode};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        LeetCode1093 l93 = new LeetCode1093();
        l93.sampleStats(arr);
    }
}