package com.gt;

import java.util.List;

class Node{
    Node right;
    Node left;
    int data;
    public Node(){};
    public Node(int data){
        this.data = data;
    }
}


public class Tree {
    public List<Node> find (int data,Node treeNode){
        return null;
    }

    public Node deleteNode(Node root, int key) {
        Node current = root;
        Node father=null;

        while(current!=null && current.data!=key  ){
            father = current;
            current = (key > current.data?current.right:current.left);
        }
        if(current == null)
            return root;
        if(current.right != null && current.left!=null){
            Node minCur = current.right;
            Node minFar = current;
            while(minCur.left!=null){
                minFar = minCur;
                minCur = minCur.left;
            }
            current.data = minCur.data;
            current = minCur;
            father = minFar;
        }
        Node child = null;
        if(current.right!=null)
            child = current.right;
        else if(current.left != null)
            child = current.left;
        if(father == null)
            root = child;
        else if(father.left == current)
            father.left=child;
        else
            father.right=child;
        return root;
    }
    public boolean insert(int data,Node treeNode){
        if(treeNode == null){
            treeNode = new Node(data);
            return true;
        }
        Node node = treeNode;
        while (node != null){
            if(node.data >= data){
                if(node.right == null){
                    node.right = new Node(data);
                    return true;
                }else{
                    node = node.right;
                }
            }else{
                if(node.left == null){
                    node.left = new Node(data);
                    return true;
                }else{
                    node = node.left;
                }
            }
        }
        return false;
    }
}
