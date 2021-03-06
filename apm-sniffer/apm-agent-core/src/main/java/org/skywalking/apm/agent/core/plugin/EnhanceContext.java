/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
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
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking
 */

package org.skywalking.apm.agent.core.plugin;

/**
 * The <code>EnhanceContext</code> represents the context or status for processing a class.
 *
 * Based on this context, the plugin core {@link org.skywalking.apm.agent.core.plugin.interceptor.enhance.ClassEnhancePluginDefine}
 * knows how to process the specific steps for every particular plugin.
 *
 * @author wusheng
 */
public class EnhanceContext {

    /**
     * 是否完成增强
     */
    private boolean isEnhanced = false;
    /**
     * 是否已经实现 {@link org.skywalking.apm.agent.core.plugin.interceptor.enhance.EnhancedInstance} 接口
     *
     * 通过 `byte-buddy` 改写实现
     *
     * The object has already been enhanced or extended.
     * e.g. added the new field, or implemented the new interface
     */
    private boolean objectExtended = false;

    public boolean isEnhanced() {
        return isEnhanced;
    }

    public void initializationStageCompleted() {
        isEnhanced = true;
    }

    public boolean isObjectExtended() {
        return objectExtended;
    }

    public void extendObjectCompleted() {
        objectExtended = true;
    }
}
