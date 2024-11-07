package br.com.techjobs.api.techjobs.util;

import java.lang.reflect.Field;

public class Util {
    public static <T> T convertStrings(T object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field: fields) {
            field.setAccessible(true);

            String valor = (String)field.get(object);

            if (valor != null && valor.trim().isEmpty()) {
                valor = null;
            }

            if (valor != null) {
                valor = "%" + valor.toLowerCase() +"%";
            }

            field.set(object, valor);
        }

        return object;
    }
}
