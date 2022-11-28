package elastic;

import com.oracle.svm.core.annotate.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
        System.out.println( student.getID());
        System.out.println( student.getFirstName());
        System.out.println(student.getLastName());

        if (student.getID() == null) {
            student.setID(UUID.randomUUID().toString());
            System.out.println("this is running");
            System.out.println( student.getID());


        }else

        studentServices.index(student);
        return Response.created(URI.create("/student/" + student.getID())).build();
    }



    @GET
    @Path("/{id}")
    public Student get( @PathParam("id") String id) throws IOException {
        System.out.println("this is id: "+id);
        Student searchStudent =studentServices.get(id);
        System.out.println("get id is working");
return  searchStudent;
    }


}
