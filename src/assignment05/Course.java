package assignment05;
import static java.util.Map.entry;

import java.util.Map;
import java.util.Set;

public class Course {
	public static final Map<Double, String> letterGrade = 
			Map.ofEntries(entry(4.0, "A"), entry(3.7, "A-"), entry(3.3, "B+"),
					entry(3.0, "B"), entry(2.7, "B-"), entry(2.3, "C+"), 
					entry(2.0, "C"), entry(1.7, "C-"), entry(1.0, "D"), entry(0.0, "F"));
	public static final Map<String, Double> gradePoints = 
			Map.ofEntries(entry("A", 4.0), entry("A-", 3.7), entry("B+", 3.3),
					entry("B", 3.0), entry("B-", 2.7), entry("C+", 2.3), 
					entry("C", 2.0), entry("C-", 1.7), entry("D", 1.0), entry("F", 0.0));
	String courseRubric; 
	String courseNumber; // is a String to accommodate "480C" 
	String courseTitle;
	int credits;
	Set<Gened> geneds;
	String crnSemCombo; // for example: "Key26768x202120"
	// the CRN is 26768, 2021 is the year and 20 means Spring
	// nnnn10 is Winter nnnn, nnnn20 is Spring nnnn,
	// nnnn60 is Summer nnnn, nnnn90 is Fall nnnn
	public Course(String courseRubricIn, String courseNumberIn, 
			String courseTitleIn, int creditsIn, Set<Gened> genedsIn,
			String crnSemComboIn) {
		courseRubric = courseRubricIn; courseNumber = courseNumberIn;
		courseTitle = courseTitleIn; credits = creditsIn;
		geneds = genedsIn; crnSemCombo = crnSemComboIn;
	}
	public String getCourseRubric() {
		return courseRubric;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public int getCredits() {
		return credits;
	}
	public Set<Gened> getGeneds() {
		return geneds;
	}
	public String getCrnSemCombo() {
		return crnSemCombo;
	}
	public String toString() {
		return courseRubric + courseNumber;
	}
}
