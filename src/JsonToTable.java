import java.util.ArrayList;

public class JsonToTable {
    public JsonToTable(String fileName) {

        JsonTranslateToList massParser = new JsonTranslateToList(fileName);
        // mainList  contains keys as first element of  each ArrayList:  mainList/Arraylist.get(0)/key
        // the following elements in each ArrayList are values;          mainList/Arraylist.get(1-n)/values
        ArrayList<ArrayList> mainList = massParser.getMainList();
// this is the biggest ArrayList. This needs to create table's columns as big as biggest ArrayList otherways it throw exeption.
        int BiggetsArrayList =0;
        for(ArrayList ar: mainList){
            int x = ar.size();
            if(x>BiggetsArrayList){
                BiggetsArrayList = x; }
        }
        //  We use it to concatenate keys
        int sumArraysLength =0;
        for(int i =0;i<mainList.size();i++){
            String[] s = (String[]) mainList.get(i).get(0);
            sumArraysLength += s.length;
        }
        // this is used to get keys and pass it to massKeys
        String[][] keys = new String[mainList.size()][];
        int x = 0;
        //   this is concatenated row. it becomes titles for table
        String[] massKeys = new String[sumArraysLength];

        for (int i = 0; i < mainList.size(); i++) {
            keys[i] = (String[]) mainList.get(i).get(0);
        }

        for (String[] key : keys) {
            for (int i = 0; i < key.length; i++) {
                massKeys[x] = key[i];
                x++;
            }}
//--------------------------------------------------------------------------

        Object[][] valuesList = new Object[BiggetsArrayList-1][];
        Object[][] values = new Object[mainList.size()][];
        int j =0;
        for (int z = 0; z < BiggetsArrayList-1; z++) {
                j++;
            int y = 0;
            //  concatenate row of arrays:
            Object[] massValues = new Object[sumArraysLength];
            for (int i = 0; i < mainList.size(); i++) {

                //  set "null" if element of ArrayList does not exist
                try {
                    values[i] = (Object[]) mainList.get(i).get(j);

                } catch (IndexOutOfBoundsException e){
                    values[i] = new String[values[i].length]; // makes empty space
                }

            }
            for (Object[] value : values) {
                for (int i = 0; i < value.length; i++) {
                    massValues[y] = value[i];

                    y++;
                } }

            valuesList[z] = massValues;
            for (int i = 0; i < mainList.size(); i++) {

            }
        }
            new Table(valuesList ,massKeys);
        }
}


