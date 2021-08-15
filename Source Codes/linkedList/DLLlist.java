package linkedList;

public class DLLlist {
DLLNode head;
public int dlllength()
{
	int length=0;
	DLLNode current=head;
	while(current!=null)
	{
		length++;
		current=current.getNext();
	}
	return length;
}
public void insertAtBegin(DLLNode node){
   if(head==null)
   {
	   head=node;
	   head.next=null;
	   head.prev=null;
   }
   else{
	   node.setNext(head);
	   node.prev=null;
   }
	
}
public void printDLL()
{
	DLLNode p=head;
	if(head==null)
	{
		System.out.println("No Nodes");
	}
	else{
	while(p.getNext()!=null)
	{
		System.out.print(p.getData() + " ");
		p=p.getNext();
		
	}
	System.out.print(p.getData() + " ");
	System.out.println();
}
}
public void insertAtEnd(DLLNode node){
	if(head==null)
	{
		head=node;
		head.next=null;
		head.prev=null;
	}
	else{
		DLLNode p=head;
		while(p.getNext()!=null)
		{
			p=p.getNext();
		}
		p.setNext(node);
		}
}
public void insert(DLLNode data, int position)
{
	int p=dlllength();
	if(position<0)
	{
		position=0;
	}
	if(position>p)
	{
		
		position=p;
	}
	if(head==null){
		head=data;
	}
	else if(position==0)
	{
		DLLNode temp=data;
		temp.next=head;
		head=temp;
		temp.prev=null;
		}
	else{
		DLLNode temp=head;
		for(int i=1;i<position;i++)
		{
			temp=temp.getNext();
		}
		DLLNode newnode=data;
		newnode.next=temp.next;
		newnode.prev=temp;
		temp.setNext(newnode);
		}
	DLLNode temp=head;
	temp=temp.getNext();
	temp.prev=null;
	head.next=null;
	head=temp;
}
public void deleteAtEnd()
{
	DLLNode temp=head;
	while(temp.getNext().getNext()!=null)
	{
		temp=temp.getNext();
	}
	temp.prev=null;
	temp.next=null;
}
public void delete(int position)
{
	
}
}



