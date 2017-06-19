/*
    Given the root and two nodes in a Binary Tree. Find the lowest common ancestor
    (LCA) of the two nodes.

    The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

    The node has an extra attribute parent which point to the father of itself. The root's parent is null.
 */

/*
    Example
    For the following binary tree:

      4
     / \
    3   7
       / \
      5   6
    LCA(3, 5) = 4

    LCA(5, 6) = 7

    LCA(6, 7) = 7
 */



public class Solution {
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                           ParentTreeNode A,
                                           ParentTreeNode B) {
        /* Get the path from node A to Root */
        ArrayList<ParentTreeNode> pathA = getPath2Root(A);
        /* Get the path from node A to Root */
        ArrayList<ParentTreeNode> pathB = getPath2Root(B);

        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;

        ParentTreeNode lowestAncestor = null;
        while (indexA >= 0 && indexB >= 0) {
            if (pathA.get(indexA) != pathB.get(indexB)) {
                break;
            }

            lowestAncestor = pathA.get(indexA);
            indexA--;
            indexB--;
        }
        return lowestAncestor;
    }

    private ArrayList<ParentTreeNode> getPath2Root(ParentTreeNode node) {
        ArrayList<ParentTreeNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;       
    }

}

/*
    We can't use the normal sequence because we cannot make sure when they have
    the first common element. If you really want to do it, you could try to make
    it O(n^2) where you should loop though pathA and nested loop the pathB
*/