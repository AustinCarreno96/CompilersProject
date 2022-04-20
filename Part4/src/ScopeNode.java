import java.util.ArrayList;
import java.util.LinkedList;


public class ScopeNode extends ASTNode{
    private ArrayList<ASTNode> children = new ArrayList<>();
    private final LinkedList<String> parameters = null;

    ScopeNode(String element) {
        super(element);
    }

    ScopeNode(String element, ArrayList<ASTNode> children) {
        super(element);
        this.children = children;
    }

    @Override
    protected String getElement() {
        return element;
    }

    @Override
    protected ASTNode getChild(int index) {
        return null;
    }

    @Override
    protected void print() {

    }
}
