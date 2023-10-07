import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        String[] arr = new String[s];
        
        for(int i =0; i<s; i++)
            arr[i] = br.readLine();
        
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                    
                }else {
                    return o1.length() - o2.length();
                }
            }
        });
        
        System.out.println(arr[0]);
        for(int i = 1; i<s; i++){
            if(!arr[i].equals(arr[i-1])){
                System.out.println(arr[i]);
            }
        }
    }
}