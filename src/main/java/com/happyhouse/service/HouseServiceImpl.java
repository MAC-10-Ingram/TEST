package com.happyhouse.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happyhouse.mapper.HouseMapper;
import com.happyhouse.model.HouseInfoDto;
import com.happyhouse.model.SidoGugunCodeDto;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseMapper houseMapper;
	
	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return houseMapper.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return houseMapper.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return houseMapper.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong, HttpSession session) throws Exception {
		if (session.getAttribute("id") == null) {
			houseMapper.insertRecentDong(dong);
			return houseMapper.getAptInDong(dong);
		} else {
			houseMapper.insertRecentDong(dong);
			Map<String, String> map = new HashMap<>();
			map.put("dong", dong);
			map.put("id", (String)session.getAttribute("id"));
			return houseMapper.getAptInDongByLogin(map);
		}
	}

	@Override
	public List<HouseInfoDto> getAptInAptName(String aptName, HttpSession session) throws Exception {
		if (session.getAttribute("id") == null) {
			houseMapper.insertRecentApt(aptName);
			return houseMapper.getAptInAptName(aptName);
		} else {
			houseMapper.insertRecentApt(aptName);
			Map<String, String> map = new HashMap<>();
			map.put("aptName", aptName);
			map.put("id", (String)session.getAttribute("id"));
			return houseMapper.getAptInAptNameByLogin(map);
		}
	}

	@Override
	public List<HouseInfoDto> getPopularDong() throws SQLException {
		return houseMapper.getPopularDong();
	}

	@Override
	public List<HouseInfoDto> getPopularApt() throws SQLException {
		return houseMapper.getPopularApt();
	}

}
