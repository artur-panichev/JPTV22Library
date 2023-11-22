/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class DatabaseManager {
    /**
     * Создание EntityManager для управления сохранностью 
     * сущностей
     * 1. сохранение книги
     * 2. сохранение читателя
     * 3. сохранение истории
     * 4. считывание из базы книги
     * 5. считывание из базы читателя
     * 6. считывание из базы истории
     * 
     */
    private EntityManager em;
    public void DatabaseManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPTV22Library");
        this.em = emf.createEntityManager();
    }
    public void saveBook(Book book){
        /**
         * 1. если author.gerId() == null => записываем автора в базу
         * 2. иначе => обновляем автора
         * 3. если book/getId() == null => записываем книгу в базу
         * 4. иначе => обновляем книгу
         */
        em.getTransaction().begin();
            for (int i = 0; i <book.getAuthors().size(); i++) {
                if(book.getAuthors().get(i).getId() == null){
                    em.persist(book.getAuthors().get(i));
                }else{
                    em.merge(book.getAuthors().get(i));
                }

                if(book.getId() == null){
                    em.persist(book);
                } else{
                    em.merge(book);
                }

            }
        em.getTransaction().commit();
    }
    public void saveReader(Reader reader){
        em.getTransaction().begin();
            if(reader.getId() == null){
                    em.persist(reader);
            } else{
                    em.merge(reader);
            }
        em.getTransaction().commit();
    }
    public void saveHistory(History history){
        Book book = null;
        Reader reader = null;
        if(history.getBook().getId() == null){
            em.persist(history);
        } else{
            book = em.find(Book.class, history.getBook().getId());
        }
        
        if(history.getReader().getId() == null){
            em.persist(history.gtReader());
        } else{
            reader = em.find(Reader.class, history)
        }
    }
    
}
