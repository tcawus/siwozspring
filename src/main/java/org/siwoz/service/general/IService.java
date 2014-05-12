package org.siwoz.service.general;

import java.util.Collection;

/**
 * 
 * @author Tomek Wagner
 *
 * @param <T>
 */
public interface IService<T> {

    /**
     * Gets all objects from DB.
     * @param id
     * @return
     */
    public Collection<T> getAll();

    /**
     * Gets object with selected ID.
     * @param id
     * @return
     */
    public T getById(long id);
    
    /**
     * Add specified object.
     * @param id
     * @return
     */
    public T add(T object);
    
    /**
     * Updates object with specified ID.
     * @param id
     * @return
     */
    public void update(T object);
    
    /**
     * Deletes object with selected ID.
     * @param id
     * @return
     */
    public void delete(T object);

}
