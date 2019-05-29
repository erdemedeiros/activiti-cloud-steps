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

import java.util.List;

import org.activiti.api.model.shared.model.VariableInstance;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessDefinitionMeta;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.ProcessInstanceMeta;
import org.activiti.api.process.model.payloads.DeleteProcessPayload;
import org.activiti.api.process.model.payloads.GetProcessDefinitionsPayload;
import org.activiti.api.process.model.payloads.GetProcessInstancesPayload;
import org.activiti.api.process.model.payloads.GetVariablesPayload;
import org.activiti.api.process.model.payloads.RemoveProcessVariablesPayload;
import org.activiti.api.process.model.payloads.ResumeProcessPayload;
import org.activiti.api.process.model.payloads.SetProcessVariablesPayload;
import org.activiti.api.process.model.payloads.SignalPayload;
import org.activiti.api.process.model.payloads.StartProcessPayload;
import org.activiti.api.process.model.payloads.SuspendProcessPayload;
import org.activiti.api.process.model.payloads.UpdateProcessPayload;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.process.runtime.conf.ProcessRuntimeConfiguration;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.cloud.client.ProcessRuntimeClient;

public class ClientDelegateProcessRuntime implements ProcessRuntime {

    private ProcessRuntimeClient processRuntimeClient;

    public ClientDelegateProcessRuntime(ProcessRuntimeClient processRuntimeClient) {
        this.processRuntimeClient = processRuntimeClient;
    }

    @Override
    public ProcessRuntimeConfiguration configuration() {
        return null;
    }

    @Override
    public ProcessDefinition processDefinition(String processDefinitionId) {
        return null;
    }

    @Override
    public Page<ProcessDefinition> processDefinitions(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProcessDefinition> processDefinitions(Pageable pageable,
                                                      GetProcessDefinitionsPayload getProcessDefinitionsPayload) {
        return null;
    }

    @Override
    public ProcessInstance start(StartProcessPayload startProcessPayload) {
        return processRuntimeClient.startProcess(startProcessPayload);
    }

    @Override
    public Page<ProcessInstance> processInstances(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProcessInstance> processInstances(Pageable pageable,
                                                  GetProcessInstancesPayload getProcessInstancesPayload) {
        return null;
    }

    @Override
    public ProcessInstance processInstance(String s) {
        return null;
    }

    @Override
    public ProcessInstance suspend(SuspendProcessPayload suspendProcessPayload) {
        return null;
    }

    @Override
    public ProcessInstance resume(ResumeProcessPayload resumeProcessPayload) {
        return null;
    }

    @Override
    public ProcessInstance delete(DeleteProcessPayload deleteProcessPayload) {
        return null;
    }

    @Override
    public ProcessInstance update(UpdateProcessPayload updateProcessPayload) {
        return null;
    }

    @Override
    public void signal(SignalPayload signalPayload) {

    }

    @Override
    public ProcessDefinitionMeta processDefinitionMeta(String s) {
        return null;
    }

    @Override
    public ProcessInstanceMeta processInstanceMeta(String s) {
        return null;
    }

    @Override
    public List<VariableInstance> variables(GetVariablesPayload getVariablesPayload) {
        return null;
    }

    @Override
    public void removeVariables(RemoveProcessVariablesPayload removeProcessVariablesPayload) {

    }

    @Override
    public void setVariables(SetProcessVariablesPayload setProcessVariablesPayload) {

    }
}
