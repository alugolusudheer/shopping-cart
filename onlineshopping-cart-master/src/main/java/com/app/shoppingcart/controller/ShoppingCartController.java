package com.app.shoppingcart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.shoppingcart.dto.RemoveProductFromCartDto;
import com.app.shoppingcart.dto.UpdateProductDto;
import com.app.shoppingcart.dto.UserProductDto;
import com.app.shoppingcart.entity.User;
import com.app.shoppingcart.exception.ShoppingCartServiceException;
import com.app.shoppingcart.service.ShoppingCartService;

@RestController
@CrossOrigin("*")
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

	@Autowired
	ShoppingCartService shoppingCartService;

	// ---Search Product---

	// Search Product By ID
	@RequestMapping(value = "/searchProductById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> searchProductById(@PathVariable("id") int id) {
		try {
			List<Object> response = null;
			response = shoppingCartService.searchProductById(id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ShoppingCartServiceException e) {
			return new ResponseEntity<>("Exception" + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Search Product By Name
	@RequestMapping(value = "/searchProductByName/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> searchProductByName(@PathVariable("name") String name) {
		try {
			List<Object> response = null;
			response = shoppingCartService.searchProductByName(name);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ShoppingCartServiceException e) {
			return new ResponseEntity<>("Exception" + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Search Product By Category
	@RequestMapping(value = "/searchProductByCategory/{category}", method = RequestMethod.GET)
	public ResponseEntity<?> searchProductByCategory(@PathVariable("category") String category) {
		try {
			List<Object> response = null;
			response = shoppingCartService.searchProductByCategory(category);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ShoppingCartServiceException e) {
			return new ResponseEntity<>("Exception" + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// --- Add ---

	// Add Product To Cart
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public ResponseEntity<?> addToCart(@RequestBody UserProductDto userProduct) {
		try {
			String message = "";
			message = shoppingCartService.addToCart(userProduct);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (ShoppingCartServiceException e) {
			return new ResponseEntity<>("Exception" + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// --- Remove ---

	// Remove Product from Cart
	@RequestMapping(value = "/removeProductFromCart", method = RequestMethod.POST)
	public ResponseEntity<?> removeProductFromCart(@RequestBody RemoveProductFromCartDto removeProductById) {
		try {
			String message = "";
			message = shoppingCartService.removeProductFromCart(removeProductById);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (ShoppingCartServiceException e) {
			return new ResponseEntity<>("Exception" + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// Remove All Product from Cart
	@RequestMapping(value = "/removeAllProductFromCart", method = RequestMethod.POST)
	public ResponseEntity<?> removeAllProductFromCart(@RequestBody User user) {
		try {
			String message = "";
			message = shoppingCartService.removeAllProductFromCart(user);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (ShoppingCartServiceException e) {
			return new ResponseEntity<>("Exception" + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// --- Updating the cart ---

	// Update Product from Cart
	@RequestMapping(value = "/updateProductInCart", method = RequestMethod.POST)
	public ResponseEntity<?> updateProductInCart(@RequestBody UpdateProductDto updateProduct) {
		try {
			String message = "";
			message = shoppingCartService.updateProductInCart(updateProduct);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (ShoppingCartServiceException e) {
			return new ResponseEntity<>("Exception" + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// --- View Cart details ---

	// View Cart
	@RequestMapping(value = "/viewCart", method = RequestMethod.POST)
	public ResponseEntity<?> viewMyCart(@RequestBody User user) {
		try {
			Map<String, Object> response = null;
			response = shoppingCartService.viewMyCart(user);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ShoppingCartServiceException e) {
			return new ResponseEntity<>("Exception" + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// View All Product
	@RequestMapping(value = "/viewAllProduct", method = RequestMethod.GET)
	public ResponseEntity<?> viewAllProduct() {
		try {
			List<Object> response = null;
			response = shoppingCartService.viewAllProduct();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (ShoppingCartServiceException e) {
			return new ResponseEntity<>("Exception" + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ResponseEntity<?> home() {
		return new ResponseEntity<>("Home", HttpStatus.OK);
	}

	@RequestMapping(value = "*", method = RequestMethod.GET)
	public ResponseEntity<?> error() {
		return new ResponseEntity<>("Error: BAD GATEWAY: Please verify accessed URL or Method of Request !!", HttpStatus.BAD_GATEWAY);
	}
}
