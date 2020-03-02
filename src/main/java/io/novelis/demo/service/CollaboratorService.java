package io.novelis.demo.service;

import java.util.List;
import java.util.Optional;

import io.novelis.demo.entity.Collaborator;

public interface CollaboratorService {

	public List<Collaborator> findAll();
	
	public Optional<Collaborator> findByID(int theID);
	
	public Collaborator AddCollaborator(Collaborator collaborator) throws Exception;
	
	public Collaborator updateCollaborator(Collaborator collaborator);
	
	public void deleteByID(int theID);

}
