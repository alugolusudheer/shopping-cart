package com.app.shoppingcart.helper;

import org.springframework.stereotype.Component;

import com.app.shoppingcart.dto.ApparalRequestDto;
import com.app.shoppingcart.dto.ApparalResponseDto;
import com.app.shoppingcart.dto.BookRequestDto;
import com.app.shoppingcart.dto.BookResponseDto;
import com.app.shoppingcart.entity.Apparal;
import com.app.shoppingcart.entity.Book;

@Component
public class ProductResponseObject {

	public Apparal createApparalResponseObject(ApparalRequestDto newApparal) {
		Apparal apparal = new Apparal();
		apparal.setBrand(newApparal.getBrand());
		apparal.setDesign(newApparal.getDesign());
		apparal.setPrice(newApparal.getUnitPrice());
		apparal.setProductName("APPARAL");
		apparal.setType(newApparal.getType());
		apparal.setQuantity(newApparal.getQuantity());
		return apparal;
	}

	public Book createBookResponseObject(BookRequestDto newBook) {
		Book book = new Book();
		book.setAuthor(newBook.getAuthor());
		book.setGenre(newBook.getGenre());
		book.setPrice(newBook.getUnitPrice());
		book.setProductName("BOOK");
		book.setPublication(newBook.getPublication());
		book.setQuantity(newBook.getQuantity());
		return book;
	}

	public ApparalResponseDto createApparalDtoResponseObject(Apparal apparal, int quantity) {

		ApparalResponseDto apparalDto = new ApparalResponseDto();
		apparalDto.setApparalId(apparal.getProductId());
		apparalDto.setBrand(apparal.getBrand());
		apparalDto.setDesign(apparal.getDesign());
		apparalDto.setProductName(apparal.getProductName());
		apparalDto.setType(apparal.getType());
		apparalDto.setUnitPrice(apparal.getPrice());
		apparalDto.setQuantity(quantity);
		return apparalDto;
	}

	public BookResponseDto createBookDtoResponseObject(Book book, int quantity) {
		BookResponseDto bookDto = new BookResponseDto();
		bookDto.setAuthor(book.getAuthor());
		bookDto.setBookId(book.getProductId());
		bookDto.setGenre(book.getGenre());
		bookDto.setProductName(book.getProductName());
		bookDto.setPublication(book.getPublication());
		bookDto.setUnitPrice(book.getPrice());
		bookDto.setQuantity(quantity);
		return bookDto;
	}

	public ApparalResponseDto createApparalResponseObject(Apparal apparal,int quantity) {
		ApparalResponseDto apparalDto = new ApparalResponseDto();
		apparalDto.setApparalId(apparal.getProductId());
		apparalDto.setBrand(apparal.getBrand());
		apparalDto.setDesign(apparal.getDesign());
		apparalDto.setProductName(apparal.getProductName());
		apparalDto.setType(apparal.getType());
		apparalDto.setUnitPrice(apparal.getPrice());
		apparalDto.setQuantity(quantity);
		return apparalDto;
	}
}
