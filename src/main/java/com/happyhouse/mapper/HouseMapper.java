package com.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.happyhouse.model.HouseInfoDto;
import com.happyhouse.model.SidoGugunCodeDto;

@Mapper
public interface HouseMapper {

	List<SidoGugunCodeDto> getSido() throws SQLException;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws SQLException;
	List<HouseInfoDto> getDongInGugun(String gugun) throws SQLException;
	List<HouseInfoDto> getAptInDong(String dong) throws SQLException;
	List<HouseInfoDto> getAptInAptName(String aptName) throws SQLException;
	List<HouseInfoDto> getAptInDongByLogin(Map<String, String> map) throws SQLException;
	List<HouseInfoDto> getAptInAptNameByLogin(Map<String, String> map) throws SQLException;
	List<HouseInfoDto> getPopularDong() throws SQLException;
	List<HouseInfoDto> getPopularApt() throws SQLException;
	void insertRecentDong(String dong) throws SQLException;
	void insertRecentApt(String aptName) throws SQLException;
}
