package com.bwsk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwsk.entity.Company;
import com.bwsk.service.CompanyService;
import com.bwsk.util.Result;
/**
 * 公司相关的接口
 * @author lujian
 *
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	 	
	/**
	 * 通过微信ID或者用户ID查询关联的信息
	 * @param user
	 * @return
	 */
	@RequestMapping("/queryCompanyByUidOrCid")
	public Result<?> queryCompanyByUidOrCid(Company company) {
		List<Company> list=companyService.queryCompanyByUidOrCid(company);
		if(list!=null&&list.size()>0) {
			return	Result.success(list);
		}else {
			return Result.error(500, "服务端错误");
		}
	}
	
	/**
	 * 添加或者修改公司信息
	 * @param company
	 * @return
	 */
	@RequestMapping("/insertOrUpdateCompany")
	public Result<?> insertOrUpdateCompany(Company company) {	
		int row=companyService.insertOrUpdateCompany(company);
		if(row>0) {
			return	Result.success("操作成功");
		}else {
			return Result.error(500, "服务端错误");
		}	
	}
}
