public class BinaryTree {

    Node root;

    public void inOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverse(focusNode.leftChild);
            System.out.println(focusNode.term);
            inOrderTraverse(focusNode.rightChild);
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
