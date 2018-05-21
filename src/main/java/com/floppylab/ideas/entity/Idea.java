package com.floppylab.ideas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.floppylab.ideas.dto.IdeaDto;
import com.floppylab.ideas.helper.IdeaType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "idea")
@NoArgsConstructor
public class Idea {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "is_private", nullable=false)
	private Boolean isPrivate;

	@Column(name = "name", length=200, nullable=false)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable=false) 
	private Date creationDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated", nullable=false) 
	private Date lastUpdated;
	
	@Column(name = "type", nullable=false)
	@Enumerated(EnumType.STRING)
	private IdeaType type;
	
	@Column(name = "short_description", length=300)
	private String shortDescription;
	
	@Column(name = "description", length=1500)
	private String description;

	public Idea(IdeaDto ideaDto) {
		this.name = ideaDto.getName();
		this.type = ideaDto.getType();
		this.shortDescription = ideaDto.getShortDescription();
		this.description = ideaDto.getDescription();
	}
	
    @PrePersist
	public void prePersist() {
    	this.isPrivate = true;
    	this.creationDate = new Date();
    	this.lastUpdated = creationDate;
    	this.type = IdeaType.YELLOW;
    }
    
    @PreUpdate
	public void preUpdate() {
    	this.lastUpdated = new Date();
    }

}