import java.util.ArrayList;
import java.util.List;

public class Solution {

    //Definition for a binary tree node.
    public static class TreeNode {
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

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> listRight = new ArrayList<>();
        TreeNode traveler = root;

        if(root == null) return list;

        do {
            if(listRight.size() > 0) {
                listRight.remove(listRight.size() - 1);
            }
            //System.out.println("travel value: " + traveler.val);
            while(traveler.left != null) {

                list.add(traveler.val);
                if (traveler.right != null) {
                    listRight.add(traveler.right);
                }
                traveler = traveler.left;
            }

            if(traveler.right != null) {
                //System.out.println("travel right not null");
                listRight.add(traveler.right);
            }

            list.add(traveler.val);

            if (listRight.size() > 0) {
                //System.out.println("lastRight : " + listRight.get(listRight.size() - 1).val);
                traveler = listRight.get(listRight.size() - 1);
            }
        } while (listRight.size() > 0);

        return list;
    }

    // Binary Tree Inorder Traversal
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);

        return list;
    }

    public static void helper(TreeNode root, List<Integer> list) {
        if(root != null) {
            if(root.left != null) {
                helper(root.left, list);
            }
            list.add(root.val);
            if(root.right != null) {
                helper(root.right, list);
            }
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postHelper(root, list);
        return list;
    }

    // Desired output: ACEDBHIGF aka 1,3,5,4,2,8,9,7,6
    public static void postHelper(TreeNode root, List<Integer> list) {
        if(root != null) {
            if(root.left != null) {
                helper(root.left, list);
                if(root.right != null) {
                    helper(root.right, list);
                }
            }
            list.add(root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, null);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);

        //System.out.println(preorderTraversal(treeNode1));
        //System.out.println(inorderTraversal(treeNode1));    // Desired output: 1,3,2
        System.out.println(postorderTraversal(treeNode1));    // Desired output: 3,2,1

        TreeNode treeNodeC = new TreeNode(3);
        TreeNode treeNodeE = new TreeNode(5);
        TreeNode treeNodeH = new TreeNode(8);

        TreeNode treeNodeA = new TreeNode(1);
        TreeNode treeNodeD = new TreeNode(4, treeNodeC,treeNodeE);
        TreeNode treeNodeI = new TreeNode(9, treeNodeH, null);

        TreeNode treeNodeB = new TreeNode(2, treeNodeA, treeNodeD);
        TreeNode treeNodeG = new TreeNode(7, null, treeNodeI);

        TreeNode treeNodeF = new TreeNode(6, treeNodeB, treeNodeG);

        /*System.out.println(preorderTraversal(treeNodeF)); // Desired output: FBADCEGIH aka 6,2,1,4,3,5,7,9,8
        System.out.println(preorderTraversal(new TreeNode()));*/

        /*System.out.println(inorderTraversal(treeNodeF));
        System.out.println(inorderTraversal(new TreeNode()));*/
        System.out.println(postorderTraversal(treeNodeF));  // Desired output: ACEDBHIGF aka 1,3,5,4,2,8,9,7,6
        System.out.println(postorderTraversal(new TreeNode()));

    }
}
