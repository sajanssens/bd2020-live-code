package org.example.resources.generified;

import org.example.domain.generified.Dao;

import javax.ws.rs.*;
import java.util.Collection;

public abstract class Resource<E> {

    protected Dao<E> dao;

    public abstract void setDao(Dao<E> dao);

    // public abstract Dao<E> getDao();

    @GET
    public Collection<E> getAll(@QueryParam("q") String q) {
        return q == null ? dao.getAll() : dao.get(q);
    }

    @GET @Path("{id}")
    public E get(@PathParam("id") String id) {
        return dao.getById(id);
    }

    @POST
    public E post(E e) {
        if (dao.add(e) != null) {
            return e;
        } else {
            throw new RuntimeException("Post " + e + " failed.");
        }
    }

    @DELETE @Path("{id}")
    public void delete(@PathParam("id") String id) {
        if (!dao.remove(id)) {
            throw new BadRequestException("Delete with id " + id + " failed.");
        }
    }

    @PUT @Path("{id}")
    public E put(@PathParam("id") String id, E e) {
        if (dao.update(id, e)) {
            return e;
        } else {
            throw new RuntimeException("Update " + e + " failed.");
        }
    }
}
