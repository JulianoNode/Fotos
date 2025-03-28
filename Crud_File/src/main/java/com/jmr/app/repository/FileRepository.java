package com.jmr.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.jmr.app.domain.File;
public interface FileRepository extends JpaRepository<File, Long>{
	@Query("select e from File e where e.nome like :search%")
	Page<File> findAllBynome(String search, Pageable pageable);	
}
