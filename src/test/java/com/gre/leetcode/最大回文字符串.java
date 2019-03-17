package com.gre.leetcode;


import org.junit.Test;

public class 最大回文字符串 { 

    @Test
	public void test1() {
        String str = "ccabacddddfff";
        System.out.println(m1(str));
        System.out.println(m2(str));
        
	}
    @Test
    public void m3(){
    	String s = "ccabacddddfff";
    	int[] r = new int[s.length()];
    	int max = 0;
    	int id=0;
    	for(int i=1;i<s.length()-1;i++){
    		
    	}
    	System.out.println(prepare(s)); 
    }
    public String m2(String str){
    	int begin = 0;
    	int length = 1;
    	for(int i=0;i<str.length();i++){
    		int before = i-1;
    		int after = i+1;
    		while(before >= 0 && after < str.length() && str.charAt(before) == str.charAt(after)){
    			int len = after - before + 1;
    			if(len > length){
    				length = len;
    				begin = before;
    			}
    			before--;
    			after++;
    		}
    	}
    	for(int i=0;i<str.length();i++){
    		int before = i;
    		int after = i+1;
    		while(before >= 0 && after < str.length() && str.charAt(before) == str.charAt(after)){
    			int len = after - before + 1;
    			if(len > length){
    				length = len;
    				begin = before;
    			}
    			before--;
    			after++;
    		}
    	}
    	return str.substring(begin, length+begin);
    }
    
    //暴力遍历求解，先遍历长度，再遍历这个长度的多少个子串O(n^2)，判断每个子串是否回文O(n),所以总的是O^3
    public String m1(String str){
        if(str.length() <= 1){
            return str;
        }
        for(int i =str.length();i>0;i--){//子串的长度,这个遍历是遍历子串的长度，从大到小（获取最大子串）
            for (int j = 0; j <= str.length()-i; j++) {//有多少个子串
                String sub = str.substring(j, i+j);//子串的位置,j代表从J位置开始，因为从j开始了，所以长度延后j，即i+j
                if(isArm(sub)){
                    return sub;
                }
            }
        }
        return "";
    }
    /**
     * 判断是否是回文字符串
     */
    public Boolean isArm(String str){
        int begin = 0;
        int end = str.length() - 1 ;
        while(begin <= end){
            if(str.charAt(begin) == str.charAt(end)){
                begin++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
    public String prepare(String s){
    	StringBuilder sb = new StringBuilder();
    	sb.append("&");
    	for(int i=0;i<s.length();i++){
    		sb.append("#").append(s.charAt(i));
    	}
    	sb.append("#");
    	return sb.toString();
    }

}
