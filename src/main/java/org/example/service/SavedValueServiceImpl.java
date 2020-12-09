package org.example.service;

import org.example.repository.SavedValueEntity;
import org.example.repository.SavedValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SavedValueServiceImpl implements SavedValueService {

    @Autowired

    SavedValueRepository savedValueRepository;

    @Override

    public SavedValueEntity getByClientKey(String clientKey) {

        return savedValueRepository.findById(clientKey).get();

    }

    @Override

    public void setForClientKey(String clientKey, String value) {

        SavedValueEntity entity = new SavedValueEntity(clientKey, value);

        savedValueRepository.save(entity);

    }

}