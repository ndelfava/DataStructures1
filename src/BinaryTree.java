public class BinaryTree {

    Node root;


    public void inOrderTraverse(Node current) {

        if (current != null) {
            inOrderTraverse(current.leftChild);
            System.out.println(current.term);
            inOrderTraverse(current.rightChild);
        }
    }

    public Node search(Node root, String t) {
        if (root == null) return null;
        if (root.term.equals(t)) return root;

        if (t.compareTo(root.term) < 0) {
            return search(root.leftChild, t);
        }
        else {
            return search(root.rightChild, t);
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

                if (term.compareTo(focusNode.term) < 0) {

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
