# spring2021-assignment05
spring2021-assignment05
Look for the items in upper case for the tasks you have to do. They also appear as "TODO" in the code provided. Once you do (5) and (6), you can comment out the "TODO" in (7), you can run `Test.java`. `Test` creates 200 students and enrolls all of them in 4 courses, randomly. It then asks the user to enter the letter grades (in upper case) for the students in the course(s) taught by one instructor.
1. `Course` represents a course. The fields are `courseRubric`, `courseNumber`, `courseTitle`, `credits`, `geneds`, `crnSemCombo`, and an example of the values are shown in a constructor such as `new Course("GEOG", "101", "Intro To Geog", 4, Set.of(G, N), "Key32236x202090")`. `Course` also has mappings between grade points and letter grades.
2. `Enrollment` stores a `course` and a `gradePoints` to represent a student's enrollment in a class. Using the maps in Course, the possible values of `gradePoints` are restricted to 0.0, 1.0, 1.7, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0.
3. The classes RawCourseList and CourseManagment store all the courses we are using and servis methods.
 - `Map<Course, Instructor> list` maps courses to instructors
 - `Map<Course, Integer> capacities` gives the max capacity of each course (set to 20 for testing)
 - `Map<Course, Integer> actualEnrollment` stores the actual number of students enrolled
 - `Map<Course, Set<Student>> classStudentLists` stores the set of students enrolled in each course
 - `Map<String, Course> key2CourseMap` maps the crnSemCombo of a course back to that course
 - `Set<Instructor> allInstructors` is the set of all the instructors. It as the same emlements as the array RawCourseList.instructors.
4. The methods are `findFromKey` to look up in `key2CourseMap` (if the key does not exist you get Optional.empty); `addEnrollment` to add 1 to the actualEnrollment if there is space; and `public static boolean dropEnrollment(String courseKey)`, to reduce the actualEnrollment if a student drops a course. YOU HAVE TO WRITE `dropEnrollment`
5. YOU HAVE TO WRITE some of the code of `Instructor.java`. The method `populateCoursesTaught` should be clear. In `putGrades` you first need to define a local variable `proxy`. The code you need is very similar to the definition of the proxy in line 46 of `Test.java`. LATER, we want to go back and modify this class to assign all the grades randomly and comment out the console interaction on lines 39 through 50.
6. YOU HAVE TO COMPLETE `InstructorInvocationHandler`. Look carefully at `StudentInvocationHandler` to see how to allow the invocation of specific methods and throwing IllegalAccessException for the others.
7. The class `Student` needs the method `public boolean dropRegistration(String key)` to BE COMPLETED. If the student is enrolled in the course with `crnSemCombo` equal to `key`, then that enrollment must be removed from `enrollments` and the count in `actualEnrollment`  must be reduced by 1.
8. After running `Test.java` to see everything is working, go back to (5), put in fields	`private static Random ranGen = new Random()` and `private static String[] letters = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "F"}` into Instructor and change `putGrades` to insert randome grades for the students.
9. In `Test`, change `tryGrading();` to `tryGrading1();` on line 25 and run the program again.
10. If you put 15 in new Random of `Test` line 13,  `NamesResource` line 13, `Instructor` line 11, you should get the following GPAs:

```java
Casey Samuel Mendez, semester gpa: 2.81
Morris Tammie Schmidt, semester gpa: 2.18
Mae Gerald Burke, semester gpa: 1.09
Lance Kathleen Hanna, semester gpa: 2.04
Miguel Melinda Woods, semester gpa: 2.25
Kitty Marvin Marks, semester gpa: 3.47
Irma Jacquelyn Ellison, semester gpa: 2.10
Nina Stephen Mcintosh, semester gpa: 3.50
Maribel Brittany Trevino, semester gpa: 2.08
Billy Jesus Glover, semester gpa: 2.50
Elmer Anita Valentine, semester gpa: 3.03
Darryl Annie Conner, semester gpa: 1.91
Ivan Valeria Lyons, semester gpa: 2.93
Mona Lonnie Haynes, semester gpa: 1.93
Rhea Sheena Vang, semester gpa: 2.33
Edgar Walter Saunders, semester gpa: 2.10
Jordan Milton Schwartz, semester gpa: 3.17
Mavis Gary Yang, semester gpa: 2.03
Luis Ronda Hurst, semester gpa: 1.85
Luann Gertrude Lester, semester gpa: 2.60
Candace Carrie Manning, semester gpa: 1.93
Arnold Savannah Hale, semester gpa: 2.65
Vincent Ruthie Lloyd, semester gpa: 1.35
Cecilia Autumn Dudley, semester gpa: 2.14
Thomas Ronda Frost, semester gpa: 2.33
Troy Mayra Andrade, semester gpa: 2.04
Darryl Audra Peck, semester gpa: 2.51
Dollie Clarence Coleman, semester gpa: 2.49
Earl Steven Gallagher, semester gpa: 2.35
Everett Jeanie Padilla, semester gpa: 2.68
Luella Maurice Morrow, semester gpa: 2.47
David Courtney Ibarra, semester gpa: 1.75
Brian Adrian Marsh, semester gpa: 1.06
Ernestine Nadia Cabrera, semester gpa: 2.39
Elma Duane Maddox, semester gpa: 2.25
Roberto Reginald Lutz, semester gpa: 1.71
Raul Ramon Reed, semester gpa: 2.28
Maurice Leanne Dickson, semester gpa: 2.58
Leroy Edward Hines, semester gpa: 2.00
Minerva Sean Torres, semester gpa: 3.58
Cathy Roxanne O'Neal, semester gpa: 1.90
Gertrude Alexandra Wyatt, semester gpa: 2.75
Lewis Eugene Pineda, semester gpa: 1.77
Randy Bryan English, semester gpa: 1.94
Tonia Roberto Francis, semester gpa: 2.35
Marcus Roy Maddox, semester gpa: 2.28
Shirley Jack Blake, semester gpa: 2.18
Jaclyn Allen Bray, semester gpa: 2.75
Anita Jeff Mayo, semester gpa: 1.18
Lydia Hector Mercer, semester gpa: 3.00
Nathan Beverly Hubbard, semester gpa: 2.15
Sallie Raymond Downs, semester gpa: 2.57
Ricky Brenda Hall, semester gpa: 3.50
Joan Julio Graves, semester gpa: 1.87
Jeanette Tony Clay, semester gpa: 2.33
Joseph Micheal O'Neal, semester gpa: 2.46
Ray Celina Winters, semester gpa: 1.60
Clinton Alan Miranda, semester gpa: 1.93
Gerald Roy Carey, semester gpa: 1.53
Joni Kitty Mendez, semester gpa: 1.51
Alba Darren Smith, semester gpa: 1.90
Kurt Jimmie Kim, semester gpa: 2.24
Annette Justin Robinson, semester gpa: 2.50
Travis Brad Pacheco, semester gpa: 3.23
Matthew Marcus Frey, semester gpa: 2.10
Paulette Ruthie Ochoa, semester gpa: 3.00
Heather Bridget Leon, semester gpa: 2.16
Deirdre Chester Schwartz, semester gpa: 1.58
Etta Bethany Bernard, semester gpa: 2.09
Cherry Theodore Park, semester gpa: 2.90
Martin Kevin Kidd, semester gpa: 2.25
Martin Manuel Sanders, semester gpa: 3.61
Cindy Francine Diaz, semester gpa: 1.93
Herman Emma Dennis, semester gpa: 2.50
William Rose Atkins, semester gpa: 2.75
Yvette Enrique Hanna, semester gpa: 2.33
Noreen Erna Mcdonald, semester gpa: 3.25
Rafael Mario Ashley, semester gpa: 2.60
Jeremy Arthur Stone, semester gpa: 2.88
Rick Ronald Gross, semester gpa: 2.73
Carmela Janna Patton, semester gpa: 2.78
Lesley Roberto Spears, semester gpa: 2.00
Angelica Brent Ferrell, semester gpa: 3.19
Mark Wayne Davis, semester gpa: 3.10
Carlos Matthew Mosley, semester gpa: 2.10
Ralph Andre Ross, semester gpa: 1.68
Jeff Perry Meadows, semester gpa: 2.60
Stacy Eugenia Andrade, semester gpa: 2.43
Sherri Cara Glenn, semester gpa: 2.33
Bradley Delores Pham, semester gpa: 1.43
Vernon Harry Cobb, semester gpa: 1.12
Latonya Vincent Barnes, semester gpa: 2.67
Francis Penny Meadows, semester gpa: 2.25
Aaron Enid West, semester gpa: 3.81
Ronda Leonard Saunders, semester gpa: 3.09
Tom Herman Aguirre, semester gpa: 2.28
Brett Kathleen Gates, semester gpa: 1.75
Justin Gayle Parker, semester gpa: 2.53
Luis Aaron Avila, semester gpa: 2.65
Raul Lora Gould, semester gpa: 2.68
Hattie Johnny Bautista, semester gpa: 2.00
Leroy Cassie Sampson, semester gpa: 1.51
William Cassie Bond, semester gpa: 2.06
Gordon Claude Fleming, semester gpa: 2.44
Nancy Carlos Esparza, semester gpa: 1.75
Marcia Gerald Fry, semester gpa: 2.60
Gregory Jeffrey Escobar, semester gpa: 1.93
Jeff Alvin Garrett, semester gpa: 3.15
Jeremy Sharon Mcintosh, semester gpa: 2.50
Rene Hilary Banks, semester gpa: 2.91
Bertha Reyna Peck, semester gpa: 2.79
Michael Adrian Zavala, semester gpa: 1.63
Julie Claudine Figueroa, semester gpa: 2.29
Elsie Constance Dougherty, semester gpa: 2.30
Adeline Luisa David, semester gpa: 2.68
Eric Martin Wilkerson, semester gpa: 2.53
Ilene Dollie Miranda, semester gpa: 2.47
Karl Kris Haynes, semester gpa: 2.47
Keith Victor Acosta, semester gpa: 2.83
Ian Carolyn Riley, semester gpa: 1.75
Melanie Neil Gamble, semester gpa: 1.92
Corina Janice Nicholson, semester gpa: 1.93
Gregory Benita Zimmerman, semester gpa: 2.60
Clyde Therese Coleman, semester gpa: 2.43
Ella Charlotte Ewing, semester gpa: 3.28
Hannah Jeremy Vazquez, semester gpa: 1.51
Gregory Eddie Cochran, semester gpa: 2.97
Vernon Trisha Avila, semester gpa: 2.68
Latasha Lawrence Hubbard, semester gpa: 2.90
Carly Joseph Cochran, semester gpa: 2.65
Gordon Robert Cannon, semester gpa: 2.43
Minnie Joe Coleman, semester gpa: 2.50
Francisca Angelia Bennett, semester gpa: 2.69
Andre Stanley Donovan, semester gpa: 2.30
Priscilla Maura Hodge, semester gpa: 3.15
Katharine Sidney Baker, semester gpa: 3.13
Ava Alan Mckenzie, semester gpa: 3.08
Gale Natalia Meyers, semester gpa: 2.40
Leila Seth Fischer, semester gpa: 2.21
Gene Leroy Patel, semester gpa: 2.25
Jose Marquita Gallagher, semester gpa: 2.43
Victor Paige Bowman, semester gpa: 2.97
Beatrice Erik Wood, semester gpa: 1.90
Kurt Nicole Ellison, semester gpa: 2.43
Jorge Ronda Mata, semester gpa: 1.75
Sasha Lewis Lowe, semester gpa: 2.75
Gretchen Gracie Mcdowell, semester gpa: 2.25
Clinton Harvey Costa, semester gpa: 2.71
Allan Adriana Hester, semester gpa: 2.18
Lilly Kenneth Huff, semester gpa: 2.28
Donald Cecile Bentley, semester gpa: 1.85
Desiree Tamika Wu, semester gpa: 2.08
Roy Angeline Horn, semester gpa: 2.60
Gay Cara Bates, semester gpa: 2.50
Jerome Norman Meza, semester gpa: 2.00
Jenifer Sara Levine, semester gpa: 2.93
Leroy John Ray, semester gpa: 2.35
Marc Joan Henry, semester gpa: 2.58
Kelly Wilma Cowan, semester gpa: 2.50
Maureen Jeff Conway, semester gpa: 2.40
Lance Molly Jensen, semester gpa: 1.81
Zelma Ora Maddox, semester gpa: 1.63
Christy Elinor Watts, semester gpa: 2.93
Luis Charity Jones, semester gpa: 1.68
Greg Sam Yang, semester gpa: 2.50
Bianca Sofia Church, semester gpa: 2.58
Eddie Pam Kaufman, semester gpa: 1.01
Mariana Roxanne Johns, semester gpa: 2.15
Jack Isabel Aguilar, semester gpa: 2.50
Nanette Shirley Valdez, semester gpa: 2.35
Leticia Oscar Todd, semester gpa: 1.10
Latisha Leon Garrett, semester gpa: 1.29
Chris Lottie Mueller, semester gpa: 2.58
Cathleen Russell Fernandez, semester gpa: 1.25
Dorthy Arthur Dixon, semester gpa: 2.81
Tina Chandra Aguilar, semester gpa: 2.65
Ross Jimmie Chen, semester gpa: 2.53
Eduardo Essie Ali, semester gpa: 3.60
Joseph Kyle Copeland, semester gpa: 2.43
Hugh Raul Hughes, semester gpa: 1.83
Elaine James Nicholson, semester gpa: 2.93
Chester Cecilia Tanner, semester gpa: 3.53
Katherine Jennie Bruce, semester gpa: 1.50
Roger Bonnie Woodward, semester gpa: 2.64
Vernon Wallace Rosales, semester gpa: 1.92
Thelma Jose Crosby, semester gpa: 1.08
George Leta Church, semester gpa: 2.10
Marvin Amparo Crane, semester gpa: 2.34
Virgil Flossie Skinner, semester gpa: 3.25
Jay Wade Benton, semester gpa: 2.00
Cassandra Dale Waters, semester gpa: 2.25
Johnnie Dollie Case, semester gpa: 2.18
Jordan Leslie Roth, semester gpa: 3.10
Raul Melinda Valenzuela, semester gpa: 2.29
Don Cheryl Rosario, semester gpa: 2.33
Lynda Fernando Neal, semester gpa: 2.18
Laura Lorna Sweeney, semester gpa: 2.65
Jorge Ivan Ferrell, semester gpa: 1.75
Jayne Chad Harding, semester gpa: 2.65
Willard Danny Pittman, semester gpa: 3.04
```

