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

    public Integer get(int number) {
        if (number > value) {
            if (rightNode != null) {
                return rightNode.get(number);
            }
        }
        if (number < value) {
            if (leftNode != null) {
                return leftNode.get(number);
            }
        }
        if (number == value) {
            return value;
        }
        return null;
    }

    public void delete(int number) {
        //such element searching
        TreeNode node = getNode(number);
        if (node == null) {
            return;
        }

        //is leaf
        if (node.parentNode != null && node.rightNode == null && node.leftNode == null) {
            node.leafDeleting();
        }
    }

    private TreeNode getNode(int number) {
        if (number > value) {
            if (rightNode != null) {
                return rightNode.getNode(number);
            }
        }
        else if (number < value) {
            if (leftNode != null) {
                return leftNode.getNode(number);
            }
        }
        else {
            return this;
        }
        return null;
    }

    private void leafDeleting() {
        //removing the parent link to this node
        if (this == parentNode.rightNode) {
            parentNode.rightNode = null;
        }
        else {
            parentNode.leftNode = null;
        }
        //remove parent link
        parentNode = null;
    }
}
