package com.app.shoppingcart.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.shoppingcart.dto.RemoveProductFromCartDto;
import com.app.shoppingcart.dto.UpdateProductDto;
import com.app.shoppingcart.dto.UserProductDto;
import com.app.shoppingcart.entity.User;
import com.app.shoppingcart.exception.ShoppingCartServiceException;

@Service
public interface ShoppingCartService {

	
	public String addToCart(UserProductDto userProduct) throws ShoppingCartServiceException;
	
	public String deleteProductById(int id) throws ShoppingCartServiceException ;
	
	public String removeProductFromCart(RemoveProductFromCartDto removeProductById)
			throws ShoppingCartServiceException ;
	
	public String removeAllProductFromCart(User user) throws ShoppingCartServiceException ;
	
	public List<Object> viewAllProduct() throws ShoppingCartServiceException;
	
	public Map<String, Object> viewMyCart(User user) throws ShoppingCartServiceException;
	
	public List<Object> searchProductById(int id) throws ShoppingCartServiceException;
	
	public List<Object> searchProductByName(String name) throws ShoppingCartServiceException;
	
	public List<Object> searchProductByCategory(String category) throws ShoppingCartServiceException;
	
	public String updateProductInCart(UpdateProductDto updateProduct) throws ShoppingCartServiceException;

}
