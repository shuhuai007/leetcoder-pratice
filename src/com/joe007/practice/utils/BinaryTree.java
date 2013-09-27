package com.joe007.practice.utils;

public class BinaryTree<E> {
    public static class TreeNode {
        Object data;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(Object data) {
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right, TreeNode parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public Object getValue(){
           return data; 
        }

        public boolean isLeaf(){
            return (this.left == null && this.right == null);
        }

        public boolean hasLeaf(){
            return this.left != null;
        }

        public boolean hasRight(){
            return this.right != null;
        }

        public boolean hasParent(){
            return this.parent != null;
        }

        public TreeNode getLeafChild(){
            return this.left;
        }

        public TreeNode getRightChild(){
            return this.right;
        }
        
        public TreeNode getParent(){
            return this.parent;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    private TreeNode root;

    public BinaryTree() {
        this.root = new TreeNode();
    }

    public BinaryTree(E data) {
        this.root = new TreeNode(data);
    }

    /**
     * 为指定节点添加子节点。
     * 
     * @param index
     *            需要添加子节点的父节点的索引
     * @param data
     *            新子节点的数据
     * @param isLeft
     *            是否为左节点
     * @return 新增的节点
     */
    public TreeNode addNode(TreeNode parent, E data, boolean isLeft) {
        if (parent == null) {
            throw new RuntimeException(parent + "节点为null，无法添加子节点");
        }
        if (isLeft && parent.left != null) {
            throw new RuntimeException(parent + "节点已有左子节点，无法添加左子节点");
        }
        if (!isLeft && parent.right != null) {
            throw new RuntimeException(parent + "节点已有右子节点，无法添加右子节点");
        }
        TreeNode newNode = new TreeNode(data);
        if (isLeft) {
            // 让父节点的left引用指向新节点
            parent.left = newNode;
        } else {
            // 让父节点的left引用指向新节点
            parent.right = newNode;
        }
        newNode.parent = parent;
        return newNode;
    }

    // 判断二叉树是否为空。
    public boolean empty() {
        // 根据根元素来判断二叉树是否为空
        return root.data == null;
    }

    // 返回根节点。
    public TreeNode root() {
        if (empty()) {
            throw new RuntimeException("树为空，无法访问根节点");
        }
        return root;
    }

    // 返回指定节点（非根节点）的父节点。
    public E parent(TreeNode node) {
        // 对于二叉链表存储法，如果要访问指定节点的父节点必须遍历二叉树
        return (E)node.parent;
    }

    // 返回指定节点（非叶子）的左子节点。当左子节点不存在时返回null
    public E leftChild(TreeNode parent) {
        if (parent == null) {
            throw new RuntimeException(parent + "节点为null，无法添加子节点");
        }
        return parent.left == null ? null : (E) parent.left.data;
    }

    // 返回指定节点（非叶子）的右子节点。当右子节点不存在时返回null
    public E rightChild(TreeNode parent) {
        if (parent == null) {
            throw new RuntimeException(parent + "节点为null，无法添加子节点");
        }
        return parent.right == null ? null : (E) parent.right.data;
    }

    // 返回该二叉树的深度。
    public int deep() {
        // 获取该树的深度
        return deep(root);
    }

    // 这是一个递归方法：每棵子树的深度为其所有子树的最大深度 + 1
    private int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 没有子树
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            int leftDeep = deep(node.left);
            int rightDeep = deep(node.right);
            // 记录其所有左、右子树中较大的深度
            int max = leftDeep > rightDeep ? leftDeep : rightDeep;
            // 返回其左右子树中较大的深度 + 1
            return max + 1;
        }
    }

    public static void main(String[] args) {
//         5
//        / \
//       4   8
//      /   / \
//     11  13  4
//    /  \    / \
//   7    2  5   1
        System.out.println("---construct tree---");
        BinaryTree<Integer> intTree = new BinaryTree(5);
        System.out.println("root:" + intTree.root());
        BinaryTree.TreeNode rootNode = intTree.root();
        // 2nd floor
        BinaryTree.TreeNode node4 = intTree.addNode(intTree.root(), 4, true);
        BinaryTree.TreeNode node8 = intTree.addNode(intTree.root(), 8, false);
        // 3ird floor
        BinaryTree.TreeNode node11 = intTree.addNode(node4, 11, true);
        BinaryTree.TreeNode node13 = intTree.addNode(node8, 13, true);
        BinaryTree.TreeNode node3_4 = intTree.addNode(node8, 4, false);
        // 4th floor
        BinaryTree.TreeNode node7 = intTree.addNode(node11, 7, true);
        BinaryTree.TreeNode node2 = intTree.addNode(node11, 2, false);
        BinaryTree.TreeNode node4_5 = intTree.addNode(node3_4, 5, true);
        BinaryTree.TreeNode node1 = intTree.addNode(node3_4, 1, false);
//        System.out.println(node4);
//        System.out.println(node8); 
//        System.out.println(node11); 
//        System.out.println(node13);
//        System.out.println(node3_4);
//        System.out.println(node7); 
//        System.out.println(node2); 
//        System.out.println(node4_5);
//        System.out.println(node1);

        System.out.println("root's left:" + intTree.leftChild(rootNode));
        System.out.println("root's parent:" + intTree.parent(rootNode));
        System.out.println("node1's left:" + intTree.leftChild(node1));
        System.out.println("node1's parent:" + intTree.parent(node1));

    }
}
