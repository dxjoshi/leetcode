
/*
You are given a BST (Binary search tree) with’ N’ number of nodes and a value ‘X’. Your task is to find the greatest value node of the BST which is smaller than or equal to ‘X’.
        Note :‘X’ is not smaller than the smallest node of BST .
*/
class TreeNodeNew<T>
{
    T data;
    TreeNodeNew<T> left;
    TreeNodeNew<T> right;

    TreeNodeNew(T data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

public class FloorBST_CNinja {
    public static int floorInBST(TreeNodeNew<Integer> root, int X) {
        int res = 0;
        while (root != null) {
            if (root.data > X) {
                root = root.left;
            } else {
                res = root.data;
                root = root.right;
            }
        }
        return res;
    }

}
