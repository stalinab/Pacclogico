package Framework;

public class PatException extends Exception {

    public PatException(String e, String clase, String metodo) {
        System.out.println("[ERROR EN PoliTinder para el log] " + clase + "." + metodo + " : " + e);
    }
    
}