package br.com.joao.calorias.controller;

import br.com.joao.calorias.models.Food;
import br.com.joao.calorias.models.FoodForm;
import br.com.joao.calorias.services.FoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> produtos(){
        return foodService.findAll();
    }

    @GetMapping("/{id}")
    public Food produto(@PathVariable int id){
        return foodService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Food> add(@RequestBody FoodForm form, UriComponentsBuilder uriBuilder){
        return foodService.add(form, uriBuilder);
    }


}
