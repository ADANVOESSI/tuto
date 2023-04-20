package com.highfive.tuto.web.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.highfive.tuto.service.CrudService;

public abstract class CrudResource<T, ID> {

    private final CrudService<T, ID> service;

    public CrudResource(CrudService<T, ID> service){
        this.service = service ; 
    }

    /*
     * CRUD
     * Create : POST
     */
    @PostMapping("")
    public ResponseEntity<T> create(@RequestBody T entity){
        try{
            T createEntity = this.service.create(entity);
            return ResponseEntity .ok(createEntity);  //200
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().build();//400
        }
    }

    /*
     * ReadAll : GET
     * https://www.exemple.com/brands
     */
    @GetMapping("")
    //@ RequestParam Map <String,String>params
    public ResponseEntity<List<T>>readAll(){
        return ResponseEntity.ok(this .service.getAll());
    }


    //Read : GET
    @GetMapping("/{id}")//https://www.exemple.com/brand/1
    //(@RequestParam String name)
    public ResponseEntity<T>read (@PathVariable ID id){
        return this.service.get(id)
                          .map(ResponseEntity::ok)
                          .orElseGet(()-> ResponseEntity.notFound().build());
    }

@PutMapping("/{id}")
public ResponseEntity <T> update (@PathVariable ID id ,@RequestBody T entity){
    try {
        return ResponseEntity.ok(this.service.update(id, entity));
    }catch(IllegalArgumentException  e ){

        return ResponseEntity.badRequest().build();
        //return ResponseEntity.badRequest().body("Sorry not autorise");
    }
}



    //Delete :DELETE
     @DeleteMapping("/{id}")
     public ResponseEntity delete (@PathVariable ID id){
        boolean deleted = this . service .delete (id);
        if(deleted){
            return ResponseEntity.noContent().build(); //204
        }else {
            return ResponseEntity.notFound().build();//404
        }
     }
    

}
