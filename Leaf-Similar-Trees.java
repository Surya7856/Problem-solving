//https://leetcode.com/problems/leaf-similar-trees/?envType=daily-question&envId=2024-01-09
class Solution {
    //function to traverse the tree and add the leaf node to list
    void fun(TreeNode root,ArrayList<Integer> tree){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            tree.add(root.val);
            return;
        }
        fun(root.left,tree);
        fun(root.right,tree);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> tree1=new ArrayList<>();
        ArrayList<Integer> tree2=new ArrayList<>();
        fun(root1,tree1);
        fun(root2,tree2);
        //checks whether the leafs are similar or not
        return tree1.equals(tree2);
    }
}
