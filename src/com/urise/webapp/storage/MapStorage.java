package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> Map = new HashMap();

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        Map.put((String) searchKey, r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return Map.containsKey((String) searchKey);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        Map.put((String) searchKey, r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        Map.remove((String) searchKey);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return Map.get((String) searchKey);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    public void clear() {
        Map.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[Map.size()];
        Map.values().toArray(resumes);
            return resumes;
    }

    @Override
    public int size() {
        return Map.size();
    }
}
