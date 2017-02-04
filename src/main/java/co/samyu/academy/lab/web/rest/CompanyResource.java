package co.samyu.academy.lab.web.rest;

import co.samyu.academy.lab.domain.Building;
import co.samyu.academy.lab.domain.City;
import co.samyu.academy.lab.domain.Company;
import co.samyu.academy.lab.repository.BuildingRepository;
import co.samyu.academy.lab.repository.CityRepository;
import co.samyu.academy.lab.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * Created on 03/Feb/2017.
 */
@RestController
@RequestMapping("/api")
public class CompanyResource {

    private static final Logger LOG = LoggerFactory.getLogger(CompanyResource.class);

    @Autowired
    private CompanyRepository companyRepository;

    @RequestMapping(value = "/companies", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> create(@Valid @RequestBody Company company) throws URISyntaxException {
        LOG.debug("REST request to save Company : {}", company);
        if (company.getId() != null) {
            // return ResponseEntity.badRequest().header("Failure", "A new city cannot already have an ID").build();
        }
        return Optional.ofNullable(companyRepository.save(company))
                .map(companyDetail -> new ResponseEntity<>(
                        companyDetail,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/companies", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> update(@Valid @RequestBody Company company) throws URISyntaxException {
        LOG.debug("REST request to update Company : {}", company);
        return Optional.ofNullable(companyRepository.save(company))
                .map(companyDetail -> new ResponseEntity<>(
                        companyDetail,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Company> getBuildings() {
        return companyRepository.findAll();
    }

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> get(@PathVariable Long id) {
        LOG.debug("REST request to get Company : {}", id);
        return Optional.ofNullable(companyRepository.findOne(id))
                .map(company -> new ResponseEntity<>(company, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id)throws Exception  {
        LOG.debug("REST request to delete Company : {}", id);
        companyRepository.delete(id);
    }

}

