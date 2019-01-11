package empty;

import java.util.Date;
//对应数据库的实体类,属性名对应数据库里的字段名
public class Student {
private int	id;
private String	name;
private int	age;
private String	sex;
private Date  birth;
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public int getAge() {
	return age;
}
public String getSex() {
	return sex;
}
public Date getBirth() {
	return birth;
}
public void setId(int id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setAge(int age) {
	this.age = age;
}
public void setSex(String sex) {
	this.sex = sex;
}
public void setBirth(Date birth) {
	this.birth = birth;
}
public Student(int id, String name, int age, String sex, Date birth) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.sex = sex;
	this.birth = birth;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", birth=" + birth + "]";
}
public Student() {
	super();
}
















}
