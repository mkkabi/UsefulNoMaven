package DesignPatterns_Pluralsight.behavioral.memento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MementoEverydayDemo {

    private static Employee deserialize() {
        Employee emp = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/Resources/employeeFromDesignPatterns.ser"));) {
//            FileInputStream fileIn = new FileInputStream("src/Resources/employeeFromDesignPatterns.ser");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
            emp = (Employee) in.readObject();
//            in.close();
//            fileIn.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return emp;
    }

    private static void serialize(Employee emp) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/Resources/employeeFromDesignPatterns.ser"));) {
//            FileOutputStream fileOut = new FileOutputStream("src/Resources/employeeFromDesignPatterns.ser");
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
//            out.close();
//            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Employee emp = new Employee();
        emp.setName("Bryan Hansen");
        emp.setAddress("111 E Code Street");
        emp.setPhone("888-555-1212");

        serialize(emp);
        Employee newEmp = deserialize();
        System.out.println(newEmp.getName());

    }
}
