package assignment05;

import java.lang.reflect.*;

public class InstructorInvocationHandler implements InvocationHandler {
	Instructor instructor;

	public InstructorInvocationHandler(Instructor instructorIn) {
		instructor = instructorIn;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws IllegalAccessException {
		try {
            if (method.getName().startsWith("get")) {
				throw new IllegalAccessException();
			} else if (method.getName().equals("setGrade")) {
				return method.invoke(instructor, args);
   			} else if (method.getName().startsWith("populate")) {
				return method.invoke(instructor, args);
   			} else if (method.getName().equals("putGrades")) {
				return method.invoke(instructor, args);
			} else if (method.getName().equals("requestRegistration")) {
				throw new IllegalAccessException();
			} else if (method.getName().equals("dropRegistration")) {
				throw new IllegalAccessException();
			} else return method.invoke(instructor, args);
// see StudentInvocationHandler and have the "get", "request...", "dropReg..."
// be the methods that throw new IllegalAccessException
// and have the "setGrade", "populate", and "putGrades" be the one that invokes
// the method for the instructor field above
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
		return null;
	}
}
