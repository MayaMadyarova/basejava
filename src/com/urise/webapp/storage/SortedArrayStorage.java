package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    public void sort(Resume r) {
        int index = getIndex(r.getUuid()) * (-1) - 1;
        if(index >= 0)  {
            for (int i = size - 1; i > index; i--) {
                storage[i] = storage[i - 1];
            }
            storage[index] = r;
        }
    }

    public void shift(int index) {
        for(int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
