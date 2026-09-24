package studentmanagement;
import java.util.ArrayList;

public class StudentService {
	private ArrayList< Student> students = new ArrayList<>();
// private, damit die main classe nicht direct darauf zugreift
	 //public void addStudent(Student student) {
		// students.add(student);
		 // bedeutet , wenn du ein neuses objekt student bekommt , dann in der Liste hinzufügen
	 //}
	
	public boolean addStudent(Student student) {

	    if (studentIdExists(student.getId())) {
	        return false;
	    }

	    students.add(student);
	    return true;
	}
	
	 //alle Student printen
	 public void zeigenAlleStudent() {
		 for(Student student: students) {
			 System.out.println(student);
			 
		 }
	 }
	 public Student findStudentById(int id) {
		 for(Student student : students) {
			 
			 if (student.getId() == id) {
				 return student;
			 }
		 }
		 return null;
	 }
	 public boolean updateStudent ( int id , String name, int alter, String email) {
		 
		 Student student = findStudentById(id);
		 
		 if( student !=null) {
			 student.setName(name);
			 student.setAlter(alter);
			 student.setEmail(email);
			 
			 return true;
		 }
		 
		 return false ;
	 }
	 
	 public boolean deleteStudent( int id) {
		 Student student = findStudentById(id);
		 
		 if(student != null) {
			 students.remove(student);
			 return true;
			 
		 }
		 
		 return false;
	 }
	 
	 // damit 2 student die gleiche Id nicht haben
	 
	 public boolean studentIdExists(int id) {

		    for (Student student : students) {

		        if (student.getId() == id) {
		            return true;
		        }
		    }

		    return false;
		}
}
