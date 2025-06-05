package com.ems.Employee.Service.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

    int id;
    String name;
    long salary;
    double age;
    String address;

    public test(int id, String name, long salary, String address, double age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

class Employee{

    public static void main(String[] args) {
        test emp1= new test(1,"nikhil", 8000,"delhi", 20.5);
        test emp2= new test(2,"sam", 15000,"bombay", 23);
        test emp3= new test(3,"dam", 12000,"noida", 21);
        test emp4= new test(4,"nikhil", 6000,"meerut", 34);
        test emp5= new test(5,"harry", 10000,"gzb", 32);
        test emp6= new test(6,"sohan", 13000,"kolkata", 20.5);



        List<test> employeeList= new ArrayList<>(Arrays.asList(emp1,emp2,emp3, emp4,emp5,emp6));

        System.out.println("Employee List:");
        for (test data:employeeList){
            System.out.println(data);
        }

        employeeList.remove(2);

        System.out.println("Employee List after removing 2nd index:");
        for (test data:employeeList){
            System.out.println(data);
        }

    }



}

