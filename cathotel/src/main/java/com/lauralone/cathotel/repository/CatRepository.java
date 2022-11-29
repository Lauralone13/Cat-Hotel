package com.lauralone.cathotel.repository;

import com.lauralone.cathotel.entity.Cat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CatRepository extends CrudRepository<Cat, Integer> {

	List<Cat> findByName(String name);
	List<Cat> findByColor(String color);
	List<Cat> findByAge(int age);
	List<Cat> findByAgeBetween(int start, int end);

}
