package studentmanagement;
import java.util.Scanner;
// damit mein programm interactif wird;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		StudentService service = new StudentService();
		
		Scanner scanner = new Scanner(System.in);
		
		CourseService courseService = new CourseService();
		
		EnrollementService enrollementService = new EnrollementService();
		
		boolean running = true;

		while (running) {

		    System.out.println("========================================");
		    System.out.println("       STUDENT MANAGEMENT SYSTEM");
		    System.out.println("========================================");
		    System.out.println("1. Add student");
		    System.out.println("2. Show all students");
		    System.out.println("3. Find student");
		    System.out.println("4. Update student");
		    System.out.println("5. Delete student");
		    
		    System.out.println("6. Add course");
		    System.out.println("7. Show all courses");
		    System.out.println("8. Find course");
		    System.out.println("9. Update course");
		    System.out.println("10. Delete course");
		    
		    System.out.println("11. Enroll student in course");
		    System.out.println("12. Show student's courses");
		    System.out.println("13. Show course's students");
		    System.out.println("14. Remove student from course");
		    
		    System.out.println("0. Exit");
		    System.out.print("Choose an option: ");

		    int choice = scanner.nextInt();

		    switch (choice) {

		    case 1:
		        System.out.print("Enter student ID: ");
		        int id = scanner.nextInt();

		        scanner.nextLine();

		        System.out.print("Enter name: ");
		        String name = scanner.nextLine();

		        System.out.print("Enter age: ");
		        int age = scanner.nextInt();

		        scanner.nextLine();

		        System.out.print("Enter email: ");
		        String email = scanner.nextLine();

		        Student student = new Student(id, name, age, email);

		        boolean added = service.addStudent(student);

		        if (added) {
		            System.out.println("Student added successfully!");
		        } else {
		            System.out.println("A student with this ID already exists.");
		        }
		        break;
		        
		    case 2:
		    
		        service.zeigenAlleStudent();
		        break;
		        
		    case 3:
		        System.out.print("Enter student ID: ");
		        int searchId = scanner.nextInt();

		        Student foundStudent = service.findStudentById(searchId);

		        if (foundStudent != null) {
		            System.out.println("Student found:");
		            System.out.println(foundStudent);
		        } else {
		            System.out.println("Student not found.");
		        }

		        break;

		    case 4:
		        System.out.print("Enter student ID: ");
		        int updateId = scanner.nextInt();

		        scanner.nextLine();

		        System.out.print("Enter new name: ");
		        String newName = scanner.nextLine();

		        System.out.print("Enter new age: ");
		        int newAge = scanner.nextInt();

		        scanner.nextLine();

		        System.out.print("Enter new email: ");
		        String newEmail = scanner.nextLine();

		        boolean updated = service.updateStudent(
		                updateId,
		                newName,
		                newAge,
		                newEmail
		        );

		        if (updated) {
		            System.out.println("Student updated successfully!");
		        } else {
		            System.out.println("Student not found.");
		        }

		        break;

		    case 5:
		        System.out.print("Enter student ID: ");
		        int deleteId = scanner.nextInt();

		        boolean deleted = service.deleteStudent(deleteId);

		        if (deleted) {
		            System.out.println("Student deleted successfully!");
		        } else {
		            System.out.println("Student not found.");
		        }

		        break;
		        
		    case 6:
		        System.out.print("Enter course ID: ");
		        int courseId = scanner.nextInt();

		        scanner.nextLine();

		        System.out.print("Enter course name: ");
		        String courseName = scanner.nextLine();

		        System.out.print("Enter credits: ");
		        int credits = scanner.nextInt();

		        Course course = new Course(courseId, courseName, credits);

		        boolean courseAdded = courseService.addCourse(course);

		        if (courseAdded) {
		            System.out.println("Course added successfully!");
		        } else {
		            System.out.println("A course with this ID already exists.");
		        }
		        break;
		        
		    case 7:
		        courseService.showAllCourses();
		        break;
		        
		    case 8:
		        System.out.print("Enter course ID: ");
		        int searchCourseId = scanner.nextInt();

		        Course foundCourse = courseService.findCourseById(searchCourseId);

		        if (foundCourse != null) {
		            System.out.println("Course found:");
		            System.out.println(foundCourse);
		        } else {
		            System.out.println("Course not found.");
		        }

		        break;
		        
		    case 9:
		        System.out.print("Enter course ID: ");
		        int updateCourseId = scanner.nextInt();

		        scanner.nextLine();

		        System.out.print("Enter new course name: ");
		        String newCourseName = scanner.nextLine();

		        System.out.print("Enter new credits: ");
		        int newCredits = scanner.nextInt();

		        boolean courseUpdated = courseService.updateCourse(
		                updateCourseId,
		                newCourseName,
		                newCredits
		        );

		        if (courseUpdated) {
		            System.out.println("Course updated successfully!");
		        } else {
		            System.out.println("Course not found.");
		        }

		        break;
		        
		    case 10:
		        System.out.print("Enter course ID: ");
		        int deleteCourseId = scanner.nextInt();

		        boolean courseDeleted = courseService.deleteCourse(deleteCourseId);

		        if (courseDeleted) {
		            System.out.println("Course deleted successfully!");
		        } else {
		            System.out.println("Course not found.");
		        }

		        break;
		        
		    case 11:
		        System.out.print("Enter student ID: ");
		        int enrollementStudentId = scanner.nextInt();

		        System.out.print("Enter course ID: ");
		        int enrollementCourseId = scanner.nextInt();

		        Student enrollementStudent = service.findStudentById(enrollementStudentId);
		        Course enrollementCourse = courseService.findCourseById(enrollementCourseId);
		        System.out.println("Student found: " + enrollementStudent);
		        System.out.println("Course found: " + enrollementCourse);

		        if (enrollementStudent != null && enrollementCourse != null) {

		            boolean enrolled = enrollementService.enrollStudent(
		                    enrollementStudent,
		                    enrollementCourse
		            );

		            if (enrolled) {
		                System.out.println("Student enrolled successfully!");
		            } else {
		                System.out.println("Student is already enrolled in this course.");
		            }

		        } else {
		            System.out.println("Student or course not found.");
		        }

		        break;
		        
		    case 12:
		        System.out.print("Enter student ID: ");
		        int studentId = scanner.nextInt();

		        System.out.println("Courses of student:");

		        enrollementService.showCoursesForStudent(studentId);

		        break;
		        
		    case 13:
		        System.out.print("Enter course ID: ");
		        int kursId = scanner.nextInt();

		        System.out.println("Students enrolled in course:");

		        enrollementService.showStudentsForCourse(kursId);

		        break;
		        
		    case 14:
		        System.out.print("Enter student ID: ");
		        int unenrollStudentId = scanner.nextInt();

		        Student studentToRemove = service.findStudentById(unenrollStudentId);

		        if (studentToRemove == null) {
		            System.out.println("Student not found.");
		            break;
		        }

		        System.out.print("Enter course ID: ");
		        int unenrollCourseId = scanner.nextInt();

		        Course courseToRemove = courseService.findCourseById(unenrollCourseId);

		        if (courseToRemove == null) {
		            System.out.println("Course not found.");
		            break;
		        }

		        boolean unenrolled = enrollementService.unenrollStudent(
		                unenrollStudentId,
		                unenrollCourseId
		        );

		        if (unenrolled) {
		            System.out.println("Student removed from course successfully!");
		        } else {
		            System.out.println("This student is not enrolled in this course.");
		        }

		        break;
		        
		        // la je peut savor directment pourquoi un eleve ou un cour n'a pas été trouver lors d'un enregistrrement, donc si l'etudiant n'existe ps ou meme le cour ca renvois not found et si ca donne sa supprime proprement1
		     
		        

		        case 0:
		            running = false;
		            System.out.println("Goodbye!");
		            break;

		        default:
		            System.out.println("Invalid option.");
		    }
		}
		
		scanner.close();
		
	}
	// jetzt habe ich auch course , die gut funktionieren , aber wie kann ich bestimmen, dass ei student in einem kurs eingeschieben ist ? ich muss wie in UML machen , die Abhängigkeiten schaffen

}
// jetzt meine Main methode sauber! im allgemeinen habe ich hier einen teil es programm , der ermöglicht  studenten einzuschreiben, daten zu updaten, , zu löschen, durch eine Abfrage der benutzer durch das Menu, jetzt muss ich den teil Kurs programmierenn, mit Abhängigkeiten und do , damit ein studdent einen kurs besucht.  
