package com.rest.main;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rest.classes.Usuario;

@Path("/rest")
public class MainRest {

 static final String JSON_UTF_8 = "application/json;charset=UTF-8";
 static final String  TEXT ="text/plain";
 static final String BAM = "application/octet-stream";
 static final String GZIP = "application/x-gzip";
 static final String BED ="application/vnd.realvnc.bed";
 //static final String SRCFILES = "/var/www/srcDreamgenics/";
 //static final String SRCFILES = "\var\www\srcDreamgenics\";
 static final String SRCFILES = "/";
 protected Gson gson;

 @GET
 @Path("/user/{name}")
 @Produces({JSON_UTF_8})
 public Object getUserByName(@PathParam("name") String name){
  Usuario user = new Usuario(name, "Lorenzo");
  gson = new GsonBuilder().disableHtmlEscaping().create();

  return gson.toJson(user);
 }
 
 
 @GET
 @Path("/referenceGenome/{filename}")
 @Produces({TEXT})
 public Object getFa(@PathParam("filename") String filename) throws FileNotFoundException{
  File file = new File(SRCFILES+filename);
  return file;
  }
 
 @GET
 @Path("/referenceGenomeIndex/{filename}")
 @Produces({TEXT})
 public Object getFaFai(@PathParam("filename") String filename) throws FileNotFoundException{
  File file = new File(SRCFILES+filename);
  return file;

 }
 
 @GET
 @Path("cytoband/{filename}")
 @Produces({GZIP})
 public Object getCytoband(@PathParam("filename") String filename) throws FileNotFoundException{
	 File file = new File(SRCFILES+filename);
	  return file;
 }
 
 @GET
 @Path("geneAnnotation/{filename}")
 @Produces({GZIP})
 public Object getGeneAnnotation(@PathParam("filename") String filename) throws FileNotFoundException{
	 File file = new File(SRCFILES+filename);
	  return file;
 }
 
 @GET
 @Path("geneAnnotationIndex/{filename}")
 @Produces({GZIP})
 public Object getGeneAnnotationIndex(@PathParam("filename") String filename) throws FileNotFoundException{
	 File file = new File(SRCFILES+filename);
	  return file;
 }
 
 @GET
 @Path("bam/{filename}")
 @Produces({BAM})
 public Object getBam(@PathParam("filename") String filename) throws FileNotFoundException{
	 File file = new File(SRCFILES+filename);
	  return file;
 }
 
 
 @GET
 @Path("bed/{filename}")
 @Produces({BED})
 public Object getBed(@PathParam("filename") String filename) throws FileNotFoundException{
	 File file = new File(SRCFILES+filename);
	  return file;
 }
 
 @GET
 @Path("variants/{filename}")
 @Produces({GZIP})
 public Object getVariant(@PathParam("filename") String filename) throws FileNotFoundException{
	 File file = new File(SRCFILES+filename);
	  return file;
 }
 
 @GET
 @Path("variantsIndex/{filename}")
 @Produces({GZIP})
 public Object getVariantsIndex(@PathParam("filename") String filename) throws FileNotFoundException{
	 File file = new File(SRCFILES+filename);
	  return file;
 }
}





