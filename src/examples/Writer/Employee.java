package examples.Reader;

import java.io.Serializable;

public class Employee implements Serializable {
    String name;
    String department;
    transient int salary;
    Car car;

    public Employee(String name, String department, int salary, Car car) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary + '\'' +
                ", car=" + car +
                '}';
    }
}
