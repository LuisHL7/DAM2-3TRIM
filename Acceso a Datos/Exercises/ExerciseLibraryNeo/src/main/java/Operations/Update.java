package Operations;

import model.Authors;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Update {
    public static void main(String[] args) {
        String dni;
        updateAddressByDni(dni);
    }

    private static void updateAddressByDni(String dni) {
        ODB odb = ODBFactory.open("neodatisServer.test");
        IQuery query = new CriteriaQuery(Authors.class, Where.equal("dni", dni));
        Objects<Authors> objects = odb.getObjects(query);
        Authors a1=(Authors) odb.getObjects(query).getFirst();
        a1.setAddress("My house");
        odb.store(a1);
        odb.close();
    }

}
