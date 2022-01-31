import java.io.*;
import java.util.*;
 
class Driver{

static class Node
{
    Node left;
    Node right;
    int data;
};

static Node newNode(int dat)
{
    Node tmp = new Node();
 
    tmp.data = dat;
    tmp.left = null;
    tmp.right = null;
 
    return tmp;
}
 

public static ArrayList<Integer> longestPath(Node root)
{
     

    if(root == null)
    {
        ArrayList<Integer> output = new ArrayList<>();
        return output;
    }
     

    ArrayList<Integer> right = longestPath(root.right);
     
    ArrayList<Integer> left = longestPath(root.left);
     
    if(right.size() < left.size())
    {
        left.add(root.data);
    }
    else
    {
        right.add(root.data);
    }
     
    return (left.size() >
            right.size() ? left :right);
}
 

public static void main(String[] args)
{
    Node root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.left.right.right = newNode(6);
     
    ArrayList<Integer> output = longestPath(root);
    int n = output.size();
     
    System.out.print(output.get(n - 1));
    for(int i = n - 2; i >= 0; i--)
    {
        System.out.print(" -> " + output.get(i));
    }
}
}