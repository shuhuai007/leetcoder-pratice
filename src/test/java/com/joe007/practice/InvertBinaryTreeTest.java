package com.joe007.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link InvertBinaryTree}.
 */
public class InvertBinaryTreeTest {

    private InvertBinaryTree instance;

    @Before
    public void before() {
        this.instance = new InvertBinaryTree();
    }

    @Test
    public void invertTreeTest() {
        TreeNode treeNode = new TreeNode(4);
        TreeNode secLayerLeft = new TreeNode(2);
        TreeNode secLayerRight = new TreeNode(7);
        TreeNode thirdLayerLeft = new TreeNode(1);
        TreeNode thirdLayerRight = new TreeNode(3);
        TreeNode invertedTree = instance.invertTree(treeNode);
        Assert.assertNotNull(invertedTree);


    }

}
