package org.launchcode.recipes.models.data;

import org.launchcode.recipes.models.Cuisine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends CrudRepository<Cuisine, Integer> {
}
