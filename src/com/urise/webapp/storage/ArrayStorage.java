package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage{

   public void sort(Resume r) {

   }

   public void shift(int index) {
       storage[index] = storage[size - 1];
   }

    public int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid() == uuid) {
                return i;
            }
        }
        return -1;
    }
}