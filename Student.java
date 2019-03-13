/* Name: Yohaan Mohan
 * Student Number: 160291137
 */

public class Student{

    private String name;
    private int exam;
    private int cwk;
    private int total;
    private String grade;

    public Student(String name, int exam, int cwk){
        this.name=name;
        this.exam=exam;
        this.cwk=cwk;
        this.total=calcTotal();
        this.grade=calcGrade();
    }

    private int calcTotal(){
		return  (int)Math.round(0.6*exam+(1.0-0.6)*cwk);
    }

	private String calcGrade(){
		if (exam<35||cwk<35) return ("F");  //if either exam or cwk component less than 35 fail, even if total mark is 40 or greater
		if (total<40) return ("F");  //the pass mark is 40
        if (total<50) return ("D");
        if (total<60) return ("C");
        if (total<70) return ("B");
        return ("A");
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getExam()
    {
        return exam;
    }
    
    public int getCwk()
    {
        return cwk;
    }
    
    public String getGrade()
    {
        return grade;
    }
    
    public int getTotal(){
		return total;
	}


    public String toString()
    {
        String returnString = "";
        returnString += "Name: " + name + "\n";
        returnString += "Exam Score: " + exam + "\n";
        returnString += "Coursework Score: " + cwk + "\n";
        returnString += "Total Score: " + total + "\n";
        returnString += "Grade: " + grade + "\n";
        return returnString;
    }

}
