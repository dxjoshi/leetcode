
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
