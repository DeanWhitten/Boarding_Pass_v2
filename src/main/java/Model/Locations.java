package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Locations {
    //State,City,Latitude,Longitude  <- order  of each String[]
    private ArrayList<String[]> strLocationArrayList = new ArrayList<>();

    {
        String callFileStr;
        try {
            File callFile = new File("src/main/resources/TextFiles/locations.txt");
            Scanner reader = new Scanner(callFile);
            while (reader.hasNextLine()) {
                callFileStr = reader.nextLine();
                String[] textLine = callFileStr.split(",");
                strLocationArrayList.add(textLine);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Locations(){

    }

    public ArrayList<String> locationNamesList() {
        ArrayList<String> nameList = new ArrayList<>();
        for (String[] strItem : strLocationArrayList){
            String newPlace =   strItem[1] + ", " + strItem[0];
            nameList.add(newPlace);
        }
        Collections.sort(nameList);
        return nameList;
    }

    public double findLocationLAT(String locationName){
        // index 2
        String[] locationNameArr = locationName.split(",");

        double LAT = 0.0;

        for(String[] strItem : strLocationArrayList){
            if(locationNameArr[0].equals(strItem[1])){
                LAT = Double.parseDouble(strItem[2]);
            }
        }
        return LAT;
    }

    public double findLocationLONG(String locationName){
        //index 3
        String[] locationNameArr = locationName.split(",");

        double LONG = 0.0;

        for(String[] strItem : strLocationArrayList){
            if(locationNameArr[0].equals(strItem[1])){
                LONG = Double.parseDouble(strItem[3]);
            }
        }
        return LONG;
    }

}
