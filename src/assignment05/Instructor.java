package assignment05;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Instructor implements CourseUser {
	private String lastNames;
	private String firstNames;
	private Map<Course, Set<Student>> coursesToTeach = new HashMap<>();

	public Instructor(String lNames, String fNames) {
		lastNames = lNames;
		firstNames = fNames;
	}


	public void populateCoursesTaught() {
		for(Course c : CourseManagement.list.keySet()) {
			//TODO: Done by Abby - i don't understand the mapping for "this
		
			// Go through the keys of CourseManagement.list using the
		// keySet() method. If the course c is a key for "this"
		// Instructor put in coursesToTeach the mapping from c
		// to the Set in CourseManagement.classStudentLists for c
	}

	public void putGrades() {
		for(var course : coursesToTeach.keySet()) {
			String courseKey = course.getCrnSemCombo();
			Scanner kbd = new Scanner(System.in);
			// See how proxy is made for StudentInvocationHandler in Test
			// create CourseUser proxy as InstructorInvocationHandler
			// from this Instructor
			// @TODO: Amelia I cannot figure out how to make the invocation correctly
			CourseUser proxy = (CourseUser)Proxy.newProxyInstance(
					     course.getClass().getClassLoader(),
					     course.getClass().getInterfaces(),
					     new InstructorInvocationHandler());
					   crnSemCombo.clear();

			CourseUser proxy = new InstructorInvocationHandler(this);
			for(Student s : coursesToTeach.get(course)) {
				// TODO LATER
				// replace with assigning a random grades to the student
				boolean formatCorrect = false;
				while(!formatCorrect) {
					System.out.println(s.getbNumber() + ": " + s.getLastNames() + ", " + s.getFirstNames() + ". Grade: ");
					String grade = kbd.nextLine();
					if(Course.gradePoints.keySet().contains(grade)) {
						// this uses the proxy made above:
						proxy.setGrade(s, courseKey, grade);
						formatCorrect = true;
					} else {
						System.out.println(grade + "is not a valid grade, please re-enter");
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Instructor: " + firstNames + " " + lastNames + ", teaching ["
				+ coursesToTeach.keySet() + "]";
	}


}
