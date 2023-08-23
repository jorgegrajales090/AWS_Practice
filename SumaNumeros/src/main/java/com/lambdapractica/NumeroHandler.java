package com.lambdapractica;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.List;

public class NumeroHandler implements RequestHandler<List<Integer>, String>{
    @Override
    public String handleRequest(List<Integer> integers, Context context) {
        return "La suma de numeros es: " + new OperacionAritmetica().sumarNumeros(integers);
    }
}
