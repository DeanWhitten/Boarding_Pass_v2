package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BoardingPass {


    private int ticketID;
    private LocalDate date;
    private Locations origin;
    private Locations destination;
    private LocalTime eta;
    private LocalTime departure;

    private String name;
    private String email;
    private String phoneNum;
    private String gender;
    private int age;

    private double ticketPrice;

    public BoardingPass(int ticketID, LocalDate date, Locations origin, Locations destination, LocalTime eta,
                        LocalTime departure, String name, String email, String phoneNum, String gender, int age,
                        double ticketPrice){
        this.setTicketID(ticketID);
        this.setDate(date);
        this.setOrigin(origin);
        this.setDestination(destination);
        this.setEta(eta);
        this.setDeparture(departure);

        this.setName(name);
        this.setEmail(email);
        this.setPhoneNum(phoneNum);
        this.setGender(gender);
        this.setAge(age);

        this.setTicketPrice(ticketPrice);
    }


    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Locations getOrigin() {
        return origin;
    }

    public void setOrigin(Locations origin) {
        this.origin = origin;
    }

    public Locations getDestination() {
        return destination;
    }

    public void setDestination(Locations destination) {
        this.destination = destination;
    }

    public LocalTime getEta() {
        return eta;
    }

    public void setEta(LocalTime eta) {
        this.eta = eta;
    }

    public LocalTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void generateEstimates(String gender, int age, Locations origin, Locations destination, LocalTime departure){
       Double distance = calculateDistance(origin, destination);
       LocalTime eta = calculateETA(distance, departure);
       Double ticketPrice = calculatePrice(distance, age, gender);

       setEta(eta);
       setTicketPrice(ticketPrice);

    }


   //calculates distance in miles
    private Double calculateDistance(Locations origin, Locations destination) {
        double distance = 0;

        return distance;
    }

    //calculates ETA based on distance and departure
    public LocalTime calculateETA(Double distance, LocalTime departure){
        LocalTime eta = null;

        return null;
    }

    //calculates price based on distance for the base ticket price and discounts based on gender and age.
    private Double calculatePrice(Double distance, int age, String gender) {
        Double price = 0.00;

        return price;
    }
}
