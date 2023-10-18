package ejercicio1;

import api.config.Configuration;
import api.factoryRequest.FactoryRequest;
import api.testSuites.TestBaseAuthBasic;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class Ejercicio1 extends TestBaseAuthBasic {

    public String pass;
    public String correo;
    @BeforeEach
    public void setup(){
        correo =Configuration.user;
        pass = Configuration.password;
    }

    @Test
    public void createUsercreateProjectdeleteUser(){
        JSONObject body = new JSONObject();
        body.put("Email",correo);
        body.put("Password",pass);
        body.put("FullName","Luis Mateo Michel Flores");

        this.createUser(Configuration.host + "/api/user.json", body, post);
        int idUser = response.then().extract().path("Id");
        JSONObject bodyProject = new JSONObject();
        bodyProject.put("Content","Refactor");

        this.createProject(Configuration.host + "/api/projects.json", bodyProject, post);
        this.deleteUser(idUser, delete, body);
        this.createProject(Configuration.host + "/api/projects.json", bodyProject, post);

    }

    private void createUser(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("Email")));
    }


/*
    @Test
    public void createUpdateDeleteProject(){
        JSONObject bodyProject = new JSONObject();
        bodyProject.put("Content","Refactor");

        this.createProject(Configuration.host + "/api/projects.json", bodyProject, post);
        int idProject = response.then().extract().path("Id");
        this.deleteUser(idProject, delete, bodyProject);
    }

*/
    private void deleteUser(int idUser, String delete, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/user/" + idUser + ".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("Email")));
    }


    private void createProject(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        if(response == null){
            Assertions.assertTrue(true, "El usuario no fue borrado");
        }
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

}
