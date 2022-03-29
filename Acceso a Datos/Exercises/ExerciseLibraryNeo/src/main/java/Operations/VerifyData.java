package Operations;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VerifyData {
    public static Logger logger = Logger.getLogger("MyLogger");

    public static byte readOptionAndAge() {
        byte option = 0;
        boolean verify;
        Scanner entry = new Scanner(System.in);
        do {
            verify = true;
            if (entry.hasNextByte()) {
                option = entry.nextByte();
                if (option <= 0) {
                    logger.log(Level.SEVERE, "ERROR: The value enter is negative. Write a positive number:");
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

    protected static String readName() {
        String name;
        boolean repeat;
        Scanner entry = new Scanner(System.in);
        do {
            repeat = true;
            name = entry.nextLine();
            if (!name.toUpperCase().matches("[A-ZÁÉÍÓÚÜÑ\\s]+")) {
                logger.log(Level.SEVERE, "ERROR: The name entered is incorrect. Enter a valid name:");
                repeat = false;
            }
        } while (!repeat);
        return name;
    }

    protected static String readDni() {
        Scanner entry = new Scanner(System.in);
        String dni;
        boolean repeat = true;
        do {
            dni = entry.nextLine();
            if (dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
                if (verifyDni(dni)) {
                    repeat = false;
                } else {
                    logger.log(Level.SEVERE, "ERROR: The NIF entered is incorrectly.");
                }
            } else {
                logger.log(Level.SEVERE, "ERROR: The NIF entered is incorrectly. E.G.(77777777R).");
            }
        } while (repeat);
        return dni;
    }

    protected static boolean verifyDni(String dni) {
        String letterValid = "TRWAGMYFPDXBNJZSQVHLCKE";
        //If else in a single line
        return letterValid.charAt((Integer.parseInt(dni.substring(0, 8)) % 23)) == dni.charAt(8);
    }

    protected static String readString() {
        String world;
        Scanner entry = new Scanner(System.in);
        do {
            world = entry.nextLine();
        } while (world.isEmpty());

        return world;
    }

    public static double readDouble() {
        double value = 0;
        boolean repeat = true;
        Scanner entry = new Scanner(System.in);
        do {
            if (entry.hasNextDouble()) {
                value = entry.nextDouble();
                if (isPositive(value)) {
                    repeat = false;
                }
            } else {
                logger.log(Level.SEVERE, "ERROR: The value entered not is decimal. Enter a valid value:");
            }
            entry.nextLine();
        } while (repeat);

        return value;
    }

    protected static String readCode() {
        String code;
        boolean repeat;
        Scanner entry = new Scanner(System.in);
        do {
            repeat = true;
            code = entry.nextLine();
            if (!code.toUpperCase().matches("\\d{3}[A-Z]")) {
                logger.log(Level.SEVERE, "ERROR: The code entered is incorrect. Enter a valid code:");
                repeat = false;
            }
        } while (!repeat);
        return code;
    }

    protected static Date readDate() {
        Scanner entry = new Scanner(System.in);
        String dateText;
        Date date = null;
        boolean repeat = true;
        do {
            dateText = entry.nextLine().toUpperCase();
            if (dateText.matches("\\d\\d*/\\d\\d*/\\d\\d\\d\\d")) {
                repeat =false;
                date = convertDate(dateText);
            } else {
                logger.log(Level.SEVERE, "ERROR: The date entered is incorrectly. E.G. dd/MM/yyyy ");
            }
        } while (repeat);
        return date;
    }

    protected static Date convertDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Date.valueOf(LocalDate.parse(date, formatter));
    }

    protected static float readFloat() {
        float value = 0;
        boolean repeat = true;
        Scanner entry = new Scanner(System.in);
        do {
            if (entry.hasNextFloat()) {
                value = entry.nextFloat();
                if (isPositive((double) value)) {
                    repeat = false;
                }
            } else {
                logger.log(Level.SEVERE, "ERROR: The value entered not is decimal. Enter a valid value:");
            }
            entry.nextLine();
        } while (repeat);

        return value;
    }

    protected static boolean isPositive(Double value) {
        boolean positive = true;
        if (value < 0) {
            logger.log(Level.SEVERE, "ERROR: The value entered is less than zero. Enter a positive value:");
            positive = false;
        }
        return positive;
    }

    protected static float readGrade() {
        float grade = 0;
        boolean verify;
        Scanner entry = new Scanner(System.in);
        do {
            verify = true;
            if (entry.hasNextFloat()) {
                grade = entry.nextFloat();
                if (grade <= 0) {
                    logger.log(Level.SEVERE, "ERROR: The value enter is negative. Write a positive number:");
                    verify = false;
                } else if( grade > 10){
                    logger.log(Level.SEVERE, "ERROR: The value is greater than ten. Write a number (0 to 10):");
                    verify = false;
                }
            } else {
                logger.log(Level.SEVERE, "ERROR: Tha value enter is incorrectly. Write a number:");
                verify = false;
            }
            entry.nextLine();
        } while (!verify);
        return grade;
    }

    protected static int readInt() {
        int grade = 0;
        boolean verify;
        Scanner entry = new Scanner(System.in);
        do {
            verify = true;
            if (entry.hasNextInt()) {
                grade = entry.nextInt();
                if (grade < 0) {
                    logger.log(Level.SEVERE, "ERROR: The value enter is negative. Write a positive number:");
                    verify = false;
                } else if( grade > 10){
                    logger.log(Level.SEVERE, "ERROR: The value is greater than ten. Write a number (0 to 10):");
                    verify = false;
                }
            } else {
                logger.log(Level.SEVERE, "ERROR: Tha value enter is incorrectly. Write a number:");
                verify = false;
            }
            entry.nextLine();
        } while (!verify);
        return grade;
    }

    public static String readAnswer() {
        Scanner verify = new Scanner(System.in);
        String option;
        boolean repeat;
        do {
            repeat = false;
            option = verify.nextLine();
            if (!option.toUpperCase().matches("[YN]")) {
                repeat = true;
                logger.log(Level.SEVERE, "ERROR: Please, Enter the option correctly [Y o N]: ");
            }
        } while (repeat);
        return option;

    }
}

