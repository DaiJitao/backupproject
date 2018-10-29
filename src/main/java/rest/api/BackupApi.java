package rest.api;

import backup.Client.ClientOp;
import backup.common.ConstantURL;
import backup.job.JobOp;
import backup.utils.BackupResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by daijitao on 2018/10/25.
 */
@Path("/")
public class BackupApi {
    @Path("/getName/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON) // 返回类型
    public String getName(@PathParam("id") String id) {
        ConstantURL url = new ConstantURL();
        //System.out.println(url.getClass().getClassLoader().getResource("").toString());
        System.out.println(url.getName());
        System.out.println("id=" + id);
        System.out.println(System.getProperty("user.dir")); //获取用户的工作目录
        return id;
    }

    @Path("/clients")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getNames() {
        ClientOp clientOp = new ClientOp();
        String result = clientOp.getClients();
        return result;
    }

    @Path("/jobs/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobByid(@PathParam("id") String jobId) {
        JobOp jobOp = new JobOp();
        String result = null;
        try {
            result = jobOp.getJobById(jobId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null){
            return Response.status(Response.Status.OK).entity(result).build();
        }
        return Response.serverError().build();

    }
}




















