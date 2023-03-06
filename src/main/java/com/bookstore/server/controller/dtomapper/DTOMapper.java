package com.bookstore.server.controller.dtomapper;

public interface DTOMapper<D, R> {

    D toDTO(R restModel);

    R toRest(D dto);
}
