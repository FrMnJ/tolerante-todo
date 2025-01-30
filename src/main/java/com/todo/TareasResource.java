package com.todo;

import java.util.ArrayList;
import java.util.List;

public class TareasResource {
    private List<Tarea> tareas;

    public TareasResource(){
        this.tareas = new ArrayList<Tarea>();
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }    

    public void addTarea(Tarea tarea){
        try{
            this.tareas.add(tarea);
        }
        catch(UnsupportedOperationException e){
            TodoOutputController.printErrorMessage("Error: La operacion no es soportada.");
        }
        catch(ClassCastException e){
            TodoOutputController.printErrorMessage("Error: La clase no puede ser añadida a una lista.");
        }
        catch(NullPointerException e){
            TodoOutputController.printErrorMessage("Error: El elemento es nulo.");
        }
        catch(IllegalArgumentException e){
            TodoOutputController.printErrorMessage("Error: Alguna propiedad no nos permite que sea añadido.");
        }
        catch(Exception e){
            TodoOutputController.printErrorMessage("Error: "+e.getMessage());
        }
    }

    public void markTaskAsDone(int tareaIndex){
        try {
            Tarea tarea = this.tareas.get(tareaIndex);
            tarea.setDone(true);
        } catch (IndexOutOfBoundsException e) {
            TodoOutputController.printErrorMessage("Error: Index de tarea fuera de rango.");
        }
    }

    public void deleteTarea(int tareaIndex){
        try {
            this.tareas.remove(tareaIndex);
        } catch (IndexOutOfBoundsException e) {
            TodoOutputController.printErrorMessage("Error: Index de tarea fuera de rango.");
        } catch(Exception e){
            TodoOutputController.printErrorMessage("Error desconocido: "+e.getMessage());
        }

    }
}
