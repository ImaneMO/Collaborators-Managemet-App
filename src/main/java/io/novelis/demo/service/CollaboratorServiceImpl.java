package io.novelis.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.novelis.demo.dao.CollaboratorRepository;
import io.novelis.demo.entity.Collaborator;

@Service
public class CollaboratorServiceImpl implements CollaboratorService {
	
	private final CollaboratorRepository collaboratorRepository;
	

	@Autowired
	public CollaboratorServiceImpl(CollaboratorRepository theCollaboratorRepository) {
		collaboratorRepository = theCollaboratorRepository;
	}


	@Override
	public List<Collaborator> findAll() {
		List<Collaborator> collaborators = collaboratorRepository.findAll();
        return collaborators;
	}

	@Override
	public Optional<Collaborator> findByID(int theID) {
		Optional<Collaborator> result = collaboratorRepository.findById(theID);
		if(result.isPresent()) {
			return result;
		}else {
			throw new NullPointerException("We haven't found your collaborator!");
		}
	}

	/*@Override
	/* public ResponseEntity<CollaboratorDTO> AddCollaborator(CollaboratorDTO collaborator) {
		Collaborator save = collaboratorRepository.save(collaboratorDTO.convertToCollaborator());
        save.convertToDTO(); 
        return new ResponseEntity<CollaboratorDTO>(collaborator, HttpStatus.OK);
	} */
	
	
	@Override
	public Collaborator AddCollaborator(Collaborator collaborator) throws NullPointerException {
		Collaborator saved = collaboratorRepository.save(collaborator);
        return saved; 
	}
	
	@Override
	public Collaborator updateCollaborator(Collaborator collaborator) {
		Optional<Collaborator> optionalCollaborator = collaboratorRepository.findById(collaborator.getId());
        if (!optionalCollaborator.isPresent()) {
        	throw new RuntimeException("Could not find a Coollaborator with id " + collaborator.getId());
        } 
        return new Collaborator(optionalCollaborator.get().getFirstName(), 
        		optionalCollaborator.get().getLastName(), 
        		optionalCollaborator.get().getCivility(), 
        		optionalCollaborator.get().getDateOfBirth(), 
        		optionalCollaborator.get().getEmail(),
        		optionalCollaborator.get().getphone_number());
	}
	

	@Override
	public void deleteByID(int theID) {
		if (collaboratorRepository.existsById(theID)) {
			collaboratorRepository.deleteById(theID);
        } else {
            throw new RuntimeException("Did not find Collaborator with id - "+theID);
        }
	}
	
	
	
}
