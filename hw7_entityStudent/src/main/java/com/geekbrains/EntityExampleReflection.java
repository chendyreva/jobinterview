package com.geekbrains;

import org.springframework.data.repository.CrudRepository;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class EntityExampleReflection extends ArrayList<EntityFieldReflection> {
    public EntityExampleReflection(Object entityExample) {
        getFields(entityExample.getClass()).forEach(field -> add(new EntityFieldReflection(entityExample, field)));
    }

    public static List<EntityExampleReflection> getAllExamples(CrudRepository repository) {
        List<EntityExampleReflection> entityExampleReflections = new ArrayList<>();
        repository.findAll().forEach(entityExample -> entityExampleReflections.add(new EntityExampleReflection(entityExample)));
        return entityExampleReflections;
    }

    private static List<Field> getFields(List<Field> fields, Class<?> type) {
        fields.addAll(
                Arrays.stream(type.getDeclaredFields())
                      .filter(field -> !Modifier.isStatic(field.getModifiers()))
                      .collect(toList()));

        if (type.getSuperclass() != null) {
            getFields(fields, type.getSuperclass());
        }

        return fields;
    }

    private static List<Field> getFields(Class<?> type) {
        final List<Field> fields = new ArrayList<>();
        return getFields(fields, type);
    }

    public List<Object> getFieldNames() {
        return stream().map(EntityFieldReflection::getName).collect(Collectors.toList());
    }

    public List<String> getFieldValues() {
        return stream()
                .map(fieldReflection -> fieldReflection.getValue() == null ? "null" : fieldReflection.getValue())
                .collect(Collectors.toList());
    }
}

