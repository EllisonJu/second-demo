package com.miki.seconddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miki.seconddemo.domain.Girl;
import com.miki.seconddemo.propertory.GirlPropertory;
import com.miki.seconddemo.service.GirlService;

@RestController
@RequestMapping("/gril")
public class GirlController {

	@Autowired
	private GirlPropertory girlPropertory;
	
	@Autowired
	private GirlService girlService;
	
	/**
	 * 查询所有女生列表
	 * @return
	 */
	@GetMapping(value="/girlList")
	public List<Girl> girlList(){
		return girlPropertory.findAll();
	}
	
	/**
	 * 新增女生信息
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping(value="addGirl")
	public Girl addGirl(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
		Girl girl = new Girl();
		girl.setCupSize(cupSize);
		girl.setAge(age);
		return girlPropertory.save(girl);
		
	}
	
	/**
	 * 通过id查询女生
	 * @param id
	 * @return
	 */
	@GetMapping(value="queryGirlById")
	public Girl queryGirlById(@RequestParam("id") Integer id){
		return girlPropertory.findById(id).get();
	}
	
	/**
	 * 通过id更新女生
	 * @param id
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping(value="updateGirlById")
	public Girl updateGirlById(@RequestParam("id") Integer id,
							   @RequestParam("cupSize") String cupSize,
							   @RequestParam("age") Integer age){
		Girl girl = new Girl();
		girl.setAge(age);
		girl.setId(id);
		girl.setCupSize(cupSize);
		return girlPropertory.save(girl);
	}
	
	/**
	 * 通过id删除女生
	 * @param id
	 * @return 
	 * @return
	 */
	@DeleteMapping(value="deleteGirlById")
	public void deleteGirlById(@RequestParam("id") Integer id){
		Girl girl = new Girl();
		girl.setId(id);
//		girlPropertory.deleteById(id);
		girlPropertory.delete(girl);
	}
	
	/**
	 * 通过age查询女生
	 * @param age
	 * @return
	 */
	@GetMapping(value="/findByAge")
	public List<Girl> findByAge(@RequestParam("age") Integer age){
		return girlPropertory.findByAge(age);
	}
	
	/**
	 * 事务操作，插入两条数据
	 */
	@PostMapping(value="insertTwo")
	public void insertTwo(){
		girlService.insertTwo();
	}
}
