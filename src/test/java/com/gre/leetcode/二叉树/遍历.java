package com.gre.leetcode.二叉树;

import org.junit.Test;
/**
 * 1：满二叉树：所有层都满员了的二叉树
 * 2：完全二叉树，除最后一层外都满员，最后一层存在节点的都在左边，满一定是完全，完全不一定满
 * 3：满二叉树第k层有2的k-1次方个节点
 * 4：满二叉树有2的k次方-1个节点
 * @author Qxq
 *
 */
public class 遍历 {
	
	class Node{
		int value;
		Node left;
		Node right;
	}
	
	/**
	 * 				5
	 * 			   / \
	 * 		      3	  7
	 * 	         / \
	 *          2	4
	 * 
	 */
	Node init(){
		Node root = new Node();
		root.value = 5;
		Node l = new Node();
		l.value =3;
		Node ll = new Node();
		ll.value =2;
		Node lr = new Node();
		lr.value =4;
		Node r = new Node();
		r.value =7;
		root.left = l;
		root.right =r;
		l.left=ll;
		l.right=lr;
		return root;
	}
	/**
	 * 根结点 ---> 左子树 ---> 右子树
	 */
	@Test
	public void 前序遍历(){
		Node root = init();
		print(root);
	}
	void print(Node root){
		if(root!=null){
			System.out.println(root.value);
			print(root.left);
			print(root.right);
		}
	}
	/**
	 * 左子树 ---> 根结点 ---> 右子树
	 */
	@Test
	public void 中序遍历(){
		Node root = init();
		print(root);
	}
	void printMid(Node root){
		if(root!=null){
			printMid(root.left);
			System.out.println(root.value);
			printMid(root.right);
		}
	}
	/**
	 * 左子树 ---> 右子树 ---> 根结点
	 */
	@Test
	public void 后序遍历(){
		Node root = init();
		print(root);
	}
	void printAfter(Node root){
		if(root!=null){
			printAfter(root.left);
			System.out.println(root.value);
			printAfter(root.right);
		}
	}
	
	@Test
	public void 求最大深度(){
		Node root = init();
		System.out.println(getMaxDeep(root));
		System.out.println(getMinDeep(root));
	}
	public int getMaxDeep(Node n){
		if(n==null){
			return 0;
		}
		return Math.max(getMaxDeep(n.left)+1, getMaxDeep(n.right)+1);
	}
	public int getMinDeep(Node n){
		if(n==null){
			return 0;
		}
		return Math.min(getMinDeep(n.left)+1, getMinDeep(n.right)+1);
	}
}
