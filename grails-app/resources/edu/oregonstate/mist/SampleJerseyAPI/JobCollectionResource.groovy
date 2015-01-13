package edu.oregonstate.mist.SampleJerseyAPI

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.POST
import javax.ws.rs.core.Response

@Path('/api/job')
@Consumes(['application/xml','application/json'])
@Produces(['application/xml','application/json'])
class JobCollectionResource {

    def jobResourceService

    @POST
    Response create(Job dto) {
        created jobResourceService.create(dto)
    }

    @GET
    Response readAll() {
        ok jobResourceService.readAll()
    }

    @Path('/{id}')
    JobResource getResource(@PathParam('id') Long id) {
        new JobResource(jobResourceService: jobResourceService, id:id)
    }
}
