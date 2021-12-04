
package taller2;
public class ListaEstudiante {
    private int cant;
    private int max;
    private Estudiantes[] Lista;

    public ListaEstudiante() {
        this.max = 999;
        cant =0;
        Lista= new Estudiantes[max];
    }
    public boolean ingresarEstudiante(Estudiantes E){
        boolean t=false;
        if(cant <max){
            Lista[cant]=E;
            cant++;
            t=true;
        }
        return t;
    }
    
    public Estudiantes BuscarEstudiante(String Rut){
        Estudiantes E= null;
        for(int i=0;i<cant;i++){
            if(Lista[i].getRut().equals(Rut)){
                E=Lista[i];
                 
            }
        }
        return E;
    }
    public int getCantidad(){
        return cant;
    }

    public Estudiantes[] getLista() {
        return Lista;
    }
    
}
