package com.imooc.dao;

import java.util.List;

import com.imooc.bean.Area;

public interface AreaDao {
	/**
	 * 列出区域列表
	 * 
	 * @return areaList
	 */
	public List<Area> queryArea();

	/**
	 * 根据Id列出具体区域
	 * 
	 * @return area
	 */
	public Area queryAreaById(int areaId);

	/**
	 * 插入区域信息
	 * 
	 * @param area
	 * @return
	 */
	public int insertArea(Area area);

	/**
	 * 更新区域信息
	 * 
	 * @param area
	 * @return
	 */
	public int updateArea(Area area);

	/**
	 * 删除区域信息
	 * 
	 * @param areaId
	 * @return
	 */
	public int deleteArea(int areaId);
}
