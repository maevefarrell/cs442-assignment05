package assignment05;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Test {
 private static Student[] students = new Student[200];
 private static Random ranGen = new Random(15);

 static List<String> crnSemCombos = CourseManagement.list.keySet().stream()
   .map(Course::getCrnSemCombo)
   .collect(Collectors.toList());

 public static void main(String[] args) {
  System.out.println("Make test students -----------------");
  make200Students();
  System.out.println("\nEnroll students in classes -----------------");
  enrollInclasses();
  System.out.println("\nPut grades in for one instructor -----------------");
  tryGrading();
  System.out.println("\nDone -----------------");
  printGPAs();
 }
 private static void printGPAs() {
  for(var st : students) {
   System.out.printf("%s %s, semester gpa: %.2f\n",
     st.getFirstNames(), st.getLastNames(), st.getGpa());
  }

 }
 private static void make200Students() {
  int nextBNum = 111111;
  for(int i = 0; i < students.length; i++) {
   int bn = nextBNum++;
   while (!BNumberValidator.isValid(bn)) {
    bn = nextBNum++;
   }
   students[i] = new Student("B00" + bn,
     NamesResource.getRandomLastName(),
     NamesResource.getRandomFirstName()
     + " " + NamesResource.getRandomFirstName());
   CourseManagement.enrolledStudents.add(students[i]);
  }
 }

 private static void enrollInclasses() {
  Set<String> crnSemCombo = new TreeSet<>();
  for(var st : students) {
   CourseUser proxy = (CourseUser)Proxy.newProxyInstance(
     st.getClass().getClassLoader(),
     st.getClass().getInterfaces(),
     new StudentInvocationHandler(st));
   crnSemCombo.clear();
   while(crnSemCombo.size() < 4) {
    int j = ranGen.nextInt(crnSemCombos.size());
    crnSemCombo.add(crnSemCombos.get(j));
   }
   String[] reg = proxy.requestRegistration(crnSemCombo.toArray(new String[] {}));
   int numCrs = reg.length;
   while(numCrs < 4) {
    List<String> enrolled = proxy.getEnrollmentKeys();
    List<Course> possible = new ArrayList<>();
    for(Course c : CourseManagement.list.keySet()) {
     if(!enrolled.contains(c.getCrnSemCombo()) &&
       CourseManagement.actualEnrollment.get(c) < CourseManagement.capacities.get(c))
      possible.add(c);
    }
    int j = ranGen.nextInt(possible.size());
    proxy.requestRegistration(new String[] {possible.get(j).getCrnSemCombo()});
    numCrs++;
   }
   System.out.println(proxy);
  }
 }
 private static void tryGrading() {
  List<Instructor> list = new ArrayList<>(CourseManagement.allInstructors);
  int j = ranGen.nextInt(list.size());
  Instructor instr = list.get(j);
  instr.populateCoursesTaught();
  System.out.println(instr);
  instr.putGrades();
 }
 private static void tryGrading1() {
  for(var instr : CourseManagement.allInstructors) {
   instr.populateCoursesTaught();
   instr.putGrades();
  }
 }
}
