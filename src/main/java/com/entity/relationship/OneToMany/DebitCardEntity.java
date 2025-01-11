package com.entity.relationship.OneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "debitCards")
@Data

public class DebitCardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer debitCardId;
	String title;
	
	@ManyToOne
	@JoinColumn(name = "accountId")
	AccountEntity account;
	
}
