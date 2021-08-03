package com.cts.pension.disbursement.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import static com.cts.pension.disbursement.util.PensionConstant.AUTHORIZATION;

@FeignClient(name = "Authorizatiion-Microservice", url = "http://localhost:8400/auth/api/v1")
public interface AuthorisingClient {

	@PostMapping("/authorize")
	public boolean authorizeTheRequest(@RequestHeader(value = AUTHORIZATION, required = true) String requestTokenHeader);
}
