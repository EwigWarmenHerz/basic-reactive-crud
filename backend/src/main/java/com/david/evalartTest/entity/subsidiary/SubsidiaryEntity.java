package com.david.evalartTest.entity.subsidiary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("subsidiary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubsidiaryEntity {
    @Id
    long id;
    String name;
}
