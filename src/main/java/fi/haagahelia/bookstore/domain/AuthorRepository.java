package fi.haagahelia.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{
	
}
