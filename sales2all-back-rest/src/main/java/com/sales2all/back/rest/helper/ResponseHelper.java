package com.sales2all.back.rest.helper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by Yahor_Fralou on 8/1/2016.
 */
public class ResponseHelper {
    public static final int STATUS_ERROR = Status.BAD_REQUEST.getStatusCode();
    public static final int STATUS_NOT_FOUND = Status.NOT_FOUND.getStatusCode();
    public static final int STATUS_INTERNAL_ERROR = Status.INTERNAL_SERVER_ERROR.getStatusCode();
    public static final int STATUS_OK = Status.OK.getStatusCode();

    public static Response error(String message) {
        return Response.status(STATUS_ERROR).entity(new ResponseObject(STATUS_ERROR, message)).build();
    }

    public static Response error(Object entity) {
        return Response.status(STATUS_ERROR).entity(entity).build();
    }

    public static Response notFound() {
        return Response.status(STATUS_NOT_FOUND).entity(new ResponseObject(STATUS_NOT_FOUND, Status.NOT_FOUND.getReasonPhrase())).build();
    }

    public static Response notFound(String message) {
        return Response.status(STATUS_NOT_FOUND).entity(new ResponseObject(STATUS_NOT_FOUND, message)).build();
    }

    public static Response notFound(Object entity) {
        return Response.status(STATUS_NOT_FOUND).entity(entity).build();
    }

    public static Response internalError(String message) {
        return Response.status(STATUS_INTERNAL_ERROR).entity(new ResponseObject(STATUS_INTERNAL_ERROR, message)).type(MediaType.APPLICATION_JSON).build();

    }

    public static Response ok() {
        return Response.status(STATUS_OK).build();
    }

    public static Response ok(Object entity) {
        return Response.status(STATUS_OK).entity(entity).build();
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.NONE) // to ignore any property which is not annotated
    static class ResponseObject {
        @XmlElement(name = "status")
        private int status;
        @XmlElement(name = "message")
        private String message;

        public ResponseObject() {
        }

        public ResponseObject(int status, String message) {
            this.status = status;
            this.message = message;
        }
        @XmlTransient
        public int getStatus() {
            return status;
        }
        public void setStatus(int status) {
            this.status = status;
        }
        @XmlTransient
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
    }

}
