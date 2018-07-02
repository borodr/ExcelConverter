package com.converter.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.converter.Model.KorGrupa;
import com.converter.Repository.KorGrupaRepository;

@Service
public class KorGrupaService {

	private KorGrupaRepository korrep;
	
	@Autowired
	public KorGrupaService(KorGrupaRepository korrep) {
		this.korrep = korrep;
	}
	
	
	public List<KorGrupa> findAll() {
		return (List<KorGrupa>) korrep.findAll();
	}
}
