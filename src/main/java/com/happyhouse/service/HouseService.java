package com.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.happyhouse.model.HouseInfoDto;
import com.happyhouse.model.SidoGugunCodeDto;

public interface HouseService {

	List<SidoGugunCodeDto> getSido() throws Exception;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
	List<HouseInfoDto> getAptInDong(String dong, String id) throws Exception;
	List<HouseInfoDto> getAptInAptName(String aptName, String id) throws Exception;
	List<HouseInfoDto> getPopularDong() throws SQLException;
	List<HouseInfoDto> getPopularApt() throws SQLException;
}
