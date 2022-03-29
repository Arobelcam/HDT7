package com;

public class Asociacion <K, V> {
    public K key ;
    public V value;

    public Asociacion(K key , V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + this.key + ", " + this.value + ") ";
    }
}