import java.util.HashMap;
import java.util.Map;

public class JewelsStones{
    public static int getJewelStones(String J,String S){
        HashMap<Character,Integer> jewels = new HashMap<>(50);
        for(int i = 0;i < J.length();i++){
            Character ch = J.charAt(i);
            if (!jewels.containsKey(ch) && Character.isLetter(ch)){
                jewels.put(ch, 0);
            }
        }
        for (int i = 0;i < S.length();i++){
            Character ch = S.charAt(i);
            if (jewels.containsKey(ch)){
                jewels.put(ch, jewels.get(ch) + 1);
            }
        }
        int count = 0;
        for (Integer value : jewels.values()){
            count += value;
        }
        return count;
    } 


    public static void main(String[] args) {
        System.out.println(getJewelStones("aAA", "aAAbbbb"));
        System.out.println(getJewelStones("z", "ZZZ")); 
        System.out.println(getJewelStones("Z12", "ZZZ12")); 
        System.out.println(getJewelStones("", "ZZZ12")); 
    }
}