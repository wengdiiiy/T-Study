package wendy.algorithm;

public class BinaryTreeTest {
	public static void main(String[] args) {
        // 노드 생성
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
         
        // 트리에 노드 추가
        A.setLeft(B);
        B.setLeft(C);
        B.setRight(D);
         
        A.setRight(E);
        E.setLeft(F);
        E.setRight(G);
         
         
        // 출력
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
