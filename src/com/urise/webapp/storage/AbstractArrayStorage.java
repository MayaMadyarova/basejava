package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    public Resume[] storage = new Resume[STORAGE_LIMIT];
    public int size = 0;

    @Override
    public void save(Resume r) {
        if (getIndex(r.getUuid()) >= 0) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = r;
            size++;
            sort(r);
        }
    }

    public abstract void sort(Resume r);

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if(index < 0) {
            System.out.println("The resume " + uuid + " does not exist");
        } else {
            shift(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public abstract void shift(int index);

    public int size() {
        return size;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            System.out.println("Resume " + r.getUuid() + "does not exist");
        } else {
            storage[index] = r;
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
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

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }
}
