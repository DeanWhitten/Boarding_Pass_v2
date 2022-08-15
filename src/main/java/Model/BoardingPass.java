package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BoardingPass {


    private int ticketID;
    private String name;
    private String email;
    private String phoneNum;
    private String gender;
    private int age;

    private LocalDate date;
    private LocalTime departure;
    private String origin;
    private String destination;
    private int duration;
    private LocalTime eta;

    private double basePrice;
    private double ageDiscount;
    private double genderDiscount;
    private double totalPrice;



    public BoardingPass(int ticketID, String name, String email, String  phoneNum, String gender, int age,
                        LocalDate date, LocalTime departure, String origin, String destination, int duration,
                        LocalTime eta, double basePrice, double ageDiscount, double genderDiscount, double totalPrice){
        this.setTicketID(ticketID);
        this.setName(name);
        this.setEmail(email);
        this.setPhoneNum(phoneNum);
        this.setGender(gender);
        this.setAge(age);

        this.setDate(date);
        this.setDeparture(departure);
        this.setOrigin(origin);
        this.setDestination(destination);
        this.setDuration(duration);
        this.setEta(eta);

        this.setBasePrice(basePrice);
        this.setAgeDiscount(ageDiscount);
        this.setGenderDiscount(genderDiscount);
        this.setTotalPrice(totalPrice);
    }

    public BoardingPass() {

    }

    public int getTicketID() {
        return ticketID;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public String getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public LocalDate getDate() {
        return date;
    }
    public LocalTime getDeparture() {
        return departure;
    }
    public String getOrigin() {
        return origin;
    }
    public String getDestination() {
        return destination;
    }
    public int getDuration() {
        return duration;
    }
    public LocalTime getEta() {
        return eta;
    }
    public double getBasePrice() {
        return basePrice;
    }
    public double getAgeDiscount() {
        return ageDiscount;
    }
    public double getGenderDiscount() {
        return genderDiscount;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setDeparture(LocalTime departure) {
        this.departure = departure;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setEta(LocalTime eta) {
        this.eta = eta;
    }
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    public void setAgeDiscount(double ageDiscount) {
        this.ageDiscount = ageDiscount;
    }
    public void setGenderDiscount(double genderDiscount) {
        this.genderDiscount = genderDiscount;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



    public void generateEstimates(String gender, int age, String origin, String destination, LocalTime departure){
       double distance = calculateDistance(origin, destination);
       calculateETA(distance);
       calculatePrice(distance, age, gender);
    }


   //calculates distance in miles
    public double calculateDistance(String origin, String destination){
        Locations locations = new Locations();
        double lat1 = locations.findLocationLAT(origin);
        double lon1 = locations.findLocationLONG(origin);
        double lat2 = locations.findLocationLAT(destination);
        double lon2 = locations.findLocationLONG(destination);

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return dist;
    }
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }


    //calculates ETA based on distance and departure time
    public void calculateETA(Double distance){
        double mph = 500;

        int totalDurInMins = (int) (distance / mph) * 60;
        setDuration(totalDurInMins);

        setEta(getDeparture().minusMinutes(totalDurInMins));
    }

    //calculates price based on distance for the base ticket price and discounts based on gender and age.
    private void calculatePrice(double distance, int age, String gender) {
        double basePrice = .25 * distance;
        setBasePrice(basePrice);

        if(age >= 60){
            setAgeDiscount(getBasePrice() / .60);
            basePrice = basePrice - getAgeDiscount();
        }

        if (age <= 12){
            setAgeDiscount(getBasePrice()/ .5);
            basePrice = basePrice - getAgeDiscount();
        }


        if (gender.equals("Female")){
            setGenderDiscount(basePrice /.25);
        }

        setTotalPrice(getBasePrice() - (getAgeDiscount() + getGenderDiscount()));

    }



}
