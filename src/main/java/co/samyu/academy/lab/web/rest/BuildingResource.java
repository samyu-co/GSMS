package co.samyu.academy.lab.web.rest;

import co.samyu.academy.lab.domain.Building;
import co.samyu.academy.lab.repository.BuildingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created on 03/Feb/2017.
 */

@RestController
@RequestMapping("/api")
public class BuildingResource {

    private static final Logger LOG = LoggerFactory.getLogger(BuildingResource.class);

    @Autowired
    private BuildingRepository buildingRepository;

    @RequestMapping(value = "/buildings", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
       public ResponseEntity<Building> create(@Valid @RequestBody Building building) throws URISyntaxException {
        LOG.debug("REST request to save Building : {}", building);
        if (building.getId() != null) {
            // return ResponseEntity.badRequest().header("Failure", "A new building cannot already have an ID").build();
        }
        return Optional.ofNullable(buildingRepository.save(building))
                .map(buildingDetail -> new ResponseEntity<>(
                        buildingDetail,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/buildings", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Building> update(@Valid @RequestBody Building building) throws URISyntaxException {
        LOG.debug("REST request to update Building : {}", building);
        return Optional.ofNullable(buildingRepository.save(building))
                .map(buildingDetail -> new ResponseEntity<>(
                        buildingDetail,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/buildings", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Building> getBuildings() {
        return buildingRepository.findAll();
    }

    @RequestMapping(value = "/buildings/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Building> get(@PathVariable Long id) {
        LOG.debug("REST request to get Building : {}", id);
        return Optional.ofNullable(buildingRepository.findOne(id))
                .map(cargo -> new ResponseEntity<>(
                        cargo,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/building/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id)throws Exception  {
        LOG.debug("REST request to delete Building : {}", id);
            buildingRepository.delete(id);
    }

}
