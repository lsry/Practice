public class MulHash{
    // (√5 - 1)/2         
    private static final double GOLD_NUM = 0.6180339887;
    private static final int SPACE = 1000;

    public static int mulHash(int key){
        int mul = (int)(GOLD_NUM * key);
        double difference = GOLD_NUM *key - mul;
        return (int)(SPACE * difference);
    }

    public static void main(String[] args){
        for (int i = 61;i <= 65;i++){
            System.out.println(mulHash(i));
        }
    }
}