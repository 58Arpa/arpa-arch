package com.arpa.and.arch.binding.command;

/**
 * A one-argument action.
 *
 * @param <T>
 *         the first argument type
 */
public interface BindingConsumer <T> {
    void call(T t);
}