package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BreweryClientTest {
    @Autowired
    BreweryClient breweryClient;

    @Test
    public void getBeerById() {
        BeerDto dto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSavedNewBeer() {
        BeerDto dto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").beerStyle("New Style").upc(10L).build();
        URI uri = breweryClient.saveNewBeer(dto);

        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testSavedBeer() {
        BeerDto dto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").beerStyle("New Style").upc(10L).build();

        breweryClient.updateBeer(UUID.randomUUID(), dto);
    }

    @Test
    void testDeleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}
