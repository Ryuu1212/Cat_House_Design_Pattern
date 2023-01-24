package background;

public class BackgroundB implements Background{
     String filepath;
     public BackgroundB() {
         filepath = "/resources/maps/map02.txt";
     }

     @Override
     public String getfilePath() {
         return filepath;
     }
}
