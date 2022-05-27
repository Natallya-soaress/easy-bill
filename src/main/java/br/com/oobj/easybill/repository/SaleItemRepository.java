package br.com.oobj.easybill.repository;

import br.com.oobj.easybill.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {

    @Query(value = "SELECT * FROM sales_items i WHERE i.sale_id = :id", nativeQuery = true)
    List<SaleItem> findBySaleItemSale(Long id);

}
