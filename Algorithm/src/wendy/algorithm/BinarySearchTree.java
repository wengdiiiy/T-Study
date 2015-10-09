package wendy.algorithm;

/**
 * http://warmz.tistory.com/619
 */
public class BinarySearchTree {
	
	// 전위 순회
    public static void preorder(Node node) {
        if(node == null)
            return;
         
        // 부모 노드 출력
        System.out.print(" " + node.getData());
         
        // 왼쪽 하위 트리 출력
        preorder(node.getLeft());
         
        // 오른쪽 하위 트리 출력
        preorder(node.getRight());
    }
     
    // 중위 순회
    public static void inorder(Node node) {
        if(node == null)
            return;
         
        // 왼쪽 하위 트리 출력
        inorder(node.getLeft());
         
        // 부모 노드 출력
        System.out.print(" " + node.getData());
         
        // 오른쪽 하위 트리 출력
        inorder(node.getRight());
    }
     
    // 후위 순회
    public static void postorder(Node node) {
        if(node == null)
            return;
         
        // 왼쪽 하위 트리 출력
        postorder(node.getLeft());
         
        // 오른쪽 하위 트리 출력
        postorder(node.getRight());
         
        // 부모 노드 출력
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
