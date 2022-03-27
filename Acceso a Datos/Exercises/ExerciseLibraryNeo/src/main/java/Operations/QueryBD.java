package Operations;

import model.Authors;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class QueryBD {
    public static Objects<Authors> queryDni(String dni, ODB odb) {
        return odb.getObjects(new CriteriaQuery(Authors.class, Where.equal("dni", dni)));
    }

    public static Objects<Authors> queryTitleAndAuthor(String title, String name, ODB odb) {
        return odb.getObjects(new CriteriaQuery(Authors.class, new And().add(Where.iequal("name", name)).add(Where.iequal("book.", title))));
    }

    public static Objects<Authors> queryIdAndAuthor(int id, String name, ODB odb) {
        return odb.getObjects(new CriteriaQuery(Authors.class, new And().add(Where.iequal("name", name)).add(Where.equal("id", id))));
    }

    public static Objects<Authors> queryAuthorItalian(ODB odb) {
        return odb.getObjects(new CriteriaQuery(Authors.class, Where.iequal("nationality", "Italiana")));
    }

}
