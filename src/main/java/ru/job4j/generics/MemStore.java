package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        T element = findById(id);
        if (element != null) {
            int index = mem.indexOf(element);
            mem.set(index, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        T element = findById(id);
        if (element != null) {
            result = mem.remove(element);
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T element : mem) {
            if (element.getId().equals(id)) {
                result = element;
                break;
            }
        }
        return result;
    }
}
