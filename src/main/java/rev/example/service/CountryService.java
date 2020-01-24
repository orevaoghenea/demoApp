package rev.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rev.example.model.Country;
import rev.example.repository.CountryRepository;

import java.util.Date;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country insertcountry(Country insert) {
        Country country = new Country();
        country.setName(insert.getName());
        country.setContinent(insert.getContinent());
        country.setDateCreated(new Date());
        countryRepository.save(country);
        return country;
    }

    public Country getCountryByName(String name) {
        Country countryByName = countryRepository.findCountryByName(name);
        if(countryByName == null) {
            throw new IllegalArgumentException("Country with name " + name + "does  not exist in your database");
        }
        return countryByName;
    }

    public Country getCountryByContinent(String continent) {
       Country countryByContinent = countryRepository.findByContinent(continent);
       if (countryByContinent == null){
           throw new IllegalArgumentException("The Continent with name " + continent + " does  not exist in your database.");
       }
       return countryByContinent;
       }


    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    public boolean deleteCountryByName(String name) {
        Country country = countryRepository.findCountryByName(name);
        if(country != null){
            countryRepository.delete(country);
            return true;
        }
        return false;
    }

}



