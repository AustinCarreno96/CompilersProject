import java.util.ArrayList;
import java.util.LinkedList;


public class ScopeNode extends ASTNode{
    private ArrayList<ASTNode> children = new ArrayList<>();
    private ArrayList<String> parameters = null;

    ScopeNode(String element) {
        super(element);
    }// end constructor()

    ScopeNode(String element, ArrayList<ASTNode> children) {
        super(element);
        this.children = children;
    }// end constructor

    @Override
    protected String getElement() {
        return element;
    }// end getElement()

    @Override
    protected ASTNode getChild(int index) {
        if (index < children_length() && index >= 0) {
            return children.get(index);
        } else {
            return null;
        }// end if / else
    }// end getChild()

    @Override
    protected void print() {

    }// end print()


    public void add_parameters(ArrayList<String> strings) {
        this.parameters = strings;
    }// end add_parameters()


    public void add_child(ASTNode child) {
        this.children.add(child);
    }// end add_child()

    public int children_length() {
        return children.size();
    }// end children_length()
}// end ScopeNode class
