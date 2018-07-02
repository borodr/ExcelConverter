package com.converter.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ActuatorMetricWriter;
import org.springframework.stereotype.Service;

import com.converter.Model.OrganizacionaJedinica;
import com.converter.Repository.OrganizacionaJedinicaRep;

@Service
public class OrganizacionaJedinicaService {

	
	private final OrganizacionaJedinicaRep orgrep;
	
	
	@Autowired
	public OrganizacionaJedinicaService(OrganizacionaJedinicaRep orgrep) {
		this.orgrep = orgrep;
	}
	
	
	public List<OrganizacionaJedinica> findAll(){
		return (List<OrganizacionaJedinica>) orgrep.findAll();
	}
}
