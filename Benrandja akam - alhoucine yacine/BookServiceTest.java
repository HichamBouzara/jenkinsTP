package com.example.service;

import com.example.dao.IReservationDao;
import com.example.dao.IRoomDao;
import com.example.model.Guest;
import com.example.model.Reservation;
import com.example.model.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class BookServiceTest {

    @Mock
    IReservationDao reservationDao ;
    @Mock
    IRoomDao roomDao ;

    Room room ;
    Guest guest ;
    Reservation reservation ;
    Date date_in ,date_out ;


    public BookServiceTest() throws Exception {

        this.room = new Room(1,"room1",2);
        this.guest = new Guest("yacime" ,"akram") ;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.date_in = sdf.parse("29-01-2019") ;
        this.date_out = sdf.parse("1-01-1996") ;
        this.reservation = new Reservation(date_in,date_out,room,guest)  ;


    }

    @Test
    public void bookRoom() {

        when(roomDao.isAvailable(room,date_in,date_out)).thenReturn(true) ;
        when(reservationDao.createReservation(reservation)).thenReturn(true) ;
        assertTrue(reservationDao.createReservation(reservation));
        assertTrue(roomDao.isAvailable(room,date_in,date_out));
        BookService service = new BookService(roomDao,reservationDao) ;
        boolean booked = service.bookRoom(room,date_in,date_out,guest) ;

        assertTrue(booked);

    }

    @Test
    public void cancelReservation() {

        when(reservationDao.findReservation(2018)).thenReturn(reservation) ;
        when(reservationDao.cancelReservation(reservation)).thenReturn(true) ;
        BookService service = new BookService(roomDao,reservationDao) ;
        boolean booked = service.cancelReservation(2018) ;
        assertTrue(booked);


    }
}