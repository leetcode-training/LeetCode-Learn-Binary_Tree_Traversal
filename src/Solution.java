import java.util.ArrayList;
import java.util.List;

public class Solution {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<Integer> listRight = new ArrayList<>();
        TreeNode traveler = root;
        //TreeNode parent = null;
        int childCount = 0;

        while(traveler.left != null) {
            list.add(traveler.val);
            listRight.add(traveler.right.val);
            traveler = traveler.left;
        }

        for(int i=0; i<listRight.size(); i++){
            list.add(listRight.get(i));
        }

        return list;
    }
}
