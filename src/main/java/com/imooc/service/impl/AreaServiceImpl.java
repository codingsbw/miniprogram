package com.imooc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.bean.Area;
import com.imooc.dao.AreaDao;
import com.imooc.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao areaDao;

	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		return areaDao.queryArea();
	}

	@Override
	public Area getAreaById(int areaId) {
		// TODO Auto-generated method stub
		return areaDao.queryAreaById(areaId);
	}

	@Transactional
//	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean addArea(Area area) {
		// TODO Auto-generated method stub
		if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
			area.setCreateTime(new Date());
			area.setLastEditTime(new Date());
			try {
				int effectedNum = areaDao.insertArea(area);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("插入区域信息失败！");
				}
			} catch (Exception e) {
				throw new RuntimeException("插入区域信息失败：" + e.getMessage());
			}
		} else {
			throw new RuntimeException("区域信息不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean modifyArea(Area area) {
		// TODO Auto-generated method stub
		if (area.getAreaId() != null && !"".equals(area.getAreaId())) {
			area.setLastEditTime(new Date());
			try {
				int effectedNum = areaDao.updateArea(area);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("更改区域信息失败！");
				}
			} catch (Exception e) {
				throw new RuntimeException("更改区域信息失败：" + e.getMessage());
			}
		} else {
			throw new RuntimeException("区域ID不能为空！");
		}
	}

	@Transactional
	@Override
	public boolean deleteArea(int areaId) {
		// TODO Auto-generated method stub
		if (areaId > 0) {
			try {
				int effectedNum = areaDao.deleteArea(areaId);
				if (effectedNum > 0) {
					return true;
				} else {
					throw new RuntimeException("删除区域信息失败！");
				}
			} catch (Exception e) {
				throw new RuntimeException("删除区域信息失败：" + e.getMessage());
			}
		} else {
			throw new RuntimeException("区域ID不能为空！");
		}
	}

}
