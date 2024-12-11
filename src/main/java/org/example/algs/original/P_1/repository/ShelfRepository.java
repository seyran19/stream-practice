package org.example.algs.original.P_1.repository;

import org.example.algs.original.P_1.models.Shelf;

public class ShelfRepository {

    public Shelf findFormByShape(int shape){
        /// достаем из бд подходящий объект
        return new Shelf();
    }

    public Boolean save(Shelf shelf) {
        /// сохраняем в бд
        return true;
    }
}
