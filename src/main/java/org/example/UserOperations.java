package org.example;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public class UserOperations {
    private List<User> users;
    CSVReaderWriter csvReaderWriter;

    public UserOperations(String fileName) {
        csvReaderWriter = new CSVReaderWriter(fileName);
        users = csvReaderWriter.read();
    }


    public String save(User user) {
        if(!users.contains(user)){
            csvReaderWriter.write(user);
            return "Added this user";

        }
        return "This user exists";
    }

    public User getUser(String id ){
        User user = users.stream()
                .filter(customer -> customer.getId().toString().equals(id))
                .findFirst()
                .orElse(null);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void deleteAll(){
        users.clear();
        csvReaderWriter.deleteAll();
    }

    public String deleteUser(String value){
        int quantityUser = users.size();
        users = users.stream()
                .filter(user -> (!String.valueOf(user.getId()).equals(value) &&
                       !(user.getFirstName() + " " + user.getLastName() +" " + user.getPatronymic()).equals(value)))
                .collect(Collectors.toList());
        if ( quantityUser == users.size()){
            return "User didn't find ";

        }
        csvReaderWriter.deleteAll();
        users.forEach(user ->  csvReaderWriter.write(user));
        return "User deleted";
    }
}
