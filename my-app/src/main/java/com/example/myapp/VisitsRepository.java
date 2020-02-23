package com.example.myapp;

import org.springframework.data.repository.CrudRepository;

interface VisitsRepository extends CrudRepository<Visit, Long> {
}
