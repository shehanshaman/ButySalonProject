package validation;

import javax.swing.*;

public class Validation {

    public static void validateNIC(JTextField id) {
        if (!id.getText().matches("[\\d]{0,9}")) {
            id.setText(id.getText().substring(0, (id.getText().length() - 1)));
        }
        if (id.getText().matches("[\\d]{9}")) {
            id.setText(id.getText() + "V");
        }
    }

    public static void validateTelephoneNumber(JTextField id) {
        if (!id.getText().matches("[\\d]{0,10}")) {
            id.setText(id.getText().substring(0, (id.getText().length() - 1)));
        }
    }

    public static void validateQty(JTextField id) {
        if (!id.getText().matches("[\\d]+")) {
            if(id.getText().length()>1){
                id.setText(id.getText().substring(0, (id.getText().length() - 1)));
            }else{
                id.setText(id.getText().substring(0, 0));
            }
            
        }
    }
    public static void validateprice(JTextField id) {
        if (!id.getText().matches("[\\d]+[.]{0,1}[\\d]{0,2}")) {
            if(id.getText().length()>0){
                id.setText(id.getText().substring(0, (id.getText().length() - 1)));
            }else{
                id.setText(id.getText().substring(0, 0));
            }            
        }        
        
    }

    public static void validateName(JTextField id) {
//        try{
//        if (!id.getText().matches("[[\\w]+[ ]*]+")) {
//            id.setText(id.getText().substring(0, (id.getText().length() - 1)));
//        }
//        }catch(StringIndexOutOfBoundsException e){
//            
//        }
    }

    public static void validateLanguage(JTextField id) throws StringIndexOutOfBoundsException {
        if (!id.getText().matches("[A-Z]+[a-z]*")) {
            id.setText(id.getText().substring(0, (id.getText().length() - 1)));
        }
    }
    public static void validatePlace(JTextField id) throws StringIndexOutOfBoundsException {
        if (!id.getText().matches("[A-Z]{1,}[-]{0,1}[\\d]*[/]{0,1}[A-Z]{0,}[-]{0,1}[\\d]*")) {
            id.setText(id.getText().substring(0, (id.getText().length() - 1)));
        }
    }
    public static void validateAddress(JTextArea id) throws StringIndexOutOfBoundsException {
        if (!id.getText().matches("[[a-z]*[\\d]*[A-Z]*[,]{0,1}]*")) {
            id.setText(id.getText().substring(0, (id.getText().length() - 1)));
        }
    }
    public static void validateBirthday(JTextField id) throws StringIndexOutOfBoundsException {
        if (!id.getText().matches("[\\d]{1,4}[-]{0,1}[\\d]{0,2}[-]{0,1}[\\d]{0,2}")) {
            id.setText(id.getText().substring(0, (id.getText().length() - 1)));
        }
    }
    public static void connectionAddress(JTextField id) throws StringIndexOutOfBoundsException {
        if (!id.getText().matches("[\\d]+")) {
            id.setText(id.getText().substring(0, (id.getText().length() - 1)));
        }
    }
}
