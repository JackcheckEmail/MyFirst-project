import java.util.ArrayList;
import java.util.Collections;

class Formulas {
    private int distance =11799;
public void setDistance(int distance){
    this.distance =distance;
}
    public int getDistance() {
        return distance;
    }

    public int findAvarageTime(ArrayList<Integer> flights ){
        int avarageTime = 0;
        for(int fly:flights){
             // calculates average value
            avarageTime+=distance/fly;
        }
        return avarageTime/flights.size();
       }


    public int findProcental(ArrayList<Integer> flights){

        Collections.sort(flights);
        // calculate procentel
        double n = 0.9* flights.size();
        int ans = (int)n;
        return flights.get(ans-1);
    }}