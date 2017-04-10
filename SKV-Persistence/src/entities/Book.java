package skv.lia.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Aid")
	private int aid;
	@Column(name = "Author")
	private String author;

	@Pattern(regexp = "[0-9X]*", message = "ISBN - oglitligt tecken (bara siffror eller X tillåtna)")
	@Size(min = 10, message = "ISBN för kort (behöver minst 10 tecken)")
	@Column(name = "Isbn")
	private String isbn;
	@Column(name = "Title")
	@Size(min = 5, message = "Ange en titel på boken du vill lägga till")
	private String title;
	@Column(name = "Copies")
	private int copies;
	

	public Book(int aid, String author, String title, String isbn, int copies) {
		this.aid = aid;
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.copies = copies;
	}

	public Book() {
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

}