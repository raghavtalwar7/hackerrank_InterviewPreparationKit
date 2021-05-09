import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'whatFlavors' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY cost
     *  2. INTEGER money
     */

    public static void whatFlavors(List<Integer> cost, int money) {
        
        Map<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < cost.size() ; i++){
            if(cost.get(i)<money){
                if(hm.containsKey(money-cost.get(i))){
                    System.out.println((hm.get(money-cost.get(i))+1)+" "+(i+1));
                }
                if(!hm.containsKey(cost.get(i))){
                    hm.put(cost.get(i), i);
                }
            }
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int money = Integer.parseInt(bufferedReader.readLine().trim());

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] costTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> cost = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costTemp[i]);
                cost.add(costItem);
            }

            Result.whatFlavors(cost, money);
        }

        bufferedReader.close();
    }
}
