package assignment05;

import java.util.ArrayList;
import java.util.List;

public class Student implements CourseUser {
	private String bNumber;
	private String lastNames;
	private String firstNames;
	private List<Enrollment> enrollments = new ArrayList<>(); 
	
	public Student(String bNumberIn, String lastNamesIn, String firstNamesIn) {
		bNumber = bNumberIn;
		lastNames = lastNamesIn;
		firstNames = firstNamesIn;
	}
	public String getbNumber() {
		return bNumber;
	}
	public String getLastNames() {
		return lastNames;
	}
	public String getFirstNames() {
		return firstNames;
	}
	public List<String> getEnrollmentKeys() {
		List<String> ret = new ArrayList<>();
		for(var e : enrollments) {
			ret.add(e.getCourse().getCrnSemCombo());
		}
		return ret;
	}
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}
	public double getGpa() {
		double sumQpts = 0;
		int credits = 0;
		for(Enrollment e : enrollments) {
			credits += e.getCredits();
			sumQpts += e.qualityPoints();
		}
		if(credits != 0) return sumQpts/credits;
		return 0.0;
	}
	public String[] requestRegistration(String[] keys) {
		List<String> returnValue = new ArrayList<>();
		for(String key : keys) {
			if(CourseManagement.addEnrollment(key)) {
				Course crs = CourseManagement.findFromKey(key).get();
				enrollments.add(new Enrollment(crs));
				CourseManagement.classStudentLists.get(crs).add(this);
				returnValue.add(key);
			}
		}
		return returnValue.toArray(new String[] {});
	}
	public boolean dropRegistration(String key) {
		TODO
		return false;
	}
	public String toString() {
		return firstNames + " " + lastNames + " (" + bNumber + "): " + enrollments;
	}
}
