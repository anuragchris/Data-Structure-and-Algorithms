package linkedList;

public class BruteForceMerge {
public void bruteForceMerge(LinkedList list1, LinkedList list2)
{
	int flag=0;
	//List p=list1.getHead();
	Node q=list2.getHead();
	while(q.getNext()!=null)
	{
		Node p=list1.getHead();
		while(p.getNext()!=null)
		{
			if(p==q)
			{
				flag=1;
				break;
			}
			p=p.getNext();
			
	
		}
		if(p==q)
		{
			flag=1;
			break;
		}
	q=q.getNext();
	}
	if(flag==0)
	{
		Node p=list1.getHead();
		while(p.getNext()!=null)
		{
			if(p==q)
			{
				flag=1;
				break;
			}
			p=p.getNext();
		}
		if(p==q)
		{
			flag=1;
		}
		
	}
	if(flag==0)
	{
		System.out.print("Not Merging");
	}
	else
	{
		System.out.print("Merging at " + q.getData());
	}
}


}
