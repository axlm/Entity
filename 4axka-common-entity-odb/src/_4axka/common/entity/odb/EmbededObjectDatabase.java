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
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ext.Db4oException;
import com.db4o.query.Predicate;


public final class EmbededObjectDatabase {
    private ObjectContainer __database;

    public void connect(final String file) throws DatabaseException {
        try {
            final EmbeddedConfiguration configuration_ = newConfiguration();
            __database = openFile(configuration_, file);
        } catch (final Db4oException e_) {
            throw new DatabaseException(e_);
        }
    }

    public void disconnect() throws DatabaseException {
        try {
            __database.close();
        } catch (final Db4oException e_) {
            throw new DatabaseException(e_);
        }
    }

    public <E> void add(final E entity) throws AdditionException {
        try {
            __database.store(entity);
        } catch (final Db4oException e_) {
            throw new AdditionException(e_);
        }
    }

    public <E> void add(final Iterable<E> entities) throws AdditionException {
        for (final E e_ : entities) {
            add(e_);
        }
    }

    public <E> void remove(final E entity) throws RemovalException {
        try {
            __database.delete(entity);
        } catch (Db4oException e_) {
            throw new RemovalException(e_);
        }
    }

    public <E> void remove(final Iterable<E> entities) throws RemovalException {
        for (final E e_ : entities) {
            remove(e_);
        }
    }

    public <E> Iterable<E> find(final Class<E> entity) throws SearchException {
        try {
            return __database.query(entity);
        } catch (Db4oException e_) {
            throw new SearchException(e_);
        }
    }

    public <E> Iterable<E> find(final Predicate<E> match) throws SearchException {
        try {
            return __database.query(match);
        } catch (Db4oException e_) {
            throw new SearchException();
        }
    }

    public <E extends Comparable<E>> Iterable<E> find(
            final Predicate<E> predicate,
            final Comparator<E> orderBy)
                    throws SearchException {
        try {
            return __database.query(predicate, orderBy);
        } catch (Db4oException e_) {
            throw new SearchException(e_);
        }
    }

    public <E> E modify(final E entity) throws ModificationException {
        return null;
    }

    public <E> Iterable<E> modify(final Iterable<E> entities) {
        return null;
    }
}
