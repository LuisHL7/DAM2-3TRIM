package model;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class QueryBD {
    public static Objects<Customer> queryDni(String dni, ODB odb) {
        return odb.getObjects(new CriteriaQuery(Customer.class, Where.equal("dni", dni)));
    }

//    public static Objects<Customer> queryDni(int number, ODB odb) {
//        return odb.getObjects(new CriteriaQuery(Customer.class, Where.equal("number", number)));
//    }
//
//    public static Objects<Authors> queryTitleAndAuthor(String title, String name, ODB odb) {
//        return odb.getObjects(new CriteriaQuery(Authors.class, new And().add(Where.iequal("name", name)).add(Where.iequal("book.", title))));
//    }
//
//    public static Objects<Authors> queryIdAndAuthor(int id, String name, ODB odb) {
//        return odb.getObjects(new CriteriaQuery(Authors.class, new And().add(Where.iequal("name", name)).add(Where.equal("id", id))));
//    }
//
//    public static Objects<Authors> queryAuthorItalian(ODB odb) {
//        return odb.getObjects(new CriteriaQuery(Authors.class, Where.iequal("nationality", "Italian")));
//    }
//
//    public static Objects<Authors> queryAuthorSpanish(ODB odb) {
//        return odb.getObjects(new CriteriaQuery(Authors.class, new And().add(Where.iequal("nationality", "Spanish")).add(Where.lt("age", 60))));
//    }
//
//    public static Values queryNumberOfAuthorsByCountry(ODB odb) {
//        return odb.getValues(new ValuesCriteriaQuery(Authors.class, Where.isNotNull("nationality")).field("nationality").count("dni").groupBy("nationality"));
//    }
//
    public static Objects<Customer> queryCustomerName(ODB odb, String name) {
        return odb.getObjects(new CriteriaQuery(Customer.class, Where.iequal("name", name)));
    }

    public static Objects<Customer> queryCustomerNameWithC(ODB odb) {
        return odb.getObjects(new CriteriaQuery(Customer.class, Where.like("name","C%")));
    }

    public static Objects<Customer> queryDataCustomer(ODB odb) {
        return odb.getObjects(Customer.class);
    }

}
