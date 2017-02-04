package co.samyu.academy.lab.web.rest;

import co.samyu.academy.lab.domain.Building;
import co.samyu.academy.lab.domain.City;
import co.samyu.academy.lab.repository.BuildingRepository;
import co.samyu.academy.lab.repository.CityRepository;
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
public class CityResource {

    private static final Logger LOG = LoggerFactory.getLogger(CityResource.class);

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(value = "/cities", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> create(@Valid @RequestBody City city) throws URISyntaxException {
        LOG.debug("REST request to save City : {}", city);
        if (city.getId() != null) {
            // return ResponseEntity.badRequest().header("Failure", "A new city cannot already have an ID").build();
        }
        return Optional.ofNullable(cityRepository.save(city))
                .map(cityDetail -> new ResponseEntity<>(
                        cityDetail,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/cities", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> update(@Valid @RequestBody City city) throws URISyntaxException {
        LOG.debug("REST request to update City : {}", city);
        return Optional.ofNullable(cityRepository.save(city))
                .map(cityDetail -> new ResponseEntity<>(
                        cityDetail,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/cities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> getBuildings() {
        return cityRepository.findAll();
    }

    @RequestMapping(value = "/cities/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> get(@PathVariable Long id) {
        LOG.debug("REST request to get City : {}", id);
        return Optional.ofNullable(cityRepository.findOne(id))
                .map(city -> new ResponseEntity<>(
                        city,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/cities/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id)throws Exception  {
        LOG.debug("REST request to delete City : {}", id);
        cityRepository.delete(id);
    }

}
