package wendy.algorithm;

public class BinaryTreeTest {
	public static void main(String[] args) {
        // ��� ����
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
         
        // Ʈ���� ��� �߰�
        A.setLeft(B);
        B.setLeft(C);
        B.setRight(D);
         
        A.setRight(E);
        E.setLeft(F);
        E.setRight(G);
         
         
        // ���
        System.out.println("Preorder");
        BinarySearchTree.preorder(A);
        System.out.println("\n");
 
        System.out.println("Inorder");
        BinarySearchTree.inorder(A);
        System.out.println("\n");
         
        System.out.println("Postorder");
        BinarySearchTree.postorder(A);
    }
}
