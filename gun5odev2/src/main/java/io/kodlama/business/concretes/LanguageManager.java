package io.kodlama.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.business.abstratcs.LanguageService;
import io.kodlama.business.dto.language.requests.AddLanguageRequest;
import io.kodlama.business.dto.language.requests.UpdateLanguageRequest;
import io.kodlama.business.dto.language.responces.GetAllLanguageResponse;
import io.kodlama.business.dto.language.responces.GetByIdLanguageResponse;
import io.kodlama.core.utilities.mapper.ModelMapperService;
import io.kodlama.dataAccess.abstracts.LanguageDao;
import io.kodlama.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	@Autowired
	private LanguageDao languageDao;

	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages = languageDao.findAll();
		List<GetAllLanguageResponse> languageResponse = languages.stream()
				.map(language -> modelMapperService.forResponse().map(language, GetAllLanguageResponse.class))
				.toList();
		return languageResponse;
	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		Language language = languageDao.findById(id).orElseThrow();
		GetByIdLanguageResponse languageResponse = modelMapperService.forResponse().map(language,
				GetByIdLanguageResponse.class);
		return languageResponse;
	}

	@Override
	public void add(AddLanguageRequest addLanguageRequest) {
		Language language = modelMapperService.forRequest().map(addLanguageRequest, Language.class);
		this.languageDao.save(language);
	}

	@Override
	public void update(int id, UpdateLanguageRequest updateLanguageRequest) {
		Language language = languageDao.findById(id).orElseThrow();
		this.modelMapperService.forRequest().map(updateLanguageRequest, language);
		languageDao.save(language);
	}

	@Override
	public void delete(int id) {
		Language language = languageDao.findById(id).orElseThrow();
		languageDao.delete(language);

	}
}
