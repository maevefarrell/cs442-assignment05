package assignment05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentInvocationHandler implements InvocationHandler { 
	Student student;

	public StudentInvocationHandler(Student studentIn) {
		student = studentIn;
	}

	public Object invoke(Object proxy, Method method, Object[] args) 
			throws IllegalAccessException {  
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(student, args);
			} else if (method.getName().equals("setGrade")) {
				throw new IllegalAccessException();
   			} else if (method.getName().startsWith("populate")) {
				throw new IllegalAccessException();
   			} else if (method.getName().equals("putGrades")) {
				throw new IllegalAccessException();
			} else if (method.getName().equals("requestRegistration")) {
				return method.invoke(student, args);
			} else if (method.getName().equals("dropRegistration")) {
				return method.invoke(student, args);
			} else return method.invoke(student, args);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
