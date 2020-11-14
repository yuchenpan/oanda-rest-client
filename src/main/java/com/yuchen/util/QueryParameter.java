package com.yuchen.util;

public record QueryParameter(String name, String value) {
    public static QueryParameter of(String name, String value)
    {
        return new QueryParameter(name, value);
    }

    @Override
    public String toString() {
        return this.name + "=" + this.value;
    }
}
