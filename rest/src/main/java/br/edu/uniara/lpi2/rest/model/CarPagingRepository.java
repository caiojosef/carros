package br.edu.uniara.lpi2.rest.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarPagingRepository
        extends PagingAndSortingRepository<Car, Long> {
}
