package util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.arangodb.entity.BaseDocument;
import com.fasterxml.jackson.databind.ObjectMapper;

import data.Entity;

public class AppUtility {
	private static Random ran = new Random();
	
	public static int Random(int range)
	{
		return (int) Math.round(Math.random() * (range - 1));
	}
	
	public static int RandomRange(int min, int max)
	{
		return min + (int) Math.round(Math.random() * (max - min));
	}
	
	public static String RandomDate(int startYear, int endYear) {
        int day = RandomRange(1, 28);
        int month = RandomRange(1, 12);
        int year = RandomRange(startYear, endYear);
        LocalDate date = LocalDate.of(year, month, day);
        return date.toString();
    }
	
	public static Entity GetRandomEntityFromArray(ArrayList<Entity> array) {
		int i = Random(array.size());		
		return array.get(i);
	}
	
	public static Entity GetRandomEntityFromMutipleArray(Entity exception, ArrayList<Entity>...entities_arr) {      
		int len = entities_arr.length;   
	    int type = Random(len);
	    
	    ArrayList<Entity> entities = entities_arr[type];
	    if (entities.isEmpty())
	    	return null;
	    
	    Entity ret = entities.get(Random(entities.size()));    	
	    return ret;   
	}
	
	public static HashMap ToHashMap(Object object) {
        ObjectMapper oMapper = new ObjectMapper();
        HashMap<String, Object> hmap = oMapper.convertValue(object, HashMap.class);
        return hmap;
    }
	
	public static BaseDocument ToBaseDocument(Object object) {
        HashMap hm = ToHashMap(object);
        BaseDocument document = new BaseDocument();
        
        hm.forEach((key, value) -> {
            if (key.equals("id")) {
				document.setKey((String) value);
			} else {
				document.addAttribute((String) key, value);
			}
        });
        
        return document;
    }
	
	public static ArrayList<BaseDocument> ToBaseDocument(ArrayList<?> objects) {
        ArrayList<BaseDocument> documents = new ArrayList<>();
        
        objects.forEach((object) -> {
            documents.add(ToBaseDocument(object));
        });
        
        return documents;
    }
}
