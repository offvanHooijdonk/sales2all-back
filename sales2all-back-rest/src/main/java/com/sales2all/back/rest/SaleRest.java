package com.sales2all.back.rest;

import com.sales2all.back.data.domain.SaleBean;
import com.sales2all.back.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

/**
 * Created by Yahor_Fralou on 8/1/2016.
 */
@Component
@Path(SaleRest.PATH)
@Produces(MediaType.APPLICATION_JSON)
public class SaleRest {
    static final String PATH = "sale";

    @Autowired
    private ISaleService saleService;

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
}
