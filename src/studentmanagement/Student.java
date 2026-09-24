package studentmanagement;

public class Student {
	private int id;
	private String name;
	private int alter;
	private String email;
	
	
	public Student(int id , String name, int alter, String email) {
		this.id= id;
		this.name=name;
		this.alter=alter;
		this.email=email;
	}
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id= id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter =alter;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	@Override
	public String toString () {
		return "Student{" + 
	           "id=" + id + 
	           ",name='" + name + '\'' +
	           ",alter=" + alter +
	           ",email ='" + email + '\'' + 
	           '}';
	}

}
