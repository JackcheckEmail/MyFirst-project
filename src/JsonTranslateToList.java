import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class JsonTranslateToList {

    private ArrayList<ArrayList> MainList;

    JsonTranslateToList(String fileName) {
        MainList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONArray a = null;
        try {
            // read JSON file
            a = (JSONArray) parser.parse(new FileReader(fileName));
        } catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Object[][] arMass = new Object[a.size()][];
        String[][]strKeys = new String[a.size()][];
        int i = 0;

        for (Object o : a){
            JSONObject jsonObject = (JSONObject) o;

            Set keys = jsonObject.keySet();

            strKeys[i] =(String[]) keys.toArray(new String[0]);

            Collection<Object[]> JsonValues = jsonObject.values();

            arMass[i] = JsonValues.toArray();
            i++;
        }
        method(MainList, strKeys,arMass);
    }
    // adds elements to MainList. MainList contains ArrayLists. Each ArrayList contains  unique key as first element and its values as following elements
    public void method(ArrayList<ArrayList> MainList , String[][] keys ,Object[][]values){
        // create ArrayList if there is no ArrayLists and add first key and first value to it
        if(MainList.isEmpty()){
            MainList.add(new ArrayList());
            MainList.get(0).add(keys[0]);
            MainList.get(0).add(values[0]);
        }
        for(int i = 1; i< keys.length;i++){
            for(int j =0; j<MainList.size();j++){
                    // if existing ArrayList have key add value to it
                if(Arrays.equals((String[])MainList.get(j).get(0), keys[i])){
                    MainList.get(j).add(values[i]);

                    break;
                }
                // otherwise create new ArrayList, add key and value to it
                if(j==MainList.size()-1){
                    MainList.add(new ArrayList());
                    MainList.get(j+1).add(keys[i]);
                    MainList.get(j+1).add(values[i]);

                    break;}
            } }

    }
    public ArrayList getMainList(){return MainList;};
}
