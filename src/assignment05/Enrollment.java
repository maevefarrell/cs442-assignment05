package assignment05;

public class Enrollment {
	private Course course;
	private double gradePoints;
	public Enrollment(Course c) {
		course = c;
	}
	
	public double getGradePoints() {
		return gradePoints;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setGradePoints(double gradePoints) {
		this.gradePoints = gradePoints;
	}

	public String getLetterGrade() {
		return Course.letterGrade.get(gradePoints);
	}
	public Double qualityPoints() {
		return gradePoints * course.credits;
	}
	public int getCredits() {
		return course.getCredits();
	}	
	public String toString() {
		return course + ", GdPts = " + gradePoints;
	}
}
