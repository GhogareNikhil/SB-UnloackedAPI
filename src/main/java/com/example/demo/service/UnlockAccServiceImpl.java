package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bindings.UnlockAccRequest;
import com.example.demo.constatnts.AppConstants;
import com.example.demo.entity.UserEntity;
import com.example.demo.props.AppProoerties;
import com.example.demo.repository.UserRepository;

@Service
public class UnlockAccServiceImpl implements UnlockAccService {

	@Autowired
	private UserRepository usRepository;

	@Autowired
	private AppProoerties appProoerties;

	@Override
	public String UnlockAccount(UnlockAccRequest unlAccRequest) {
		UserEntity user = usRepository.findByUserEmaillAndUserPwd(unlAccRequest.getEmail(), unlAccRequest.getTempPwd());
		if (user != null) {
			user.setUserPwd(unlAccRequest.getNewPwd());
			user.setSetUserAccStatus("UNLOCKED");
			usRepository.save(user);
			return appProoerties.getMessage().get(AppConstants.ACC_UNLOCKED_SUCCESS);
		}
		return appProoerties.getMessage().get(AppConstants.INVALID_TEMP_PWD);
	}
}
