package com.floppylab.ideas.dto;

import com.floppylab.ideas.helper.IdeaType;

import lombok.Data;

@Data
public class IdeaDto {

	private Long id;
	private String name;
	private IdeaType type;
	private String shortDescription;
	private String description;

}
