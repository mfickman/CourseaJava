
/**
 * Write a description of Assignment3 here.
 * 
 * @author (Mark Fickman) 
 * @version (3/8/2020)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class Assignment3 {
    //week 3 country export assignment
    
    //method named tester to create CSVParser
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //each time new test, need to reser parser
        //parser = fr.getCSVParser()
           
        System.out.println("Germany countryInfo");
        String ger_test = countryInfo(parser, "Germany");
        System.out.println(ger_test);
        System.out.println("");
        
        System.out.println("gold and diamonds listExportersTwoProducts test");
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        System.out.println("");
        
        parser = fr.getCSVParser();
        String expItem = "gold";
        System.out.println(expItem + " numberOfExporters test");
        int expCount = numberOfExporters(parser, expItem);
        System.out.println("The number of countries who export " + expItem + " is " + expCount);
        System.out.println("");
        
        parser = fr.getCSVParser();
        String expAmount = "$500,000,000,000";
        System.out.println(expAmount + " bigExporters test");
        bigExporters(parser, expAmount);
        System.out.println("");
        
        
    }
    
    //method neamed country info to list all for particular country
    public String countryInfo(CSVParser parser, String country){
        //get all contries in file
        String country_x = "";
        String export_x = "";
        String value_x = "";
        String result = "";
        for (CSVRecord record: parser){
            String f_country = record.get("Country");
            if (f_country.indexOf(country) != -1){
                country_x = f_country;
                export_x = record.get("Exports");
                value_x = record.get("Value (dollars)");
                result=(country_x + ": " + export_x + ": " + value_x);   
            }
            //if not contained in file return "NOT FOUND"
            if (result == ""){
                result = "NOT FOUND";
            }    
        }
        return result;
    }  
    
    //new method, list countreis that have two passed exports
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        //loop through all exports
        for (CSVRecord record: parser){
            //get exports entry
            String exports = record.get("Exports");
            //check if exports entries contain both strings (&&)
            if ((exports.indexOf(exportItem1) != -1) && (exports.indexOf(exportItem2) != -1)){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    //new method to list of the of countries who export passed item
    public int numberOfExporters(CSVParser parser, String exportItem){
        //intialize count as zero
        int exportCount = 0;
        //loop through all exports
        for (CSVRecord record: parser){
            String exports = record.get("Exports");
            //check if exports contain exportItem
            if (exports.indexOf(exportItem) != -1){
                //iterate count if export contains expoert item
                exportCount++;
            }
        }
        return exportCount;
    }
    
    //new method to print out countries whose value.length() is greater then string.length() passed
    public void bigExporters(CSVParser parser, String amount){
        //loop thorough all values
        for (CSVRecord record: parser){
            
            //check if length is longer than length of passed string
            //System.out.println("amount.length(): " + amount.length());
            //System.out.println("record.get(Value(dollars)): " + record.get("Value (dollars)").length());
            if (amount.length() < (record.get("Value (dollars)")).length()){
                System.out.println(record.get("Country"));
            }   
        }
    }
    
    //call tester
    public void main(String[] args){
        tester();
    }
   
} 
