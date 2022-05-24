package exercisexmldb;

/**
 *
 * @author Jeff
 */
public class Menu {
    public static void menuPrincipal()throws Exception{
       
        byte opcion;
        do {
        System.out.println("1.-Listar todos los empleados que sean del departamento 10.");
        System.out.println("2.-Mostrar las colecciones hijas.");
        System.out.println("3.-Mostrar los ficheros de las colecciones hijas.");
        System.out.println("4.-Crear una colección y añadir un fichero.");
        System.out.println("5.-Borrar una colección.");
        System.out.println("6.-Borrar un fichero.");
        System.out.println("7.-Añadir 10 en el stock actual de los productos");
        System.out.println("8.-Leer el contenido de un fichero y generar otro fichero con su contenido.");
        System.out.println("9.-Crear un fichero, escribir en el una consulta y ejecutar esa consulta desde el fichero.");
        System.out.println("10.-Submenu");
        System.out.println("11.-Salir");
        System.out.print("Ingrese una opción: ");
        opcion  = VerificarDatos.leerOpcion();
            switch (opcion) {
                case 1 -> Operaciones.empleadosDepartamento10();
                case 2 -> Operaciones.verColecciones();
                case 3 -> Operaciones.verRecursosdeColecciones();
                case 4 -> Operaciones.crearColeccionYSubirFichero();
                case 5 -> Operaciones.borrarColeccion();
                case 6 -> Operaciones.borrarFichero();
                case 7 -> Operaciones.modificarProductos();
                case 8 -> Operaciones.bajarDocumento();
                case 9 -> Operaciones.ejecutarConsultaFichero();
                case 10 -> menu();
                case 11 -> System.out.println("Saliendo de la aplicación.");               
            }
        } while (opcion!=11);
    }
    
    public static void menu()throws Exception{
        byte opcion;
        do {
        System.out.println("1.-Listar todos los departamentos.");
        System.out.println("2.-Insertar un departamento ");
        System.out.println("3.-Consultar un departamento.");
        System.out.println("4.-Modificar un departamento.");
        System.out.println("5.-Borrar un departamento.");
        System.out.println("6.-Salir");
        System.out.print("Ingrese una opción: ");
        opcion = VerificarDatos.leerOpcion();
            switch (opcion) {
                case 1 -> Operaciones.listarTodosLosDepartamentos();
                case 2 -> Operaciones.insertarDepartamento();
                case 3 -> Operaciones.consultarDepartamento();
                case 4 -> Operaciones.modificarDepartamento();
                case 5 -> Operaciones.eliminarDepartamento();
                case 6 -> System.out.println("Saliendo del submenu.");               
            }
        } while (opcion!=6);
    }
}
