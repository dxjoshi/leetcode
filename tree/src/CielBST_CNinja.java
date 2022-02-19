/*
Ninja is given a binary search tree and an integer. Now he is given a particular key in the tree and returns its ceil value. Can you help Ninja solve the problem?
*/

public class CielBST_CNinja {
    public  static int findCeil(TreeNodeNew<Integer> node, int x) {

        // Initializing ceil value
        int ceil = -1;

        // Traverse till the node is not null
        while (node != null) {

            // If node value equals key then return it
            if (x == node.data) {
                return node.data;
            }

            // Traverse right sub-tree
            if (x > node.data) {

                node = node.right;
            }

            // Traverse left sub-tree
            else {
                ceil = node.data;
                node = node.left;
            }
        }

        // Return the ceil value
        return ceil;

    }

}
