package com.miki.seconddemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miki.seconddemo.Utils.ResultUtils;
import com.miki.seconddemo.domain.Girl;
import com.miki.seconddemo.domain.Result;
import com.miki.seconddemo.propertory.GirlPropertory;
import com.miki.seconddemo.service.GirlService;

@RestController
@RequestMapping("/gril")
public class GirlController {

	private final static Logger logger = LoggerFactory.getLogger(GirlController.class); 
	
	@Autowired
	private GirlPropertory girlPropertory;
	
	@Autowired
	private GirlService girlService;
	
	@Autowired
	private ResultUtils resultUtils;
	
	/**
	 * 查询所有女生列表
	 * @return
	 */
	@GetMapping(value="/girlList")
	public Result<Girl> girlList(){
		logger.info("girlList");
		Result result = new Result<>();
		if(girlPropertory.findAll() != null ){
			return resultUtils.success("查询",girlPropertory.findAll());
		}else{
			return resultUtils.error(201, "查询失败");
		}
	}
	
	/**
	 * 新增女生信息
	 * @return
	 */
	@PostMapping(value="addGirl")
	public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
//			return null;
			return resultUtils.error(201, "新增失败,"+bindingResult.getFieldError().getDefaultMessage());
		}
		girl.setCupSize(girl.getCupSize());
		girl.setAge(girl.getAge());
		girl.setMoney(girl.getMoney());
		return resultUtils.success("新增女生信息", girlPropertory.save(girl));
	}
	
	/**
	 * 通过id查询女生
	 * @param id
	 * @return
	 */
	@GetMapping(value="queryGirlById")
	public Result<Girl> queryGirlById(@RequestParam("id") Integer id){
		if(girlPropertory.findById(id).get() != null){
			return resultUtils.error(201, "查询失败");
		}
		return resultUtils.success("查询",girlPropertory.findById(id).get());
	}
	
	/**
	 * 通过id更新女生
	 * @param id
	 * @param cupSize
	 * @param age
	 * @return
	 */
	@PostMapping(value="updateGirlById")
	public Result<Girl> updateGirlById(@RequestParam("id") Integer id,
							   @RequestParam("cupSize") String cupSize,
							   @RequestParam("age") Integer age){
		Girl girl = new Girl();
		girl.setAge(age);
		girl.setId(id);
		girl.setCupSize(cupSize);
		if(girlPropertory.save(girl) != null){
			return resultUtils.error(201, "更新失败");
		}
		return resultUtils.success("更新",girlPropertory.save(girl));
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
	public Result<Girl> findByAge(@RequestParam("age") Integer age){
		if(girlPropertory.findByAge(age) != null){
			return resultUtils.error(201, "更新失败");
		}
		return resultUtils.success("更新",girlPropertory.findByAge(age));
	}
	
	/**
	 * 事务操作，插入两条数据
	 */
	@PostMapping(value="insertTwo")
	public void insertTwo(){
		girlService.insertTwo();
	}
	
	/**
	 * 获取女生的age
	 * @throws Exception 
	 */
	@GetMapping(value="getAge")
	public void getAge(@RequestParam("id") Integer id) throws Exception{
		girlService.getAge(id);
	}
}
