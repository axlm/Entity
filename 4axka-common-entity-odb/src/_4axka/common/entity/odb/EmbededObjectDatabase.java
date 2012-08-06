// $Id$

/*
 * \u00A9 2012, 4axka (Pty) Ltd.  All rights reserved.
 *
 * The content of EmbededObjectDatabase.java is strictly CONFIDENTIAL.
 *
 * It may not be viewed as a whole, or in part by any unauthorised party unless
 * explicit permission has been granted by an authorised 4axka representative.
 *
 * It may not be reproduced as a whole, or in part by any means unless explicit
 * permission has been granted by an authorised 4axka representative.
 */
package _4axka.common.entity.odb;


import static com.db4o.Db4oEmbedded.newConfiguration;
import static com.db4o.Db4oEmbedded.openFile;

import java.io.Serializable;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

import _4axka.util.data.exception.DataAdditionException;
import _4axka.util.data.exception.DataModificationException;
import _4axka.util.data.exception.DataRemovalException;
import _4axka.util.data.exception.DataSearchException;
import _4axka.util.data.exception.DatabaseException;
import _4axka.util.functor.Modifier;

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

    public <E> Iterable<E> add(final Iterable<E> entities) throws DataAdditionException {
        final CopyOnWriteArrayList<E> result_ = new CopyOnWriteArrayList<>();

        for (final E e_ : entities) {
            result_.add(add(e_));
        }

        return result_;
    }

    public <E> E add(final E entity) throws DataAdditionException {
        try {
            __database.store(entity);
        } catch (final Db4oException e_) {
            throw new DataAdditionException(e_);
        }

        return entity;
    }

    public <E> Iterable<E> remove(final Iterable<E> entities) throws DataRemovalException {
        final CopyOnWriteArrayList<E> result_ = new CopyOnWriteArrayList<>();

        for (final E e_ : entities) {
            result_.add(remove(e_));
        }

        return result_;
    }

    public <E> E remove(final E entity) throws DataRemovalException {
        try {
            __database.delete(entity);
        } catch (Db4oException e_) {
            throw new DataRemovalException(e_);
        }

        return entity;
    }

    public <E> Iterable<E> find(final Class<E> entity) throws DataSearchException {
        try {
            return __database.query(entity);
        } catch (Db4oException e_) {
            throw new DataSearchException(e_);
        }
    }

    public <E> Iterable<E> find(final Predicate<E> criteria) throws DataSearchException {
        try {
            return __database.query(criteria);
        } catch (Db4oException e_) {
            throw new DataSearchException();
        }
    }

    public <E extends Comparable<E>> Iterable<E> find(
            final Predicate<E> criteria,
            final Comparator<E> sortOrder)
            throws DataSearchException {
        try {
            return __database.query(criteria, sortOrder);
        } catch (Db4oException e_) {
            throw new DataSearchException(e_);
        }
    }

    public <E> E modify(final E entity) throws DataModificationException {
        return null;
    }

    public <E> Iterable<E> modify(final Iterable<E> entities) {
        return null;
    }

    public <R extends Serializable, E extends Serializable, T extends Throwable> Iterable<E> modify(
            final Predicate<E> criteria,
            final Modifier<R, E, T> modifier) {
        return null;
    }
}
