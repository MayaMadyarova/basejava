package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

  /*  private static class ResumeComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }*/

    private static final Comparator RESUME_COMPARATOR = new Comparator<Resume>() {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    };

    @Override
    public void deleteResume(int index) {
        int numMoved = size - index -1;
        if(numMoved > 0) {
            System.arraycopy(storage,index + 1, storage, index, numMoved);
        }
    }

    @Override
    public void insertResume(int index, Resume r) {
        int indexId = getSearchKey(r.getUuid()) * (-1) - 1;
       System.arraycopy(storage, indexId, storage,indexId + 1, size - indexId);
            storage[indexId] = r;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}