package cz.uhk.kppro.repository;

import cz.uhk.kppro.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}
