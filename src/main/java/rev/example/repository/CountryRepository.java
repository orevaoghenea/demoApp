package rev.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rev.example.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

    public Country findCountryByName(String name);

    public Country findByContinent(String continent);

}
