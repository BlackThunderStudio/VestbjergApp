package com.teamSuperior.guiApp.enums;

/**
 * Created by Domestos Maximus on 29-Nov-16.
 */
public enum ErrorCode {
    CONNECTION_HOSTNAME_EMPTY("Database connection ERROR", "No path to host was specified"),
    CONNECTION_USERNAME_EMPTY("Database connection ERROR", "Username cannot be empty"),
    CONNECTION_PASSWORD_EMPTY("Database connection ERROR", "Password cannot be empty"),
    CONNECTION_TEST_FAILED("Database connection ERROR", "Test Failed"),
    CONNECTION_REG_EMPTY("Connection ERROR", "In order to connect please fill out the configuration first!"),
    VALIDATION_FIELD_EMPTY("Input ERROR", "All fields must be filled properly"),
    VALIDATION_ILLEGAL_CHARS("Input ERROR", "Illegal characters spotted in th input"),
    ACCESS_DENIED_NOT_LOGGED_IN("Access denied", "You need to be logged in to access this function!"),
    ACCESS_DENIED_INSUFFICIENT_PERMISSIONS("Access denied", "You don't have permission to access this function!"),
    NOT_IMPLEMENTED("Sorry", "This functionality is not yet implemented."),
    USER_ALREADY_LOGGED_OUT("Warning", "You are already logged out"),
    LOGIN_EMPTY_INPUT("User validation error", "None of the fields can be empty"),
    LOGIN_USERNAME_EMPTY("User validation error", "Employee ID cannot be empty"),
    LOGIN_PASSWORD_EMPTY("User validation error", "The password field cannot be empty");


    private String errorTitle;
    private String errorMessage;

    ErrorCode(String errorTitle, String errorMessage) {
        this.errorTitle = errorTitle;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorTitle() {
        return errorTitle;
    }
}
