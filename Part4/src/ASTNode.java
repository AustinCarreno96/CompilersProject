public abstract class ASTNode {
    //Data Field
    protected final String element;

    //Constructor
    protected ASTNode(String element) {
        this.element = element;
    }

    //Methods
    protected abstract String getElement();

    protected abstract ASTNode getChild(int index);

    protected abstract void print();
}

