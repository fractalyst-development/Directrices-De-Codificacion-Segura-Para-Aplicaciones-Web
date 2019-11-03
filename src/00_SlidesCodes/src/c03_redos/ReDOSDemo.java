package c03_redos;



public class ReDOSDemo {

    public static void main(String[] args) {
        String regex = "(a|aa)+";
        String cadena = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//        Regex testPassword = new Regex(userName);
        Boolean estaContenido = regex.matches(cadena);
        if (estaContenido) {
            System.out.println("Do not include name in password.");
        } else {
            System.out.println("Good password.");
        }
    }
}
