package disjointSets;

public class Implement {
    public static void main(String[] args) {
	// FastUnion fs = new FastUnion();
	// fs.MAKESET(10);
	// System.out.println(fs.FIND(6));
	// fs.UNION(5, 6);
	// fs.printSet();
	// System.out.println(fs.FIND(5));

	UnionBySize us = new UnionBySize();
	us.MAKESET(6);
	us.UNION(1, 2);
	us.printSet();
	us.UNION(0, 2);
	System.out.println();
	us.printSet();
	// System.out.println(us.FIND(4));
    }
}
