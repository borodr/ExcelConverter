package com.converter.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.converter.Model.RobaGrupa;
import com.converter.Repository.RobaGrupaRepository;

@Service
public class RobaGrupaService {

	
	private final RobaGrupaRepository rgRep;
	
	@Autowired
	public RobaGrupaService(RobaGrupaRepository rgRep) {
		this.rgRep = rgRep;
	}
	
	
	public List<RobaGrupa> findAll(){
		return (List<RobaGrupa>) rgRep.findAll();
	}
	
}
