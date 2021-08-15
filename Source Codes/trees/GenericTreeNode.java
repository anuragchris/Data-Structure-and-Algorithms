package trees;

public class GenericTreeNode {
    int data;
    GenericTreeNode firstChild;
    GenericTreeNode nextSibling;

    public int getData() {
	return data;
    }

    public void setData(int data) {
	this.data = data;
    }

    public GenericTreeNode getFirstChild() {
	return firstChild;
    }

    public void setFirstChild(GenericTreeNode firstChild) {
	this.firstChild = firstChild;
    }

    public GenericTreeNode getNextSibling() {
	return nextSibling;
    }

    public void setNextSibling(GenericTreeNode nextSibling) {
	this.nextSibling = nextSibling;
    }

}
