package com.example.vokzalproj.controller;

import com.example.vokzalproj.model.*;
import com.example.vokzalproj.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin
public class VokzalController {

    private final RailwayRepareService repareService;
    private final RoutService routService;
    private final StaffFineService fineService;
    private final StaffService staffService;
    private final TicketService ticketService;
    private final TrainService trainService;


    @Autowired
    public VokzalController(RailwayRepareService repareService, RoutService routService, StaffFineService fineService,
                            StaffService staffService, TicketService ticketService, TrainService trainService) {
        this.repareService = repareService;
        this.routService = routService;
        this.fineService = fineService;
        this.staffService = staffService;
        this.ticketService = ticketService;
        this.trainService = trainService;

    }

    @GetMapping(value = "/trains")
    public void GetTrains(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Train> trains = new ArrayList<>();
        trains = trainService.getAllTrains();
        JSONArray ja = new JSONArray();
        for(Train train : trains){
            Set<Rout> routs = new HashSet<>();
            routs = train.getRouts();
            String routsToString = "";
            JSONArray jaRouts = new JSONArray();
            for(Rout rout : routs){
                jaRouts.add(rout.getId());
            }
            JSONObject jo = new JSONObject();
            jo.put("id", train.getId());
            jo.put("renovation_year", train.getRenovationYear());
            jo.put("manufacture_year", train.getManufactureYear());
            jo.put("seats", train.getSeats());
            jo.put("routs",jaRouts);
            ja.add(jo);


            //response.getWriter().write("Train id: "+ train.getId()+"\nrenovationYear: "+ train.getRenovationYear()
               //     +"\nmanufactureYear: "+train.getManufactureYear()+"\nseats: "+train.getSeats()+"\nrouts: "+routsToString+"\n\n");
        }

        response.getWriter().write(ja.toJSONString());
    }
    @GetMapping(value = "/tickets")
    public void GetTickets(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets = ticketService.getAllTickets();
        JSONArray ja = new JSONArray();
        for(Ticket ticket : tickets){
            JSONObject jo = new JSONObject();
            jo.put("id", ticket.getId());
            jo.put("destination_time", ticket.getDestTime());
            jo.put("price", ticket.getPrice());
            jo.put("timestamp", ticket.getTimestamp().toString());
            jo.put("rout_id", ticket.getRoutId());
            ja.add(jo);
        }
        response.getWriter().write(ja.toJSONString());
    }
    @DeleteMapping(path = "/{id}")
    public void DeleteTickets(@PathVariable int id) throws IOException {
        ticketService.removeTicketById(id);
    }
    @GetMapping(value = "/fines")
    public void GetFines(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<StaffFine> fines = new ArrayList<>();
        fines = fineService.getAllStaffFines();
        JSONArray ja = new JSONArray();
        for(StaffFine fine : fines){
            JSONObject jo = new JSONObject();
            jo.put("id", fine.getId());
            jo.put("fine", fine.getFine());
            jo.put("reason", fine.getReason());
            jo.put("staff_id", fine.getStaffId());
            jo.put("is_payed", fine.isPayed());
            ja.add(jo);
        }

        response.getWriter().write(ja.toJSONString());
    }

    @GetMapping(value = "/staff")
    public void GetStaff(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Staff> staff = new ArrayList<>();
        staff = staffService.getAllStaff();
        JSONArray ja = new JSONArray();
        for(Staff person : staff){
            JSONObject jo = new JSONObject();
            jo.put("id", person.getId());
            jo.put("train_id", person.getTrainId());
            jo.put("role", person.getRole());
            jo.put("name", person.getName());
            ja.add(jo);
        }
        response.getWriter().write(ja.toJSONString());
    }

    @GetMapping(value = "/routs")
    public void GetRouts(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Rout> routs = new ArrayList<>();
        routs = routService.getAllRouts();
        JSONArray ja = new JSONArray();
        for(Rout rout : routs){
           Set<Train> trains = new HashSet<>();
           trains = rout.getTrains();
           JSONArray jaTrains = new JSONArray();
           for(Train train : trains){
               jaTrains.add(train.getId());
            }
            JSONObject jo = new JSONObject();
            jo.put("id", rout.getId());
            jo.put("departure", rout.getDeparture());
            jo.put("destination", rout.getDestination());
            jo.put("trains", jaTrains);
            ja.add(jo);
           // response.getWriter().write("Rout id: "+ rout.getId()+"\ndeparture: "+rout.getDeparture()
                //    +"\ndestination: "+rout.getDestination()+"\ntrains: "+trainsToString+"\n\n");
        }
        response.getWriter().write(ja.toJSONString());
    }

    @GetMapping(value = "/repares")
    public void GetRepares(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<RailwayRepare> repares = new ArrayList<>();
        repares = repareService.getAllRepares();
        JSONArray ja = new JSONArray();
        for(RailwayRepare repare : repares){
            JSONObject jo = new JSONObject();
            jo.put("id", repare.getId());
            jo.put("deadline", repare.getDeadline());
            jo.put("place", repare.getPlace());
            jo.put("rout_id", repare.getRoutId());
            jo.put("is_done", repare.isDone());
            ja.add(jo);
        }
        response.getWriter().write(ja.toJSONString());
    }

}
