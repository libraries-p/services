package me.lorenzo.services.service;

public interface Service<T extends Service<T>> {
    Class<T> asType();
}
