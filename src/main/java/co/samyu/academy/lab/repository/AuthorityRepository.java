package co.samyu.academy.lab.repository;

import co.samyu.academy.lab.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 07/Feb/2017.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
