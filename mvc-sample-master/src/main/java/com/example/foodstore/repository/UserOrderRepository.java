package com.example.foodStore.repository;

import com.example.foodStore.model.UserOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserOrderRepository extends CrudRepository<UserOrder, Integer> {
    @Query ("select uo from UserOrder uo where uo.userAccess.id = :userAccessId")
    List<UserOrder> findAllByUserAccessId(@Param("userAccessId") int userAccessId);
}
