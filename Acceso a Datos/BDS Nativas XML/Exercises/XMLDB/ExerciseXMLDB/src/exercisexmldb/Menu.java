package exercisexmldb;

/**
 *
 * @author Jeff
 */
public class Menu {
    public static void menu()throws Exception{
        byte opcion = VerificarDatos.leerOpcion();
        do {
        System.out.println("1.-Listar todos los departamentos.");
        System.out.println("2.-Insertar un departamento ");
        System.out.println("3.-Consultar un departamento.");
        System.out.println("4.-Modificar un departamento.");
        System.out.println("5.-Borrar un departamento.");
        System.out.println("6.-Salir");
            switch (opcion) {
                case 1 -> Operaciones.listarTodosLosDepartamentos();
                case 2 -> Operaciones.insertarDepartamento();
                case 3 -> Operaciones.consultarDepartamento();
                case 4 -> Operaciones.modificarDepartamento();
                case 5 -> Operaciones.eliminarDepartamento();
                case 6 -> System.out.println("Saliendo de la aplicación.");               
            }
        } while (opcion!=6);
    }
}
