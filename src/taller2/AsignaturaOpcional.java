
package taller2;


public class AsignaturaOpcional extends Asignatura{
    private int CreditosPre;

    public AsignaturaOpcional(int Creditos, int Codigo, String NombreA, int CreditosPre) {
        super(Codigo, NombreA, Creditos);
        this.CreditosPre = CreditosPre;
    }

    public int getCreditosPre() {
        return CreditosPre;
    }
    
}
