package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.Arbol;

public class AppTest {

    @Test

    public void buscarTest(){
        Arbol insancia = new Arbol<>();
        String palabra = "";
        String expected = null;
        String result = insancia.buscar(palabra);
        assertEquals(expected, result);
    }

}
