
package taller2;

public interface Sistema {
    public boolean ingresarEstudiante(Estudiantes E);
    public boolean ingresarAsignatura(Asignatura A);
    public boolean ingresarProfesor(Profesor P);
    public boolean ingresarParalelos(Paralelos PA);
    public String IniciarSesion(String correo, String Contraseña);
    public Estudiantes BuscaEstudiantePorCorreo(String correo);
    public Profesor BuscaProfesorPorCorreo(String correo);
    public int CalcularCredito(Estudiantes E);
    public int nivelEstudiante(Estudiantes E);
    public boolean InscribirAsignatura(int Codigo , float num,Estudiantes E);
    public boolean EliminarAsignatura (int Codigo,Estudiantes E);
    public ListaParalelos MostrarParalelosProfesor(Profesor P);
    public ListaEstudiante AñadirAlumnosParalelo(float paralelo, float codigo);
     public boolean IngresarNotaFinal(int codigoAsignatura, String rut, float nota);
     
}
