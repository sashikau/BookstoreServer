package com.bookstore.server.service.entitymapper;

public interface EntityMapper<E, D> {

    E toEntity(D dto);

    D toDTO(E entity);
}