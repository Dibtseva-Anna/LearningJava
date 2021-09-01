package com.anna.tree;

public class TreeNode implements Node {
    public int value;
    public TreeNode parentNode;
    public TreeNode rightNode;
    public TreeNode leftNode;

    public TreeNode(int value) {
        this.value = value;
    }

    public void add(int number) {
        if (number > value) {
            if(rightNode == null) {
                rightNode = new TreeNode(number);
                rightNode.parentNode = this;
            }
            else
                rightNode.add(number);
        }
        else{
            if(leftNode == null) {
                leftNode = new TreeNode(number);
                leftNode.parentNode = this;
            }
            else
                leftNode.add(number);
        }
    }

    @Override
    public String toString() {
        return toString(0);
    }

    private String toString(int tabulation) {
        StringBuilder tree = new StringBuilder();
        if (rightNode != null){
            tree.append(rightNode.toString(tabulation+1));
        }
        for (int i=0; i < tabulation; i++) {
            tree.append(' ');
        }
        tree.append(value).append('\n');
        if (leftNode != null) {
            tree.append(leftNode.toString(tabulation + 1));
        }
        return tree.toString();
    }


}
