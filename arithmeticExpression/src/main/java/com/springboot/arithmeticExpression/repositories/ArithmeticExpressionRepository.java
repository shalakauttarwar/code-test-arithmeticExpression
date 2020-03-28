package com.springboot.arithmeticExpression.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.arithmeticExpression.models.ArithmeticExpression;

@Repository
public interface ArithmeticExpressionRepository extends CrudRepository<ArithmeticExpression, Integer> {

}
