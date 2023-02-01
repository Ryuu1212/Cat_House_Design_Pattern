package background;

public class BackgroundCatBed implements Background{
     String filepath;
     public BackgroundCatBed() {
         filepath = "/resources/furniture/catbedfront.png";
     }

     @Override
     public String getfilePath() {
         return filepath;
     }
 }