
package taller2;


public class Estudiantes {
    private String rut;
    private String correo;
    private int nivel;
    private String contraseña;
    private float[] Lista;
    private int cantAsignatura;
    private float[] ListaAsignaturas;

    public Estudiantes(String rut, String correo, int nivel, String contraseña,int cantAsignatura, float[] Lista, float[] ListaAsignaturas) {
        this.rut = rut;
        this.correo = correo;
        this.nivel = nivel;
        this.contraseña = contraseña;
        this.cantAsignatura=cantAsignatura;
        this.Lista= Lista;
        this.ListaAsignaturas = ListaAsignaturas;
       
        
    }

    public float[] getListaAsignaturas() {
        return ListaAsignaturas;
    }

    public void setListaAsignaturas(float[] ListaAsignaturas) {
        this.ListaAsignaturas = ListaAsignaturas;
    }
   
    
    public void setCantAsignatura(int cantAsignatura) {
        this.cantAsignatura = cantAsignatura;
    }

    public float[] getLista() {
        return Lista;
    }

    public int getCantAsignatura() {
        return cantAsignatura;
    }

    public String getRut() {
        return rut;
    }

    public String getCorreo() {
        return correo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    

    public String getContraseña() {
        return contraseña;
    }
    
}
