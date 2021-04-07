package assignment05;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

public class CourseManagement {
	public static Set<Student> enrolledStudents = new HashSet<>();	
	public static Map<Course, Instructor> list = new TreeMap<> (
			Comparator.comparing(Course::toString)
			.thenComparing(Course::getCrnSemCombo)); 
	static Map<Course, Integer> capacities = new HashMap<>();
	static Map<Course, Integer> actualEnrollment = new HashMap<>();
	public static Map<Course, Set<Student>> classStudentLists = new HashMap<>();
	public static Map<String, Course> key2CourseMap = new HashMap<>();
	public static List<Instructor> allInstructors = new ArrayList<>(Arrays.asList(RawCourseList.instructors));

	static {
		for(Course c : RawCourseList.mapCourseEntries.keySet()) {
			capacities.put(c, 20); // just for testing
			actualEnrollment.put(c, 0);
			list.put(c, RawCourseList.mapCourseEntries.get(c));
			classStudentLists.put(c, new HashSet<>());
			key2CourseMap.put(c.getCrnSemCombo(), c);
		}
	}

	public static Optional<Course> findFromKey(String courseKey) {
			if(key2CourseMap.containsKey(courseKey)) 
				return Optional.of(key2CourseMap.get(courseKey));
		return Optional.empty();
	}

	public static boolean addEnrollment(String courseKey) {
		var crs = findFromKey(courseKey); // crs type is Optional<Course>
		if(crs.isPresent()) {
			Course c = crs.get();
			int i = actualEnrollment.get(c);
			if(i < capacities.get(c)) {
				actualEnrollment.put(c, i + 1);
				return true;
			} else return false;	
		}
		return false;		
	}
	
	public static boolean dropEnrollment(String courseKey) {
		TODO
		// return true if c = crs.get() exists and
		// the actualEnrollment.get(c) > 0 and you
		// decrease it by 1
		// return false in all other cases
		return false;
	}
}
