package Operations;

import model.Authors;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Insert {
    public static void main(String[] args) {
        ODB odb = ODBFactory.open("neodatisServer.test");
        Authors a1 = new Authors("Y6912269R","Luis Huapaya", "Rua Roris 79", 27,"peruana");
        odb.store(a1);
        odb.close();

    }
}
