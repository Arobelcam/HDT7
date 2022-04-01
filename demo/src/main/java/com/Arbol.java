package com;

public class Arbol<E> {


    // Se crean las variables del arbol
    private E val; 
    private Arbol<E> parent; 
    private Arbol<E> izq, der; 

    public Arbol() {
        // constructor que crea el nodo vacío
        val = null;
        parent = null; izq = der = this;
    }

    public Arbol(E valor) {
        // post, regresa 3 valores y 2 espacios vacios 
        val = valor;
        der = izq = new Arbol<E>();
        setLeft(izq);
        setRight(der);
    }

    public Arbol(E valor, Arbol<E> izq, Arbol<E> der) {
        // post: regresa 3 valores y 2 subarboles 
        val = valor;
        if (izq == null) { izq = new Arbol<E>(); }
        setLeft(izq);
        if (der == null) { der = new Arbol<E>(); }
        setRight(der);
    }

    public Arbol<E> left() {
       // regresa el lado izquierdo 
        return izq;
    }

    public Arbol<E> right() {
       // regresa el lado derecho 
        return der;
    }

    public Arbol<E> parent() {
        // regresa el nodo o un valor vació 
        return parent;

    }

    public void setLeft(Arbol<E> newLeft) {
        if (isEmpty()) return;
        if (izq != null && izq.parent() == this) izq.setParent(null);
        izq = newLeft;
        izq.setParent(this);
    }

    public void setRight(Arbol<E> newLeft) {
        if (isEmpty()) return;
        if (der != null && der.parent() == this) der.setParent(null);
        der= newLeft;
        der.setParent(this);
    }

    protected void setParent(Arbol<E> newParent) {
        // Se establece el parent 
        if (!isEmpty()) {
            parent = newParent;
        }
    }

    public E valor() {
        // regresa valores asociados con este nodo 
        return val;
    }

    public void setValue(E value) {
        // regresa valores asociados con este nodo 
        val = value;
    }

    // funcion para comprobar si esta vacio 
    private boolean isEmpty() {
        return val == null && izq == null && der == null;
    }

    // Funcion para realizar el ordenamiento 
    public String inOrder(Arbol bt) {
        String arbol = "";
        if (bt.val != null) {
            arbol += inOrder(bt.izq);
            arbol += bt.valor();
            arbol += inOrder(bt.der);
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
            return this.izq.buscar(pIngles);
        } else if (((Asociacion) this.val).key.toString().compareTo(pIngles) < 0) {
            return this.der.buscar((pIngles));
        }
        return null;

    }

}
