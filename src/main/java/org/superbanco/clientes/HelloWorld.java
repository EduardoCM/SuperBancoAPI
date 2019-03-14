package org.superbanco.clientes;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/api/cliente")
public class HelloWorld {
  
  private static List<Cliente> clientes = new ArrayList<>();
 
  static {
    Cliente cliente = new Cliente();
    cliente.setNombre("Eduardo");
    cliente.setApellido("Castillo");
    clientes.add(cliente);
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Cliente> getClientes(){
    return clientes;
  }
  
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Cliente addCliente(Cliente cliente) {
    clientes.add(cliente);
    return cliente;
  }
  
  @DELETE
  @Path("/{index}")
  @Produces(MediaType.APPLICATION_JSON)
  public Cliente deleteCliente(@PathParam("index") int index) {
   return clientes.remove(index);  
  }
  
  @PUT
  @Path("/{index}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Cliente updateCliente(@PathParam("index") int index, Cliente cliente) {
    return clientes.set(index, cliente);
  }

  /*
    mvn archetype:generate
    7: remote -> org.apache.cxf.archetype:cxf-jaxrs-service (Simple CXF JAX-RS webapp service using Spring configuration)
    86: 3.1.18    
  */
}

