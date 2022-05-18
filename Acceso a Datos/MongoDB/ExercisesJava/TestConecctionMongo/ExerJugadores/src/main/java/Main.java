import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class Main {
    public static void main(String[] args) {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        try(MongoClient client = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build()){
            insertPlayer();
        } catch () {
        }
    }

    public static void insertPlayer() {
        Jugadores jugadores = new Jugadores().setNombre("Luis");

        Grade newGrade = new Grade().setStudent_id(10003d)
                .setClass_id(10d)
                .setScores(singletonList(new Score().setType("homework").setScore(50d)));
        grades.insertOne(newGrade);
    }
}
