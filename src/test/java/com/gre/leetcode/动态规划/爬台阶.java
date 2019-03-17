package com.gre.leetcode.动态规划;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 一共n层台阶，每次只能爬一层或者两侧，一共多少种爬法
 * 
 *
 */
public class 爬台阶 {
	@Test
	public void test(){
		System.out.println(m1(10));
		System.out.println(m2(10));
		System.out.println(m3(10));
	}
	/**
	 * 动态规划算法,从下向上计算。
	 * @param n
	 * @return
	 */
	public int m3(Integer n){
		if(n == 1){
			return 1;
		}else if(n == 2){
			return 2;
		}
		int f1 =1;
		int f2 =2;
		int total=0;
		for(int i=3;i<=n;i++){
			total = f1+f2;
			f1=f2;
			f2=total;
		}
		return total;
	}
	/**
	 * 备忘录
	 * 共7层的时候，之前的f(1,2,3,4...)都重复计算了
	 */
	public int m2(Integer n){
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		Integer total =0;
		if(n == 1){
			total = 1;
		}else if(n == 2){
			total = 2;
		}else{
			if(m.containsKey(n)){
				total = m.get(n);
			}else{
				total = m1(n-1)+m1(n-2);
				m.put(n, total);
			}
		}
		
		return total;
	}
	/**
	 * 第一种解法递归
	 * 假设一共10层，假设爬到i层的方法为f(i),那么第10层的爬法：f(10)=f(9)+f(8),每次只能爬1\2层。
	 * f(1)=1(只能选择爬一层),f(2)=2（爬一层两次或者爬一次两层）
	 * @param n
	 * @return
	 */
	public int m1(int n){
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		return m1(n-1)+m1(n-2);
	}
}
