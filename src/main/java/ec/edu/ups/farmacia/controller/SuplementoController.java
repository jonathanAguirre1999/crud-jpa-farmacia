package ec.edu.ups.farmacia.controller;

import ec.edu.ups.farmacia.dao.SuplementoDAO;
import ec.edu.ups.farmacia.model.Categoria;
import ec.edu.ups.farmacia.model.DetalleNutricional;
import ec.edu.ups.farmacia.model.Ingrediente;
import ec.edu.ups.farmacia.model.Laboratorio;
import ec.edu.ups.farmacia.model.Suplemento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuplementoController {

    // CREACION DE SUPLEMENTOS
    public void agregarSuplemento(SuplementoDAO dao, Scanner scanner) {
        System.out.println("\n--- Agregar Nuevo Suplemento ---");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Presentación (Ej. Frasco 60 caps): ");
        String presentacion = scanner.nextLine();
        System.out.print("Dosis: ");
        String dosis = scanner.nextLine();

        System.out.print("Stock inicial: ");
        int stock = Integer.parseInt(scanner.nextLine());
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());

        System.out.println("\n--- Asignación de Categoría y Laboratorio ---");
        System.out.print("ID de la Categoría (Ej: 1=Aminoácidos, 2=Vitaminas, 3=Proteínas): ");
        Long idCategoria = Long.parseLong(scanner.nextLine());

        System.out.print("ID del Laboratorio (Ej: 1=God's, 2=Mason, 3=Xtralife, 4=Megalabs): ");
        Long idLaboratorio = Long.parseLong(scanner.nextLine());

        System.out.println("\n--- Detalle Nutricional ---");
        System.out.print("Tamaño de la porción (Ej: 1 scoop, 2 cápsulas): ");
        String porcion = scanner.nextLine();
        System.out.print("Calorías por porción: ");
        int calorias = Integer.parseInt(scanner.nextLine());

        DetalleNutricional detalle = new DetalleNutricional();
        detalle.setTamanioPorcion(porcion);
        detalle.setCalorias(calorias);

        System.out.println("\n--- Ingredientes ---");
        System.out.print("Ingrese los ingredientes separados por coma (Ej: Zinc, Magnesio): ");
        String ingredientesInput = scanner.nextLine();

        List<Ingrediente> listaIngredientes = new ArrayList<>();
        if (!ingredientesInput.trim().isEmpty()) {
            String[] nombresIngredientes = ingredientesInput.split(",");
            for (String nom : nombresIngredientes) {
                Ingrediente ing = new Ingrediente();
                ing.setNombre(nom.trim());
                listaIngredientes.add(ing);
            }
        }

        Suplemento suplemento = new Suplemento();
        suplemento.setNombre(nombre);
        suplemento.setPresentacion(presentacion);
        suplemento.setDosis(dosis);
        suplemento.setStock(stock);
        suplemento.setPrecio(precio);

        Categoria cat = new Categoria();
        cat.setId(idCategoria);
        suplemento.setCategoria(cat);

        Laboratorio lab = new Laboratorio();
        lab.setId(idLaboratorio);
        suplemento.setLaboratorio(lab);

        suplemento.setDetalleNutricional(detalle);
        suplemento.setIngredientes(listaIngredientes);

        dao.crear(suplemento);
        System.out.println("\n¡Suplemento y sus relaciones guardados con éxito!");
    }

    // BUSQUEDAS
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

    // ACTUALIZACION
    public void actualizarSuplemento(SuplementoDAO dao, Scanner scanner) {
        System.out.println("\n--- Actualizar Suplemento ---");
        System.out.print("Ingrese el ID del suplemento a actualizar: ");
        Long id = Long.parseLong(scanner.nextLine());
        Suplemento suplemento = dao.buscarPorId(id);

        if (suplemento != null) {
            System.out.println("Suplemento encontrado: \n" + suplemento.toString());

            System.out.print("Nuevo nombre (dejar en blanco para no cambiar): ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                suplemento.setNombre(nuevoNombre);
            }

            System.out.print("Nueva presentacion (dejar en blanco para no cambiar): ");
            String nuevaPresentacion = scanner.nextLine();
            if (!nuevaPresentacion.isEmpty()) {
                suplemento.setPresentacion(nuevaPresentacion);
            }

            System.out.print("Nueva dosis (dejar en blanco para no cambiar): ");
            String nuevaDosis = scanner.nextLine();
            if (!nuevaDosis.isEmpty()) {
                suplemento.setDosis(nuevaDosis);
            }

            System.out.print("Nuevo ID de laboratorio (dejar en blanco para no cambiar): ");
            String nuevoLabId = scanner.nextLine();
            if (!nuevoLabId.isEmpty()) {
                Laboratorio lab = new Laboratorio();
                lab.setId(Long.parseLong(nuevoLabId));
                suplemento.setLaboratorio(lab);
            }

            System.out.print("Nuevo ID de categoría (dejar en blanco para no cambiar): ");
            String nuevaCatId = scanner.nextLine();
            if (!nuevaCatId.isEmpty()) {
                Categoria cat = new Categoria();
                cat.setId(Long.parseLong(nuevaCatId));
                suplemento.setCategoria(cat);
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

    // ELIMINACION
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

    public void reportePorCategoria(SuplementoDAO dao, Scanner scanner) {
        System.out.println("\n--- Reporte de Suplementos por Categoría ---");
        System.out.print("Ingrese el nombre exacto de la categoría (Ej: Proteínas, Vitaminas y Omegas): ");
        String tipoCategoria = scanner.nextLine();

        List<Suplemento> resultados = dao.obtenerReportePorCategoria(tipoCategoria);

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron suplementos para la categoría: " + tipoCategoria);
        } else {
            System.out.println("Resultados encontrados (" + resultados.size() + "):");
            for (Suplemento sup : resultados) {
                System.out.println("- " + sup.getNombre() + " | Precio: $" + sup.getPrecio() +
                        " | Laboratorio: " + sup.getLaboratorio().getNombre());
            }
        }
    }

    public void estadisticasLaboratorios(SuplementoDAO dao) {
        System.out.println("\n--- Estadísticas por Laboratorio ---");
        List<Object[]> estadisticas = dao.obtenerEstadisticasLaboratorio();

        if (estadisticas.isEmpty()) {
            System.out.println("No hay datos estadísticos disponibles.");
        } else {
            System.out.printf("%-20s | %-15s | %-15s\n", "LABORATORIO", "TOTAL PRODUCTOS", "PRECIO MÁXIMO");
            System.out.println("---------------------------------------------------------------");
            for (Object[] fila : estadisticas) {
                String nombreLab = (String) fila[0];
                Long totalProductos = (Long) fila[1];
                Double precioMax = (Double) fila[2];

                System.out.printf("%-20s | %-15d | $%-14.2f\n", nombreLab, totalProductos, precioMax);
            }
        }
    }

    public void catalogoPaginado(SuplementoDAO dao, Scanner scanner) {
        System.out.println("\n--- Catálogo Paginado de Suplementos ---");
        System.out.print("Ingrese el stock mínimo para filtrar: ");
        int stockMin = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese el número de página que desea ver (Ej: 1, 2...): ");
        int pagina = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese la cantidad de registros por página (Ej: 2, 5...): ");
        int tamano = Integer.parseInt(scanner.nextLine());

        List<Suplemento> catalogo = dao.obtenerCatalogoPaginado(stockMin, pagina, tamano);

        if (catalogo.isEmpty()) {
            System.out.println("No se encontraron resultados en esta página con los filtros aplicados.");
        } else {
            System.out.println("\nMostrando Página " + pagina + " (Stock > " + stockMin + "):");
            for (Suplemento sup : catalogo) {
                System.out.println("- [" + sup.getId() + "] " + sup.getNombre() +
                        " (Stock: " + sup.getStock() + ")");
            }
        }
    }
}