package com.csye6225.assignment1.resource;

import com.csye6225.assignment1.model.AnnouncementModel;
import com.csye6225.assignment1.service.AnnouncementService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("announcement")
public class Announcement {

    AnnouncementService as = new AnnouncementService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AnnouncementModel> getAllAnnouncementsByProgram() {

        return as.getAll();
    }

    @GET
    @Path("/{boardId}_{announcementId}")
    @Produces(MediaType.APPLICATION_JSON)
    public AnnouncementModel getAnnouncement(@PathParam("boardId") String boardId, @PathParam("announcementId") String announcementId) {
        return as.get(boardId, announcementId);
    }

    @DELETE
    @Path("/{boardId}_{announcementId}")
    @Produces(MediaType.APPLICATION_JSON)
    public AnnouncementModel deleteAnnouncement(@PathParam("boardId") String boardId, @PathParam("announcementId") String announcementId) {
        return as.delete(boardId, announcementId);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AnnouncementModel addAnnouncement(AnnouncementModel announcement) {
        return as.add(announcement);
    }



    @PUT
    @Path("/{boardId}_{announcementId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AnnouncementModel updateAnnouncement(@PathParam("boardId") String boardId, @PathParam("announcementId") String announcementId,
                                                AnnouncementModel announcement) {
        return as.update(announcement);
    }

}