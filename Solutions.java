package misc;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class main_misc2 {
	
	
		
		
	
	
	public static void main(String[] args) {
	//(a+b)%k = ((a % k)+(b % k)) % k    || ||
	
	int[] v2 = {-1,-1,-1,5,5,5};
	int[] v1 = {-3,-2,-0,1,2,5,8,9};
	System.out.println(find_magic_index(v1));
	System.out.println(find_magic_index_non_decrescent(v2));
	
	}	
	
	//If the sequence is crescent
	
	private static int find_magic_index(int[] numbers) {
		
		int low = 0;
		int high = numbers.length -1;
		
		while(low <= high) {
			
			int middle_position = (high+low)/2;
			if(middle_position == numbers[middle_position]) {
				return middle_position;
			}
			if(numbers[middle_position] > middle_position) {
				//its impossible for the magic index to be on the right.so search on left
				//ex:if v[4] = 5 --> the index will increase in 1 and the v[i] can increase in 1,2,...
				//so even if v[i] just increase in 1,because v[i] starts bigger than i,v[i] will be allways bigger than i
				//so its impossible to find a magical index in the right
				high = middle_position -1;
			}
			if(numbers[middle_position] < middle_position){
				low = middle_position+1;
			}
			
		}
		return -1;
		
	}
	
	//If the sequence is non-decrescent(ex:1,1,1,1,2)
	//if v[i] > i --> v[i+1],...,v[v[i]-1] cant be the magic index,so "jump".
	//worst case is still O(n) but for a good amount of cases it will amortized,ex of worst case:[-1,1,1,2,2,5]
	
	private static int find_magic_index_non_decrescent(int []numbers){
		
		for(int i = 0;i < numbers.length;i++) {
			if(numbers[i] == i) {
				return i;
			}
			if(numbers[i] > i && numbers[i] < numbers.length) {
				if(numbers[numbers[i]] == numbers[i]){
					return numbers[i];
				}
				i = numbers[i];//jump
			}
		}
		return -1;
	}
	
	
	} 
	
