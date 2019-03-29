package com.gre.leetcode;

import java.util.Arrays;
import org.junit.Test;

public class 两个大数字相加 {
	@Test
	public void test() {
		String a="zz999999";
		String b="32";
		/**
		 * 判断合不合法
		 */
		String p="[1-9][0-9]*";
		if(!a.matches(p) || !b.matches(p)) {
			throw new RuntimeException("数字不合法");
		}
		char[] aa = new StringBuilder(a).reverse().toString().toCharArray();
		char[] ba = new StringBuilder(b).reverse().toString().toCharArray();
		int[] result = new int[Math.max(aa.length, ba.length)+1];
		
		int temp =0;
		
		for(int i=0;i<result.length;i++) {
			char ca = '0';
			if(aa.length > i) {
				ca = aa[i];
			}
			char cb = '0';
			if(ba.length > i) {
				cb = ba[i];
			}
			int va = ca-'0';
			int vb = cb-'0';
			int vt = va+vb+temp;
			if(vt >= 10) {
				temp = 1;
				vt = vt -10;
			}
			result[i] = vt;
		}
		System.out.println(Arrays.toString(result));
	}
}
