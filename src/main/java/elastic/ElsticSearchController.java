package elastic;

import com.oracle.svm.core.annotate.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.util.UUID;
@Path("/student")
public class ElsticSearchController {

    @Inject
    StudentServices studentServices;
    @POST

    public Response index(Student student) throws IOException {
        if (student.ID == null) {
            student.ID = UUID.randomUUID().toString();
        }
        studentServices.index(student);
        return Response.created(URI.create("/fruits/" + student.ID)).build();
    }



    @GET
    @Path("/{id}")
    public Student get(String id) throws IOException {
        return studentServices.get(id);
    }


}
