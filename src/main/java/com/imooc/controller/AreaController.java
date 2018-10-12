package com.imooc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.bean.Area;
import com.imooc.service.AreaService;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
	@Autowired
	private AreaService areaService;

	@RequestMapping("/listarea")
	public Map<String, Object> listArea() {
		Map<String, Object> modelMap = new HashMap<>();
		List<Area> areaList = areaService.getAreaList();
		modelMap.put("areaList", areaList);
		System.out.println(((List<Area>)modelMap.get("areaList")).get(0).getCreateTime());
		return modelMap;
	}

	@RequestMapping("/getareabyid")
	public Map<String, Object> getAreaById(Integer areaId) {
		Map<String, Object> modelMap = new HashMap<>();
		Area area = areaService.getAreaById(areaId);
		modelMap.put("area", area);
		return modelMap;
	}

	@RequestMapping("/addarea")
	public Map<String, Object> addArea(@RequestBody Area area) {
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("success", areaService.addArea(area));
		return modelMap;
	}

	@RequestMapping("/modifyarea")
	public Map<String, Object> modifyarea(@RequestBody Area area) {
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("success", areaService.modifyArea(area));
		return modelMap;
	}

	@RequestMapping("/removearea")
	public Map<String, Object> removearea(Integer areaId) {
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("success", areaService.deleteArea(areaId));
		return modelMap;
	}
}
