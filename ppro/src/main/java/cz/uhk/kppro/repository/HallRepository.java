package cz.uhk.kppro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import cz.uhk.kppro.model.Hall;


public interface HallRepository extends JpaRepository<Hall, Long> {

}
