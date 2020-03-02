package io.novelis.demo.rest;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.novelis.demo.dao.CollaboratorRepository;
import io.novelis.demo.dto.AppResponse;
import io.novelis.demo.dto.CollaboratorDTO;
import io.novelis.demo.dto.CollaboratorDetailsResponse;
import io.novelis.demo.dto.CollaboratorListResponse;
import io.novelis.demo.dto.ErrorResponse;
import io.novelis.demo.dto.PageMeta;
import io.novelis.demo.dto.SuccessResponse;
import io.novelis.demo.entity.Collaborator;
import io.novelis.demo.service.CollaboratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api( description="API for CRUD operations on collaborators.")
@RestController
@RequestMapping("/api")
public class CollaboratorRestController {
	
	private CollaboratorService collaboratorService;
	
	@Autowired
	private CollaboratorRepository collaboratorRepository;
	
			//inject CollabRepository
		@Autowired
		public CollaboratorRestController(CollaboratorService thecollaboratorService) {
			collaboratorService = thecollaboratorService ;
		}
		
		@GetMapping
		public AppResponse index(@RequestParam(value = "page", defaultValue = "1") int page,
                				@RequestParam(value = "page_size", defaultValue = "2") int pageSize,
                				HttpServletRequest request) {
			
			Pageable pageable = getPageable(page, pageSize);
			Page<Collaborator> collaborators = this.collaboratorRepository.findAll(pageable);
			Collection<CollaboratorDTO> collaboratorDTOs = buildCollaborators(collaborators);
			return new CollaboratorListResponse(PageMeta.build(collaborators, request.getRequestURI()), collaboratorDTOs);
		
		}
	
		//expose "/collaborators" & return list of employees
		@ApiOperation(value = "Recuperate the list of all the collaborators.")
		@GetMapping("/collaborators")
		public List<Collaborator> findAll(){
			List<Collaborator> collabList = collaboratorService.findAll();
			return collabList;	
		}
		
		//expose "/collaborators/{id}
		@ApiOperation(value = "Recuperate a collaborator based on his ID on the condition that he exists!")
		@GetMapping("/collaborators/{id}")
		public ResponseEntity<AppResponse> findById(@PathVariable int id) {
			Optional<Collaborator> collaborator = this.collaboratorRepository.findById(id);
			return collaborator.<ResponseEntity<AppResponse>>map(collaborator1 -> new ResponseEntity<>(new CollaboratorDetailsResponse(collaborator1), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(
						new ErrorResponse("Collaborator not found"), HttpStatus.NOT_FOUND));
		}
		
		@ApiOperation(value = "Create a collaborator on the condition that he doesn't already exist!")
		@PostMapping("/collaborators")
		public ResponseEntity<AppResponse> AddCollaborator(@RequestBody @Valid Collaborator collaborator) throws Exception{
			collaborator.setId(0);
			return new ResponseEntity<>(new CollaboratorDetailsResponse(collaboratorRepository.save(collaborator), 
					"Collaborator created successfully"), HttpStatus.CREATED);
		}
		
		@ApiOperation(value = "Update a collaborator's informations on the condition that he exists!")
		@PutMapping("/collaborators")
		public ResponseEntity<AppResponse> updatecollaborator(@Valid @PathVariable("id") Integer id,
                @RequestBody Collaborator collaboratorInput) {
			 Optional<Collaborator> optionalCollaborator = collaboratorRepository.findById(id);
		        if (optionalCollaborator.isPresent()) {
		        	Collaborator collaborator = optionalCollaborator.get();
		        	collaborator.setFirstName(collaboratorInput.getFirstName());
		        	collaborator.setLastName(collaboratorInput.getLastName());
		        	collaborator.setEmail(collaboratorInput.getEmail());
		            return ResponseEntity.ok(new CollaboratorDetailsResponse(collaboratorRepository.save(optionalCollaborator.get()), "Collaborator updated successfully"));
		        } else {
		            return new ResponseEntity<>(new ErrorResponse("Collaborator does not exist"), HttpStatus.NOT_FOUND);
		        }
		}
		
		@ApiOperation(value = "Delete a collaborator if he is found!")
		@DeleteMapping("/collaborators/{id}")
		public ResponseEntity<AppResponse> deleteById(@PathVariable int id) {
			Optional<Collaborator> collaborator = collaboratorRepository.findById(id);
	        if (collaborator.isPresent()) {
	        	collaboratorRepository.delete(collaborator.get());
	            return ResponseEntity.ok(new SuccessResponse("You have successfully deleted the collaborator"));
	        } else {
	            return new ResponseEntity<>(new ErrorResponse("This collaborator does not exist"), HttpStatus.NOT_FOUND);
	        }
		}
		
		private Pageable getPageable(int page, int pageSize) {
	        if (page <= 0)
	            page = 1;

	        if (pageSize <= 0)
	            pageSize = 2;

	        PageRequest pageRequest = PageRequest.of(page - 1, pageSize, Sort.Direction.DESC,"id");
	        return pageRequest;
	    }
		
		private List<CollaboratorDTO> buildCollaborators(Page<Collaborator> collaborator) {
	        List<CollaboratorDTO> collaboratorDTOs = collaborator.getContent().stream().map(CollaboratorDTO::build).collect(Collectors.toList());
	        return collaboratorDTOs;
	    }
		
	


}
