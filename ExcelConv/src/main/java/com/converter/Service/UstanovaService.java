package com.converter.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.converter.Model.Ustanova;
import com.converter.Repository.UstanovaRepository;

@Service
public class UstanovaService {

	private final UstanovaRepository urep;
	
	
	@Autowired
	public UstanovaService(UstanovaRepository urep) {
		this.urep = urep;
	}
	
	
	public List<Ustanova> findAll(){
		return (List<Ustanova>) urep.findAll();
	}
}
