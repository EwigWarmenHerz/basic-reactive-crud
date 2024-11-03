package com.david.evalartTest.entity.stock;

public record MostStockedProductDto(
        String name,
        String subsidiaryName,
        String branchName,
        long totalStock
) {
}
