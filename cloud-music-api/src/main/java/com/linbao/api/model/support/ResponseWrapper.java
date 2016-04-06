
package com.linbao.api.model.support;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
/**
 * Response wrapper for JAX-RS 1.1
 */
public abstract class ResponseWrapper extends Response
{
    private final Response delegate;

    protected ResponseWrapper(final Response delegate)
    {
        this.delegate = delegate;
    }

    protected static ResponseBuilder headers(final Map<String, List<Object>> headers, final ResponseBuilder responseBuilder)
    {
        if (headers != null)
        {
            for (final Entry<String, List<Object>> nameAndValues : headers.entrySet())
            {
                for (final Object value : nameAndValues.getValue())
                {
                    responseBuilder.header(nameAndValues.getKey(), value);
                }
            }
        }

        return responseBuilder;
    }
    /**
     * Delete 
     *  e.g. {
     *  "status" : "ok",
     *  "message" : "success"
     * }
     * 
     * 
     * @param entity
     *     {
     *      "status" : "ok",
     *      "message" : "success"
     *     }
     *     
     */
    public static Response withJsonOK(StreamingOutput entity) {
        Response.ResponseBuilder responseBuilder = Response.status(200).header("Content-Type", "application/json");
        responseBuilder.entity(entity);
        return responseBuilder.build();
    }
    /**
     * Get Entity by id
     * @param <T>
     * @param entity
     *     
     */
    public static <T> Response withJsonOK(T entity) {
        Response.ResponseBuilder responseBuilder = Response.status(200).header("Content-Type", "application/json");
        responseBuilder.entity(entity);
        return responseBuilder.build();
    }
    /**
     *  e.g. {
     *  "id" : "123",
     *  "username" : "linbao",
     *  "birthday" : "19890622"
     * }
     * @param <T>
     * 
     * 
     * @param entity
     *     {
     *      "id" : "123",
     *      "username" : "linbao",
     *      "birthday" : "19890622"
     *     }
     *     
     */
    public static <T> Response withJsonOK(List<T> entity) {
        Response.ResponseBuilder responseBuilder = Response.status(200).header("Content-Type", "application/json");
        responseBuilder.entity(entity);
        return responseBuilder.build();
    }
    
    /**
     * 
     * @param entity
     *     
     */
    public static Response withJsonCreated(StreamingOutput entity) {
        Response.ResponseBuilder responseBuilder = Response.status(201).header("Content-Type", "application/json");
        responseBuilder.entity(entity);
        return responseBuilder.build();
    }

    /**
     * 
     * @param entity
     *     
     */
    public static Response withJsonBadRequest(StreamingOutput entity) {
        Response.ResponseBuilder responseBuilder = Response.status(400).header("Content-Type", "application/json");
        responseBuilder.entity(entity);
        return responseBuilder.build();
    }

    @Override
    public int hashCode()
    {
        return delegate.hashCode();
    }

    @Override
    public int getStatus()
    {
        return delegate.getStatus();
    }

    @Override
    public boolean equals(final Object obj)
    {
        return delegate.equals(obj);
    }

    @Override
    public Object getEntity()
    {
        return delegate.getEntity();
    }

    @Override
    public String toString()
    {
        return delegate.toString();
    }

    @Override
    public MultivaluedMap<String, Object> getMetadata()
    {
        return delegate.getMetadata();
    }
}

