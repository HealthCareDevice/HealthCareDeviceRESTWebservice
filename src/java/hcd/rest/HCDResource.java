/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hcd.rest;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * REST Web Service
 *
 * @author RayaXP
 */
@Path("HCD")
public class HCDResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HCDResource
     */
    public HCDResource() {
    }

    /**
     * Retrieves representation of an instance of hcd.rest.HCDResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @POST
  @Path("heartrate")
  @Produces("text/plain")
  @Consumes("application/JSON")
  public String heartrate(String heartrateJSONData) {
        try {
            JSONObject $jSONObject =new JSONObject(heartrateJSONData);
            JSONObject $heartRate= $jSONObject.getJSONObject("Heart Rate");
            int UserID=$heartRate.getInt("UserID");
            int Max=$heartRate.getInt("Max");
            int Min=$heartRate.getInt("Min");
            String Date=$heartRate.getString("Date");
            
            return "Heart Rate for User:"+UserID+" in Date of "+Date+" is "+Max+":"+Min;
        } catch (JSONException ex) {
            Logger.getLogger(HCDResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
  }
    /**
     * PUT method for updating or creating an instance of HCDResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
