package stacks;

public class TowerOfHanoi {
    public static void main(String args[]) throws Exception {

	UsingArrays s1 = new UsingArrays();
	UsingArrays s2 = new UsingArrays();
	UsingArrays s3 = new UsingArrays();
	try {
	    s1.push(3);
	    s1.push(2);
	    s1.push(1);

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
	int y = s1.displayTop();
	s1.pop();
	s2.push(y);
	int z = s1.displayTop();
	s3.push(z);
	s1.pop();
	s3.push(s2.displayTop());
	s2.pop();
	s2.push(s1.displayTop());
	s1.pop();
	s1.push(s3.displayTop());
	s3.pop();
	s2.push(s3.displayTop());
	s3.pop();
	s2.push(s1.displayTop());
	System.out.println(s2.display());

    }
}
