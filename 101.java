// My first idea was encode the tree in a String by doing some traversal
// and then check if the string is a palindrome. Turns out that we have to
// encode not only the contents of the nodes, but also the structure.
// The idea is nice and simple, but the implementation turns out to be not
// that neat. I guess, there are much better approaches.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    
    public boolean isSymmetric(TreeNode root) {
        
        // Imagine I write as a string a two-digit integer. It will be read and
        // compared to one that is written "backwards". I have to use ArrayList...
        ArrayList<Integer> content = new ArrayList<Integer>();
        StringBuilder structure = new StringBuilder();
        
        if (root != null)
            inOrderTraversal(root, 'X', content, structure);
        
        return (isPalindrome(content) && isAntiSymmetric(structure.toString()));
    }
    
    private void inOrderTraversal(TreeNode x, char pos,
            ArrayList<Integer> content, StringBuilder structure) {
        
        if (x == null) {
            structure.append(pos);
            return;
        }
        
        inOrderTraversal(x.left, LEFT, content, structure);
        content.add(x.val);
        structure.append(pos);
        inOrderTraversal(x.right, RIGHT, content, structure);
    }    
    
    private static boolean isPalindrome(ArrayList<Integer> array) {
        
        for (int left = 0, right = array.size()-1; left < right; left++, right--)
            if (array.get(left) != array.get(right))
                return false;
                
        return true;
    }
    
    private static boolean isAntiSymmetric(String s) {
        
        for (int left = 0, right = s.length()-1; left < right; left++, right--)
            if (s.charAt(left) == s.charAt(right))
                return false;
                
        return true;
    }
}