package Fruitables.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageProductDTO {

    private Meta meta;
    private List<ProductDTO> productDTOList;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Meta{
        private int page;
        private int pageSize;
        private int pages;
        private Long total;
    }



}
