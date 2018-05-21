package com.floppylab.ideas.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.floppylab.ideas.dto.IdeaDto;
import com.floppylab.ideas.entity.Idea;
import com.floppylab.ideas.helper.IdeaType;
import com.floppylab.ideas.repository.IdeaRepository;

@Service
@Transactional
public class IdeaService {

	@Autowired
	private IdeaRepository ideaRepository;
	
	@Autowired
	private MarkdownService markdownService;

	private static final int PAGE_SIZE = 9;

	public Page<Idea> getIdeas(Integer page) {
		PageRequest request = new PageRequest((page != null ? page : 0), PAGE_SIZE);
		return ideaRepository.findAllByOrderByLastUpdatedDesc(request);
	}
	
	public Page<Idea> getIdeas(Integer page, IdeaType type) {
		PageRequest request = new PageRequest((page != null ? page : 0), PAGE_SIZE);
		return ideaRepository.findByTypeOrderByLastUpdatedDesc(type, request);
	}
	
	public Idea getIdea(Long id) {
		Idea idea = ideaRepository.findById(id);
		idea.setDescription(markdownService.convertToHtml(idea.getDescription()));
		return idea;
	}

	public void saveIdea(IdeaDto ideaDto) {
		Idea idea = new Idea(ideaDto);	
		ideaRepository.save(idea);
	}
	
	public void modifyIdea(IdeaDto ideaDto) {
		Idea idea = ideaRepository.findById(ideaDto.getId());	
		idea.setName(ideaDto.getName());
		idea.setType(ideaDto.getType());
		idea.setShortDescription(ideaDto.getShortDescription());
		idea.setDescription(ideaDto.getDescription());
		ideaRepository.save(idea);
	}
	
	public void deleteAll() {
		ideaRepository.deleteAll();
	}

	public void delete(Long id) {
		ideaRepository.delete(id);		
	}

	

	
}
