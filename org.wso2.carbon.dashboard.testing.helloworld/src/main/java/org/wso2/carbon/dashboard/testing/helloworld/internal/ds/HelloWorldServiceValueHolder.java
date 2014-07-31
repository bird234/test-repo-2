/*
 * Copyright 2004,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.dashboard.testing.helloworld.internal.ds;

import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.dashboard.testing.helloworld.HelloWorldService;

/**
 * common place to hold some OSGI bundle references.
 */
public final class HelloWorldServiceValueHolder {

    private static HelloWorldService carbonHelloWorldService;
    private static ComponentContext componentContext;

    private HelloWorldServiceValueHolder() {
    }

    public static void registerCarbonEventService(
            HelloWorldService carbonHelloWorldService) {

        HelloWorldServiceValueHolder.carbonHelloWorldService = carbonHelloWorldService;
    }

    public static HelloWorldService getCarbonHelloWorldService() {
        return HelloWorldServiceValueHolder.carbonHelloWorldService;
    }

    public static void registerComponentContext(
            ComponentContext componentContext) {

        HelloWorldServiceValueHolder.componentContext = componentContext;
    }

    public static ComponentContext getComponentContext() {
        return HelloWorldServiceValueHolder.componentContext;
    }

}
