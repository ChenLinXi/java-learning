package com.jason.rbt;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 红黑树
 */
public class RBTree<T extends Comparable<T>> {

    // 根结点
    private final RBTreeNode<T> root;
    // 节点数目
    private AtomicLong size = new AtomicLong(0);
    // 覆盖写入模式, 写入数据时会更新现有数据, 默认选择覆盖写入模式
    private volatile boolean overrideMode = true;

    public RBTree() {
        // 实例对象时创建根结点
        this.root = new RBTreeNode<>();
    }

    public RBTree(boolean overrideMode) {
        this();
        this.overrideMode = overrideMode;
    }

    public boolean isOverrideMode() {
        return overrideMode;
    }

    public void setOverrideMode(boolean overrideMode) {
        this.overrideMode = overrideMode;
    }

    // 红黑树节点数目
    public long getSize() {
        return size.get();
    }

    public T addNode(T value) {
        return null;
    }

    /**
     * 从根结点开始往下递归查询
     */
    public T find(T value) {
        RBTreeNode<T> dataRoot = getRoot();
        while (dataRoot != null) {
            int cmp = dataRoot.getValue().compareTo(value);
            if (cmp < 0) {
                dataRoot = dataRoot.getRight();
            } else if (cmp > 0) {
                dataRoot = dataRoot.getLeft();
            } else {
                return dataRoot.getValue();
            }
        }
        return null;
    }

    public T remove(T value) {
        RBTreeNode<T> dataRoot = getRoot();
        RBTreeNode<T> parent = root;

        while (dataRoot != null) {
            int cmp = dataRoot.getValue().compareTo(value);
            if (cmp < 0) {
                parent = dataRoot;
                dataRoot = dataRoot.getRight();
            } else if (cmp > 0) {
                parent = dataRoot;
                dataRoot = dataRoot.getLeft();
            } else {
                if (dataRoot.getRight() != null) {
                    RBTreeNode<T> min = removeMin(dataRoot.getRight());
                    // x used for fix color balance
                    RBTreeNode<T> x = min.getRight() == null ? min.getParent() : min.getRight();
                    boolean isParent = min.getRight() == null;

                    min.setLeft(dataRoot.getLeft());
                    setParent(dataRoot.getLeft(),min);
                    if(parent.getLeft()==dataRoot){
                        parent.setLeft(min);
                    }else{
                        parent.setRight(min);
                    }
                    setParent(min,parent);

                    boolean curMinIsBlack = min.isBlack();
                    //inherit dataRoot's color
                    if (dataRoot.isRed()) {
                        min.setRed();
                    } else {
                        min.setBlack();
                    }

                    if(min!=dataRoot.getRight()){
                        min.setRight(dataRoot.getRight());
                        setParent(dataRoot.getRight(),min);
                    }
                    //remove a black node,need fix color
                    if(curMinIsBlack){
                        if(min!=dataRoot.getRight()){
                            fixRemove(x,isParent);
                        }else if(min.getRight()!=null){
                            fixRemove(min.getRight(),false);
                        }else{
                            fixRemove(min,true);
                        }
                    }
                } else {
                    setParent(dataRoot.getLeft(), parent);
                    if(parent.getLeft()==dataRoot){
                        parent.setLeft(dataRoot.getLeft());
                    }else{
                        parent.setRight(dataRoot.getLeft());
                    }
                    //current node is black and tree is not empty
                    if(dataRoot.isBlack() && !(root.getLeft()==null)){
                        RBTreeNode<T> x = dataRoot.getLeft()==null
                            ? parent :dataRoot.getLeft();
                        boolean isParent = dataRoot.getLeft()==null;
                        fixRemove(x,isParent);
                    }
                }
                setParent(dataRoot, null);
                dataRoot.setLeft(null);
                dataRoot.setRight(null);
                if(getRoot()!=null){
                    getRoot().setBlack();
                    getRoot().setParent(null);
                }
                size.decrementAndGet();
                return dataRoot.getValue();
            }
        }
        return null;
    }

    /**
     * 为了判断是否为根结点，选取原根结点的左儿子节点作为新的根结点
     */
    private RBTreeNode<T> getRoot() {
        return root.getLeft();
    }

    /**
     * 修正删除节点后的红黑树
     *
     * @param node 删除的节点
     * @param isParent 是否是父节点
     */
    private void fixRemove(RBTreeNode<T> node, boolean isParent) {
        RBTreeNode<T> current = isParent ? null : node;
        boolean isRed = isParent ? false : node.isRed();
        RBTreeNode<T> parent = isParent ? node : node.getParent();

        while (!isRed && !isRoot(current)) {
            // 在修正之前，存在叔叔节点
            RBTreeNode<T> sibling = getSibling(current, parent);

            boolean isLeft = (parent.getRight() == sibling);
            if (sibling.isRed() && !isLeft) { // 第一种情况
                parent.setRed();
                sibling.setBlack();
                rightRotate(parent);
            } else if (sibling.isRed() && isLeft) {
                parent.setRed();
                sibling.setBlack();
                leftRotate(parent);
            } else if (isBlack(sibling.getLeft()) && isBlack(sibling.getRight())) { // 第二种情况
                sibling.setRed();
                current = parent;
                isRed = current.isRed();
                parent = parent.getParent();
            } else if (isLeft && !isBlack(sibling.getLeft()) && isBlack(sibling.getLeft())) { // 第三种情况
                sibling.setRed();
                sibling.getLeft().setBlack();
                rightRotate(sibling);
            } else if (isLeft && !isBlack(sibling.getLeft()) && isBlack(sibling.getLeft())) {
                sibling.setRed();
                sibling.getLeft().setBlack();
                rightRotate(sibling);
            } else if (isLeft && !isBlack(sibling.getRight())) {  // 第四种情况
                if (parent.isRed()) {
                    sibling.setRed();
                } else {
                    sibling.setBlack();
                }
                parent.setBlack();
                sibling.getRight().setBlack();
                leftRotate(parent);
                current = getRoot();
            } else if (!isLeft && !isBlack(sibling.getLeft())) {
                if (parent.isRed()) {
                    sibling.setRed();
                } else {
                    sibling.setBlack();
                }
                parent.setBlack();
                sibling.getLeft().setBlack();
                rightRotate(parent);
                current = getRoot();
            }
        }
        if (isRed) {
            current.setBlack();
        }
        if (getRoot() != null) {
            getRoot().setBlack();
            getRoot().setParent(null);
        }
    }

    /**
     * 查询兄弟节点
     */
    private RBTreeNode<T> getSibling(RBTreeNode<T> node, RBTreeNode<T> parent) {
        parent = (node == null ? parent : node.getParent());
        if (node == null) {
            return parent.getLeft() == null ? parent.getRight() : parent.getLeft();
        }
        if (node == parent.getLeft()) {
            return parent.getRight();
        } else {
            return parent.getLeft();
        }
    }

    private boolean isBlack(RBTreeNode<T> node) {
        return node == null || node.isBlack();
    }

    private boolean isRoot(RBTreeNode<T> node) {
        return root.getLeft() == node && node.getParent() == null;
    }

    /**
     * 删除最小值节点
     *
     * 遍历到最小节点后判断是否有兄弟节点 如果存在兄弟节点，则需要以最小值节点的父节点为旋转节点左旋
     */
    private RBTreeNode<T> removeMin(RBTreeNode<T> node) {
        RBTreeNode<T> parent = node;
        while (node != null && node.getLeft() != null) {
            // 记录父节点
            parent = node;
            // 迭代遍历
            node = node.getLeft();
        }
        // node节点为最小值的节点
        if (parent == node) {
            // node节点无兄弟节点
            return node;
        }

        // node节点有兄弟节点
        // 删除最小值节点后以parent根结点作为旋转节点左旋
        parent.setLeft(node.getRight());
        setParent(node.getRight(), parent);
        return node;
    }

    /**
     * 从根结点按照大小递归比较后插入新的节点
     *
     * 注意红黑树初始化时没有子节点的特殊情况
     */
    private T addNode(RBTreeNode<T> node) {
        node.setLeft(null);
        node.setRight(null);
        // 红黑树规则，新增节点默认为红色
        node.setRed();
        setParent(node, null);
        if (root.getLeft() == null) {
            root.setLeft(node);
            // 红黑树规则，根节点为红色
            node.setBlack();
            size.incrementAndGet();
        } else {
            RBTreeNode<T> parent = findParentNode(node);
            int cmp = parent.getValue().compareTo(node.getValue());

            // 默认为覆盖写入模式，遇到相同value的节点会以更新的方式新增节点
            if (this.overrideMode && cmp == 0) {
                T value = parent.getValue();
                parent.setValue(node.getValue());
                return value;
            } else if (cmp == 0) {
                // 数值相同
                return parent.getValue();
            }

            setParent(node, parent);
            if (cmp > 0) {
                parent.setLeft(node);
            } else {
                parent.setRight(node);
            }

            // 插入后按照三种情况修改节点的颜色
            fixInsert(node);
            size.incrementAndGet();
        }
        return null;
    }

    /**
     * 添加节点后修正三种破坏平衡的情况
     */
    private void fixInsert(RBTreeNode<T> node) {
        RBTreeNode<T> parent = node.getParent();

        while (parent != null && parent.isRed()) {
            RBTreeNode<T> uncle = getUncle(node);

            if (uncle == null) {
                // 在添加子节点修正平衡的时候，祖节点的颜色不可能为红色
                // 叔叔节点为空时需要修正
                RBTreeNode<T> ancestor = parent.getParent();
                if (parent == ancestor.getLeft()) {
                    boolean isRight = (node == parent.getRight());
                    if (isRight) {
                        leftRotate(parent);
                    }
                    rightRotate(ancestor);

                    if (isRight) {
                        node.setBlack();
                        parent = null; // 结束循环
                    } else {
                        parent.setBlack();
                    }
                    ancestor.setRed();
                } else {
                    boolean isLeft = (node == parent.getLeft());
                    if (isLeft) {
                        rightRotate(parent);
                    }
                    leftRotate(ancestor);

                    if (isLeft) {
                        node.setBlack();
                        parent = null; // 结束循环
                    } else {
                        parent.setBlack();
                    }
                    ancestor.setRed();
                }
            } else {
                // 叔叔节点为红色
                parent.setBlack();
                uncle.setBlack();
                parent.getParent().setRed();

                // 自底往上递归修正受影响的节点
                node = parent.getParent();
                parent = node.getLeft();
            }
        }
        // 自底往上递归修正后，修正根结点
        getRoot().setBlack();
        getRoot().setParent(null);
    }

    /**
     * 查询node节点的父节点，如果父节点的值与node节点的值相同，则返回父节点
     */
    private RBTreeNode<T> findParentNode(RBTreeNode<T> node) {
        RBTreeNode<T> dataRoot = getRoot();
        RBTreeNode<T> child = dataRoot;

        while (child != null) {
            int cmp = child.getValue().compareTo(node.getValue());
            if (cmp == 0) {
                return child;
            }
            if (cmp > 0) {
                dataRoot = child;
                child = child.getLeft();
            } else if (cmp < 0) {
                dataRoot = child;
                child = child.getRight();
            }
        }
        return dataRoot;
    }

    /**
     * 查询当前节点的叔叔节点
     *
     * 查询叔叔节点的隐形条件，当前节点一定存在父节点／叔叔节点
     */
    private RBTreeNode<T> getUncle(RBTreeNode<T> node) {
        // 父节点
        RBTreeNode<T> parent = node.getParent();
        // 祖父节点
        RBTreeNode<T> ancestor = parent.getParent();
        if (ancestor == null) {
            return null;
        }
        return parent == ancestor.getLeft() ? ancestor.getRight() : ancestor.getLeft();
    }

    /**
     * 节点左旋
     *
     * 在记录当前节点的根结点后, 以当前节点的右子节点作为当前节点的父节点
     *
     * 节点左旋, 然后修改当前节点与前父节点之间的关系(PS:在修改过程中需要判断节点左旋后是否为根结点这种特殊情况)
     */
    private void leftRotate(RBTreeNode<T> node) {
        RBTreeNode<T> right = node.getRight();
        if (right == null) {
            throw new IllegalStateException("right node is null");
        }
        // 记录当前节点的父节点
        RBTreeNode<T> parent = node.getParent();
        // 当前节点左旋
        node.setRight(right.getLeft());
        setParent(right.getLeft(), node);

        if (parent == null) {
            // 当前操作节点的右子节点作为根节点
            root.setLeft(right);
            setParent(right, null);
        } else {
            // 修正父节点的连接状态
            if (parent.getLeft() == node) {
                parent.setLeft(right);
            } else {
                parent.setRight(right);
            }
            setParent(right, parent);
        }
    }

    /**
     * 节点右旋
     *
     * 在记录当前节点的根结点后，以当前节点替换其父节点成为新的父节点
     *
     * 在此过程中需要注意原父节点与当前节点的右子节点的大小关系
     */
    private void rightRotate(RBTreeNode<T> node) {
        RBTreeNode<T> left = node.getLeft();
        if (left == null) {
            throw new IllegalStateException("left node is null");
        }
        RBTreeNode<T> parent = node.getParent();
        // 节点右旋
        node.setLeft(left.getRight());
        setParent(left.getRight(), node);
        // 修改左子节点为当前节点的父节点
        left.setRight(node);
        setParent(node, left);

        if (parent == null) {
            root.setLeft(left);
            setParent(left, null);
        } else {
            if (parent.getLeft() == null) {
                parent.setLeft(left);
            } else {
                parent.setRight(left);
            }
            setParent(left, parent);
        }
    }

    /**
     * 重新设置当前操作节点的父节点
     *
     * @param node 待操作节点
     * @param parent 待操作节点的父节点
     */
    private void setParent(RBTreeNode<T> node, RBTreeNode<T> parent) {
        if (node != null) {
            if (parent == root) {
                node.setParent(null);
            } else {
                node.setParent(parent);
            }
        }
    }

    public void printTree(RBTreeNode<T> root) {

    }
}
