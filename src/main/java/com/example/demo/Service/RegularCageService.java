package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.RegularCage;
import com.example.demo.Repo.RegularCageRepository;

@Service
public class RegularCageService {
	public static final int DEFAULT_SOLD = 0;// replace by orderitem sold number
	@Autowired
	RegularCageRepository regularCageRepository;
	
	public List<RegularCage> getRegularCageList(){
		List<RegularCage> cageList = regularCageRepository.findAll();
		return cageList;
	}
	public RegularCage getRegularCageById(int cageId) {
		RegularCage cage = regularCageRepository.findById(cageId);
		return cage;
<<<<<<< HEAD
	}
	public boolean checkExist(int cageId) {
		if(regularCageRepository.existsById(cageId)) {
			return true;
		}
		return false;
	}
=======
	}	
>>>>>>> bae8eb462db280c2ce65fe41100d52b2c7b606d0
}