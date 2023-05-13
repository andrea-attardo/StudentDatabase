import java.util.ArrayList;
import java.security.SecureRandom;

enum UniYear {FRESH, SOPHO, JUNIOR, SENIOR};

public class Student{ 
    
    //attributi
    private static int nextID = 0;
    private String name;
    private final int ID;
    private UniYear year;
    private ArrayList<Course> enrolledCourses;
    private double balance;
    
    //constructor
    public Student(String name, UniYear year){
        this.name = name;
        this.year = year;
        ID = generateID();
        enrolledCourses = new ArrayList<>();
        balance = 10000;
    }
    
    
    //methods
    public int getID(){
        return this.ID;
    }
    
    public double getBalance(){
        return this.balance;
    }
    
    public void payTuition(Course course){
        if (enrolledCourses.isEmpty()){
            System.out.println("No courses enrolled");
        }else{
            course.setTuitionPayed();
            balance -= course.getTuitionFee();
          
        }
        
        
    }
    
    
    public void printCoursesPayed(){
        for(Course course : enrolledCourses){
            if (course.isTuitionPayed()){
                System.out.println(course);
            }
        }
    }
    
    public void enrollTo(Course course){
        enrolledCourses.add(course);
    }
    
    public ArrayList<Course> getEnrolledCourses(){
        return enrolledCourses;
    }
    
    //helper methods
    private int generateID(){
        nextID++;
        return ((year.ordinal() + 1) * 10000) + nextID;
    }
    
    
    @Override
    public String toString(){
        return ID + " " + name + " " + year + " " + balance + " Course enrolled: " + enrolledCourses;
    }
} \\prova commento jdied
