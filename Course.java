public enum Course{
    MATH("Math"), 
    HISTORY("History"), 
    CHEMISTRY("Chem"), 
    ENGLISH("Eng"), 
    COMPUTER_SCIENCE("Cs");
    
    private String abbreviation;
    private double tuitionFee;
    private boolean isTuitionPayed;
    
    Course(String abbreviation){
        this.abbreviation = abbreviation;
        tuitionFee = 600.00;
        isTuitionPayed = false;
    }
    
    public String getAbbreviation(){
        return abbreviation;
    }
    
    public double getTuitionFee(){
        return tuitionFee;
    }
    
    
    public void setTuitionPayed(){
        isTuitionPayed = true;
    }
    
    public boolean isTuitionPayed(){
        return isTuitionPayed;
    }
}