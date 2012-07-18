/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.human.interactions.api;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.jboss.human.interactions.internals.annotations.Persistent;
import org.jboss.human.interactions.internals.annotations.Local;
import org.jboss.human.interactions.model.Content;
import org.jboss.human.interactions.model.FaultData;
import org.jboss.human.interactions.model.Group;
import org.jboss.human.interactions.model.Status;
import org.jboss.human.interactions.model.TaskDef;
import org.jboss.human.interactions.model.TaskEvent;
import org.jboss.human.interactions.model.TaskInstance;
import org.jboss.human.interactions.model.TaskSummary;
import org.jboss.human.interactions.model.User;

/**
 *
 * @author salaboy
 */

public class TaskServiceEntryPointImpl implements TaskServiceEntryPoint {

    @Inject
    @Local
    private TaskDefService taskDefService;
    @Inject
    @Local
    private TaskInstanceService taskInstanceService;
    @Inject
    @Local
    private TaskIdentityService taskIdentityService;
    @Inject
    @Local
    private TaskAdminService taskAdminService;
    @Inject
    @Local
    private TaskQueryService taskQueryService;

    @Inject
    @Persistent
    @Local
    private TaskEventsService taskEventsService;
    
    
    
    public TaskServiceEntryPointImpl() {
    }

    @Override
    public TaskDefService getTaskDefService() {
        return taskDefService;
    }

    @Override
    public TaskInstanceService getTaskInstanceService() {
        return taskInstanceService;
    }

    @Override
    public TaskIdentityService getTaskIdentityService() {
        return taskIdentityService;
    }

    @Override
    public TaskAdminService getTaskAdminService() {
        return taskAdminService;
    }

    @Override
    public TaskQueryService getTaskQueryService() {
        return taskQueryService;
    }

    public TaskEventsService getTaskEventsService() {
        return taskEventsService;
    }
    

    public List<TaskSummary> getActiveTasks() {
        return taskAdminService.getActiveTasks();
    }

    public List<TaskSummary> getActiveTasks(Date since) {
        return taskAdminService.getActiveTasks(since);
    }

    public List<TaskSummary> getCompletedTasks() {
        return taskAdminService.getCompletedTasks();
    }

    public List<TaskSummary> getCompletedTasks(Date since) {
        return taskAdminService.getCompletedTasks(since);
    }

    public List<TaskSummary> getCompletedTasksByProcessId(Long processId) {
        return taskAdminService.getCompletedTasksByProcessId(processId);
    }

    public int archiveTasks(List<TaskSummary> tasks) {
        return taskAdminService.archiveTasks(tasks);
    }

    public List<TaskSummary> getArchivedTasks() {
        return taskAdminService.getArchivedTasks();
    }

    public int removeTasks(List<TaskSummary> tasks) {
        return taskAdminService.removeTasks(tasks);
    }

    public void deployTaskDef(TaskDef def) {
        taskDefService.deployTaskDef(def);
    }

    public List<TaskDef> getAllTaskDef(String filter) {
        return taskDefService.getAllTaskDef(filter);
    }

    public TaskDef getTaskDefById(String id) {
        return taskDefService.getTaskDefById(id);
    }

    public void undeployTaskDef(String id) {
        taskDefService.undeployTaskDef(id);
    }

    public void addUser(User user) {
        taskIdentityService.addUser(user);
    }

    public void addGroup(Group group) {
        taskIdentityService.addGroup(group);
    }

    public void removeGroup(String groupId) {
        taskIdentityService.removeGroup(groupId);
    }

    public void removeUser(String userId) {
        taskIdentityService.removeUser(userId);
    }

    public List<User> getUsers() {
        return taskIdentityService.getUsers();
    }

    public List<Group> getGroups() {
        return taskIdentityService.getGroups();
    }

    public User getUserById(String userId) {
        return taskIdentityService.getUserById(userId);
    }

    public Group getGroupById(String groupId) {
        return taskIdentityService.getGroupById(groupId);
    }

    public long newTask(String name, Map<String, Object> params) {
        return taskInstanceService.newTask(name, params);
    }

    public void activate(long taskId, String userId) {
        taskInstanceService.activate(taskId, userId);
    }

    public void claim(long taskId, String userId) {
        taskInstanceService.claim(taskId, userId);
    }

    public void claim(long taskId, String userId, List<String> groupIds) {
        taskInstanceService.claim(taskId, userId, groupIds);
    }

    public void claimNextAvailable(String userId, String language) {
        taskInstanceService.claimNextAvailable(userId, language);
    }

    public void claimNextAvailable(String userId, List<String> groupIds, String language) {
        taskInstanceService.claimNextAvailable(userId, groupIds, language);
    }

    public void complete(long taskId, String userId, Map<String, Object> data) {
        taskInstanceService.complete(taskId, userId, data);
    }

    public void delegate(long taskId, String userId, String targetUserId) {
        taskInstanceService.delegate(taskId, userId, targetUserId);
    }

    public void deleteFault(long taskId, String userId) {
        taskInstanceService.deleteFault(taskId, userId);
    }

    public void deleteOutput(long taskId, String userId) {
        taskInstanceService.deleteOutput(taskId, userId);
    }

    public void exit(long taskId, String userId) {
        taskInstanceService.exit(taskId, userId);
    }

    public void fail(long taskId, String userId, FaultData faultData) {
        taskInstanceService.fail(taskId, userId, faultData);
    }

    public void forward(long taskId, String userId, String targetEntityId) {
        taskInstanceService.forward(taskId, userId, targetEntityId);
    }

    public void release(long taskId, String userId) {
        taskInstanceService.release(taskId, userId);
    }

    public void remove(long taskId, String userId) {
        taskInstanceService.remove(taskId, userId);
    }

    public void resume(long taskId, String userId) {
        taskInstanceService.resume(taskId, userId);
    }

    public void setFault(long taskId, String userId, FaultData fault) {
        taskInstanceService.setFault(taskId, userId, fault);
    }

    public void setOutput(long taskId, String userId, Object outputContentData) {
        taskInstanceService.setOutput(taskId, userId, outputContentData);
    }

    public void setPriority(long taskId, String userId, int priority) {
        taskInstanceService.setPriority(taskId, userId, priority);
    }

    public void skip(long taskId, String userId) {
        taskInstanceService.skip(taskId, userId);
    }

    public void start(long taskId, String userId) {
        taskInstanceService.start(taskId, userId);
    }

    public void stop(long taskId, String userId) {
        taskInstanceService.stop(taskId, userId);
    }

    public void suspend(long taskId, String userId) {
        taskInstanceService.suspend(taskId, userId);
    }

   
    public List<TaskSummary> getTasksAssignedAsBusinessAdministrator(String userId, String language) {
        return taskQueryService.getTasksAssignedAsBusinessAdministrator(userId, language);
    }

    public List<TaskSummary> getTasksAssignedAsExcludedOwner(String userId, String language) {
        return taskQueryService.getTasksAssignedAsExcludedOwner(userId, language);
    }

    public List<TaskSummary> getTasksAssignedAsPotentialOwner(String userId, String language) {
        return taskQueryService.getTasksAssignedAsPotentialOwner(userId, language);
    }

    public List<TaskSummary> getTasksAssignedAsPotentialOwner(String userId, List<String> groupIds, String language) {
        return taskQueryService.getTasksAssignedAsPotentialOwner(userId, groupIds, language);
    }

    public List<TaskSummary> getTasksAssignedAsPotentialOwner(String userId, List<String> groupIds, String language, int firstResult, int maxResult) {
        return taskQueryService.getTasksAssignedAsPotentialOwner(userId, groupIds, language, firstResult, maxResult);
    }

    public List<TaskSummary> getTasksAssignedAsRecipient(String userId, String language) {
        return taskQueryService.getTasksAssignedAsRecipient(userId, language);
    }

    public List<TaskSummary> getTasksAssignedAsTaskInitiator(String userId, String language) {
        return taskQueryService.getTasksAssignedAsTaskInitiator(userId, language);
    }

    public List<TaskSummary> getTasksAssignedAsTaskStakeholder(String userId, String language) {
        return taskQueryService.getTasksAssignedAsTaskStakeholder(userId, language);
    }

    public List<TaskSummary> getTasksOwned(String userId) {
        return taskQueryService.getTasksOwned(userId);
    }

    public List<TaskSummary> getTasksOwned(String userId, List<Status> status, String language) {
        return taskQueryService.getTasksOwned(userId, status, language);
    }

    public List<TaskSummary> getTasksAssignedAsPotentialOwnerByStatus(String salaboy, List<Status> status, String language) {
        return taskQueryService.getTasksAssignedAsPotentialOwnerByStatus(salaboy, status, language);
    }

    public List<TaskSummary> getTasksAssignedAsPotentialOwnerByStatusByGroup(String userId, List<String> groupIds, List<Status> status, String language) {
        return taskQueryService.getTasksAssignedAsPotentialOwnerByStatusByGroup(userId, groupIds, status, language);
    }

    public List<TaskSummary> getSubTasksAssignedAsPotentialOwner(long parentId, String userId, String language) {
        return taskQueryService.getSubTasksAssignedAsPotentialOwner(parentId, userId, language);
    }

    public List<TaskSummary> getSubTasksByParent(long parentId) {
        return taskQueryService.getSubTasksByParent(parentId);
    }

    public TaskInstance getTaskInstanceById(long taskId) {
        return taskQueryService.getTaskInstanceById(taskId);
    }

    public Content getContentById(long contentId) {
        return taskQueryService.getContentById(contentId);
    }

    public TaskInstance getTaskByWorkItemId(long workItemId) {
        return taskQueryService.getTaskByWorkItemId(workItemId);
    }

    public List<TaskEvent> getTaskEventsById(long taskId) {
        return taskEventsService.getTaskEventsById(taskId);
    }

    public long newTask(TaskDef def, Map<String, Object> params) {
        return taskInstanceService.newTask(def, params);
    }
    
    public long newTask(TaskDef def, Map<String, Object> params, boolean deploy) {
        return taskInstanceService.newTask(def, params, deploy);
    }

    public void setTaskDefService(TaskDefService taskDefService) {
        this.taskDefService = taskDefService;
    }

    public void setTaskInstanceService(TaskInstanceService taskInstanceService) {
        this.taskInstanceService = taskInstanceService;
    }

    public void setTaskIdentityService(TaskIdentityService taskIdentityService) {
        this.taskIdentityService = taskIdentityService;
    }

    public void setTaskAdminService(TaskAdminService taskAdminService) {
        this.taskAdminService = taskAdminService;
    }

    public void setTaskQueryService(TaskQueryService taskQueryService) {
        this.taskQueryService = taskQueryService;
    }

    public void setTaskEventsService(TaskEventsService taskEventsService) {
        this.taskEventsService = taskEventsService;
    }
    
    
    
}
