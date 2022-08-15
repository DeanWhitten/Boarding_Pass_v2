module com.deanwhitten.boarding_pass_v2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.deanwhitten.boarding_pass_v2 to javafx.fxml;
    opens Model to javafx.fxml;
    exports com.deanwhitten.boarding_pass_v2;
    exports Model;
}