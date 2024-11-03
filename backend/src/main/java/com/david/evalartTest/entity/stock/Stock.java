package com.david.evalartTest.entity.stock;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    long id;
    @Column("product_id")
    //@Schema(name = "productId", description = "The unique identifier for a product")
    long productId;
    @Column("subsidiary_branch_id")
    long subsidiaryBranchId;
    long stock;

}
