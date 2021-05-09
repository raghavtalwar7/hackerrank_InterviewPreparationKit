import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        Map<Character, Integer> count_letter = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(count_letter.containsKey(s.charAt(i))){
                count_letter.put(s.charAt(i), count_letter.get(s.charAt(i))+1);
            }
            else{
                count_letter.put(s.charAt(i), 1);
            }
        }
        Set<Integer> setsize = new HashSet<>();
        if(setsize.size()==1){
            return "YES";
        }
        ArrayList<Integer> value = new ArrayList<>(count_letter.values());
        int max = Collections.max(value);
        int min = Collections.min(value);
        
        int maxc=0, minc=0;
        
        for(int i = 0 ; i < value.size() ; i++){
            if(value.get(i)==max){
                maxc++;
            }
            else if(value.get(i)==min){
                minc++;
            }
        }
        if(min==max){
            return "YES";
        }
        else if(min==1 && minc==1 && minc!=maxc){
            return "YES";
        }
        else if(max-min==1 && (maxc==1||minc==1)){
            return "YES";
        }
        else{
            return "NO";
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
