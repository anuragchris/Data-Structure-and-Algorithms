package linkedList;

public class CircularLinkedList {
	Node head;
	public int Length() {
		int length =0;
		Node p=head;
		while(p.getNext()!=head) {
			length++;
			p=p.getNext();
		}	
		length+=1;
		return length;
	}
	public void insertAtEnd(Node data)
	{
		if(head==null) {
			head=data;
			head.setNext(head);
		}
		else {
			Node p=head;
			while(p.getNext()!=head)
			{
				p=p.getNext();
			}
			p=p.getNext();
			Node temp;
			temp=data;
			temp.setNext(p.getNext());
			p.setNext(temp);
		   }
     }
	public void displayCircular()
	{
		Node p=head;
		while(p.getNext()!=head)
		{
			System.out.print(p.getData() + "->");
			p=p.getNext();
		}
		p.getNext();
		System.out.print(p.getData());
	}
	public int elementFromEnd() {
		Node p=head;
		int q;
		int a=Length();
		int n=4;
		int b=a-n+1;
		if(b<0) {
			System.out.print("Enter Valid Number");
				q=0;
		}
		else {
			for(int i=1;i<b;i++)
			{
				p=p.getNext();
			}
			q=p.getData();
			}
		return q;
		}
	public int twoPointerSol() {
		Node p=head;
		Node q=head;
		int a;
		int n=4;
		for(int i=0;i<n-1;i++)
		{
			if(p.getNext()!=null)
			{
				p=p.getNext();
			}
		}
		while(p.getNext()!=head)
		{
			p=p.getNext();
			q=q.getNext();
		}
		 a=q.getData();
		 return a;
		}
	public void loop()
	{
		Node p=head;
		Node q=head;
		while(p!=null || q.getNext()!=null && q!=null)
		{
			p=p.getNext();
			q=q.getNext().getNext();
			if(p==q){
				System.out.print("Loop Detected");
				break;
		}
		}
			
	}
}
