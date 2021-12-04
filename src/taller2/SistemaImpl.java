
package taller2;


public class SistemaImpl implements Sistema {
    private ListaAsignatura LA;
    private ListaEstudiante LE;
    private ListaProfesor LP;
    private ListaParalelos LPA;

    @Override
    public boolean ingresarEstudiante(Estudiantes E){
        return LE.ingresarEstudiante(E);
    }    
    @Override
    public boolean ingresarAsignatura(Asignatura A){
        return LA.ingresarAsignatura(A);
    }    
    @Override
    public boolean ingresarProfesor(Profesor P){
        return LP.ingresarProfesor(P);
    }
    @Override
    public boolean ingresarParalelos(Paralelos PA){
        return LPA.ingresarParalelo(PA);
    }
 
    @Override
    public String IniciarSesion(String correo, String Contraseña){
        if(correo.equals("Admin") && Contraseña.equals("GHI_789")){
            return "Admin";
        }
        Estudiantes[] ListaE= LE.getLista();
        for(int i=0;i<LE.getCantidad();i++){
            if(ListaE[i].getContraseña().equals(Contraseña) && ListaE[i].getCorreo().equals(correo)){
                return "Estudiante";
            }
        }
        Profesor[] ListaP = LP.getLista();
        for(int x=0;x<LP.getCantidad();x++){
            if(ListaE[x].getContraseña().equals(Contraseña) && ListaE[x].getCorreo().equals(correo)){
                return "Profesor";
            }
        }
        return "correo o contraseña incorrecta";
    }
    @Override
    public Estudiantes BuscaEstudiantePorCorreo(String correo){
        Estudiantes[] ListaE= LE.getLista();
        for(int i=0;i<LE.getCantidad();i++){
            if( ListaE[i].getCorreo().equals(correo)){
               return ListaE[i];
            }
  
    } 
          return null;
    }
    @Override
    public Profesor BuscaProfesorPorCorreo(String correo){
        Profesor[] ListaP= LP.getLista();
        for(int i=0;i<LP.getCantidad();i++){
            if( ListaP[i].getCorreoProfesor().equals(correo)){
               return ListaP[i];
            }
    
    }
        return null;
}
      
    @Override
    public int CalcularCredito(Estudiantes E){
        int credito=0;
        for(int i=0;i<E.getCantAsignatura();i++){
            Asignatura a= LA.BuscarAsignatura(E.getListaAsignaturas()[0]);
            credito+=a.getCreditos();
            i++;
        }
        return credito;
    }
    //Actualiza el nivel del estudiante
    @Override
    public int nivelEstudiante(Estudiantes E){
        int LV=E.getNivel();
        int lvmenor=LV;
        boolean T=true;
        //Ahora se revisan las notas finales
        for(int i=0;i<E.getCantAsignatura();i++){
            Asignatura Asig=LA.BuscarAsignatura(E.getListaAsignaturas()[i]);
            //Buscamos la asignatura y la guardamos, solo las obligatorias tienen nivel
            if(Asig instanceof AsignaturaObligatoria){
                 if(E.getListaAsignaturas()[i++]<3.95 && T){
                        //Es la asignatura que no se paso, pero hay que ver si es la menor
                        if(LV<=((AsignaturaObligatoria) Asig).getNivel()){
                            lvmenor = LV;
                            T=false;
                        }
                }
                 //Hay que revisar si es el  nivel original que se paso
                 if(lvmenor>=3.95 && T){
                     lvmenor=((AsignaturaObligatoria) Asig).getNivel();
                 }        
        }   
    }
        return LV;
    }
    //Inscribe una Asignatura a un alumno mientras los creditos no superen 40
    @Override
    public boolean InscribirAsignatura(int Codigo , float num,Estudiantes E){
        boolean t=false;
        //Hay que buscar la asignatura y ver los creditos
        int credito= CalcularCredito(E);
        if(credito<41){
            float[] lAsig=E.getLista();
            int  cantt= E.getCantAsignatura()*2;
            lAsig[cantt]= Codigo;
            lAsig[cantt++]=num;
            cantt++;
            E.setCantAsignatura(cantt);
            t=true;
        }
        return t;
    }
   //Elimina una asignatura que un estudiante este dando
   @Override
    public boolean EliminarAsignatura (int Codigo,Estudiantes E){
       boolean t=false;
       int borrar=-1;
       for(int i=0;i<E.getCantAsignatura();i++){
           if(Codigo==E.getLista()[i]){
               borrar=i;
               t=true;
           }
           i++;
       }
       if(t){
           for(int x=borrar;x<E.getCantAsignatura();x++){
               E.getLista()[x]=E.getLista()[x+2];
               E.getLista()[x+1]=E.getLista()[x+3];
           }
           E.setCantAsignatura(E.getCantAsignatura());
       }
       return t;
   }
   //Guarda los paralelos del profesor
   @Override
    public ListaParalelos MostrarParalelosProfesor(Profesor P){
       ListaParalelos LPPP =new ListaParalelos();
       String RP= P.getRut();
       for(int i=0;i<LPA.getCant();i++){
           if(LPA.getLista()[i].getRutProfesor().equals(P.getRut())){
               LPPP.ingresarParalelo(LPA.getLista()[i]);
           }
       }
       return LPPP;
   }
   //Guarda los alumnos cuyo paralelo y asignatura es la misma
   @Override
    public ListaEstudiante AñadirAlumnosParalelo(float paralelo, float codigo){
       ListaEstudiante LEP= new ListaEstudiante();
       Estudiantes[] ListaE= LE.getLista();
       for(int i=0;i<LE.getCantidad();i++){
           Estudiantes E=ListaE[i];
           float[] LAsig= E.getLista();
           if(LAsig[0]==codigo && LAsig[1]==paralelo){
               LEP.ingresarEstudiante(E);
           }
       }
       
       return LEP;
   }
   //Busca al Estudiante y añade su nota Final
   @Override
     public boolean IngresarNotaFinal(int codigoAsignatura, String rut, float nota) {
        for(int i=0; i<LE.getCantidad();i++){
            //Se busca al Estudiante
            if(LE.getLista()[i].getRut().equals(rut)){
                //Buscamos por asignatura del Estudiante
               float[] ListaAsignaturasEstudiante= LE.getLista()[i].getListaAsignaturas();
               for(int x=0;i<LE.getLista()[i].getCantAsignatura();x++){
                   if(ListaAsignaturasEstudiante[x]==codigoAsignatura){
                       //Se encontro al Estudiante con el codigo de asignatura
                       ListaAsignaturasEstudiante[x+1]=nota;
                       return true;
                   }
                   x++;
               }
            }
        }
        return false;
   }

}
