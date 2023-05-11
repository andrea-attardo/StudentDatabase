import java.util.*;

public class StudentDatabase{
    private List<Student> entries;
    
    public StudentDatabase(){
        entries = new ArrayList<>();
    }
    
    public void add(Student student){
        entries.add(student);
    }
    
    public List<Student> getEntries(){
        return entries;
    }
    
}