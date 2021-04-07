package assignment05;

import java.util.List;

public interface CourseUser {
	// student methods
	default String getbNumber() {return null;}
	default String getLastNames() {return null;}
	default String getFirstNames() {return null;}
	default List<String> getEnrollmentKeys() {return null;}
	default double getGpa() {return 0.0;}
	default String[] requestRegistration(String[] keys) {return null;}
	default boolean dropRegistration(String keys) {return false;}
	// complete implementation to set grade--only legal from instructor proxy
	default public void setGrade(Student st, String courseKey, String grade) {
		for(Enrollment e : st.getEnrollments()) {
			if(e.getCourse().getCrnSemCombo().equals(courseKey))
				e.setGradePoints(Course.gradePoints.get(grade));
		}
	}	
	// instructor methods
	default void populateCoursesTaught() {}
	default public void putGrades() {}
}
