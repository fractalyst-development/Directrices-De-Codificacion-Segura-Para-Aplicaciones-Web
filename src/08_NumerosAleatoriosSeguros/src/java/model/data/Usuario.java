package model.data;

public class Usuario {

    private int idUsuario;
    private String nombre;
    private String pwd;
    private boolean escritor;
    private boolean lector;
    private boolean ejecutor;

    public Usuario(int idUsuario, String nombre, String pwd, boolean escritor, boolean lector, boolean ejecutor) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.pwd = pwd;
        this.escritor = escritor;
        this.lector = lector;
        this.ejecutor = ejecutor;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + getIdUsuario() + ", nombre=" + getNombre() + ", escritor=" + isEscritor() + ", lector=" + isLector() + ", ejecutor=" + isEjecutor() + '}';
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return the escritor
     */
    public boolean isEscritor() {
        return escritor;
    }

    /**
     * @param escritor the escritor to set
     */
    public void setEscritor(boolean escritor) {
        this.escritor = escritor;
    }

    /**
     * @return the lector
     */
    public boolean isLector() {
        return lector;
    }

    /**
     * @param lector the lector to set
     */
    public void setLector(boolean lector) {
        this.lector = lector;
    }

    /**
     * @return the ejecutor
     */
    public boolean isEjecutor() {
        return ejecutor;
    }

    /**
     * @param ejecutor the ejecutor to set
     */
    public void setEjecutor(boolean ejecutor) {
        this.ejecutor = ejecutor;
    }

}
