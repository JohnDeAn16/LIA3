package skv.lia.remote.beans;

import java.util.List;

import javax.ejb.Remote;

import skv.lia.entities.Book;

@Remote
public interface BookDAOBeanRemote {

	public void addBook(Book e);
	
	public Book createBook(Book book);

	public Book createBook(int id, String author, String isbn, String title, int copies);

	public Book getBookById(int id);
	public Book getBookByAuthor(String author);
	public Book getBookByIsbn(String isbn);
	public Book getBookByTitle(String title);

	public List<Book> getAllBooks();
}
