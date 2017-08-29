/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reflexion;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * @author Master
 */
public class ProcesarInformacion {

    /**
     * Este metodo permite ver que propiedades y que metodos tiene la clase 
     * @return 
     */
    public String procesarClase(Class clase) {
        StringBuilder sb=new StringBuilder();
        //Ver el Package donde se encuentra;
        sb.append("package ");
        sb.append(clase.getPackage().getName());
        sb.append(";\n\n");
        //Ver las anotaciones de una clase
        sb.append(procesarAnotaciones(clase));
        //Ver el nombre y los modificadores de la clase
        sb.append(Modifier.toString(clase.getModifiers()));
        sb.append(" ");
        sb.append(clase.getSimpleName());
        //Ver la herencia
        if(clase.getSuperclass()!=null&&clase.getSuperclass()!=Object.class){
            sb.append(" extends ");
            sb.append(clase.getSuperclass().getName());
        }
        //Ver las interfaces
        if(clase.getInterfaces()!=null){
            for(Class i:clase.getInterfaces()){
                sb.append(" ");
                sb.append(i.getName());
            }
        }
        sb.append("{\n");
        //procesarPropiedades
        sb.append(procesarPropiedades(clase));
        //procesar metodos
        sb.append(procesarMetodos(clase));
        sb.append("\n}");
        return sb.toString();
    }
    
    private String procesarAnotaciones(Class clase){
        StringBuilder sb=new StringBuilder();
        for(Annotation anotacion:clase.getDeclaredAnnotations()){
            sb.append("@");
            sb.append(anotacion.annotationType().getName());
            sb.append("\n");
        }
        return sb.toString();
    }
    
    private String procesarMetodos(Class clase){
        StringBuilder sb=new StringBuilder();
        //TODO: implementar codigo aqui, 
        //se debe utilizar el metodo getDeclaredMethods() para obtener toda la informacion del metodo
        for(Method metodo:clase.getDeclaredMethods()){
            sb.append(metodo.getName());
            sb.append("\n");
        }
        return sb.toString();
    }
    
    private String procesarPropiedades(Class clase){
        StringBuilder sb=new StringBuilder();
        //TODO: implementar codigo aqui, 
        //se debe utilizar el metodo getDeclaredFields() para obtener toda la informacion de las propiedades
        for(Field propiedad:clase.getDeclaredFields()){
            sb.append(propiedad.getName());
            sb.append("\n");
        }
        return sb.toString();
    }
    
}
