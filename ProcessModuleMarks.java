/* Name: Yohaan Mohan
 * Student Number: 160291137
 */

import java.util.*;
import java.io.*;

public class ProcessModuleMarks{

	public static ArrayList<Student> StudentsInList(String s)throws IOException, FileNotFoundException
        {
		ArrayList<Student> students = new ArrayList<Student>();
		String name;
		int exam;
		int cwk;
		try
                {
                    Scanner in =new Scanner(new FileReader(s));
                    while(in.hasNextLine())
                    {
						name =in.nextLine();
						cwk = Integer.parseInt(in.nextLine());
						exam = Integer.parseInt(in.nextLine());
						students.add(new Student(name,exam,cwk));
                    }
                    in.close();//finished with the Scanner object, tidy up.
                }
                catch(FileNotFoundException e)
                {
                    System.out.println("File: " + s + " was not found");
                }
		return students;
	 }


	public static ArrayList<Student> StudentsInList_2(String s) throws IOException, FileNotFoundException
        {
		ArrayList<Student> students = new ArrayList<Student>();
		String name;
		int exam;
		int cwk;
		try 
                {
                    Scanner in = new Scanner(new FileReader(s));
                    while(in.hasNextLine()){
                    name =in.nextLine();
                    cwk = Integer.parseInt(in.nextLine());
                    exam = Integer.parseInt(in.nextLine());
                    Student X = new Student(name,exam,cwk);
                    int insertIndex = positionOfNext(students, X.getTotal());
                    students.add(insertIndex, X);
                    }
		in.close();//finished with the Scanner object, tidy up.
                }
                catch(FileNotFoundException e)
                {
                    System.out.println("File: " + s + " was not found");
                }
	return students;
        }

	public static int positionOfNext(ArrayList<Student> a, int x)
        {
            if(a.isEmpty())
                return 0;
            
            int count = 0;
            
            for(int i = 0; i < a.size() ; i++)
            {
                Student toCompare = a.get(i);
                if(toCompare.getTotal() > x)
                {
                    count = i;
                    break;
                }
            }
            return count;
	}

        public static void DisplayStudents(ArrayList<Student> studentArray)
        {
            for(int i = 0; i < studentArray.size(); i++)
            {
                Student studentPrint = studentArray.get(i);
                String toPrint = studentPrint.toString();
                System.out.println(toPrint);
            }
        }
        
        public static void findStudentName(ArrayList<Student> studentArray, String stringToFind)
        {
            for(int i = 0; i < studentArray.size(); i++)
            {
                Student studentToCompare = studentArray.get(i);
                if(stringToFind.compareToIgnoreCase(studentToCompare.getName())<= 0)
                {
                    String toPrint = studentToCompare.toString();
                    System.out.println(toPrint);
                }
            }
        }
        
        public static void findStudentGrade(ArrayList<Student> studentArray, String gradeToFind)
        {
            for(int i = 0; i < studentArray.size(); i++)
            {
                Student studentToCompare = studentArray.get(i);
                if(gradeToFind.compareToIgnoreCase(studentToCompare.getGrade()) == 0)
                {
                    String toPrint = studentToCompare.toString();
                    System.out.println(toPrint);
                }
            }
        }
        
        public static boolean binarySearch(ArrayList<Student> studentArray, int thing)
        {
            int low = 0;
            int high = studentArray.size() - 1;
            
            while(high >= low)
            {
                int middle = (low + high)/2;
                if(thing > studentArray.get(middle).getTotal())
                {
                    low = middle + 1;
                }
                else if(thing < studentArray.get(middle).getTotal())
                {
                    high = middle - 1;
                }
                else
                {
                    return true;
                }
            }
            return false;
        }
        
        public static void StudentsToFile(ArrayList<Student> studentArray, String outFile)throws IOException, FileNotFoundException
        {
            FileOutputStream fos = new FileOutputStream(outFile);
            PrintStream ps = new PrintStream(fos);
            for(int i = 0; i < studentArray.size(); i++)
            {
                String outputString = studentArray.get(i).toString();
                ps.print(outputString);
            }
            
            ps.close();
        }
    	public static void main(String[] args)throws IOException
        {
			 ArrayList<Student> students = StudentsInList("marks.txt");
			 DisplayStudents(students);
			 System.out.println();
			 System.out.println("/**************************************************/");
			 System.out.println();
			 findStudentName(students, "Eb");
			 System.out.println();
			 System.out.println("/**************************************************/");
			 System.out.println();
			 ArrayList<Student> students2 = StudentsInList_2("marks.txt");
			 DisplayStudents(students2);
			 System.out.println();
			 System.out.println("/**************************************************/");
			 System.out.println();
			 findStudentGrade(students2, "A");
			 System.out.println();
			 System.out.println("/**************************************************/");
			 System.out.println();
			 System.out.println(binarySearch(students2, 35));
			 System.out.println(binarySearch(students2, 68));
			 System.out.println(binarySearch(students2, 69));
			 System.out.println(binarySearch(students2, 85));

			 StudentsToFile(students2,"sortedMarks.txt");//test this by looking in the sortedMarks.txt file
	}
}
