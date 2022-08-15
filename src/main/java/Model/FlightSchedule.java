package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FlightSchedule {
    private static ObservableList<BoardingPass> allBoardingPasses = FXCollections.observableArrayList();
    public static ObservableList<BoardingPass> getAllBoardingPasses() {
        return allBoardingPasses;
    }

    public static void addBoardingPass(BoardingPass boardingPass){
        allBoardingPasses.add(boardingPass);
    }

    public static BoardingPass lookupBoardingPass(int passID){
        BoardingPass boadingPassFound = null;

        for(BoardingPass pass : allBoardingPasses){
            if(pass.getTicketID() == passID){
                boadingPassFound = pass;
            }
        }

        return boadingPassFound;
    }

    public static ObservableList<BoardingPass> lookupBoardingPass(String passName){
        ObservableList<BoardingPass> passFound = FXCollections.observableArrayList();
        passFound.clear();
        for(BoardingPass pass: allBoardingPasses){
            if(pass.getName().toLowerCase().contains(passName.toLowerCase())){
                passFound.add(pass);
            }
        }
        return passFound;
    }

    public static boolean cancelFlight(BoardingPass passSelected){
        if(allBoardingPasses.contains(passSelected)){
            allBoardingPasses.remove(passSelected);
            return true;
        }else{
            return false;
        }
    }
}
