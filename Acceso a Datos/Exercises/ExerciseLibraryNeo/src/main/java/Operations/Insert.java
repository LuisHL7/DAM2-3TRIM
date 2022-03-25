package Operations;

import model.Authors;
import model.Books;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class Insert {
    public static void main(String[] args) {
        ODB odb = ODBFactory.open("neodatisServer.test");
        Authors a1 = new Authors("Y6912269R","Luis Huapaya", "Rua Roris 79", 27,"peruana");
        odb.store(a1);
        odb.close();

    }

    public static void insertAuthor() {
        Authors a = new Authors();
        System.out.println("*******INSERT AUTHOR*******");
        System.out.println("==========================");
        System.out.print("1.-Insert the dni: ");
        a.setDni(VerifyData.readDni());
        System.out.print("2.-Insert the name: ");
        a.setName(VerifyData.readName());
        System.out.print("3.-Insert the address: ");
        a.setAddress(VerifyData.readString());
        System.out.print("4.-Insert the age: ");
        a.setAge(VerifyData.readOptionAndAge());
        System.out.print("5.-Insert the nationality: ");
        a.setNationality(VerifyData.readName());
        addObject(a);
        addBookForAuthor(a);
    }

    private static void addBookForAuthor(Authors a) {
        System.out.println("*******INSERT BOOK FOR A AUTHOR*******");
        System.out.println("==========================");
        System.out.print("Si desea añadir un libro registrado escriba Y si desea añadir un libro nuevo escriba N. (Y/N)");
        if (VerifyData.readAnswer().equals("Y")) {
            String dni;
            System.out.println("==========================");
            System.out.print("1.-Enter the dni the author: ");
            dni = VerifyData.readDni();
        } else {
            insertBook();
        }
    }


    private static void addObject(Object a) {
        ODB odb = ODBFactory.open("neodatisServer.test");
        odb.store(a);
        odb.close();
    }

    public static void insertBook() {
        Books b = new Books();
        System.out.println("*******INSERT BOOK*******");
        System.out.println("==========================");
        System.out.print("1.-Insert the title: ");
        b.setTitle(VerifyData.readName());
        System.out.print("2.-Insert the category: ");
        b.setTitle(VerifyData.readName());
        System.out.print("3.-Insert the price: ");
        b.setPrice(VerifyData.readFloat());
        System.out.print("4.-Insert date published: ");
        b.setDatePublished(VerifyData.readDate());
        addObject(b);
    }
}
