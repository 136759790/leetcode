package com.gre.leetcode.数组;

import org.junit.Test;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 */
public class 盛最多水的容器 {
	/**
	 * 双指针法，先将指针放于两头，每次移动小的指针向大的指针靠拢更新最大值
	 */
	@Test
	public void test(){
		int[] a={1,8,6,2,5,4,8,3,7};
		int start=0;
		int end = a.length-1;
		int max =0;
		while(start < end){
			int area = Math.min(a[start], a[end]) * (end -start);
			max=Math.max(max, area);
			if(a[start] < a[end]){
				start++;
			}else{
				end--;
			}
		}
		System.out.println(max);
	}
}
