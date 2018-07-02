package com.converter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.converter.Model.Radnik;

public interface RadnikRepository extends JpaRepository<Radnik, Integer>{

	Radnik findOneByKorimeAndKorlozinka(String korime, String korlozinka);
}
