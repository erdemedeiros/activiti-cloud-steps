/*
 * Copyright 2019 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.cloud.steps;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "authenticationClient")
@RequestMapping(value = "/auth/realms/activiti/protocol/openid-connect/token")
public interface AuthenticationClient {

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    String authenticate(
                        @RequestParam("client_id") String clientId,
                        @RequestParam("grant_type") String grantType,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password);
}
