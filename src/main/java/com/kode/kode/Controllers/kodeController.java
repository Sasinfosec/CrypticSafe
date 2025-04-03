package com.kode.kode.Controllers;

import com.kode.kode.models.Name;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") 
@RequestMapping("/api/v1")
public class kodeController {
    @GetMapping("/")
    public String home(){


        return "Hey Sasi";
    }


    @PostMapping("/name")
    public ResponseEntity<Name> name(@RequestBody final Name name) {
        System.out.println(name);
        Name result = new Name(toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);

    }
    @GetMapping("/name")
    public List<Name> getAllNames(){
        List<Name> result = new ArrayList<>();
        result.add(new Name("Sasi"));
        result.add(new Name("John"));
        result.add(new Name("Random"));
        return result;
    }

    @GetMapping("/users")
    public String users(){

        return "Users Returned";
    }


}
