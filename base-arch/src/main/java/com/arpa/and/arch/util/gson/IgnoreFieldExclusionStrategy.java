package com.arpa.and.arch.util.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class IgnoreFieldExclusionStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(GsonIgnoreField.class) != null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}
