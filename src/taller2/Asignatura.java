package taller2;

public class Asignatura {
    private int Codigo;
    private String NombreA;
    private int Creditos;

    public Asignatura(int Codigo, String NombreA, int Creditos) {
        this.Codigo = Codigo;
        this.NombreA = NombreA;
        this.Creditos = Creditos;
    }

    public int getCodigo() {
        return Codigo;
    }

    public String getNombreA() {
        return NombreA;
    }

    public int getCreditos() {
        return Creditos;
    }
    
}
