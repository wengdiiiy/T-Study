package wendy.algorithm;

/**
 * http://warmz.tistory.com/619
 */
public class BinarySearchTree {
	
	// ���� ��ȸ
    public static void preorder(Node node) {
        if(node == null)
            return;
         
        // �θ� ��� ���
        System.out.print(" " + node.getData());
         
        // ���� ���� Ʈ�� ���
        preorder(node.getLeft());
         
        // ������ ���� Ʈ�� ���
        preorder(node.getRight());
    }
     
    // ���� ��ȸ
    public static void inorder(Node node) {
        if(node == null)
            return;
         
        // ���� ���� Ʈ�� ���
        inorder(node.getLeft());
         
        // �θ� ��� ���
        System.out.print(" " + node.getData());
         
        // ������ ���� Ʈ�� ���
        inorder(node.getRight());
    }
     
    // ���� ��ȸ
    public static void postorder(Node node) {
        if(node == null)
            return;
         
        // ���� ���� Ʈ�� ���
        postorder(node.getLeft());
         
        // ������ ���� Ʈ�� ���
        postorder(node.getRight());
         
        // �θ� ��� ���
        System.out.print(" " + node.getData());
    }
}

class Node {
	private char data;
    private Node left;
    private Node right;
 
    public Node(char data) {
        this.setData(data);
    }
 
    public void setData(char data) {
        this.data = data;
    }
 
    public char getData() {
        return data;
    }
 
    public void setLeft(Node left) {
        this.left = left;
    }
 
    public Node getLeft() {
        return left;
    }
 
    public void setRight(Node right) {
        this.right = right;
    }
 
    public Node getRight() {
        return right;
    }
}
