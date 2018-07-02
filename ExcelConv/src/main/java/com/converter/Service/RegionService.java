package com.converter.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.converter.Model.Region;
import com.converter.Model.Ustanova;
import com.converter.Repository.RegionRepository;

@Service
public class RegionService {

	
	private final RegionRepository rrep;
	
	
	@Autowired
	public RegionService(RegionRepository rrep) {
		this.rrep = rrep;
	}
	
	public List<Region> findAll(){
		return (List<Region>) rrep.findAll();
	}
	
}
