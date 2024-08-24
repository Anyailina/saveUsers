package org.example;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String path = "/Users/anailina/Documents/education/projects/saveUsers/src/main/java/org/example/users.csv";
        UserOperations userOperations = new UserOperations(path);
        enter(userOperations);



    }
    private static   void enter(UserOperations userOperations){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Enter command");
            System.out.println(Command.SAVE + "," + Command.PRINT_USER
                    +"," + Command.DELETE_ALL + "," + Command.PRINT_ALL + "," + Command.DELETE + "," + Command.EXIT);
            try{
                Command command = Command.valueOf(scanner.nextLine());
                switch (command){
                    case  SAVE:
                        System.out.println(saveCommand(scanner,userOperations));
                        break;
                    case PRINT_USER:
                        System.out.println(printUserCommand(scanner,userOperations));
                        break;
                    case DELETE_ALL:
                        userOperations.deleteAll();
                        System.out.println("All users deleted");
                        break;
                    case PRINT_ALL:
                        userOperations.getAllUsers().forEach(System.out::println);
                        break;
                    case DELETE:
                        deleteCommand(scanner,userOperations);
                        break;
                    case EXIT:
                        flag = false;
                        System.out.println("Bye Bye");
                        break;
                }
            }
            catch (IllegalArgumentException e){
                System.out.println("Wrong command");
            }


        }
    }
    private static String saveCommand(Scanner scanner, UserOperations userOperations){
        String firstName,lastName,patronymic,line;
        System.out.println("Enter firstName, lastName, patronymic");
        line = scanner.nextLine();
        String[] array = line.split(" ");
        if(array.length == 3){
            firstName  = array[0];
            lastName = array[1];
            patronymic = array[2];
            return userOperations.save(new User(firstName,lastName,patronymic));
        }
        return "Data is not correct";

    }
    private static String printUserCommand(Scanner scanner,UserOperations userOperations){
        String id;
        id =scanner.nextLine();
        if(  userOperations.getUser(id) == null){
            return "User is not found";
        }
        return  userOperations.getUser(id).toString();
    }
    private static void deleteCommand(Scanner scanner, UserOperations userOperations){
        String line;
        line = scanner.nextLine();
        System.out.println(userOperations.deleteUser(line));
    }


}