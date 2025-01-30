package com.todo;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TareasResource tareasResource = new TareasResource();
        Scanner inputScanner = new Scanner(System.in);
        while(true){
            TodoOutputController.printOptions();
            Optional<Integer> inputtedOption = TodoInputController.getOption(inputScanner);
            while(!inputtedOption.isPresent()){
                inputtedOption = TodoInputController.getOption(inputScanner);
            }
            int option = inputtedOption.get();

            if(option == ToDoOptions.AGREGAR.getValue()){
               TareasController.addTarea(inputScanner, tareasResource);
            }
            else if(option == ToDoOptions.LISTAR.getValue()){
                TodoOutputController.printTareas(tareasResource);
                TodoOutputController.printSucessMessage("Tarea listadas con éxito.");
            }
            else if(option == ToDoOptions.COMPLETAR.getValue()){
                TareasController.checkTarea(inputScanner, tareasResource);
            }
            else if(option == ToDoOptions.ELIMINAR.getValue()){
                TareasController.deleteTarea(inputScanner, tareasResource);
            }
            else if(option == ToDoOptions.SALIR.getValue()){
                TodoOutputController.printSucessMessage("Adiós");
                break;
            }
            else{
                TodoOutputController.printErrorMessage("Error: opción invalida.");
            }
        }
        inputScanner.close();
    }
}