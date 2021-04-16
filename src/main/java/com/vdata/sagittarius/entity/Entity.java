package com.vdata.sagittarius.entity;

public interface Entity {

    int id = 0;

    default int getId() {
        return id;
    }

    default void setId(int id) {
        id = id;
    }


}
