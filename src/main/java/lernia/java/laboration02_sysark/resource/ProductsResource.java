package lernia.java.laboration02_sysark.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lernia.java.laboration02_sysark.entities.Category;
import lernia.java.laboration02_sysark.entities.ProductDto;
import lernia.java.laboration02_sysark.interceptor.Logging;
import lernia.java.laboration02_sysark.service.WarehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Logging
public class ProductsResource {

    private static final Logger logger = LoggerFactory.getLogger(ProductsResource.class);

    private WarehouseService warehouseService;

    public ProductsResource() {}

    @Inject
    public ProductsResource(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(@Valid ProductDto productDto) {
        return Response.ok(warehouseService.addNewProduct(productDto.productName(), productDto.category(), productDto.rating())).build();
    }

    @GET
    public Response getAllProducts() {
        return Response.ok(warehouseService.getAllProducts()).build();
    }

    @GET
    @Path("/{id}")
    public Response getProductByID(@Valid @PathParam("id") int id) {
        return Response.ok(warehouseService.getProductOnID(id)).build();
    }

    @GET
    @Path("/categories/{category}")
    public Response getProductsByCategory(@Valid @PathParam("category") Category category) {
        return Response.ok(warehouseService.getProductsInCategory(category)).build();
    }
}
