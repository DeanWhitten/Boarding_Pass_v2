package Model;

import java.util.ArrayList;

public class DepartureSchedule {
    private ArrayList<String> departureTimes = new ArrayList<>();


    {
        /*
        results in 24 hour international time
        with 30 min intervals
        00.00 - 24:30
        */

        for(int h = 0; h <= 24 ; h++){
            if(h <= 24){
                int m = 0;
                while(m != 60){
                    if(m == 0){
                        departureTimes.add(h +  ":" + m +"0");
                    }else{
                        departureTimes.add(h +  ":" + m);
                    }
                    m += 30;
                }
            }
        }
    }

    public DepartureSchedule(){
    }

    public ArrayList<String> listOfDepartureTimes(){
        return departureTimes;
    }
}
