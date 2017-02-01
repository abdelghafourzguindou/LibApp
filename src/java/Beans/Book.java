package Beans;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by zGuindouOS on 26/12/2016.
 */
public class Book {

    private Long idBook;
    private String codeBook;
    private String titreBook;
    private String categorieBook;
    private String auteurBook;
    private int NombreCopieBook;
    private Date dateParution;
    private Boolean image;

    public Book(String codeBook,
            String titreBook,
            String categorieBook,
            String auteurBook,
            int nombreCopieBook,
            Boolean image) {
        this.codeBook = codeBook;
        this.titreBook = titreBook;
        this.categorieBook = categorieBook;
        this.auteurBook = auteurBook;
        this.NombreCopieBook = nombreCopieBook;
        this.image = image;
    }

    public Book(Long idBook,
            String codeBook,
            String titreBook,
            String categorieBook,
            String auteurBook,
            int nombreCopieBook,
            Boolean image) {
        this.idBook = idBook;
        this.codeBook = codeBook;
        this.titreBook = titreBook;
        this.categorieBook = categorieBook;
        this.auteurBook = auteurBook;
        this.NombreCopieBook = nombreCopieBook;
        this.image = image;
    }

    public Book() {
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public String getTitreBook() {
        return titreBook;
    }

    public void setTitreBook(String titreBook) {
        this.titreBook = titreBook;
    }

    public String getCategorieBook() {
        return categorieBook;
    }

    public void setCategorieBook(String categorieBook) {
        this.categorieBook = categorieBook;
    }

    public String getAuteurBook() {
        return auteurBook;
    }

    public void setAuteurBook(String auteurBook) {
        this.auteurBook = auteurBook;
    }

    public int getNombreCopieBook() {
        return NombreCopieBook;
    }

    public void setNombreCopieBook(int nombreCopieBook) {
        NombreCopieBook = nombreCopieBook;
    }

    public Boolean getimage() {
        return image;
    }

    public void setimage(Boolean etatBook) {
        image = etatBook;
    }

    public void setDateParution(Date dateParution) {
        this.dateParution = dateParution;
    }

    public void setImage(Boolean image) {
        this.image = image;
    }

    public Date getDateParution() {
        return dateParution;
    }

    public Boolean getImage() {
        return image;
    }

}
