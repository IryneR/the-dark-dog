package org.example.repository;


import org.example.repository.SavedValueEntity;
import org.springframework.data.repository.CrudRepository;

public interface SavedValueRepository extends CrudRepository<SavedValueEntity, String> {}
