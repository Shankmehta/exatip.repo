package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.IPLPlayer;
import com.nt.repository.IPLPlayerRepository;

import lombok.extern.slf4j.Slf4j;

@Service("playerService")
@Slf4j
public class IPLPlayerMgmtServiceImpl implements IPLPlayerMgmtService {
	@Autowired
	private IPLPlayerRepository playerRepo;

	@Override
	public String registerPayer(IPLPlayer player) {
		log.info("registerPlayer(-) method");
		int idVal=playerRepo.save(player).getPid();
		return "Player is registered with the Id ::"+idVal;
	}

	@Override
	public IPLPlayer findPlayerById(int id) {
		log.info("findPlayerById(-) method");
		Optional<IPLPlayer> opt=playerRepo.findById(id);
		 if(opt.isPresent()) {
			 log.info("findPlayerById(-) --player found and returned");
			 return  opt.get();
		 }
		 log.error("Problem in finding the player");
		 throw new IllegalArgumentException("Player not found"); 
		
	}

	@Override
	public List<IPLPlayer> findAllPlayers() {
		log.info("findAllPlayer() method");
		return  playerRepo.findAll();
	}

}
