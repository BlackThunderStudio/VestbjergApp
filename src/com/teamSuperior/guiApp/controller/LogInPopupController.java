package com.teamSuperior.guiApp.controller;

import com.teamSuperior.core.connection.DBConnect;
import com.teamSuperior.core.model.entity.Employee;
import com.teamSuperior.guiApp.GUI.AlertBox;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

import static com.teamSuperior.guiApp.GUI.Error.*;
import static com.teamSuperior.guiApp.GUI.ErrorCode.*;

/**
 * Created by Domestos Maximus on 28-Nov-16.
 */
public class LogInPopupController {
    public Button btn_logIn;
    public Button btn_cancel;
    public PasswordField txt_empPassw;
    public TextField txt_empID;
    private Employee loggedUser;

    public void btn_logIn_click(ActionEvent actionEvent) {
        //TODO: write an enum for error codes
        removeRed(txt_empID);
        removeRed(txt_empPassw);

        //validating user input
        //TODO: changing textField outline doesn't work
        validateInput(txt_empID, txt_empPassw);

        //handling the input
        //TODO: log in the user
        boolean isValid = validateUser(txt_empID.getText(), txt_empPassw.getText());
    }

    public void btn_cancel_click(ActionEvent actionEvent) {
        //TODO: close the window
        AlertBox.display("Warning", "You need to log in if you want to use this application!");
    }

    private boolean validateInput(TextField user, TextField pass){
        if(user.getText().isEmpty() && pass.getText().isEmpty()){
            displayError(LOGIN_EMPTY_INPUT);
            setRed(user);
            setRed(pass);
            return false;
        }
        else if(user.getText().isEmpty()){
            displayError(LOGIN_USERNAME_EMPTY);
            return false;
        }
        else if(pass.getText().isEmpty()){
            displayError(LOGIN_PASSW_EMPTY);
            return false;
        }
        else return true;
    }

    private void setRed(TextField tf) {
        ObservableList<String> styleClass = tf.getStyleClass();

        if(!styleClass.contains("tferror")) {
            styleClass.add("tferror");
        }
    }


    private void removeRed(TextField tf) {
        ObservableList<String> styleClass = tf.getStyleClass();
        styleClass.removeAll(Collections.singleton("tferror"));
    }

    private boolean validateUser(String username, String password) {
        DBConnect conn = new DBConnect();
        ResultSet rs = null;
        boolean ret = false;
        rs = conn.getFromDataBase("SELECT * FROM employees WHERE email ='"+username+"' AND password = '"+password+"'");
        try
        {
            rs.next();
            if(rs.getInt("id") != 0 && rs.getString("name") != null
                    && rs.getString("surname") != null
                    && rs.getString("address") != null
                    && rs.getString("city") != null
                    && rs.getString("zip") != null
                    && rs.getString("email") != null
                    && rs.getString("phone") != null
                    && rs.getString("password") != null
                    && rs.getString("position") != null
                    && rs.getInt("accessLevel") >= 1
                    )
            {
                loggedUser = new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("address"), rs.getString("city"), rs.getString("zip"), rs.getString("email"), rs.getString("phone"), rs.getString("password"), rs.getString("position"), rs.getInt("numberOfSales"), rs.getDouble("totalRevenue"), rs.getInt("accessLevel"));
                ret = true;
            }
            else
            {
                ret = false;
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            AlertBox.display("Connection Error", ex.getMessage());
        }

        return ret;
    }

    public Employee getUser()
    {
        return loggedUser;
    }
}
