public class SelectProblem{
    public static void main(String[] args) {
        int x1 = 1;
        int x2 = 1298;
        double f = Math.random() / Math.nextDown(1.0);
        int x = (int)(x1 * (1.0 - f) + x2 * f);
        System.out.println("select problem: No." + x);
    }
}