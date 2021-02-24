package com.iverbs.data.leetcode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return helper(nums, 0, nums.length - 1);
     }
     
     private TreeNode helper(int[] nums, int low, int high) {
         if(low > high) {
             return null;
         }
         
         int mid = low + (high - low)/2;
         //center val of sorted array as the root of the bst
         TreeNode head = new TreeNode(nums[mid]);
         
         //left of the mid value should go to the left of this root node to satisfy bst
         head.left = helper(nums, low, mid - 1);
         //right of the mid value should go to the right of this root node to satisfy bst
         head.right = helper(nums, mid + 1, high);
         return head;
         
     }
     
     public static void main(String [] args) {
         Solution s = new Solution();
       
         TreeNode t = s.sortedArrayToBST(new int [] {-10, -3, 0, 5, 9});
         System.out.println(t);
     }
}
