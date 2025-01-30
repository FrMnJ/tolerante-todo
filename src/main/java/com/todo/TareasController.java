package com.todo;

import java.util.Scanner;
import java.util.Optional;

public class TareasController {
    public static void addTarea(Scanner inputScanner, TareasResource tareasResource){
        try {
            Tarea newTarea = TodoInputController.getTareaFromUser(inputScanner);
            tareasResource.addTarea(newTarea);
            TodoOutputController.printSucessMessage("Tarea agregada con éxito.");
        } catch (Exception e) {
            TodoOutputController
                    .printErrorMessage("Error desconocido: " + e.getMessage());
            return;
        }
    }    

    public static void checkTarea(Scanner inputScanner, TareasResource tareasResource){
        if (tareasResource.getTareas().size() == 0) {
            TodoOutputController.printSucessMessage("No hay elementos que marcar como completados.");
            return;
        }
        Optional<Integer> index = TodoInputController.getIndex(inputScanner, tareasResource);
        while (!index.isPresent()) {
            index = TodoInputController.getIndex(inputScanner, tareasResource);
        }
        int tareaIndex = index.get();
        tareasResource.markTaskAsDone(tareaIndex - 1);
        TodoOutputController.printSucessMessage("Tarea marcada como completada con éxito.");
    }

    public static void deleteTarea(Scanner inputScanner, TareasResource tareasResource) {
        if (tareasResource.getTareas().size() == 0) {
            TodoOutputController.printSucessMessage("No hay elementos que eliminar.");
            return;
        }
        Optional<Integer> index = TodoInputController.getIndex(inputScanner, tareasResource);
        while (!index.isPresent()) {
            index = TodoInputController.getIndex(inputScanner, tareasResource);
        }
        int tareaIndex = index.get();
        tareasResource.deleteTarea(tareaIndex - 1);
        TodoOutputController.printSucessMessage("Tarea eliminada con éxito.");
    }
}