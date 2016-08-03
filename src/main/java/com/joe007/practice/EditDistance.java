package com.joe007.practice;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step. You have the
 * following 3 operations permitted on a word: a) Insert a character b) Delete a
 * character c) Replace a character
 * 
 * @author zhoujie Start Time : 2013/11/06 : 16:37 End Time : 2013/11/06 : 17:23
 * 
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		if (word1 == null || word1.length() == 0) {
			return word2.length();
		}
		if (word2 == null || word2.length() == 0) {
			return word1.length();
		}

		int w1 = word1.length();
		int w2 = word2.length();

		int[][] maxCount = new int[w1+1][w2+1];

		int firsti = -1;
		int firstj = -1;
		int endi = -1;
		int endj = -1;
		boolean access = false;
		
		for (int i = 1; i <= w1; i++) {
			for (int j = 1; j <= w2; j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					if(!access){
						firsti = i-1;
						firstj = j-1;
						access = true;
					}
					endi = i - 1;
					endj = j - 1;
					
					maxCount[i][j] = maxCount[i - 1][j - 1] + 1;
				} else {
					maxCount[i][j] = Math.max(maxCount[i - 1][j],
							maxCount[i][j - 1]);
				}
			}
		}

		int minDistance = 0;
		if(firsti == -1){
			minDistance = Math.max(w1, w2);
		} else {
			System.out.println("firsti:" + firsti + " endi:" + endi +
					           " firstj:" + firstj + " endj:" + endj); 
			minDistance = Math.max(firsti, firstj) + Math.max(endi - firsti + 1 - maxCount[w1][w2],
					endj - firstj + 1 - maxCount[w1][w2]) + Math.max(w1 - endi - 1,	w2 - endj - 1);
		}

		return minDistance;
	}

	public static void main(String[] args) {
		EditDistance instance = new EditDistance();
//		String word1 = "sea";
//		String word2 = "eat";
		
//		String word1 = "a";
//		String word2 = "b";
		
		String word1 = "sea";
		String word2 = "ate";

//		System.out.println("max child str: "
//				+ instance.findMaxChildStr(word1, word2));
		 System.out.println(instance.minDistance(word1, word2));

		// char a= 'b';
		// String teststr = "hello";
		// System.out.println(teststr + a);

	}

}
