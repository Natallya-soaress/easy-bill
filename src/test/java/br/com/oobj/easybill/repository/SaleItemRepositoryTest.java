package br.com.oobj.easybill.repository;

import br.com.oobj.easybill.enums.Status;
import br.com.oobj.easybill.model.*;
import br.com.oobj.easybill.projection.SalesByProductProjection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class SaleItemRepositoryTest {

    @Autowired
    private SaleItemRepository saleItemRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Test
    public void reportSalesByProduct(){

        List<SaleItem> items = createSaleItems();
        saleItemRepository.saveAll(items);

        List<SalesByProductProjection> sales = saleItemRepository.findBySalesByProduct();

        assertThat(sales.get(0).getName()).isEqualTo("Computador");
        assertThat(sales.get(0).getQuantity()).isEqualTo(12);

    }

    public Address createAdress(){

        Address address = new Address();

        address.setStreet("Avenida 2");
        address.setCity("Anápolis");
        address.setNumber("4");
        address.setState("Goiás");
        address.setDistrict("Jundiaí");

        return address;
    }

    public Client saveClient(){

        Client client = new Client();
        Address address = createAdress();

        client.setName("Pix");
        client.setEmail("pix@gmail.com");
        client.setCpf("44486442200");
        client.setPhoneNumber("92244840");
        client.setAddress(address);

        clientRepository.save(client);
        return client;
    }

    public Product saveProduct(){

        Product product = new Product();

        product.setName("Computador");
        product.setTaxClass("222.246.88");
        product.setPrice(new BigDecimal(1200));
        product.setImageURL("url");
        product.setDescription("Pc Dell");

        productRepository.save(product);
        return product;
    }

    public Sale saveSale(){

        Client client = saveClient();

        Sale sale = new Sale();
        sale.setDate(LocalDateTime.now());
        sale.setStatus(Status.MADE);
        sale.setClient(client);

        saleRepository.save(sale);
        return sale;
    }

    public List<SaleItem> createSaleItems(){

        List<SaleItem> items = new ArrayList<>();

        Product product = saveProduct();
        Sale sale = saveSale();

        saveSale();

        SaleItem saleItem = new SaleItem();
        saleItem.setSale(sale);
        saleItem.setQuantity(4);
        saleItem.setProduct(product);
        saleItem.setPrice(product.getPrice());

        SaleItem saleItem2 = new SaleItem();
        saleItem2.setSale(sale);
        saleItem2.setQuantity(8);
        saleItem2.setProduct(product);
        saleItem2.setPrice(product.getPrice());

        items.add(saleItem);
        items.add(saleItem2);

        return items;
    }

}