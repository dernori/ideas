package com.floppylab.ideas.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.floppylab.ideas.entity.Idea;
import com.floppylab.ideas.helper.IdeaType;

public interface IdeaRepository extends PagingAndSortingRepository<Idea, Long> {
	
	Idea findById(Long id);
	
	Page<Idea> findAllByOrderByLastUpdatedDesc(Pageable pageable);
	
	Page<Idea> findByTypeOrderByLastUpdatedDesc(IdeaType type, Pageable pageable);
    
}
