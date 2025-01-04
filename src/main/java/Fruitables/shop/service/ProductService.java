package Fruitables.shop.service;

import Fruitables.shop.dto.CategoryDTO;
import Fruitables.shop.dto.PageProductDTO;
import Fruitables.shop.dto.ProductDTO;
import Fruitables.shop.dto.ProductDetailDTO;
import Fruitables.shop.entity.Category;
import Fruitables.shop.entity.Image;
import Fruitables.shop.entity.Product;
import Fruitables.shop.repository.CategoryRepository;
import Fruitables.shop.repository.ProductRepository;
import Fruitables.shop.util.ImgUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepo;
    private final ImgUtil imgUtil;
    private final UserReviewService userReviewService;
    private final CategoryRepository categoryRepo;

    public ProductService(ProductRepository productRepo, ImgUtil imgUtil, UserReviewService userReviewService, CategoryRepository categoryRepo) {
        this.productRepo = productRepo;
        this.imgUtil = imgUtil;
        this.userReviewService = userReviewService;
        this.categoryRepo = categoryRepo;
    }

    public Product getById(int id){
        return productRepo.findById(id);
    }

    public PageProductDTO getAllProduct(Pageable pageable){

        PageProductDTO pageProductDTO = new PageProductDTO();

        Page<Product> productPage = this.productRepo.findAll(pageable);
        List<ProductDTO> productDTOList = convertToPageProduct(productPage);

        pageProductDTO.setMeta(new PageProductDTO.Meta(pageable.getPageNumber()+ 1,
                pageable.getPageSize(),
                productPage.getTotalPages(),
                productPage.getTotalElements()));
        pageProductDTO.setProductDTOList(productDTOList);

        return pageProductDTO;
    }

    public PageProductDTO getAllProductByCategoory(int id, Pageable pageable){

        PageProductDTO pageProductDTO = new PageProductDTO();

        Page<Product> productPage = this.productRepo.findByCategory(categoryRepo.findById(id), pageable);
        List<ProductDTO> productDTOList = convertToPageProduct(productPage);

        pageProductDTO.setMeta(new PageProductDTO.Meta(pageable.getPageNumber()+ 1,
                pageable.getPageSize(),
                productPage.getTotalPages(),
                productPage.getTotalElements()));
        pageProductDTO.setProductDTOList(productDTOList);

        return pageProductDTO;
    }

    public PageProductDTO getProductByFilter(Specification<Product> spec, Pageable pageable){

        PageProductDTO pageProductDTO = new PageProductDTO();

        Page<Product> productPage = this.productRepo.findAll(spec, pageable);
        List<ProductDTO> productDTOList = convertToPageProduct(productPage);

        pageProductDTO.setMeta(new PageProductDTO.Meta(pageable.getPageNumber()+ 1,
                pageable.getPageSize(),
                productPage.getTotalPages(),
                productPage.getTotalElements()));
        pageProductDTO.setProductDTOList(productDTOList);

        return pageProductDTO;
    }

    public ProductDetailDTO getDetail(int id){
        Product product = productRepo.findById(id);
        if(product != null){
            ProductDetailDTO productDetailDTO = new ProductDetailDTO();
            productDetailDTO.setId(product.getId());
            productDetailDTO.setName(product.getName());
            productDetailDTO.setCategory(new CategoryDTO(product.getCategory()));
            productDetailDTO.setPrice(product.getPrice());
            productDetailDTO.setDescription(product.getDescription());

            List<Image> imgList = imgUtil.getAllImgByProduct(product);
            List<String> imgURL = new ArrayList<>();
            for(Image i : imgList){
                imgURL.add(i.getUrl());
            }
            productDetailDTO.setImage(imgURL);



            return productDetailDTO;
        }
        return null;
    }

    public List<ProductDTO> convertToPageProduct(Page<Product> productPage){
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product p : productPage){
            ProductDTO newProductDTO = new ProductDTO();
            newProductDTO.setId(p.getId());
            newProductDTO.setName(p.getName());
            newProductDTO.setPrice(p.getPrice());
            newProductDTO.setDescription(p.getDescription());

            String productImg = imgUtil.getOneProductImage(p);
            newProductDTO.setImage(productImg);

            productDTOList.add(newProductDTO);
        }
        return productDTOList;
    }

}
