package com.example.rentACar.business.abstracts;

import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {

    List<GetAllModelsResponse> getAll();

    void add(CreateModelRequest createModelRequest);


//    GetByIdBrandResponse getById(int id);
//
//    void add(CreateBrandRequest createBrandRequest);
//
//    void update(UpdateBrandRequest updateBrandRequest);
//
//    void delete(int id);
}
