package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name="MSMP_IPL_TEAM_INFO1")
@Data
@RequiredArgsConstructor
public class IPLTeam implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer teamId;
	@NonNull
	@Column(length = 20)
	private   String  teamName;
	@NonNull
	@Column(length = 20)
	private   String owner;
	@NonNull
	@Column(length = 20)
	private   String  area;
	
	public IPLTeam() {
	 System.out.println("IPLTeam::0-param constructor");
	}


}
