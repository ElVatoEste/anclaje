package test;

import model.Student;
import service.ImplIDAO;
import service.IDAO;

public class Main{
    public static void main(String[] args) {
        // Create an instance of ImplIDAO
        IDAO dao = new ImplIDAO();

        // Example of using CRUD operations
        Student student = new Student("21011754", "John Doe", "Male", "john.doe@example.com", "password123", "Active", "profile.jpg");
        // Insert
        dao.insert(student);

    }
}