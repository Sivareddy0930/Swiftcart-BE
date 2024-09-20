package com.greetlabs.swiftcart.service.Impl;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.greetlabs.swiftcart.entity.Product;
import com.greetlabs.swiftcart.repository.ProductRepository;
import com.greetlabs.swiftcart.response.ProductResponse;
import com.greetlabs.swiftcart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductRepository repo;

	@Override
	public Product addProduct(MultipartFile file, String ProductName, double Price, int Discount, String Category,
			String Discription) throws Exception {
		Product product=new Product();
		product.setProductName(ProductName);
		product.setPrice(Price);
		product.setDisocunt(Discount);
		product.setCategory(Category);
		product.setDiscription(Discription);
		if (!file.isEmpty()) {
	        byte[] photoBytes = file.getBytes();
	        Blob photoBlob = new SerialBlob(photoBytes);
	        product.setPhoto(photoBlob);
	    }

	   
	    Product savedProduct = repo.save(product);
	    
	   
	    Blob photoblob = savedProduct.getPhoto();
	    byte[] imageBytes = convertBlobToBytes(photoblob);
	    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	    
	    System.out.println("Base64 Encoded Image: " + base64Image);
	    
	    return savedProduct; 
	}
	

	    public Product updateProductPhotoFromBase64(int productId, String base64Image) throws Exception {
	        Product product = repo.findById(productId)
	                              .orElseThrow(() -> new Exception("Product not found"));

	      
	        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

	      
	        Blob imageBlob = new SerialBlob(imageBytes);
	        product.setPhoto(imageBlob);

	        return repo.save(product);
	    }


	@Override
	public List<ProductResponse> getAllProducts() {
		List<Product> products = repo.findAll();

        return products.stream().map(product -> {
            byte[] photoBytes = null;
            try {
                Blob photoBlob = product.getPhoto();
                if (photoBlob != null) {
                    photoBytes = convertBlobToBytes(photoBlob);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return new ProductResponse(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                photoBytes,
                product.getDisocunt(),
                product.getCategory(),
                product.getDiscription()
            );
        }).collect(Collectors.toList());
    }

    private byte[] convertBlobToBytes(Blob blob) throws SQLException {
        if (blob == null) {
            return null;
        }
        return blob.getBytes(1, (int) blob.length());
    }

	@Override
	public Optional<Product> getProductById(int Id) {
		return repo.findById(Id);
	}


}
