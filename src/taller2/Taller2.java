
package taller2;
import java.io.IOException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import ucn.*;
public class Taller2 {
    public String RevisarSemestre(String fecha) throws Exception{
        Date Fecha1= new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
        Date Fecha2= new SimpleDateFormat("dd/MM/yyyy").parse("08/03/2021");
        Date Fecha3= new SimpleDateFormat("dd/MM/yyyy").parse("02/05/2021");
        Date Fecha4= new SimpleDateFormat("dd/MM/yyyy").parse("03/05/2021");
        Date Fecha5= new SimpleDateFormat("dd/MM/yyyy").parse("11/07/2021");
        Date Fecha6= new SimpleDateFormat("dd/MM/yyyy").parse("12/07/2021");
        Date Fecha7= new SimpleDateFormat("dd/MM/yyyy").parse("25/07/2021");
        Date Fecha8= new SimpleDateFormat("dd/MM/yyyy").parse("26/07/2021");
        if(Fecha1.before(Fecha3) && Fecha1.after(Fecha2)){
            return "Inicio";
        }
        if(Fecha1.before(Fecha5) && Fecha1.after(Fecha4)){
            return "Mitad";
        }
        if(Fecha1.before(Fecha7) && Fecha1.after(Fecha6)){
            return "Final";
        }
        if(Fecha1.equals(Fecha8)){
            return "Cierre";
        }
        return "No hay Acciones Disponibles";
    }
    public static void leerEstudiantes(Sistema sistema) throws IOException{
      ArchivoEntrada arch= new ArchivoEntrada("estudiantes.txt");
      while(!arch.isEndFile()){
         Registro reg= arch.getRegistro();
         String rut= reg.getString();
         String correo= reg.getString();
         int nivel =reg.getInt();
         String contraseña = reg.getString();
         int cont= reg.getInt();
         float[] lista= new float[20];
         float[] listaAsignatura = new float[20];
         int x=0;
         for(int i=0;i<cont;i++){
             int code= reg.getInt();
             float nota= (float)reg.getDouble();
             int paralelo = reg.getInt();
             lista[x]=code;
             lista[x++]=paralelo;
             listaAsignatura[x]=code;
             listaAsignatura[x++]=nota;
             x=x+2;
         }//Sea crea Estudiante
         Estudiantes E= new Estudiantes( rut,  correo,  nivel,  contraseña,cont, lista, listaAsignatura);
         sistema.ingresarEstudiante(E);
      }
       arch.close();
        
    }    
    public static void leerAsignaturas(Sistema sistema) throws IOException{
      ArchivoEntrada arch= new ArchivoEntrada("asignaturas.txt");
      while(!arch.isEndFile()){
         Registro reg= arch.getRegistro();
         int codigo= reg.getInt();
         String Nombre= reg.getString();
         int creditos = reg.getInt();
         String tipo = reg.getString();
         if(tipo.equals("obligatoria")){
             int nivel = reg.getInt();
             int cantAsig= reg.getInt();
             int[] listaA = new int[999];
             for(int i=0;i<cantAsig;i++){
                 listaA[i]= reg.getInt();
             }
             AsignaturaObligatoria AO= new AsignaturaObligatoria(nivel,cantAsig,codigo, Nombre,creditos,listaA);
             sistema.ingresarAsignatura(AO);
         }
         if(tipo.equals("opcional")){
             int pre= reg.getInt();
             AsignaturaOpcional AOO=new AsignaturaOpcional(creditos,codigo, Nombre,creditos);
             sistema.ingresarAsignatura(AOO);
         }
      }
       arch.close();
        
    }    
    public static void leerProfesores(Sistema sistema) throws IOException{
    ArchivoEntrada arch= new ArchivoEntrada("profesores.txt");
          while(!arch.isEndFile()){
             Registro reg= arch.getRegistro();
             String rut= reg.getString();
             String correo= reg.getString();
             String contraseña = reg.getString();
             int salario= reg.getInt();

             Profesor P= new Profesor( rut,  correo,  contraseña,salario);
             sistema.ingresarProfesor(P);
        }
        arch.close();
        }  
    public static void leerParalelos(Sistema sistema) throws IOException{
ArchivoEntrada arch= new ArchivoEntrada("paralelos.txt");
      while(!arch.isEndFile()){
         Registro reg= arch.getRegistro();
         int paralelo= reg.getInt();
         int codigo = reg.getInt();
         String RutP = reg.getString();
         sistema.ingresarParalelos(new Paralelos(paralelo,codigo,RutP));
    }
    arch.close();
    }
    
    public static void main(String[] args) throws IOException {
        Sistema sis = new SistemaImpl();
        leerEstudiantes(sis);
        leerAsignaturas(sis);
        leerProfesores(sis);
        leerParalelos(sis);
        
    }
    
}
