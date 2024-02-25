import DataAccessComponent.AnimalDAO;
import DataAccessComponent.ClasificacionDAO;
import DataAccessComponent.DTO.AnimalDTO;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        AnimalDAO n = new AnimalDAO();
        AnimalDTO a = new AnimalDTO();
        n.readBy(1);
        a=n.readBy(1);
        System.out.println(a.getHabitat());
    }
}
