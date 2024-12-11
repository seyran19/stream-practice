package org.example.algs.original.P_1.service;

import org.example.algs.original.P_1.models.Box;
import org.example.algs.original.P_1.models.Cart;
import org.example.algs.original.P_1.models.Shelf;
import org.example.algs.original.P_1.repository.CartRepository;
import org.example.algs.original.P_1.repository.ShelfRepository;

public class RobotService {

    CartRepository cartRepository = new CartRepository();
    ShelfRepository shelfRepository = new ShelfRepository();



    public Box takeBoxFromCard(int cartId){
        System.out.println("Определяем за какой телегой закреплен робот...");
        Cart cart = cartRepository.findCartById(cartId);

        Box box = !cart.getBoxes().isEmpty() ? cart.getBoxes().removeFirst() : null;
        if (box == null) {
            System.out.println("В телеге нет коробок...");
           throw new RuntimeException("В телеге нет коробок...");
        }
        return box;

    }

    public Boolean putBox(Box box){
        Shelf shelf = shelfRepository.findFormByShape(box.getShape());
        if (shelf != null && shelf.getBoxes().size() < shelf.getCapacity()){
            System.out.println("Кладем коробку...");
            shelf.getBoxes().add(box);
            return shelfRepository.save(shelf);
        }
        System.out.println("Не получилось поместить коробку...");
        return false;
    }








}
