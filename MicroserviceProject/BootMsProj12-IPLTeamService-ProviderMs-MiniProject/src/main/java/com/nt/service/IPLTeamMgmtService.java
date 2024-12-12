package com.nt.service;

import java.util.List;

import com.nt.entity.IPLTeam;

public interface IPLTeamMgmtService {
     public  String registerIPLTeam(IPLTeam team);
     public   List<IPLTeam> getAllTeams();
     public    IPLTeam    getTeamById(int teamId);
     public void deleteTeamById(int teamId);
}
