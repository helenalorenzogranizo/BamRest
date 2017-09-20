package com.rest.main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rest.classes.Usuario;

@Path("/rest")
public class MainRest {

 static final String JSON_UTF_8 = "application/json;charset=UTF-8";
 protected Gson gson;

 @GET
 @Path("/user/{name}")
 @Produces({JSON_UTF_8})
 public Object getUserByName(@PathParam("name") String name){
  Usuario user = new Usuario(name, "Lorenzo");
  gson = new GsonBuilder().disableHtmlEscaping().create();

  return gson.toJson(user);
 }
}