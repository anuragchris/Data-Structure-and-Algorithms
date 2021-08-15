package linkedList;

public class TimeSave {
public void SaveTime(LinkedList list1, LinkedList list2)
{
int p=list1.length();
int q=list2.length();
Node a=list1.getHead();
Node b=list2.getHead();
int diff=0;
int len=0;
if(p>q)
{
	diff=p-q;
	for(int i=0;i<diff;i++) {
		a=a.getNext();	
	}
	len=q;
	
}
else if(p<q)
{
	diff=q-p;
	for(int i=0;i<diff;i++){
		b=b.getNext();	
	}
	len=p;
	
}
else {
	len= p;
}
//else
//{
//	//can be either p or q.
//	diff=p;
//	a=list1.getHead();
//}

int flag=0;

	
for(int i=0; i<len; i++)
{
if(a==b)
{
	System.out.println("Merging at :" + a.getData());
	flag=1;
	break;
	 
}
else {
	a=a.getNext();
	b=b.getNext();
	
}
}

if(flag==0) {
	System.out.println("Not Merging");
}
}
}
