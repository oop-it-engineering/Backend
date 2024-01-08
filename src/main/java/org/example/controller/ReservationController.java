package org.example.controller;

import org.example.service.ReservationService;

public class ReservationController {
    private ReservationService reservationService = new ReservationService();

    //장비 예약
    public int reservation(int deviceId, String userId) {
        int result = reservationService.reservation(deviceId, userId);
        if (result == 1) {
            System.out.println("예약 성공");
        }else {
            System.out.println("예약 실패");
        }
        return result;
    }
}
