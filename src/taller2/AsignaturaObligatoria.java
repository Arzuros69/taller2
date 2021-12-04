
package taller2;

public class AsignaturaObligatoria extends Asignatura{
    private int nivel;
    private int CantAsignaturaPrerrequisito;
    private int[] codAsignaturas;

    public AsignaturaObligatoria(int nivel, int CantAsignaturaPrerrequisito, int Codigo, String NombreA, int Creditos,int[] codAsignaturas) {
        super(Codigo, NombreA, Creditos);
        this.nivel = nivel;
        this.CantAsignaturaPrerrequisito = CantAsignaturaPrerrequisito;
        this.codAsignaturas=codAsignaturas;
    }

    public int getNivel() {
        return nivel;
    }

    public int[] getCodAsignaturas() {
        return codAsignaturas;
    }

    public int getCantAsignaturaPrerrequisito() {
        return CantAsignaturaPrerrequisito;
    }
    
}
