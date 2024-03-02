public class BinaryTree {

    Node root;


    Node search(Node root, String term) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.term == term)
            return root;

        // Key is greater than root's key
        if (root.term.compareTo(term) < 0)
            return search(root.rightChild, term);

        // Key is smaller than root's key
        return search(root.leftChild, term);
    }

    public void inOrderTraverse(boolean found, Node root, String term) {

        if (root != null && !found) {
            inOrderTraverse(false, root.leftChild, term);
            if (root.term.equals(term)) {
                found = true;
                System.out.println("Statement found: " + root.statement + " (Confidence Level: " + root.confidence + ")");
            }
            inOrderTraverse(false, root.rightChild, term);
        }
        else {
            System.out.println("Nawt");
        }
    }

    public void addNode(String term, String statement, Double confidence) {
        Node newNode = new Node(term, statement, confidence);

        if (root == null) {
            root = newNode;

        }
        else {
            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;

                if (term.compareTo(focusNode.term) == -1) {

                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
}

class Node {

    String term;
    String statement;

    Double confidence;
    Node leftChild;
    Node rightChild;

    Node(String term, String statement, Double confidence) {
        this.term = term;
        this.statement = statement;
        this.confidence = confidence;

    }
}
