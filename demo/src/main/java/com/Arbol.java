package com;

public class Arbol<E> {


    // Se crean las variables del arbol
    private E val; 
    private Arbol<E> parent; 
    private Arbol<E> left, right; 

    public Arbol() {
        // constructor que crea el nodo vacío
        val = null;
        parent = null; left = right = this;
    }

    public Arbol(E value) {
        // post, regresa 3 valores y 2 espacios vacios 
        val = value;
        right = left = new Arbol<E>();
        setLeft(left);
        setRight(right);
    }

    public Arbol(E value, Arbol<E> left, Arbol<E> right) {
        // post: regresa 3 valores y 2 subarboles 
        val = value;
        if (left == null) { left = new Arbol<E>(); }
        setLeft(left);
        if (right == null) { right = new Arbol<E>(); }
        setRight(right);
    }

    public Arbol<E> left() {
       // regresa el lado izquierdo 
        return left;
    }

    public Arbol<E> right() {
       // regresa el lado derecho 
        return right;
    }

    public Arbol<E> parent() {
        // regresa el nodo o un valor vació 
        return parent;

    }

    public void setLeft(Arbol<E> newLeft) {
        if (isEmpty()) return;
        if (left != null && left.parent() == this) left.setParent(null);
        left = newLeft;
        left.setParent(this);
    }

    public void setRight(Arbol<E> newLeft) {
        if (isEmpty()) return;
        if (right != null && right.parent() == this) right.setParent(null);
        right= newLeft;
        right.setParent(this);
    }

    protected void setParent(Arbol<E> newParent) {
        // Se establece el parent 
        if (!isEmpty()) {
            parent = newParent;
        }
    }

    public E value() {
        // regresa valores asociados con este nodo 
        return val;
    }

    public void setValue(E value) {
        // regresa valores asociados con este nodo 
        val = value;
    }

    // funcion para comprobar si esta vacio 
    private boolean isEmpty() {
        return val == null && left == null && right == null;
    }

    // Funcion para realizar el ordenamiento 
    public String inOrder(Arbol bt) {
        String arbol = "";
        if (bt.val != null) {
            arbol += inOrder(bt.left);
            arbol += bt.value();
            arbol += inOrder(bt.right);
        }
        return arbol;
    }

    // Funcion de buscar 
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
