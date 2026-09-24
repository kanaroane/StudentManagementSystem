package studentmanagement;
import java.util.ArrayList;

public class CourseService{
	private ArrayList<Course> courses = new ArrayList<>();
	
	public boolean addCourse(Course course) {

	    if (courseIdExists(course.getId())) {
	        return false;
	    }

	    courses.add(course);
	    return true;
	}
	
	public boolean courseIdExists(int id) {

	    for (Course course : courses) {

	        if (course.getId() == id) {
	            return true;
	        }
	    }

	    return false;
	}
	
	
	public void showAllCourses() {
	    for (Course course : courses) {
	        System.out.println(course);
	    }
	}
	public Course findCourseById(int id) {

	    for (Course course : courses) {

	        if (course.getId() == id) {
	            return course;
	        }
	    }

	    return null;
	}
	public boolean updateCourse(int id, String name, int credits) {

	    Course course = findCourseById(id);

	    if (course != null) {
	        course.setName(name);
	        course.setCredits(credits);

	        return true;
	    }

	    return false;
	}
	public boolean deleteCourse(int id) {

	    Course course = findCourseById(id);

	    if (course != null) {
	        courses.remove(course);
	        return true;
	    }

	    return false;
	}
	

}
