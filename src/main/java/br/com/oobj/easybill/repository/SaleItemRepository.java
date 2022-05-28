package br.com.oobj.easybill.repository;

import br.com.oobj.easybill.model.SaleItem;
import br.com.oobj.easybill.projection.SalesByProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {

    @Query(value = "SELECT * FROM sales_items i WHERE i.sale_id = :id", nativeQuery = true)
    List<SaleItem> findBySaleItemSale(Long id);

    @Query(value = "SELECT P.NAME AS \"NAME\", SUM(QUANTITY) AS \"QUANTITY\" FROM SALES_ITEMS I JOIN PRODUCTS P ON P.ID=I.PRODUCT_ID GROUP BY (PRODUCT_ID)", nativeQuery = true)
    List<SalesByProductProjection> findBySalesByProduct();

}
