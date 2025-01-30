package com.todo;

public enum ToDoOptions {
    //AGREGAR, LISTAR, COMPLETAR, ELIMINAR, SALIR;
    AGREGAR(1),
    LISTAR(2),
    COMPLETAR(3),
    ELIMINAR(4), 
    SALIR(5);

    private final int value;

    public int getValue() {
        return value;
    }

    ToDoOptions(final int newValue){
        this.value = newValue;
    }
}
