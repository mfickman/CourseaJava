
/**
 * Write a description of WhichCountriesExport here.
 * 
 * @author (Mark Fickman) 
 * @version (3/8/2020)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest){
        //for each row in the CSV File
        for (CSVRecord record: parser){
            //look ath the "Exports" column
            String export = record.get("Exports");
            //Check if the comlumn contains exportOfInterest
            if (export.indexOf(exportOfInterest) != -1){
                //If yes, write down the value in the "Country" column form that row
                String country = record.get("Country");
                System.out.println("The country " + country + " exports " + exportOfInterest);
            
            
            }
        }
    }

//test method
    public void whoExportsCoffee(){
        //test who exports coffee
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
}

}