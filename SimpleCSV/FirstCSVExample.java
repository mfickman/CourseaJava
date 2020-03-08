
/**
 * Write a description of FirstCSVExample here.
 * 
 * @author (Mark Fickman) 
 * @version (3/8/2020)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class FirstCSVExample {
    public void readFood(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record: parser){
            System.out.println(record.get("Name"));
        }
    }
    
}
