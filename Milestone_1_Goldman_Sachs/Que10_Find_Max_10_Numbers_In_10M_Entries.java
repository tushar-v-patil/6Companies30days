/*
Que10: Find max 10 numbers in a list having 10M entries.
*/
import java.util.*;
import java.io.*;

public class Template {
    
	static int mod = 1000000007;

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            pq.add(sc.nextInt());
            if(pq.size() > 10){
                pq.poll(); // pop the smallest element
            }
        }
        
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
	}
  
}
