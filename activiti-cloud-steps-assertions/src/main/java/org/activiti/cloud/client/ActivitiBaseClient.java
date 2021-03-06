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

package org.activiti.cloud.client;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ActivitiBaseClient  {

    @RequestMapping(method = RequestMethod.GET, value = "/actuator/health", produces = "application/json", consumes = "application/json")
    Map<String, Object> health();

    default boolean isServiceUp() {
        Map<String, Object> appInfo = null;
        try {
            appInfo = health();
        } catch (Exception ex) {
            //just retry once
            appInfo = health();
        }
        return appInfo != null && "UP".equals(appInfo.get("status"));
    }
}