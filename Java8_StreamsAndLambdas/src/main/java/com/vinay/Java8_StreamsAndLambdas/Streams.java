package com.vinay.Java8_StreamsAndLambdas;

import java.util.stream.Collectors;
import java.util.*;

@FunctionalInterface
interface PalindromePredicate {
    boolean check(String s);
}


class PalindromePredicateChecker {
	
	public static boolean isPalindrome(String s) {
		
		String reverse = new StringBuffer(s).reverse().toString(); 
		if (s.equals(reverse)) 
			return true;
		return false;
	}
}
public class Streams {
	public List<String> search(List<String> list) {

		return list.stream()
				  .filter(s -> s.startsWith("a"))
				  .filter(s -> s.length() == 3)
				  .collect(Collectors.toList());
	}
	
	public Double calculateAverage(List<Integer> list) {
		 return list
		 .stream()
		 .mapToDouble(i -> (double)i)
		 .average()
		 .getAsDouble();
		}
	
	
	public static boolean palindromicCheck(PalindromePredicate p,String s)	{
		
		return p.check(s);
		
	}
	
	public List<String> getPalindromesList(List<String> list){
		
		List<String> result = new ArrayList<String>();
		for(String s : list) {
			if(Streams.palindromicCheck(PalindromePredicateChecker::isPalindrome, s))
				result.add(s);
		}
		
		return result;
	}
	

	public static void main(String[] args) {
		
		Streams demo = new Streams();
		
		List<String> list1 = Arrays.asList("abc","abcd","ant","bat","axe","ave","eve");
		System.out.println(demo.search(list1));
		
		List<Integer> list2 = Arrays.asList(10,20,30,40,50);
		System.out.println(demo.calculateAverage(list2));
		
		List<String> list3 = Arrays.asList("madam","hello","malayalam","civic","radar","rider");
		System.out.println(demo.getPalindromesList(list3));
	}
}
