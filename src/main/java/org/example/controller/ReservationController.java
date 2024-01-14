package org.example.controller;

import org.example.entity.Reservation;
import org.example.service.ReservationService;

import java.util.List;

public class ReservationController {
    private ReservationService reservationService = new ReservationService();

    //장비 예약
    public int reservation(int deviceId, String userId,String resConfTime) {
        int result = reservationService.reservation(deviceId, userId,resConfTime);
        if (result == 1) {
            System.out.println("예약 성공");
        }else {
            System.out.println("예약 실패");
        }
        return result;
    }

    //수령 대기중인 장비 목록 조회

    public List<Reservation> getRes(String userId) {
        List<Reservation> reservations = reservationService.getRes(userId);
        return  reservations;
    }

    //대여중인 장비 목록 조회
    public List<Reservation> getResConf(String userId) {
        List<Reservation> reservations = reservationService.getResConf(userId);
        return  reservations;
    }

}
