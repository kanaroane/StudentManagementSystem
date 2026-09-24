package studentmanagement;
import java.util.ArrayList;

public class EnrollementService {
	
	private ArrayList<Enrollement> enrollements = new ArrayList<>();
	
	public boolean enrollStudent(Student student, Course course) {

	    if (enrollementExists(student.getId(), course.getId())) {
	        return false;
	    }

	    Enrollement enrollement = new Enrollement(student, course);
	    enrollements.add(enrollement);

	    return true;
	}
	
	public void showAllEnrollements() {
	    for (Enrollement enrollement : enrollements) {
	        System.out.println(enrollement);
	    }
	}
	
	
	public boolean enrollementExists(int studentId, int courseId) {

	    for (Enrollement enrollement : enrollements) {

	        if (enrollement.getStudent().getId() == studentId
	                && enrollement.getCourse().getId() == courseId) {
	            return true;
	        }
	    }

	    return false;
	}
	
	public void showCoursesForStudent(int studentId) {

	    boolean found = false;

	    for (Enrollement enrollement : enrollements) {

	        if (enrollement.getStudent().getId() == studentId) {

	            System.out.println(enrollement.getCourse());
	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("This student is not enrolled in any course.");
	    }
	}
	
	
	// pour afficher tout les etuiants d'un cour , donc mobtrer qui est inscrit au cour 
	public void showStudentsForCourse(int courseId) {

	    boolean found = false;

	    for (Enrollement enrollement : enrollements) {

	        if (enrollement.getCourse().getId() == courseId) {

	            System.out.println(enrollement.getStudent());
	            found = true;
	        }
	    }

	    if (!found) {
	        System.out.println("No students are enrolled in this course.");
	    }
	}
	
	
	
	// ein Student von einem Kurs rausnehmen
	
	public boolean unenrollStudent(int studentId, int courseId) {

	    for (Enrollement enrollement : enrollements) {

	        if (enrollement.getStudent().getId() == studentId
	                && enrollement.getCourse().getId() == courseId) {

	            enrollements.remove(enrollement);
	            return true;
	        }
	    }

	    return false;
	}

}
