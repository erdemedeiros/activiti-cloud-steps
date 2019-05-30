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

package org.activiti.cloud.steps.operations;

import java.util.ArrayList;
import java.util.List;

import org.activiti.api.task.model.Task;
import org.activiti.cloud.api.task.model.CloudTask;
import org.activiti.cloud.client.QueryTaskClient;
import org.activiti.steps.TaskProvider;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedResources;

public class QueryTaskProvider implements TaskProvider {

    private QueryTaskClient queryTaskClient;

    public QueryTaskProvider(QueryTaskClient queryTaskClient) {
        this.queryTaskClient = queryTaskClient;
    }

    @Override
    public List<Task> getTasks(String processInstanceId) {
        PagedResources<CloudTask> taskPagedResources = queryTaskClient.getTasks(processInstanceId,
                                                                   PageRequest.of(0,
                                                                                  1000));
        return new ArrayList<>(taskPagedResources.getContent());
    }

    @Override
    public boolean canHandle(Task.TaskStatus taskStatus) {
        return true;
    }
}