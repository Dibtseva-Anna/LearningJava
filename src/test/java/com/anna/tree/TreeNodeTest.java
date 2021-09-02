package com.anna.tree;

import org.junit.Assert;
import org.junit.Test;

public class TreeNodeTest {
    @Test
    public void firstNodeCreating() {
        int expected = 5;
        TreeNode node = new TreeNode(expected);
        int actual = node.value;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rightNodeAddingIfNotExist() {
        int firstNodeValue = 5;
        TreeNode firstNode = new TreeNode(firstNodeValue);
        int expected = firstNodeValue + 1;
        firstNode.add(expected);
        int actual = firstNode.rightNode.value;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rightNodeAddingIfExist() {
        int firstNodeValue = 5;
        TreeNode firstNode = new TreeNode(firstNodeValue);
        int rightNodeValue = firstNodeValue + 1;
        firstNode.add(rightNodeValue);
        int expected = rightNodeValue + 1;
        firstNode.add(expected);
        int actual = firstNode.rightNode.rightNode.value;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leftNodeAddingIfNotExist() {
        int firstNodeValue = 5;
        TreeNode firstNode = new TreeNode(firstNodeValue);
        int expected = firstNodeValue - 1;
        firstNode.add(expected);
        int actual = firstNode.leftNode.value;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leftNodeAddingIfExist() {
        int firstNodeValue = 5;
        TreeNode firstNode = new TreeNode(firstNodeValue);
        int leftNodeValue = firstNodeValue - 1;
        firstNode.add(leftNodeValue);
        int expected = leftNodeValue - 1;
        firstNode.add(expected);
        int actual = firstNode.leftNode.leftNode.value;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void newRightNodeHasParentWhenAdded() {
        TreeNode firstNode = new TreeNode(5);
        firstNode.add(6);
        TreeNode actual = firstNode.rightNode.parentNode;
        Assert.assertEquals(firstNode, actual);
    }

    @Test
    public void newLeftNodeHasParentWhenAdded() {
        TreeNode firstNode = new TreeNode(5);
        firstNode.add(3);
        TreeNode actual = firstNode.leftNode.parentNode;
        Assert.assertEquals(firstNode, actual);
    }

    @Test
    public void treeToString() {
        TreeNode tree = new TreeNode(5);
        tree.add(3);
        tree.add(4);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        System.out.println(tree);
    }

    @Test
    public void firstLevelToString() {
        TreeNode tree = new TreeNode(5);
        String expected = "5\n";
        String actual = tree.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void secondLevelToString() {
        TreeNode tree = new TreeNode(5);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        String expected =
                "5\n"
                +"  4\n"
                +" 3\n"
                +"  2\n";
        String actual = tree.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rightValueFinding() {
        TreeNode tree = new TreeNode(5);
        tree.add(3);
        tree.add(4);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        int expected = 10;
        int actual = tree.get(expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void leftValueFinding() {
        TreeNode tree = new TreeNode(5);
        tree.add(3);
        tree.add(4);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        tree.add(8);
        tree.add(9);
        tree.add(10);
        int expected = 2;
        int actual = tree.get(expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rootValueFinding() {
        TreeNode tree = new TreeNode(5);
        tree.add(3);
        tree.add(7);
        int expected = 5;
        int actual = tree.get(expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueFinding() {
        TreeNode tree = new TreeNode(100);
        tree.add(50);
        tree.add(30);
        tree.add(75);
        tree.add(60);
        tree.add(80);
        tree.add(90);
        tree.add(85);
        tree.add(200);
        tree.add(150);
        int expected = 85;
        int actual = tree.get(expected);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueNotExistFinding() {
        TreeNode tree = new TreeNode(100);
        tree.add(50);
        tree.add(30);
        tree.add(75);
        tree.add(60);
        tree.add(80);
        tree.add(90);
        tree.add(85);
        tree.add(200);
        tree.add(150);
        Assert.assertEquals(null, tree.get(87));
        Assert.assertEquals(null, tree.get(83));
    }



}
