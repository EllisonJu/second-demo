package com.miki.seconddemo.propertory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miki.seconddemo.domain.Girl;

public interface GirlPropertory extends JpaRepository<Girl, Integer> {

	//通过年龄来查询女生
	public List<Girl> findByAge(Integer age);
}
