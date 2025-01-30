package com.todo;

public enum Priority {
    BAJA, MEDIA, ALTA;

    public static Priority mapped(String priority){
        priority = priority.toUpperCase();
        Priority mappedPriority;
        if(priority.equals(Priority.BAJA.name())){
            mappedPriority = Priority.BAJA;
        }
        else if(priority.equals(Priority.MEDIA.name())){
            mappedPriority = Priority.MEDIA;
        }
        else if(priority.equals(Priority.ALTA.name())){
            mappedPriority = Priority.ALTA;
        }
        else{
            throw new IllegalArgumentException("Las opciones validas son alta, media o baja");
        }
        return mappedPriority;
    }
}
