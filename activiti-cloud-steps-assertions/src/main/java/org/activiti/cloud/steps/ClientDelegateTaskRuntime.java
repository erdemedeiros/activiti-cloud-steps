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

import java.util.ArrayList;
import java.util.List;

import org.activiti.api.model.shared.model.VariableInstance;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.payloads.CandidateGroupsPayload;
import org.activiti.api.task.model.payloads.CandidateUsersPayload;
import org.activiti.api.task.model.payloads.ClaimTaskPayload;
import org.activiti.api.task.model.payloads.CompleteTaskPayload;
import org.activiti.api.task.model.payloads.CreateTaskPayload;
import org.activiti.api.task.model.payloads.CreateTaskVariablePayload;
import org.activiti.api.task.model.payloads.DeleteTaskPayload;
import org.activiti.api.task.model.payloads.GetTaskVariablesPayload;
import org.activiti.api.task.model.payloads.GetTasksPayload;
import org.activiti.api.task.model.payloads.ReleaseTaskPayload;
import org.activiti.api.task.model.payloads.SaveTaskPayload;
import org.activiti.api.task.model.payloads.UpdateTaskPayload;
import org.activiti.api.task.model.payloads.UpdateTaskVariablePayload;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.api.task.runtime.conf.TaskRuntimeConfiguration;
import org.activiti.cloud.api.task.model.CloudTask;
import org.activiti.cloud.client.TaskRuntimeClient;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedResources;

public class ClientDelegateTaskRuntime implements TaskRuntime {

    private TaskRuntimeClient taskRuntimeClient;


    public ClientDelegateTaskRuntime(TaskRuntimeClient taskRuntimeClient) {
        this.taskRuntimeClient = taskRuntimeClient;
    }

    @Override
    public TaskRuntimeConfiguration configuration() {
        return null;
    }

    @Override
    public Task task(String taskId) {
        return null;
    }

    @Override
    public Page<Task> tasks(Pageable pageable) {
        //fixme: improve this conversion to take in account all the fields
        PagedResources<CloudTask> taskPagedResources = taskRuntimeClient.getTasks(toSpringPageable(pageable));
        return toAPIPage(taskPagedResources);
    }

    private PageRequest toSpringPageable(Pageable pageable) {
        return PageRequest.of(pageable.getStartIndex() * pageable.getMaxItems(),
                              pageable.getMaxItems());
    }

    private Page<Task> toAPIPage(PagedResources<CloudTask> taskPagedResources) {
        List<Task> tasks = new ArrayList<>();
        for (CloudTask taskPagedResource : taskPagedResources) {
            tasks.add(taskPagedResource);
        }
        return new PageImpl<>(tasks,
                              (int) taskPagedResources.getMetadata().getTotalElements());
    }

    @Override
    public Page<Task> tasks(Pageable pageable,
                            GetTasksPayload getTasksPayload) {
        PagedResources<CloudTask> taskPagedResources = taskRuntimeClient.getTasks(getTasksPayload.getProcessInstanceId(),
                                                                                  toSpringPageable(pageable));
        return toAPIPage(taskPagedResources);
    }

    @Override
    public Task create(CreateTaskPayload createTaskPayload) {
        return null;
    }

    @Override
    public Task claim(ClaimTaskPayload claimTaskPayload) {
        return taskRuntimeClient.claimTask(claimTaskPayload.getTaskId());
    }

    @Override
    public Task release(ReleaseTaskPayload releaseTaskPayload) {
        return null;
    }

    @Override
    public Task complete(CompleteTaskPayload completeTaskPayload) {
        return taskRuntimeClient.completeTask(completeTaskPayload.getTaskId(), completeTaskPayload);
    }

    @Override
    public void save(SaveTaskPayload saveTaskPayload) {

    }

    @Override
    public Task update(UpdateTaskPayload updateTaskPayload) {
        return null;
    }

    @Override
    public Task delete(DeleteTaskPayload deleteTaskPayload) {
        return null;
    }

    @Override
    public void createVariable(CreateTaskVariablePayload createTaskVariablePayload) {

    }

    @Override
    public void updateVariable(UpdateTaskVariablePayload updateTaskVariablePayload) {

    }

    @Override
    public List<VariableInstance> variables(GetTaskVariablesPayload getTaskVariablesPayload) {
        return null;
    }

    @Override
    public void addCandidateUsers(CandidateUsersPayload candidateUsersPayload) {

    }

    @Override
    public void deleteCandidateUsers(CandidateUsersPayload candidateUsersPayload) {

    }

    @Override
    public void addCandidateGroups(CandidateGroupsPayload candidateGroupsPayload) {

    }

    @Override
    public void deleteCandidateGroups(CandidateGroupsPayload candidateGroupsPayload) {

    }

    @Override
    public List<String> userCandidates(String taskId) {
        return null;
    }

    @Override
    public List<String> groupCandidates(String taskId) {
        return null;
    }
}
