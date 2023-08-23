package com.lambdapractica;

import java.util.List;

public class OperacionAritmetica {

    public int sumarNumeros(List<Integer> integers)
    {
        return integers.stream().mapToInt(Integer::intValue).sum();
    }
}
