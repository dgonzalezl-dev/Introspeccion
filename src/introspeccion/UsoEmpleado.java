package introspeccion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Profesora
 */
public class UsoEmpleado {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        int opcion=0;
        do{
            try{
                System.out.println("1.Nombre clase");
                System.out.println("2.Indicar constructores");
                System.out.println("3.Indicar atributos");
                System.out.println("4.Indicar metodos");
                opcion=entrada.nextInt();
                if(opcion==1)
                    nombreClase(entrada);
                else if(opcion==2)
                    constructores(entrada);
                else if(opcion==3)
                    fields(entrada);
                else if(opcion==4)
                    metodos(entrada);
            }catch(Exception ex){}
        }while(opcion!=5);
    }
    
    public static void nombreClase(Scanner entrada){
        System.out.println("Introduzca nombre de la clase");
        entrada.nextLine();
        String nombreClase = entrada.nextLine();
        Class cl1;
        try {
            cl1 = Class.forName(nombreClase);
            System.out.println(cl1.getName());
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception"+ ex);
        }
    }
    
    public static void constructores(Scanner entrada){
        System.out.println("Introduzca nombre de la clase");
        entrada.nextLine();
        String nombreClase = entrada.nextLine();
        Class cl1;
        try{
            cl1 = Class.forName(nombreClase);
            Constructor[] cons = cl1.getConstructors();
            for(int i=0;i<cons.length;i++){
                System.out.println(cons[i].toGenericString());
            }
        }catch(Exception ex){
            System.out.println("Exception"+ ex);
        }
    }
    
    public static void fields(Scanner entrada){
        System.out.println("Introduzca nombre de la clase");
        entrada.nextLine();
        String nombreClase = entrada.nextLine();
        Class cl1;
        try{
            cl1 = Class.forName(nombreClase);
            Field[] campos = cl1.getDeclaredFields();
            for(int i=0;i<campos.length;i++){
                System.out.println(campos[i].toGenericString());
            }
        }catch(Exception ex){
            System.out.println("Exception"+ ex);
        }
    }
    
    public static void metodos(Scanner entrada){
        System.out.println("Introduzca nombre de la clase");
        entrada.nextLine();
        String nombreClase = entrada.nextLine();
        Class cl1;
        try{
            cl1 = Class.forName(nombreClase);
            Method m[] = cl1.getMethods();
            for(int i=0;i<m.length;i++){
                System.out.println(m[i].toGenericString());
            }
        }catch(Exception ex){
            System.out.println("Exception"+ ex);
        }
    }
}

class Persona {

    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Empleado extends Persona {

    private double salario;

    public Empleado(String nombre, double salario) {
        super(nombre);
        this.salario = salario;
    }

    public void setIncentivo(double incentivo) {
        salario = salario + incentivo;
    }

    public String getSalario() {
        return "El salario es: " + salario;
    }
}
