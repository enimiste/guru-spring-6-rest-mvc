package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @GetMapping
    public List<Beer> listBeers() {
        return beerService.listBeers();
    }

    @GetMapping("/{beerId}")
    public Beer getBeerById(@PathVariable("beerId") UUID id){

        log.debug("Get Beer by Id - in controller");

        return beerService.getBeerById(id);
    }

    @PostMapping
    public ResponseEntity<Void> createBeer(@RequestBody Beer beer){
        Beer savedBeer = beerService.saveNewBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "/api/v1/beer/" + savedBeer.getId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
