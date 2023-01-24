package background;

public class BackgroundA implements Background{
     String filepath;
     public BackgroundA() {
         filepath = "/resources/maps/map01.txt";
     }

     @Override
     public String getfilePath() {
         return filepath;
     }
 }
