package org.zomato.nitin.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.zomato.nitin.Model.Order;
import org.zomato.nitin.Model.Restaurant;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    // Optional custom query methods
    List<Order> findByRestaurantId(String restaurantId);

    // Query to find orders with a non-null review for a specific restaurant
    @Query("{ 'restaurantId' : ?0, " + "'review' : { '$ne' : null } " + "}")
    List<Order> findOrdersByRestaurantIdWithReviews(String restaurantId);
}
