import java.util.Scanner;

public class Menu{
    
    public static void run(StudentDatabase db) throws IllegalArgumentException{
        
        Scanner in = new Scanner(System.in);
        int answer = 1;
        while (answer != 0){
            System.out.println("\nStudents Database App");
            System.out.println("------------------------");
            System.out.println("1 - mostra database");
            System.out.println("2 - registra studente nel database");
            System.out.println("3 - iscrivi uno studente a un corso");
            System.out.println("4 - paga la rata per un corso");
            System.out.println("5 - controlla stato pagamento di un corso");
            System.out.println("0 - esci");
            
            answer = in.nextInt();
            
            switch (answer) {
                case 1:
                    System.out.println(db.getEntries());
                    break;
                
                case 2:
                    try{
                        //name
                        System.out.println("\nInserisci nome studente");
                        String name = in.next();
                        
                        //uniyear
                        System.out.println("In Quale anno? (FRESH, SOPHO, JUNIOR, SENIOR)");
                        UniYear uniYear = UniYear.valueOf(in.next().toUpperCase());
                        
                        db.add(new Student(name, uniYear));    
                    }catch(IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                        //System.out.println("Nome anno sbagliato scgliere fra (FRESH, SOPHO, JUNIOR, SENIOR)");
                    }
                    break;
                    
                    
                case 3:
                    System.out.println("Scegli uno studente inserendo ID corrispondente");
                    System.out.println(db.getEntries());
                    
                    answer = in.nextInt();
                    for (Student student : db.getEntries()){
                        if (student.getID() == answer){
                            System.out.println("In quale corso iscrivere?\n (MATH, CHEMISTRY, ENGLISH, HISTORY, COMPUTER_SCIENCE" );
                            String courseName = in.next();
                            Course course = Course.valueOf(courseName);
                            student.enrollTo(course);
                            
                        }else{
                            System.out.println("ID errato");
                        }
                    }
                    
                    break;

                    case 4:
                    System.out.println("Scegli uno studente inserendo ID corrispondente");
                    System.out.println(db.getEntries());
                    
                    answer = in.nextInt();
                    for (Student student : db.getEntries()){
                        if (student.getID() == answer){
                            System.out.println("Scegli un corso fra quelli a cui sei iscirtto da pagare");
                            String courseName = in.next();
                            for (Course course : student.getEnrolledCourses()){
                                    if (!course.isTuitionPayed()){
                                student.payTuition(course);
                                System.out.println("Operazione riuscita. Corso PAGATO.");
                                    }else{
                                        System.out.println("Corso già pagato");
                                    }
                            }                   
                        }else{
                            System.out.println("ID errato");
                        }
                    }
                    
                    break;
                
                default:
                    System.out.println("Sbagliato ad inserire risposta (Esempio: lettera invece di numero)");
            }
        }
        in.close();
    }
}