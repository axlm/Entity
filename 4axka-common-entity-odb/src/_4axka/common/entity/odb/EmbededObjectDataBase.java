// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd. All rights reserved. The content of ODB.java is strictly
 * CONFIDENTIAL. It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative. It may not be
 * reproduced as a whole, or in part by any means unless explicit permission has been granted
 * by an authorised 4axka representative.
 */
package _4axka.common.entity.odb;


import static com.db4o.Db4oEmbedded.newConfiguration;
import static com.db4o.Db4oEmbedded.openFile;

import java.util.Comparator;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;


public final class EmbededObjectDataBase {
    private ObjectContainer __database;

    public void connect(final String file) throws DatabaseException {
        __database = openFile(newConfiguration(), file);
    }

    public void disconnect() throws DatabaseException {
        __database.close();
    }

    public <E> void add(final E entity) throws AdditionException {
        __database.store(entity);
    }

    public <E> void add(final Iterable<E> entities) throws AdditionException {
        for (final E e_ : entities) {
            add(e_);
        }
    }

    public <E> void remove(final E entity) throws RemovalException {
        __database.delete(entity);
    }

    public <E> void remove(final Iterable<E> entities) throws RemovalException {
        for (E e_ : entities) {
            remove(e_);
        }
    }

    public <E> Iterable<E> find(final Class<E> entity) throws SearchException {
        return __database.query(entity);
    }

    public <E> Iterable<E> find(final Predicate<E> match) throws SearchException {
        return __database.query(match);
    }

    public <E extends Comparable<E>> Iterable<E> find(
                final Predicate<E> match,
                final Comparator<E> sort)
            throws SearchException {
        return __database.query(match, sort);
    }

    public <E> E modify(final E previous, final E current) throws ModificationException {
        return null;
    }
}
