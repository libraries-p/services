package me.lorenzo.services.service.holder;

import me.lorenzo.services.service.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Services {
    private final static Map<Class<? extends Service<?>>, Service<?>> services = new HashMap<>();

    public static void register(Service<?> service) {
        services.put(service.asType(), service);
    }

    public static <T extends Service<T>> Optional<Service<T>> get(Class<T> clazz) {
        return Optional.ofNullable(clazz.cast(services.get(clazz)));
    }

    public static <T extends Service<T>> Service<T> getOrThrow(Class<T> clazz) {
        Service<T> service = clazz.cast(services.get(clazz));

        if (service == null) {
            throw new NullPointerException("Unable to found service: " + clazz.getSimpleName());
        }

        return service;
    }
}
