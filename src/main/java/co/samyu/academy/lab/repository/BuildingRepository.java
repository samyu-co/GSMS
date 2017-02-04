package co.samyu.academy.lab.repository;

import co.samyu.academy.lab.domain.Building;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 03/Feb/2017.
 */
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
