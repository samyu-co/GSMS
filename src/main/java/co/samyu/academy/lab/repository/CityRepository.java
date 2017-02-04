package co.samyu.academy.lab.repository;

import co.samyu.academy.lab.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 03/Feb/2017.
 */
public interface CityRepository extends JpaRepository<City, Long> {
}
