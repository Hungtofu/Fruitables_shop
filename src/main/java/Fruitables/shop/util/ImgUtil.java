package Fruitables.shop.util;

import Fruitables.shop.entity.Product;
import Fruitables.shop.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImgUtil {

    @Value("${file_up_load.user-image-path}")
    private String userImagePath;

    @Value("${file_up_load.product-image-path}")
    private String productImagePath;

    @Autowired
    private ImageRepository imageRepo;

    public Path init(String sPath) {

        Path path;
        try {
            path = Paths.get(sPath);
            if(Files.notExists(path)){
                Files.createDirectories(path);
            }
            return path;
        }catch (Exception e){
            System.out.println("Error create folder: " + e.getMessage());
        }
        return null;
    }

    public String saveUserImage(String email, MultipartFile file) throws IOException {
        if (file == null || file.isEmpty() || (!file.getOriginalFilename().endsWith(".jpg") && !file.getOriginalFilename().endsWith(".png"))) {
            throw new IllegalArgumentException("File is null or empty");
        }

        Path userImageFolderPath = this.init(this.userImagePath);
        if (userImageFolderPath == null) {
            throw new IllegalStateException("User image folder path is not initialized");
        }
        String extension = file.getOriginalFilename().endsWith(".jpg")? ".jpg": ".png";
        String fileName = generateUniqueFileName(email, extension,userImageFolderPath);

        Path filePath = userImageFolderPath.resolve(fileName);

        Files.copy(file.getInputStream(), filePath);

        return fileName;
    }

    public String saveProductImage(String productName, MultipartFile file) throws IOException {
        if (file == null || file.isEmpty() || !file.getOriginalFilename().endsWith(".jpg") || !file.getOriginalFilename().endsWith(".png")) {
            throw new IllegalArgumentException("File is null or empty");
        }

        Path productImageFolderPath = this.init(this.productImagePath);
        if (productImageFolderPath == null) {
            throw new IllegalStateException("User image folder path is not initialized");
        }
        String extension = file.getOriginalFilename().endsWith(".jpg")? ".jpg": ".png";
        String fileName = generateUniqueFileName(productName, extension,productImageFolderPath);

        Path filePath = productImageFolderPath.resolve(fileName);

        Files.copy(file.getInputStream(), filePath);

        return filePath.toString();
    }


    public String generateUniqueFileName(String name, String extension, Path path) {
        int count = 1;
        String baseName;
        if(name.endsWith("@gmail.com")){
            baseName = name.replace("@gmail.com", "");
        }else {
            baseName = name;
        }

        String fileName = baseName + extension;
        while (Files.exists(path.resolve(fileName))) {
            fileName = baseName + "_" + count + extension;
            count++;
        }
        return fileName;
    }

    public String getOneProductImage(Product product){
        return imageRepo.findFirstByProduct(product).getUrl();
    }



}
