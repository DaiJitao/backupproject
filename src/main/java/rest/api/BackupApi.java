package rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by daijitao on 2018/10/25.
 */
@Path("/")
public class BackupApi {
    @Path("/getName/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON) // 返回类型
    public String getName(@PathParam("id") String id) {
        System.out.println("id=" + id);
        return id;
    }

    @Path("/getName")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getNames() {
        System.out.println("dai");
        return "dai";
    }
}




















