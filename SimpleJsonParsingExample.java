
package simplejsonparsingexample;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SimpleJsonParsingExample {

    public static void main(String[] args) {
        try {
            URLConnection url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Mumbai,India").openConnection();
            InputStream is = url.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(isr);
            JSONObject jsonObject = (JSONObject) obj;
            
            JSONObject coordObj1 = (JSONObject) jsonObject.get("coord");        
            Double lon=(Double) coordObj1.get("lon");      
            Double lat=(Double) coordObj1.get("lat");
            System.out.println("Longitude :"+lon+", Latitude :"+lat);
                           
            JSONObject sysobj = (JSONObject) jsonObject.get("sys");              
            String country= (String) sysobj.get("country");          
            Long sunrise=(Long) sysobj.get("sunrise");            
            Long sunset=(Long) sysobj.get("sunset");
            System.out.println("Country :"+country+",      Sunrise :"+sunrise+",      Sunset :"+sunset);
       
            JSONArray mJsonArray =(JSONArray) jsonObject.get("weather") ;
            JSONObject mJsonObject = new JSONObject();
            for (int i = 0; i < mJsonArray.size(); i++) {
                        mJsonObject = (JSONObject) mJsonArray.get(i);
                        Long id = (Long) mJsonObject.get("id");
                        String main = (String) mJsonObject.get("main");
                        String description = (String) mJsonObject.get("description");
                        String icon = (String) mJsonObject.get("icon");
                        System.out.println("Weather_ID :"+id+",        Weather_Main :"+main+",        Weather_Description :"+description+",         Weather_Icon :"+icon);
            }             
            String base = (String) jsonObject.get("base");
            System.out.println("Base :"+base);
                   
            JSONObject mainobj = (JSONObject) jsonObject.get("main");
            Double temp=(Double) mainobj.get("temp");       
            Long humidity1 =(Long) mainobj.get("humidity");    
            Double pressure1 =(Double) mainobj.get("pressure");      
            Double temp_min=(Double) mainobj.get("temp_min");    
            Double temp_max=(Double) mainobj.get("temp_max");
            System.out.println("Temperature :"+temp+",       Humidity :"+humidity1+",        Pressure :"+pressure1+",        Temperature_min :"+temp_min+",         Temperature_max :"+temp_max);
           
            JSONObject windobj = (JSONObject) jsonObject.get("wind");               
            Double speed=(Double) windobj.get("speed");                
            Double deg=(Double) windobj.get("deg");
            System.out.println("Speed :"+speed+",          Degrees :"+deg);
            
            JSONObject cloudsobj = (JSONObject) jsonObject.get("cloud");                
            Long all=(Long) windobj.get("all");
            System.out.println("All :"+all);
            
            Long dt = (Long) jsonObject.get("dt");
            System.out.println("dt :"+dt);
              
            Long id = (Long) jsonObject.get("id");
            System.out.println("ID :"+id);
                
            String name = (String) jsonObject.get("name");
            System.out.println("Name :"+name);
             
            Long cod = (Long) jsonObject.get("cod");
            System.out.println("Cod :"+cod);
        } catch (ParseException ex) {
            Logger.getLogger(SimpleJsonParsingExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SimpleJsonParsingExample.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
}
