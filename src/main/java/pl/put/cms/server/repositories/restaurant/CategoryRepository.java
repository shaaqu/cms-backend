package pl.put.cms.server.repositories.restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Repository, Integer> {

    List<Repository> findAllByRestaurant_Id(int restaurantId);
}
