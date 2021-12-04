package taller2;


public class ListaParalelos {
    private int cant;
    private int max;
    private Paralelos[] Lista;

    public ListaParalelos() {
        this.cant = 0;
        this.max = 999;
        this.Lista = new Paralelos[max];
    }

    public int getCant() {
        return cant;
    }

    public Paralelos[] getLista() {
        return Lista;
    }
     public boolean ingresarParalelo(Paralelos P){
        boolean t=false;
         if(cant <max){
            Lista[cant]=P;
            cant++;
            t=true;
        }
         return t;
    }
    
    public Paralelos BuscarParalelo(float Codigo){
        Paralelos P= null;
        for(int i=0;i<cant;i++){
            if(Lista[i].getCodigoAsignatura()==Codigo){
                P=Lista[i];
                 
            }
        }
        return P;
    }
}
