package com.app.shoppingcart.dao;

import java.util.List;

import com.app.shoppingcart.entity.Apparal;
import com.app.shoppingcart.entity.Book;
import com.app.shoppingcart.entity.Cart;
import com.app.shoppingcart.entity.CartProduct;
import com.app.shoppingcart.entity.Product;
import com.app.shoppingcart.entity.User;
import com.app.shoppingcart.exception.DeleteApparalException;
import com.app.shoppingcart.exception.DeleteBookException;
import com.app.shoppingcart.exception.ProductException;
import com.app.shoppingcart.exception.ShoppingCartException;

public interface ShoppingCartDao {

	public String addProductToCart(Cart cart) throws ShoppingCartException;

	public Product getProductbyId(int productId) throws ProductException;

	public CartProduct checkProductAlreadyPresent(int cartId, int productId, int quantity) throws ProductException;

	public Cart getCartDetailbyId(int cartId) throws ShoppingCartException;

	public boolean updateProductQuantityInventory(Product product) throws ShoppingCartException;

	public String deleteBook(int id) throws DeleteBookException;

	public String deleteApparal(int id) throws DeleteApparalException;

	public CartProduct getCartProductByIds(int cartId, int productId) throws ShoppingCartException;

	public boolean deleteCartProductEntry(CartProduct cartProduct) throws ShoppingCartException;

	public boolean updateCartProduct(CartProduct cartProductPresent) throws ShoppingCartException;

	public boolean updateCart(Cart cartDetail) throws ShoppingCartException;

	public List<CartProduct> getAllCartProductDetailsByCartId(int cartId) throws ShoppingCartException;

	public boolean removeAllCartProductDetailsByCartId(List<CartProduct> cartProducts) throws ShoppingCartException;

	public List<Apparal> getAllApparalDetails() throws ShoppingCartException;

	public List<Book> getAllBookDetails() throws ShoppingCartException;

	public Apparal getApparalById(int productId) throws ShoppingCartException;

	public Book getBookById(int productId) throws ShoppingCartException;

	public List<Product> getProductbyCategory(String category) throws ShoppingCartException;

	public User getUserbyID(int userId) throws ProductException;

	public List<Integer> getProductIDByName(String name) throws ProductException;

	public String checkProductType(int id) throws ProductException;

}
