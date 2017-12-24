package entity;

/**
 * Title:Teacher-Data存储类<br>
 * Description:此类可以存放或是复制老师在数据库的信息，以供其他组件使用
 * 
 * @author a-member
 * @version 1.0
 */
public class Teacher {
	public String name;
	public String id;
	public String sex;
	public String department_Name;
	public float  salary;

	public Teacher() {
		
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDepartment_Name(String department_Name) {
		this.department_Name = department_Name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getDepartment_Name() {
		return department_Name;
	}

	public float getSalary() {
		return salary;
	}
}
