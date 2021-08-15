package trees;

public class GenericTreeOperations {
    public int findSum(GenericTreeNode root) {
	if (root == null) {
	    return 0;
	}
	return root.getData() + findSum(root.getFirstChild()) + findSum(root.getNextSibling());
    }

    public int depthFromParentArray(int[] p) {
	int maxDepth = 1, currentDepth = -1, j;
	for (int i = 0; i < p.length; i++) {
	    currentDepth = 0;
	    j = i;
	    while (p[j] != -1) {
		currentDepth++;
		j = p[j];
	    }
	    if (currentDepth > maxDepth) {
		maxDepth = currentDepth;
	    }
	}
	return maxDepth;
    }

    public int numberOfSiblings(GenericTreeNode current) {
	int siblings = 0;
	while (current.getNextSibling() != null) {
	    siblings += 1;
	    current = current.getNextSibling();
	}
	siblings += 1;
	return siblings;
    }

    public int countChild(GenericTreeNode current) {
	int count = 0;
	if (current == null) {
	    return 0;
	}
	current = current.getFirstChild();
	while (current != null) {
	    count += 1;
	    current = current.getNextSibling();
	}
	return count;
    }

}
