import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> hm1 = new HashMap<>();
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i< queries.size() ; i++){
            int value = queries.get(i).get(1);
            int key = queries.get(i).get(0);
            
            if(key == 1){
                if(hm1.containsKey(value)){
                    hm1.put(value, hm1.get(value)+1);
                }
                else{
                    hm1.put(value, 1);
                }
            }
            else if(key == 2){
                if(hm1.containsKey(value)){
                    if(hm1.get(value)<=1){
                        hm1.remove(value);
                    }
                    else{
                    hm1.put(value, hm1.get(value)-1);
                    }
                }
            }
            else{
                if(value>queries.size()){
                    ans.add(0);
                }
                else{
                    if(hm1.containsValue(value)){
                        ans.add(1);
                    }
                    else{
                        ans.add(0);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> ans = freqQuery(queries);

        for (int i = 0; i < ans.size(); i++) {
            bufferedWriter.write(String.valueOf(ans.get(i)));

            if (i != ans.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
