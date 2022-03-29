package com;

public class Arbol<E> {

    private E val; // value associated with node
    private Arbol<E> parent; // parent of node
    private Arbol<E> left, right; // children of node

    public Arbol() {
        // post: constructor that generates an empty node
        val = null;
        parent = null; left = right = this;
    }

    public Arbol(E value) {
        // post: returns a tree referencing value and two empty subtrees
        val = value;
        right = left = new Arbol<E>();
        setLeft(left);
        setRight(right);
    }

    public Arbol(E value, Arbol<E> left, Arbol<E> right) {
        // post: returns a tree referencing value and two subtrees
        val = value;
        if (left == null) { left = new Arbol<E>(); }
        setLeft(left);
        if (right == null) { right = new Arbol<E>(); }
        setRight(right);
    }

    public Arbol<E> left() {
        // post: returns reference to (possibly empty) left subtree
        return left;
    }

    public Arbol<E> right() {
        // post: returns reference to (possibly empty) left subtree
        return right;
    }

    public Arbol<E> parent() {
        // post: returns reference to parent node, or null
        return parent;

    }

    public void setLeft(Arbol<E> newLeft) {
        // post: sets left subtree to newLeft
        // re-parents newLeft if not null
        if (isEmpty()) return;
        if (left != null && left.parent() == this) left.setParent(null);
        left = newLeft;
        left.setParent(this);
    }

    public void setRight(Arbol<E> newLeft) {
        // post: sets left subtree to newLeft
        // re-parents newLeft if not null
        if (isEmpty()) return;
        if (right != null && right.parent() == this) right.setParent(null);
        right= newLeft;
        right.setParent(this);
    }

    protected void setParent(Arbol<E> newParent) {
        // post: re-parents this node to parent reference, or null
        if (!isEmpty()) {
            parent = newParent;
        }
    }

    public E value() {
        // post: returns value associated with this node
        return val;
    }

    public void setValue(E value) {
        // post: sets the value associated with this node
        val = value;
    }

    /* Function to check if tree is empty */
    private boolean isEmpty() {
        return val == null && left == null && right == null;
    }

    public String inOrder(Arbol bt) {
        String arbol = "";
        if (bt.val != null) {
            arbol += inOrder(bt.left);
            arbol += bt.value();
            arbol += inOrder(bt.right);
        }
        return arbol;
    }

    public String buscar(String pIngles) {
        pIngles = pIngles.toLowerCase();

        if (this.val == null) {
            return null;
        } else if (((Asociacion) this.val).key.toString().equals(pIngles)) {
            return (String) ((Asociacion) this.val).value;
        } else if (((Asociacion) this.val).key.toString().compareTo(pIngles) > 0) {
            return this.left.buscar(pIngles);
        } else if (((Asociacion) this.val).key.toString().compareTo(pIngles) < 0) {
            return this.right.buscar((pIngles));
        }
        return null;

    }

}
