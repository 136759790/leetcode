package com.gre.leetcode.数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 */
public class 两数之和 {
	@Test
	public void test1(){
		int[] arr={1,3,5,7,9,12,16};
		int target = 17;
		int[] result=new int[2];
		Map m = new HashMap();//<value,index>
		for (int i = 0; i < arr.length; i++) {
			int value = arr[i];
			if(m.containsKey(target-value)){
				result[1]=i;
				result[0]=(int) m.get(target-value);
			}else{
				m.put(value, i);
			}
		}
		System.out.println(Arrays.toString(result));
	}

}
