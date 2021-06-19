package com.deezzex.mapper;

public interface Mapper<F, T> {
    T mapFrom(F object);
}
