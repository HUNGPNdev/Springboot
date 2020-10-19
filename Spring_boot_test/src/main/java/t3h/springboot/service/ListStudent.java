package t3h.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import t3h.springboot.model.Student;

@Service
public class ListStudent implements IListStudent{
	
	@Autowired
	private IListStudent list;
	
	List<Student> listSt = new ArrayList<Student>();
	
	@Override
	public List<Student> getStudent(Student st) {
		listSt.add(st);
		return listSt;
	}

	@Override
	public List<Student> deleteStudent(String id) {
		for (int i = 0; i < listSt.size(); i++) {
			if (listSt.get(i).getId().equals(id)) {
				listSt.remove(i);
			}
		}
		return listSt;
	}

	@Override
	public List<Student> listStudent() {
		return listSt;
	}

	@Override
	public List<Student> editStudent(String ida, String id, String name) {
		for (int i = 0; i < listSt.size(); i++) {
			if (listSt.get(i).getId().equals(ida)) {
				listSt.get(i).setId(id);
				listSt.get(i).setName(name);
			}
		}
		return listSt;
	}
	
	
}
