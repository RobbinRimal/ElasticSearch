package elastic;

import io.vertx.core.json.JsonObject;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;

@ApplicationScoped
public class StudentServices {
    @Inject
    RestClient restClient;

    public void index(Student student) throws IOException {
        Request request = new Request(
                "POST",
                "/Student/_doc/"+student.getID() );
        request.setJsonEntity(JsonObject.mapFrom(student).toString());
        restClient.performRequest(request);
    }
    public Student get(String id) throws IOException {
        System.out.println("step 1");
        Request request = new Request(
                "GET",
                "/Student/_doc/" + id);
        System.out.println("step 2");
        Response response = restClient.performRequest(request);
        System.out.println("step 3");
        String responseBody = EntityUtils.toString(response.getEntity());
        JsonObject json = new JsonObject(responseBody);
        System.out.println("step 4");
        return json.getJsonObject("_source").mapTo(Student.class);
    }

}





