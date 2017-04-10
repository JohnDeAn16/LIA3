package skv.lia.beans;

 // import java.util.ArrayList;
 // import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import skv.lia.entities.Book;
import skv.lia.remote.beans.BookDAOBeanRemote;

@Named
@RequestScoped
public class BookDAOBean implements BookDAOBeanRemote {

	@PersistenceContext(unitName = "SKV-Persistence")
	EntityManager em;

	/* 
	 * private static final ArrayList<Book> books = new ArrayList<Book>(
			Arrays.asList(new Book(1, "Hans Alfredsson", "En bok om en bok", "12X4567890", 2)));

	public ArrayList<Book> getBooks() {
		return books;
	}
	 */
	
	@Override
	public void addBook(Book e) {
		if (e.getId() != 0) {
			em.merge(e);
		} else {
			em.persist(e);
		}
	}

	@Override
	public Book createBook(Book book) {
		return null;
	}

	@Override
	public Book createBook(int id, String author, String isbn, String title, int copies) {
		Book newBook = new Book();
		newBook.setId(id);
		newBook.setAuthor(author);
		newBook.setIsbn(isbn);
		newBook.setTitle(title);
		newBook.setCopies(copies);
		em.persist(newBook);
		return newBook;
	}

	@Override
	public Book getBookById(int id) {
		Query q = em.createQuery("SELECT e FROM Book e WHERE e.id = :id");
		q.setParameter("id", id);
		return (Book) q.getSingleResult();
	}

	@Override
	public Book getBookByAuthor(String author) {
		Query q = em.createQuery("SELECT e FROM Book e WHERE e.author = :author");
		q.setParameter("author", author);
		return (Book) q.getSingleResult();
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		Query q = em.createQuery("SELECT e FROM Book e WHERE e.isbn = :isbn");
		q.setParameter("isbn", isbn);
		return (Book) q.getSingleResult();
	}

	@Override
	public Book getBookByTitle(String title) {
		Query q = em.createQuery("SELECT e FROM Book e WHERE e.title = :title");
		q.setParameter("title", title);
		return (Book) q.getSingleResult();
	}

	@Override
	public List<Book> getAllBooks() {
		Query q = em.createQuery("SELECT e FROM Book e");
		return (List<Book>) q.getResultList();
	}

}