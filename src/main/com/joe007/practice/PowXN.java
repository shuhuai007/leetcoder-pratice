package com.joe007.practice;

/**
 * Implement pow(x, n).
 * 
 * @author zhoujie
 * Start Time : 2013/11/05 : 20:00
 * End   Time : 2013/11/05 : 20:36
 * 
 */
public class PowXN {

	public double pow(double x, int n) {
		if(n == 0){
			return 1;
		}
		if(x == 0){
			return 0;
		}
		
		boolean nPosiveSignal = (n > 0)? true : false;
		boolean xPosiveSignal = (x > 0)? true : false;
		
		int nAbs = Math.abs(n);
		double xAbs = Math.abs(x);
		double result = xAbs;
		System.out.println("result:" + result);
		result = powAbs(xAbs, nAbs);
		
		if(!xPosiveSignal && nAbs%2 != 0){
			result = -result;
		}
		if(!nPosiveSignal){
			result = 1.0000000000000000000000000d/result;
		}
		return result;
	}

	private double powAbs(double xAbs, int nAbs) {

		if(nAbs == 0){
			return 1;
		}
		if(nAbs == 1){
			return xAbs;
		}
		
		int childN = nAbs/2;
		int remainder = nAbs%2;
		
		double childResult =  powAbs(xAbs, childN);
		double result = childResult * childResult;
		if(remainder != 0){
			result *= xAbs;
		}
		System.out.println("n:" + nAbs + "; result:" + result);
		return result;
	}

	public static void main(String[] args) {
		PowXN instance = new PowXN();
//		double x = 1.3;
//		int n = 2;
		double x = 0.00001;
		int n = 2147483647;
		System.out.println(instance.pow(x, n));

//		System.out.println(Math.pow(0, 0));
	}

}
