package myFunctionalDetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import static seperator.Seperator.*;

public class FunctionalDetails {

    public boolean addFunctionalDetail(String ip, String port) throws FileNotFoundException, IOException {
        File file = new File("Details.txt");
        file.createNewFile();
        if (file.exists()) {
            String line = IP + SEPERATOR + ip +SEPERATOR+ "\n" + PORT + SEPERATOR + port +SEPERATOR+ "\n";
            FileWriter writer = new FileWriter("Details.txt", true);
            writer.write(line);
            writer.close();
        }
        return searchDetails(ip, port);
    }

    private boolean searchDetails(String ip, String port) throws FileNotFoundException, IOException {
        boolean ipChecked = false, portChecked = false;
        BufferedReader reader = new BufferedReader(new FileReader("Details.txt"));
        String details = "", line;
        while ((line = reader.readLine()) != null) {
            details += line;
        }
        String[] functions = details.split(SEPERATOR);        
        for (int i = 0; i < functions.length; i += 2) {
            if (IP.equals(functions[i])) {
                ipChecked = functions[i + 1].equals(ip);                
            } else if (PORT.equals(functions[i])) {
                portChecked = functions[i + 1].equals(port);                
            } else if (ipChecked && portChecked) {
                break;
            }
        }
        return ipChecked && portChecked;
    }

    public boolean modifyFunctionalDetail(String ip, String port) throws FileNotFoundException, IOException {
        File file = new File("Details.txt");
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader("Details.txt"));
            String details = "", line;
            while ((line = reader.readLine()) != null) {
                details += line;
            }
            String[] functions = details.split(SEPERATOR);            
            for (int i = 0; i < functions.length; i += 2) {
                switch (functions[i]) {
                    case IP:
                        functions[i + 1] = ip;
                        break;
                    case PORT:
                        functions[i + 1] = port;
                        break;
                }
            }
            FileWriter writer=new FileWriter("Details.txt",false);
            writer.write(functions[0] + SEPERATOR + functions[1] +SEPERATOR+ "\n" + functions[2] + SEPERATOR + functions[3] +SEPERATOR+ "\n");
            writer.close();
        } else {
            JOptionPane.showMessageDialog(null, "Database is not found", null, JOptionPane.ERROR_MESSAGE);
        }
        return searchDetails(ip, port);
    }

    public String getIPAddress() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Details.txt"));
        String details = "", line, ip = null;
        while ((line = reader.readLine()) != null) {
            details += line;
        }
        String[] functions = details.split(SEPERATOR);
        for (int i = 0; i < functions.length; i += 2) {
            if (IP.equals(functions[i])) {
                ip = functions[i + 1];
                break;
            }
        }
        return ip;
    }

    public String getPortNumber() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Details.txt"));
        String details = "", line, port = null;
        while ((line = reader.readLine()) != null) {
            details += line;
        }
        String[] functions = details.split(SEPERATOR);
        for (int i = 0; i < functions.length; i += 2) {
            if (PORT.equals(functions[i])) {
                port = functions[i + 1];
                break;
            }
        }
        if (port != null) {
            return port;
        } else {
            return null;
        }
    }


}
