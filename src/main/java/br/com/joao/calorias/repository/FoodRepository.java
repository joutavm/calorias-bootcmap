package br.com.joao.calorias.repository;

import br.com.joao.calorias.models.Food;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepository {

    private static final File FILE = new File("food.json");

    ObjectMapper mapper;

    public FoodRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }


    public List<Food> findAll() {
        List<Food> foods = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Food>> typeReference = new TypeReference<List<Food>>() {};
            foods = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return foods;
    }

    public Food findById(int id){
        return findAll().get(id);
    }

    public void add(Food food) {
        try {
            List<Food> foods = findAll();
            foods.add(food);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, foods);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
