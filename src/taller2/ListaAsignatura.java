
package taller2;

public class ListaAsignatura {
    private int max;
    private int cant;
    private Asignatura[] Lista;

    public ListaAsignatura() {
        this.max = 999;
        cant=0;
        Lista= new Asignatura[max];
    }
     public boolean ingresarAsignatura(Asignatura A){
        boolean t=false;
         if(cant <max){
            Lista[cant]=A;
            cant++;
            t=true;
        }
         return t;
    }
    public Asignatura BuscarAsignatura(float Codigo){
        Asignatura A= null;
        for(int i=0;i<cant;i++){
            if(Lista[i].getCodigo()== Codigo){
                A=Lista[i];
                 
            }
        }
        return A;
    }
    public int getCantidad(){
        return cant;
    }
    public boolean EliminarAsignatura(int Codigo){
        boolean t =false;
        int val=0;
        for(int i=0;i<cant;i++){
            if(Lista[i].getCodigo()==Codigo){
                t=true;
                Lista[i]=Lista[i+1];
                }
         if(t){
             cant--;
             for(int x=0;x<cant;x++){
                 Lista[x]=Lista[x+1];
             }
         }
        }
        return t;
    }

    public Asignatura[] getLista() {
        return Lista;
    }
    
}
