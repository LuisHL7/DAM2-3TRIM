package exercisexmldb;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeff
 */
public class VerificarDatos {

    public static Logger logger = Logger.getLogger("MyLogger");

    protected static byte leerOpcion() {
        byte option = 0;
        boolean verify;
        Scanner entry = new Scanner(System.in);
        do {
            verify = true;
            if (entry.hasNextByte()) {
                option = entry.nextByte();
                if (option <= 0) {
                    logger.log(Level.SEVERE, "ERROR: Tha value enter is negative. Write a positive number:");
                    verify = false;
                }
            } else {
                logger.log(Level.SEVERE, "ERROR: The value enter is incorrectly. Write a number:");
                verify = false;
            }
            entry.nextLine();
        } while (!verify);
        return option;
    }
    
    public static int leerNumero() {
        int numero = 0;
        boolean verify;
        Scanner entry = new Scanner(System.in);
        do {
            verify = true;
            if (entry.hasNextInt()) {
                numero = entry.nextInt();
                if (numero < 0) {
                    logger.log(Level.SEVERE, "ERROR: The value enter is negative. Write a positive number:");
                    verify = false;
                }
            } else {
                logger.log(Level.SEVERE, "ERROR: Tha value enter is incorrectly. Write a number:");
                verify = false;
            }
            entry.nextLine();
        } while (!verify);
        return numero;
    }
    
    public static String leerString() {
        String world;
        Scanner entry = new Scanner(System.in);
        do {
            world = entry.nextLine();
        } while (world.isEmpty());

        return world;
    }

}
