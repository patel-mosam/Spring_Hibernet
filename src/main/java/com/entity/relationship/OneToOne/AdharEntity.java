package com.entity.relationship.OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="adhar")
@Data
public class AdharEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer adharId;
	String adharNum;

	@OneToOne
	@JoinColumn(name = "citizenId")
	CitizenEntity citizen;

}
