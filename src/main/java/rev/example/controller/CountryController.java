package rev.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rev.example.model.Country;
import rev.example.service.CountryService;

import java.util.List;


@RestController
@RequestMapping("api/country")
public class CountryController {

    @Autowired
    CountryService count = new CountryService();

    @PostMapping("create")
    public ResponseEntity<Country> createUser(@RequestBody Country insert) {
        Country country = count.insertcountry(insert);
        return new ResponseEntity<>(country, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<Country> getCountryByName(@RequestParam String name) {
        Country country = count.getCountryByName(name);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<Country>> getCountries() {
        List<Country> countries = count.getCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteCountryByName(@RequestParam String name) {
        Boolean delete = count.deleteCountryByName(name);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}