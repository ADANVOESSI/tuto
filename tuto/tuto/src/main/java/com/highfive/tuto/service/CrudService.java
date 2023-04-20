package com.highfive.tuto.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public abstract class CrudService<T,ID> {

    private final  JpaRepository<T, ID> repository;

    public CrudService(JpaRepository<T,ID> repository) {
      this.repository = repository;
    }

    public Optional<T> get(ID id){
        return repository.findById(id);
    }

    public T save(T entity) {
        return repository.save(entity);
    }
    public List<T> getAll(){
        return repository.findAll();

    }

    public T update(ID id, T entity){
        Optional<T> existingEntity = repository.findById(id);
        if(existingEntity.isEmpty()){
            throw new IllegalArgumentException("Entity with id'" + id + "' does not exist");

        }
        entity= repository.save(entity);
        return entity;
    }
    public Boolean delete(ID id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public T create(T entity) {
        return repository.save(entity);
    }

}
