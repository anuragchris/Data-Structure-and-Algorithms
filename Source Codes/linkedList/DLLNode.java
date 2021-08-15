package linkedList;

public class DLLNode {
	private int data;
	protected DLLNode next;
	protected DLLNode prev;
	public DLLNode(int data) {
		this.data=data;
	}
	public int getData() {
		return data;
	}
	public void setNext(DLLNode next) {
		this.next=next;
	}
	public DLLNode getNext() {
		return this.next;
	}
	public void setPrev(DLLNode prev)
	{
		this.prev=prev;
	}
	public DLLNode getPrev()
	{
		return this.prev;
	}
}
