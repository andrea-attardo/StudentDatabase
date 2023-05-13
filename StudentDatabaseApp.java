import java.util.*;
            
public class StudentDatabaseApp{

    public static void main(String[] args){
        
        StudentDatabase studentsDB = new StudentDatabase();
        
        Menu menu = new Menu();

        menu.run(studentsDB);
        
    }
    
    
}


