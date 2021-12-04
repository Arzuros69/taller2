
package taller2;

public class Paralelos {
    private int NumeroParalelo;
    private int CodigoAsignatura;
    private String RutProfesor;

    public Paralelos(int NumeroParalelo, int CodigoAsignatura, String RutProfesor) {
        this.NumeroParalelo = NumeroParalelo;
        this.CodigoAsignatura = CodigoAsignatura;
        this.RutProfesor = RutProfesor;
    }

    public int getNumeroParalelo() {
        return NumeroParalelo;
    }

    public int getCodigoAsignatura() {
        return CodigoAsignatura;
    }

    public String getRutProfesor() {
        return RutProfesor;
    }
    
}
