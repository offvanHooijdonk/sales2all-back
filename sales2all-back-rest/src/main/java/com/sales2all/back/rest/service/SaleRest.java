package com.sales2all.back.rest.service;

import com.sales2all.back.data.domain.SaleBean;
import com.sales2all.back.data.domain.SaleImageBean;
import com.sales2all.back.data.service.ISaleImageService;
import com.sales2all.back.data.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.io.File;
import java.util.List;

/**
 * Created by Yahor_Fralou on 8/1/2016.
 */
@Component
@Path(SaleRest.PATH)
@Produces(MediaType.APPLICATION_JSON)
public class SaleRest {
    static final String PATH = "sale";
    static final String SALE_ID = "/{saleId}";
    static final String IMAGE = SALE_ID + "/image";
    static final String IMAGE_FILE = IMAGE + "/{fileName}";

    @Autowired
    private ISaleService saleService;
    @Autowired
    private ISaleImageService saleImageService;

    @GET
    public Response find() {
        List<SaleBean> list = saleService.listAll();
        return Response.status(Status.OK).entity(list).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSale(SaleBean bean) {
        saleService.save(bean);

        return Response.status(Status.OK).entity(bean).build();
    }

    @GET
    @Path(IMAGE_FILE)
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getSaleImage(@PathParam("saleId") Long saleId, @PathParam("fileName") String fileName) {
        // TODO check the Sale has this image at all
        String path = saleImageService.getImagePath(fileName);

        Response response;
        if (path == null) {
            response = Response.status(Status.NOT_FOUND).build();
        } else {
            File file = new File(path);
            response = Response.ok(file).build();
        }
        return response;
    }

    @PUT
    @Path(IMAGE)
    public Response addSaleImage(@PathParam("saleId") Long saleId, SaleImageBean saleImageBean) {
        // TODO check imageBean ID - if NO we need image content, ELSE - no
        Response response;

        SaleBean saleBean = saleService.getById(saleId);
        if (saleBean != null) {
            saleImageBean.setSale(saleBean);
            saleImageService.save(saleImageBean);

            response = Response.ok(saleImageBean).build();
        } else {
            response = Response.status(Status.NOT_FOUND).build();
        }

        return response;
    }
}
