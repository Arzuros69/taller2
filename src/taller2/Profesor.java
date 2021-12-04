package taller2;

public class Profesor {
    private String Rut;
    private String CorreoProfesor;
    private String ContraseñaProfesor;
    private int saldo;

    public Profesor(String Rut, String CorreoProfesor, String ContraseñaProfesor, int saldo) {
        this.Rut = Rut;
        this.CorreoProfesor = CorreoProfesor;
        this.ContraseñaProfesor = ContraseñaProfesor;
        this.saldo = saldo;
    }

    public String getRut() {
        return Rut;
    }

    public String getCorreoProfesor() {
        return CorreoProfesor;
    }

    public String getContraseñaProfesor() {
        return ContraseñaProfesor;
    }

    public int getSaldo() {
        return saldo;
    }
    
}
