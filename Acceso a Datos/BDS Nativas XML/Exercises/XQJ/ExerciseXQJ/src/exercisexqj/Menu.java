/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercisexqj;

/**
 *
 * @author Jeff
 */
public class Menu {
    public static void menu(){
        byte opcion;
        do {
        System.out.println("1.-Listar los productos.");
        System.out.println("2.-Cantidad de productos con precio mayor a 50 ");
        System.out.println("3.-Cantidad de productos por zona.");
        System.out.println("4.-Mostrar el resulltado a travez de una una consulta ubicada en el fichero.");
        System.out.println("5.-Guardar el resultado de una consulta en un fichero.");
        System.out.println("6.-Mostras productos.xml.");
        System.out.println("7.-Salir");
        System.out.print("Ingrese una opción: ");
        opcion = VerificarDatos.leerOpcion();
            switch (opcion) {
                case 1 -> Operaciones.listarProductos();
                case 2 -> Operaciones.productosConPrecioMayorA50();
                case 3 -> Operaciones.cantidadDeProductosPorZona();
                case 4 -> Operaciones.productoMayoresDe50yZona10();
                case 5 -> Operaciones.guardarConsultaEnFichero();
                case 6 -> Operaciones.mostrarProductos();
                case 7 -> System.out.println("Saliendo de la aplicación");               
            }
        } while (opcion!=7);
    }
    
}
