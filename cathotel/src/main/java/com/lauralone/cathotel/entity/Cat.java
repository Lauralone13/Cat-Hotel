package com.lauralone.cathotel.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Cat")
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String sex; //enum (? dropdown menue to choose)
	private int age;
	private String color;
	private boolean ownerKnown;

	public Cat() {
		super();
	}

	public Cat(int id, String name, String sex, int age, String color, boolean ownerKnown) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.color = color;
		this.ownerKnown = ownerKnown;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isOwnerKnown() {
		return ownerKnown;
	}

	public void setOwnerKnown(boolean ownerKnown) {
		this.ownerKnown = ownerKnown;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cat cat = (Cat) o;
		return getId() == cat.getId() && getAge() == cat.getAge() && isOwnerKnown() == cat.isOwnerKnown() && Objects.equals(getName(), cat.getName()) && Objects.equals(getSex(), cat.getSex()) && Objects.equals(getColor(), cat.getColor());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getSex(), getAge(), getColor(), isOwnerKnown());
	}

	@Override
	public String toString() {
		return "Cat{" +
				"id=" + id +
				", name='" + name + '\'' +
				", sex='" + sex + '\'' +
				", age=" + age +
				", color='" + color + '\'' +
				", ownerKnown=" + ownerKnown +
				'}';
	}
}
