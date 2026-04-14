package ec.edu.ups.farmacia.view;

import ec.edu.ups.farmacia.controller.SuplementoController;
import ec.edu.ups.farmacia.dao.SuplementoDAO;
import ec.edu.ups.farmacia.service.JpaService;

import java.util.Scanner;

public class SuplementoView {
    SuplementoController controller = new SuplementoController();
    SuplementoDAO suplementoDAO = new SuplementoDAO();
    Scanner scanner = new Scanner(System.in);

    public void inicializar() {


        int opcion = 0;

            System.out.println("*******************************************");
            System.out.println("                 BIENVENIDO                ");
            System.out.println("*******************************************");

            while(opcion != 6) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Agregar suplementos");
            System.out.println("2. Buscar suplementos por ID");
            System.out.println("3. Listado de suplementos disponibles");
            System.out.println("4. Actualizar suplementos");
            System.out.println("5. Eliminar suplementos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion){
                    case 1:
                        controller.agregarSuplemento(suplementoDAO, scanner);
                        break;
                    case 2:
                        controller.buscarSuplemento(suplementoDAO, scanner);
                        break;
                    case 3:
                        controller.listarSuplementos(suplementoDAO);
                        break;
                    case 4:
                        controller.actualizarSuplemento(suplementoDAO, scanner);
                        break;
                    case 5:
                        controller.eliminarSuplemento(suplementoDAO, scanner);
                        break;
                    case 6:
                        System.out.println("Gracias por usar nuestro sistema");
                        JpaService.close();
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida del menu");
                }
            } catch (NumberFormatException e){
                System.out.println("Ingrese un numero valido");
            } catch (Exception e){
                System.out.println("Error al procesar la solicitud: " + e.getMessage());
            }

        }
            scanner.close();
    }
}
