import java.security.KeyStore;

public class BNode extends ASTNode {
    // Children nodes of current node
    private final BNode left_child;
    private final BNode right_child;

    BNode(String element) {
        super(element);
        left_child = null;
        right_child = null;
    }

    BNode(String element, BNode left_child, BNode right_child) {
        super(element);
        this.left_child = left_child;
        this.right_child = right_child;
    }


    protected String getElement() {
        return element;
    }


    protected ASTNode getChild(int index) {
        if (index == 0) {
            return getLeftChild();
        } else if (index == 1) {
            return getRightChild();
        } else {
        return null;
        }
    }

    protected void print() {

    }

    public void print(BNode bn) {
        System.out.println("Element: " + bn.getElement());
        if (!bn.isLeaf()) {
            System.out.println("Left Node of " + bn.getElement());
            assert bn.left_child != null;
            print(bn.left_child);
            System.out.println("Right Node of " + bn.getElement());
            assert bn.right_child != null;
            print(bn.right_child);
        }
    }


    public BNode getLeftChild() {
        return left_child;
    }

    public BNode getRightChild() {
        return right_child;
    }

    public boolean isLeaf() {
        return getLeftChild() == null && getRightChild() == null;
    }
}

