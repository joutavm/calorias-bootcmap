package br.com.joao.calorias.services;


import br.com.joao.calorias.models.Food;
import br.com.joao.calorias.models.FoodForm;
import br.com.joao.calorias.repository.FoodRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class FoodService {


    FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public Food findById(int id){
        return foodRepository.findById(id);
    }


    public ResponseEntity<Food> add(FoodForm form, UriComponentsBuilder uriBuilder) {
        Food food = form.convert();
        foodRepository.add(food);

        return ResponseEntity.ok().body(food);
    }
}
