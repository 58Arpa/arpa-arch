package com.arpa.and.base.arch.binding.command;

/**
 * Represents a function with zero arguments.
 *
 * @param <T>
 *         the result type
 */
public interface BindingFunction <T> {
    T call();
}
