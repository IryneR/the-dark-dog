package org.example.service;

import org.example.repository.SavedValueEntity;

public interface SavedValueService {

    SavedValueEntity getByClientKey(String clientKey);

    void setForClientKey(String clientKey, String value);

}
