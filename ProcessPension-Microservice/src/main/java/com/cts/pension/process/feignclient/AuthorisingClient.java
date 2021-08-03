package com.cts.pension.process.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import static com.cts.pension.process.util.PensionConstant.AUTHORIZATION;

@FeignClient(name = "Authorizatiion-Microservice", url = "auth-lb-pod3-1537775790.ap-southeast-1.elb.amazonaws.com/auth/api/v1")
public interface AuthorisingClient {

	@PostMapping("/authorize")
	public boolean authorizeTheRequest(@RequestHeader(value =AUTHORIZATION , required = true) String requestTokenHeader);
}
