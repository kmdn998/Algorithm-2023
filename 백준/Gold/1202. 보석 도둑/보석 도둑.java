import java.io.*;
import java.util.*;

class Jewels implements Comparable<Jewels> {
	int weight;
	int price;

	public Jewels(int w, int p) {
		weight = w;
		price = p;
	}

	@Override
	public int compareTo(Jewels others) {
		return this.weight - others.weight;
	}
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int jewelCount = Integer.parseInt(st.nextToken());
        int bagCount = Integer.parseInt(st.nextToken());
 
        List<Jewels> jewel = new ArrayList<>();
	
		for(int i=0; i<jewelCount; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			jewel.add(new Jewels(weight,price));
		}
	
		int[] bagWeight = new int[bagCount];
	
		for(int i=0; i<bagCount; i++) {
			bagWeight[i] = Integer.parseInt(br.readLine());
		}
			
		Arrays.sort(bagWeight);
		Collections.sort(jewel);
			
		Queue<Integer> pq = new PriorityQueue<>((o1,o2) -> (o2-o1));
		
		long totalPrice = 0;
		int j=0;
	        
		for(int i=0; i<bagCount; i++) {
			while(true) {
				if(j>=jewelCount) break;
				Jewels jew = jewel.get(j);
					
				if(bagWeight[i] < jewel.get(j).weight) break;
				pq.add(jew.price);
				j++;
			}
			if(!pq.isEmpty())
				totalPrice += Math.abs(pq.poll());
		}
		System.out.println(totalPrice);
		
	    br.close();
	}
}