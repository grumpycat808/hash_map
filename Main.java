package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testData = new int[]{1,0,1,1};
		System.out.println(containsNearbyDuplicate(testData, 1));
	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				ArrayList<Integer> list = map.get(nums[i]);
				list.add(i);
				map.put(nums[i], list);
			} else {
				
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(nums[i], list);
			}
		}
		
		for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			
			ArrayList<Integer> val = entry.getValue();
			
			for (int i = 0; i < val.size() - 1; i++) {
				if(val.get(i + 1) - val.get(i) <= k) {
					return true;
				}
			}
		}
		return false;
        
    }
	
	public static boolean isIsomorphic(String s, String t) {
		if(s.length() != t.length()) return false;
		Map<Character, Character> sMap = new HashMap<Character, Character> ();
		Map<Character, Character> tMap = new HashMap<Character, Character> ();
		
		for (int i = 0; i < s.length(); i++) {
			if(!sMap.containsKey(s.charAt(i))) {
				sMap.put(s.charAt(i), t.charAt(i));
			}
		}
		
		for (int i = 0; i < t.length(); i++) {
			if(!tMap.containsKey(t.charAt(i))) {
				tMap.put(t.charAt(i), s.charAt(i));
			}
		}
		
		for (int i = 0; i < s.length(); i++) {
			Character letter = sMap.get(s.charAt(i));
			if(letter != t.charAt(i)) return false;
		}
		
		for (int i = 0; i < t.length(); i++) {
			Character letter = tMap.get(t.charAt(i));
			if(letter != s.charAt(i)) return false;
		}
		return true;
        
    }
	
	public static boolean wordPattern(String pattern, String s) {
		String[] strArray = s.split(" ");
		if(pattern.length() != strArray.length) return false;
		Map<Character, String> map = new HashMap<Character, String>();
		
		Map<String, Character> wordPatternMap = new HashMap<String, Character>();
		for (int i = 0; i < pattern.length(); i++) {
			if(!map.containsKey(pattern.charAt(i))) {
				map.put(pattern.charAt(i), strArray[i]);
			}
		}
		
		for (int i = 0; i < strArray.length; i++) {
			if(!wordPatternMap.containsKey(strArray[i])) {
				wordPatternMap.put(strArray[i], pattern.charAt(i));
			}
		}
		
		
		for (int i = 0; i < pattern.length(); i++) {
			String word = map.get(pattern.charAt(i));
			if(!word.equalsIgnoreCase(strArray[i])) return false;
		}
		
		for (int i = 0; i < strArray.length; i++) {
			Character patternLetter = wordPatternMap.get(strArray[i]);
			if(patternLetter != pattern.charAt(i)) return false;
		}
		return true;
        
    }

}
