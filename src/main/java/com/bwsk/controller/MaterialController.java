package com.bwsk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bwsk.entity.Material;
import com.bwsk.service.MaterialService;
import com.bwsk.util.Result;
import com.bwsk.util.Utils;

/**
 * 用户相关的接口
 * 
 * @author lujian
 *
 */
@RestController
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private MaterialService materialService;

	/**
	 * 添加或者修改材料信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/insertMaterial")
	public Result<?> insertMaterial() {
		List<Material> list = new ArrayList<Material>();
		Material material = new Material();
		material.setMtname("钢筋222");
		String str = "1586448000";
		material.setMttime(Utils.timeStampDate(str, null));
		material.setMttype(2);
		material.setMtremark("一般般111");
		material.setMtstatus(0);
		material.setPid(11);
		list.add(material);
		int row = materialService.insertMaterial(list);
		if (row > 0) {
			return Result.success("操作成功");
		} else {
			return Result.error(500, "服务端错误");
		}

	}

	/**
	 * 查询所有的材料提醒
	 * 
	 * @param collectionMoney
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryMaterials")
	public Result<?> queryMaterials(Material material) throws Exception {
		List<Material> list = materialService.queryMaterials(material);
		return Result.success(list);
	}

}
