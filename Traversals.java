import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeTraversalsIterative{
    // Inorder traversal (iterative): Left -> Root -> Right
    public void inorder(Node root) {
        Stack<Node> s1=new Stack<>();
        if(root==null)
        {
            return;
        }
        Node curr=root;
        while(curr!=null || !s1.isEmpty())
        {
            while(curr!=null) // go left as far as possible
            {
                s1.push(curr);
                curr=curr.left;
            }
            curr=s1.pop(); // process node
            System.out.print(curr.data+" ");
            curr=curr.right; // then go right
        }
    }

    // Preorder traversal (iterative): Root -> Left -> Right
    public void preorder(Node root) {
        Stack<Node> s1=new Stack<>();
        if(root==null)
        {
            return;
        }
        s1.push(root);
        while(!s1.isEmpty())
        {
            Node ele=s1.pop(); // process node
            System.out.print(ele.data+" ");
            if(ele.right!=null) // push right first so left is processed first
            {
                s1.push(ele.right);
            }
            if(ele.left!=null)
            {
                s1.push(ele.left);
            }
        }
    }

    // Postorder traversal (iterative using 2 stacks): Left -> Right -> Root
    public void postorder(Node root) {
        Stack<Node> trav=new Stack<>();
        Stack<Node> reverse=new Stack<>();
        if(root==null)
        {
            return;
        }
        trav.push(root);
        while(!trav.isEmpty())
        {
            Node ele=trav.pop();
            reverse.add(ele);
            if(ele.left!=null)
            {
                trav.push(ele.left);
            }
            if(ele.right!=null)
            {
                trav.push(ele.right);
            }
        }
        while(!reverse.isEmpty())
        {
            System.out.print(reverse.pop().data+" ");
        }
    }

    // Level order traversal (BFS): process level by level using queue
    public void levelorder(Node root) {
        Queue<Node> q1 = new LinkedList<>();
        if (root == null) {
            return;
        }
        q1.offer(root);
        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                Node ele = q1.poll();
                System.out.print(ele.data + " ");
                if (ele.left != null) {
                    q1.offer(ele.left);
                }
                if (ele.right != null) {
                    q1.offer(ele.right);
                }
            }
        }
    }
}

class TreeTraversalsRecursive {
    // Inorder traversal (recursive): Left -> Root -> Right
    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // Preorder traversal (recursive): Root -> Left -> Right
    public void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder traversal (recursive): Left -> Right -> Root
    public void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    // Level order traversal (recursive BFS via queue)
    public void levelorder(Node root) {
        Queue<Node> q1 = new LinkedList<>();
        if (root == null) {
            return;
        }
        q1.offer(root);
        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                Node ele = q1.poll();
                System.out.print(ele.data+" ");
                if (ele.left != null) {
                    q1.offer(ele.left);
                }
                if (ele.right != null) {
                    q1.offer(ele.right);
                }
            }
        }
    }
}

public class Traversals {
    public static void main(String[] args) {
        // Example tree:
        //           10
        //         /    \
        //       20      30
        //      /  \    /
        //    40   50  60

        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);

        TreeTraversalsRecursive l1 = new TreeTraversalsRecursive();
        System.out.println("inorder :");
        l1.inorder(root);
        System.out.println();

        System.out.println("preorder :");
        l1.preorder(root);
        System.out.println();

        System.out.println("postorder :");
        l1.postorder(root);
        System.out.println();

        System.out.println("levelorder :");
        l1.levelorder(root);
        System.out.println();

        TreeTraversalsIterative t1 = new TreeTraversalsIterative();
        System.out.println("inorder iterative :");
        t1.inorder(root);
        System.out.println();

        System.out.println("preorder iterative :");
        t1.preorder(root);
        System.out.println();

        System.out.println("postorder iterative :");
        t1.postorder(root);
        System.out.println();

        System.out.println("levelorder iterative :");
        t1.levelorder(root);
        System.out.println();
    }
}
