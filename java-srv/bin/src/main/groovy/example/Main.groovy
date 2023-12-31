
package example;

import org.apache.log4j.PropertyConfigurator;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class Main {

  public static void main(String[] args) {
    PropertyConfigurator.configure("log4j.xml");
    final String connectionStr = "jdbc:mysql://db/animal?user=root&password=";

    example.chain.ILink obj = new example.chain.Driver();

    if (obj.hasResource("com.mysql.cj.jdbc.Driver", connectionStr)){
      example.db.print.output.IOutput output = new example.db.print.output.ToConsole();
      for ( String tbl : new String[]{"dog", "breedLookup", "colorLookup", "dog_expanded", "breed_count", "dog_final"})
        example.db.DBQuery.query(connectionStr, tbl, output);
    }
  }
}
