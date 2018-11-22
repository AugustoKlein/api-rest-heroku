package com.products.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.apirest.model.Product;
import com.products.apirest.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Products")
@CrossOrigin(origins="*")
public class ProductResource {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	@ApiOperation(value = "Returns the list of products")
	public List<Product> productList(){
		return productRepository.findAll();
	}
	
	@GetMapping("/products({id})")
	@ApiOperation(value = "Returns a single product")
	public Product productEntry(@PathVariable(value="id") long id){
		return productRepository.findById(id);
	}
	
	@PostMapping("/products")
	@ApiOperation(value = "Create a product")
	public Product saveProduct(@RequestBody Product product){
		return productRepository.save(product);
	} 
	
	@DeleteMapping("/products({id})")
	@ApiOperation(value = "Delete a product")
	public void deleteProduct(@PathVariable(value="id") long id){
		productRepository.delete(productRepository.findById(id));
	}
	
	@PutMapping("/products")
	@ApiOperation(value = "Update a product")
	public Product updateProduct(@RequestBody Product product){
		return productRepository.save(product);	
	}
	
	@GetMapping("/products/TESTfindAll")
	@ApiOperation(value = "TEST findALL")
	public List<Product> findAllTest(){
		return productRepository.findAllProducts();
	}
	
	@GetMapping("/products({name})")
	@ApiOperation(value = "Returns a single product with the respective name given")
	public Product productFindByName(@PathVariable(value = "name") String name){
		return productRepository.findByName(name);
	}
}
