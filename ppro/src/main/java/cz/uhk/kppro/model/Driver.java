package cz.uhk.kppro.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Driver {
    private int personalId;

    @NotEmpty(message = "Name is required")
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 90, message = "Age must be bellow 90")
    private int age;

    @Min(value = 10000, message = "Salary must be at least 10 000")
    @Max(value = 200000, message = "Salary must be bellow 200 000")
    private int salary;

    public Driver() {

    }
    public Driver(int personalId, String name, int age, int salary) {
        this.personalId = personalId;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
