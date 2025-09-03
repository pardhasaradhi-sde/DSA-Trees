class Node{
    int data;
    Node left,right;
    public Node(int data)
    {
        this.data=data;
        left=right=null;
    }
}
public class Trees {
    public static void main(String[] args)
    {
        Node newNode=new Node(10);
        newNode.left=new Node(20);
        newNode.right=new Node(30);
        System.out.println("root node:"+newNode.data);
        System.out.println("root node:"+newNode.left.data);
        System.out.println("root node:"+newNode.right.data);

    }

}
