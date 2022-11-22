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
    @Inject
    Student student;
    @POST

    public Response index(Student student) throws IOException {
        if (student.getID() == null) {
            this.student.setID(UUID.randomUUID().toString());
        }else
            this.student.setID(student.getID());
        this.student.setFirstName(student.getFirstName());
        this.student.setLastName(student.getLastName());
        return Response.created(URI.create("/students/" + this.student.getID())).build();
    }



    @GET
    @Path("/{id}")
    public Student get(String id) throws IOException {
        return studentServices.get(id);
    }


}
