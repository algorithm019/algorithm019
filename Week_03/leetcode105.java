/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        Map<Integer, Integer> map = new HashMap<>(preLen);
        for(int i=0 ; i< inLen; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder,0, preLen-1, map, 0, inLen-1);


    }
    private TreeNode helper(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if(preLeft > preRight || inLeft > inRight) return null;

        int rootVal = preorder[preLeft];
        TreeNode root=new TreeNode(rootVal);
        int pIndex = map.get(rootVal);

        root.left = helper(preorder,preLeft+1, pIndex-inLeft+preLeft, map, inLeft, pIndex-1);
        root.right = helper(preorder,pIndex-inLeft+preLeft+1,preRight,map,pIndex+1, inRight);
        return root;

    }
}