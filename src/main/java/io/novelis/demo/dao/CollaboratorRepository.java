package io.novelis.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.novelis.demo.entity.Collaborator;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer> {
	
	/*@Query("select t from collaborators t where t.first_name = :Imane")
    Page<Collaborator> findByHqlName(Pageable pageRequest);
	*/
}
