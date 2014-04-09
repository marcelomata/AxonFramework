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

package org.axonframework.auditing;

import org.axonframework.commandhandling.CommandMessage;

import java.util.Collections;
import java.util.Map;

/**
 * Implementation of {@link org.axonframework.auditing.AuditDataProvider} that provides no information (empty map).
 *
 * @author Allard Buijze
 * @since 0.7
 */
public class EmptyDataProvider implements AuditDataProvider {

    /**
     * Returns a singleton instance to this data provider.
     */
    public static final EmptyDataProvider INSTANCE = new EmptyDataProvider();

    /**
     * {@inheritDoc}
     * <p/>
     * This implementation returns an empty map.
     */
    @Override
    public Map<String, Object> provideAuditDataFor(CommandMessage<?> command) {
        return Collections.emptyMap();
    }
}
