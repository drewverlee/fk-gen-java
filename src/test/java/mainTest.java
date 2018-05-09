import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.junit.Test;

public class mainTest {

  @Test
  public void test_insert_statments(){
    IFn require = Clojure.var("clojure.core", "require");
    require.invoke(Clojure.read("fk-gen.generate"));
    IFn getSql = Clojure.var("fk-gen.generate", "->sql");
    String args = "{:table :customer_tbl :db-info {:classname \"org.postgres.Driver\"" +
                                                   ":subprotocol \"postgresql\"" +
                                                   ":subname \"//localhost:5437/resolute_cloud_dev\"" +
                                                   ":schema \"public\"" +
                                                   ":password \"postgres\"" +
                                                   ":user \"postgres\"" +
                                                   ":sslfactory \"org.postgresql.ssl.NonValidatingFactory\"}}";

    IFn get = Clojure.var("clojure.core", "get");
    get.invoke(Clojure.read(args), Clojure.read(":table"));
    getSql.invoke(Clojure.read(args));
    String foo = "hi";
  }
}
