import edu.duke.URLResource;
/**
 * Write a description of part4 here.
 * 
 * @author (Mark Fickman) 
 * @version (3/5/2020)
 */
public class part4 {
    //test urlresoucs clss
    public static void main (String[] args){
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String w: ur.lines()){
            System.out.println("WORD: " + w);
            String lower_w = w.toLowerCase();
            int str_index = lower_w.indexOf("youtube.com");
            String my_s = "";
            if (str_index == -1){
                System.out.println("No youtube in the link");
            }
            else{
                str_index = w.indexOf("\"h") + 1;
                my_s = w.substring(str_index, w.lastIndexOf("\">", w.length()));
                System.out.println("The link is: " + my_s);
            }
            
        }
    }
}