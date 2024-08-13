package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    public Resume[] storage = new Resume[STORAGE_LIMIT];
    public int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("The resume " + uuid + " does not exist");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

}
