package studentmanagement;

public class Enrollement {
	private Student student;
	private Course course;
	
	public Enrollement(Student student, Course course) {
	    this.student = student;
	    this.course = course;
	}
	
	public Student getStudent() {
	    return student;
	}

	public void setStudent(Student student) {
	    this.student = student;
	}

	public Course getCourse() {
	    return course;
	}

	public void setCourse(Course course) {
	    this.course = course;
	}
	
	@Override
	public String toString() {
	    return "Enrollment{" +
	            "student=" + student +
	            ", course=" + course +
	            '}';
	}

}
