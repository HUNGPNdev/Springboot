package t3h.springboot.service;

import java.util.List;

import t3h.springboot.model.Student;

public interface IListStudent {
	public List<Student> getStudent(Student st);
	public List<Student> listStudent();
	public List<Student> deleteStudent(String id);
	public List<Student> editStudent(String ida, String id, String name);
}
