package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.opencsv.CSVWriter;


public class CSVReaderWriter {
    private String filePath;

    public CSVReaderWriter(String filePath) {
        this.filePath = filePath;
    }

    public void write(User user) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath, true))) {
            csvWriter.writeNext(new String[]{user.toString()});

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<User> read() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.replace("\"", "").split("\\s");
                User user = new User(UUID.fromString(parts[0]), parts[1], parts[2], parts[3]);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return users;
    }

    public void deleteAll(){
        try (FileWriter fileWriter = new FileWriter(filePath)) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
