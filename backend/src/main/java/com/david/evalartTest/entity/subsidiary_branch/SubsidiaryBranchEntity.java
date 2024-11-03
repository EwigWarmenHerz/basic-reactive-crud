package com.david.evalartTest.entity.subsidiary_branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("subsidiary_branch")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubsidiaryBranchEntity {

    @Id
    long id;
    String name;
    @Column("subsidiary_id")
    long subsidiaryId;


}
