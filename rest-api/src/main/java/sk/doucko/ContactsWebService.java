package sk.doucko;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/contacts")
public class ContactsWebService
{
    @PersistenceContext(unitName="contactListPU")
    private EntityManager em;

    @GET
    public Response getTasks()
    {
        return Response.ok("{\"hello\": \"world\"}", MediaType.APPLICATION_JSON).build();
    }

}
