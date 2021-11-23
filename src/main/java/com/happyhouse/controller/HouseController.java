package com.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.model.HouseInfoDto;
import com.happyhouse.model.SidoGugunCodeDto;
import com.happyhouse.service.HouseService;

@RestController
@RequestMapping("/map")
public class HouseController {

	@Autowired
	private HouseService houseService;
	
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
		return new ResponseEntity<List<SidoGugunCodeDto>>(houseService.getSido(), HttpStatus.OK);
	}
	
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(@RequestParam("sido") String sido) throws Exception {
		return new ResponseEntity<List<SidoGugunCodeDto>>(houseService.getGugunInSido(sido), HttpStatus.OK);
	}
	
	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(houseService.getDongInGugun(gugun), HttpStatus.OK);
	}
	
	@GetMapping("/apt")
	public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong, String id) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(houseService.getAptInDong(dong, id), HttpStatus.OK);
	}
	
	@GetMapping("/apt2")
	public ResponseEntity<List<HouseInfoDto>> apt2(@RequestParam("aptName") String aptName, String id) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(houseService.getAptInAptName(aptName, id), HttpStatus.OK);
	}
	
	@GetMapping("/popularDong")
	public ResponseEntity<List<HouseInfoDto>> getPopularDong() throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(houseService.getPopularDong(), HttpStatus.OK);
	}
	
	@GetMapping("/popularApt")
	public ResponseEntity<List<HouseInfoDto>> getPopularApt() throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(houseService.getPopularApt(), HttpStatus.OK);
	}
}
