package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void deleteResume(int index) {
        int numMoved = size - index -1;
        if(numMoved > 0) {
            System.arraycopy(storage,index + 1, storage, index, numMoved);
        }
    }

    @Override
    public void insertResume(int index, Resume r) {
        int indexId = getIndex(r.getUuid()) * (-1) - 1;
       System.arraycopy(storage, indexId, storage,indexId + 1, size - indexId);
            storage[indexId] = r;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}