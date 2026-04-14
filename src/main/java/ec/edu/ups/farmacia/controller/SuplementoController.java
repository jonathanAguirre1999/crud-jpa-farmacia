package ec.edu.ups.farmacia.controller;

import ec.edu.ups.farmacia.dao.SuplementoDAO;
import ec.edu.ups.farmacia.model.Suplemento;

import java.util.List;
import java.util.Scanner;

public class SuplementoController {

    //CREACION DE SUPLEMENTOS
    public void agregarSuplemento(SuplementoDAO dao, Scanner scanner) {
        System.out.println("\n--- Agregar Suplemento ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Presentación: ");
        String presentacion = scanner.nextLine();
        System.out.print("Dosis: ");
        String dosis = scanner.nextLine();
        System.out.print("Laboratorio: ");
        String lab = scanner.nextLine();
        System.out.print("Stock inicial: ");
        int stock = Integer.parseInt(scanner.nextLine());
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());

        Suplemento suplemento = new Suplemento(nombre, presentacion, dosis, lab, stock, precio);

        dao.crear(suplemento);
    }

    //BUSQUEDAS
    public void buscarSuplemento(SuplementoDAO dao, Scanner scanner) {
        System.out.println("\n--- Buscar Suplemento ---");
        System.out.print("Ingrese el ID del suplemento: ");
        long id = Long.parseLong(scanner.nextLine());
        Suplemento suplemento = dao.buscarPorId(id);

        if (suplemento != null) {
            System.out.println("Suplemento encontrado: \n" + suplemento.toString());
        } else {
            System.out.println("Suplemento no encontrado");
        }
    }

    public void listarSuplementos(SuplementoDAO dao) {
        System.out.println("\n--- Listado de Suplementos ---");
        List<Suplemento> suplementos = dao.obtenerTodos();
        if (suplementos.isEmpty()) {
            System.out.println("No hay suplementos disponibles");
        } else {
            for (Suplemento suplemento : suplementos) {
                System.out.println(suplemento.toString());
            }
        }
    }

    //ACTUALIZACION
    public void actualizarSuplemento(SuplementoDAO dao, Scanner scanner) {
        System.out.println("\n--- Actualizar Suplemento ---");
        System.out.println("Ingrese el ID del suplemento a actualizar: ");
        Long id = Long.parseLong(scanner.nextLine());
        Suplemento suplemento = dao.buscarPorId(id);
        if (suplemento != null) {
            System.out.println("Suplemento encontrado: \n" + suplemento.toString());

            System.out.print("Nuevo nombre (dejar en blanco para no cambiar): ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                suplemento.setNombre(nuevoNombre);
            }

            System.out.println("Nueva presentacion (dejar en blanco para no cambiar): ");
            String nuevaPresentacion = scanner.nextLine();
            if (!nuevaPresentacion.isEmpty()) {
                suplemento.setPresentacion(nuevaPresentacion);
            }

            System.out.println("Nueva dosis (dejar en blanco para no cambiar): ");
            String nuevaDosis = scanner.nextLine();
            if (!nuevaDosis.isEmpty()) {
                suplemento.setDosis(nuevaDosis);
            }

            System.out.println("Nuevo laboratorio (dejar en blanco para no cambiar): ");
            String nuevoLaboratorio = scanner.nextLine();
            if (!nuevoLaboratorio.isEmpty()) {
                suplemento.setLaboratorio(nuevoLaboratorio);
            }

            System.out.print("Nuevo stock (dejar en blanco para no cambiar): ");
            String nuevoStock = scanner.nextLine();
            if (!nuevoStock.isEmpty()) {
                suplemento.setStock(Integer.parseInt(nuevoStock));
            }

            System.out.print("Nuevo precio (dejar en blanco para no cambiar): ");
            String nuevoPrecio = scanner.nextLine();
            if (!nuevoPrecio.isEmpty()) {
                suplemento.setPrecio(Double.parseDouble(nuevoPrecio));
            }

            System.out.println("Datos actualizados correctamente");
            dao.actualizar(suplemento);
        } else {
            System.out.println("Suplemento no encontrado");
        }
    }

    //ELIMINACION
    public void eliminarSuplemento(SuplementoDAO dao, Scanner scanner) {
        System.out.println("\n--- Eliminar Suplemento ---");
        System.out.print("Ingrese el ID del suplemento a eliminar: ");
        Long id = Long.parseLong(scanner.nextLine());
        if (dao.buscarPorId(id) != null) {
            dao.eliminar(id);
            System.out.println("Suplemento eliminado correctamente");
        } else {
            System.out.println("Suplemento no encontrado");
        }
    }
}
