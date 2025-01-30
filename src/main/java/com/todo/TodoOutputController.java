package com.todo;

import java.util.List;

public class TodoOutputController {
    private static final String PIN_EMOJI = "\uD83D\uDCCD";	
    private static final String GOOD_EMOJI = "\u2705";
    private static final String BAD_EMOJI = "\u274C";
    private static final String BLUE_DIAMOND_EMOJI = "\uD83D\uDD37";
    private static final String RED_ANSI = "\u001B[31m";
    private static final String GREEN_ANSI = "\u001B[32m";
    private static final String RESET_ANSI = "\u001B[0m";
    public static void printOptions(){
            String options = new StringBuilder()
                             .append(PIN_EMOJI+" GESTOR DE TAREAS "+PIN_EMOJI+"\n")
                             .append("1. Agregar tarea\n")
                             .append("2. Listar tareas\n")
                             .append("3. Completar tarea\n")
                             .append("4. Eliminar tarea\n")
                             .append("5. Salir\n")
                             .toString();
            System.out.println();
            System.out.println(options);
    }

    public static void printSucessMessage(String msg){
        System.out.println(GREEN_ANSI+GOOD_EMOJI+" "+msg);
        System.out.println(RESET_ANSI);
    }

    public static void printErrorMessage(String message){
        System.out.println(RED_ANSI+BAD_EMOJI+" "+message);
        System.out.println(RESET_ANSI);
    }

    public static void resetTerminalColor(){
        System.out.println(RESET_ANSI);
    }

    public static void printTareas(TareasResource tareasResource) {
        List<Tarea> tareas = tareasResource.getTareas();
        if(tareas.size()<1){
            System.out.println("Lista de tareas vacia");
        }
        for (int i = 0; i < tareas.size(); i++) {
            Tarea tarea = tareas.get(i);
            System.out.println(
                   BLUE_DIAMOND_EMOJI +" " + (i+1) + ". ["+ (tarea.getDone() ? "X" : " ") + "] " + tarea.getTitle() + " (Prioridad: " + tarea.getPriority().name() + ")");
        }
    }
}
