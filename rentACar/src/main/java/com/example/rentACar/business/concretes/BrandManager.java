package com.example.rentACar.business.concretes;

import com.example.rentACar.business.abstracts.BrandService;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandsResponse;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import com.example.rentACar.business.rules.BrandBusinessRules;
import com.example.rentACar.core.utilities.mappers.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;
import com.example.rentACar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Bu sınıf bir business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {
    // BrandServiceImpl olarakta isimlendirilebilir
    //  DataAccess - Business - Api

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class); // createBrandRequest nesnemi Brand nesneme çevir
        brandRepository.save(brand);
    }


    @Override
    public GetByIdBrandResponse getById(int id) {

        Brand brand = brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {

        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {

        brandRepository.deleteById(id);
    }

}
