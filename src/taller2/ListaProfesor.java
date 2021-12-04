package taller2;
public class ListaProfesor {
    private int cant;
    private int max;
    private Profesor[] Lista;

    public ListaProfesor() {
        this.max = 999;
        cant=0;
        Lista= new Profesor[max];
        
    }
    
    public boolean ingresarProfesor(Profesor P){
        boolean t=false;
        if(cant <max){
            Lista[cant]=P;
            cant++;
            t=true;
        }
        return t;
    }
    public Profesor BuscarPofesor(String Rut){
        Profesor  P= null;
        for(int i=0;i<cant;i++){
            if(Lista[i].getRut().equals(Rut)){
                P=Lista[i];
                 
            }
        }
        return P;
    }
    public int getCantidad(){
        return cant;
    }

    public Profesor[] getLista() {
        return Lista;
    }
        
}
