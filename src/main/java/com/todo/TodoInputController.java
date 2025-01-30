package com.todo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Optional;


public class TodoInputController {
   public static Optional<Integer> getOption(Scanner scanner){
        System.out.print("> ");
        if(scanner.hasNextInt()){
         int option;
         try{
            option = scanner.nextInt();
         }
         catch(Exception e){
            TodoOutputController.printErrorMessage("Error desconocido: "+e.getMessage());
            scanner.next();
            return Optional.empty();
         }
         if(option<ToDoOptions.AGREGAR.getValue()||option>ToDoOptions.SALIR.getValue()){
            TodoOutputController.printErrorMessage("Las opciones van de 1 al 5. Fuera de rango");
            return Optional.empty();
         }
         scanner.nextLine();
         return Optional.of(option);
        }
        else{
         TodoOutputController.printErrorMessage("Error: no se ingreso un número.");
         scanner.next();
         return Optional.empty();
        }
   }

   public static Tarea getTareaFromUser(Scanner scanner){
      System.out.print("Ingrese el título de la tarea: ");
      String title = scanner.nextLine();
      System.out.print("Ingrese la descripción: ");
      String description = scanner.nextLine();
      Priority mappedPriority = Priority.BAJA;
      while(true){
         try{
            System.out.print("Ingrese la prioridad (alta, media, baja): ");
            String priority = scanner.nextLine();
            mappedPriority = Priority.mapped(priority);
            break;
         }
         catch(IllegalArgumentException e){
            TodoOutputController.printErrorMessage(e.getMessage());
         }
         catch(Exception e){
            TodoOutputController.printErrorMessage("Error desconocido: "+e.getMessage());
         }
      }
      return new Tarea(title, description, mappedPriority);
   }

   public static Optional<Integer> getIndex(Scanner scanner, TareasResource tareasResource) {
      List<Tarea> tareas = tareasResource.getTareas();
      int option = -1;
      System.out.print("Ingresa el número identificador de tarea: ");
      try {
         option = scanner.nextInt();
      } catch (InputMismatchException e) {
         TodoOutputController.printErrorMessage("Debe ser un número natural.");
         scanner.next();
      } catch (Exception e) {
         TodoOutputController.printErrorMessage("Error desconocido: " + e.getMessage());
      }
      scanner.nextLine();
      if (option < 1 || option > tareas.size()) {
         TodoOutputController.printErrorMessage("Debe ser un numero entre " + 1 + " y " + tareas.size() + ".");
         return Optional.empty();
      }
      return Optional.of(option);
   }
}
