package com.jason.rbt;

/**
 * 红黑树节点
 */
public class RBTreeNode<T extends Comparable<T>> {

    private T value;
    private RBTreeNode<T> left;
    private RBTreeNode<T> right;
    private RBTreeNode<T> parent;
    private Boolean red;

    public RBTreeNode() {
    }

    public RBTreeNode(T value) {
        this.value = value;
    }

    public RBTreeNode(T value, Boolean red) {
        this.value = value;
        this.red = red;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public RBTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(RBTreeNode<T> left) {
        this.left = left;
    }

    public RBTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(RBTreeNode<T> parent) {
        this.parent = parent;
    }

    public RBTreeNode<T> getRight() {
        return right;
    }

    public void setRight(RBTreeNode<T> right) {
        this.right = right;
    }

    public Boolean isRed() {
        return red;
    }

    public Boolean isBlack() {
        return !red;
    }

    public void setRed() {
        this.red = true;
    }

    public void setBlack() {
        this.red = false;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
