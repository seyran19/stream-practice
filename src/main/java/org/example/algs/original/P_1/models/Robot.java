package org.example.algs.original.P_1.models;

import org.example.algs.original.P_1.service.RobotService;

public class Robot {

    int id;
    String name;
    int cartId;

    private RobotService robotService;

    public void putBoxToShelfFromCart(int cartId){
        Box box = robotService.takeBoxFromCard(cartId);
        robotService.putBox(box);
    }
}
