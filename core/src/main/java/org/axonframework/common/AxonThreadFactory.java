/*
 * Copyright (c) 2010-2014. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.common;

import java.util.concurrent.ThreadFactory;

/**
 * Thread factory that created threads in a given group.
 *
 * @author Allard Buijze
 * @since 2.0
 */
public class AxonThreadFactory implements ThreadFactory {

    private final int priority;
    private final ThreadGroup groupName;

    /**
     * Initializes a ThreadFactory instance that creates each thread in a group with given <code>groupName</code> with
     * default priority.
     *
     * @param groupName The name of the group to create each thread in
     * @see Thread#setPriority(int)
     */
    public AxonThreadFactory(String groupName) {
        this(new ThreadGroup(groupName));
    }

    /**
     * Initializes a ThreadFactory instance that create each thread in the given <code>group</code> with default
     * priority.
     *
     * @param group The ThreadGroup to create each thead in
     * @see Thread#setPriority(int)
     */
    public AxonThreadFactory(ThreadGroup group) {
        this(Thread.NORM_PRIORITY, group);
    }

    /**
     * Initializes a ThreadFactory instance that create each thread in the given <code>group</code> with given
     * <code>priority</code>.
     *
     * @param priority The priority of the threads to create
     * @param group    The ThreadGroup to create each thead in
     * @see Thread#setPriority(int)
     */
    public AxonThreadFactory(int priority, ThreadGroup group) {
        Assert.isTrue(priority <= Thread.MAX_PRIORITY && priority >= Thread.MIN_PRIORITY, "Given priority is invalid");
        this.priority = priority;
        this.groupName = group;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(groupName, r);
        thread.setPriority(priority);
        return thread;
    }
}
