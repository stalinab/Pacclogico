import java.util.List;

import DataAccessComponent.AnimalDAO;
import DataAccessComponent.ClasificacionDAO;
import DataAccessComponent.DTO.AnimalDTO;
import UserInterface.Form.SplashScreenForm;
<<<<<<< HEAD
import UserInterface.Form.MainForm;
=======

>>>>>>> b050ea316e3c3beb1f6f8bc654c5878a809e0e7b
public class App {
    public static void main(String[] args) throws Exception {
        try {
            //Metodo para visualizar el SplashScreen
            SplashScreenForm.show();
            
            // Supongamos que tienes una instancia de la clase donde se encuentra el método readAllEstructura
            // y que su nombre es AnimalDAO. Reemplaza AnimalDAO con el nombre correcto de tu clase si es diferente.
            AnimalDAO animalDAO = new AnimalDAO();
        
            // Llamamos al método readAllEstructura con el tipo de hábitat "Selva"
            List<AnimalDTO> listaAnimalesSelva = animalDAO.readAllEstructura("Seva");
        
            // Imprimimos los resultados
            for (AnimalDTO animal : listaAnimalesSelva) {
                System.out.println("ID: " + animal.getIdAnimal());
                System.out.println("Sexo: " + animal.getSexo());
                System.out.println("Habitat: " + animal.getHabitat());
                System.out.println("Clasificacion: " + animal.getClasificacion());
                System.out.println("Nombre: " + animal.getNombre());
                System.out.println("QR: " + animal.getQr());
                System.out.println("--------------------");
            }
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
        }
<<<<<<< HEAD
        MainForm  mf = new MainForm("APP");
=======
>>>>>>> b050ea316e3c3beb1f6f8bc654c5878a809e0e7b
    }
}
