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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jetty.server.Server;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.dashboard.testing.helloworld.HelloWorldService;
import org.wso2.carbon.dashboard.testing.helloworld.internal.CarbonHelloWorldService;

/**
 * @scr.component name="dashboard.helloworld.service.component" immediate="true"
 */


public class HelloWorldServiceDS {

    private static final Log log = LogFactory.getLog(HelloWorldServiceDS.class);

    /**
     * initialize the cep service here.
     *
     * @param context
     */
    protected void activate(ComponentContext context) {

        try {
            Server server = new Server();
            HelloWorldService helloWorldService = (HelloWorldService) new CarbonHelloWorldService();
            HelloWorldServiceValueHolder.registerCarbonEventService(helloWorldService);

            context.getBundleContext().registerService(HelloWorldService.class.getName(), helloWorldService, null);
            HelloWorldServiceValueHolder.registerComponentContext(context);
            log.info("hello world deplyed");
            if (log.isDebugEnabled()) {
                log.debug("Successfully deployed hello world as an OSGI service");
            }
           // registerEventAdaptorTypes();
        } catch (RuntimeException e) {
            log.error("Can not deploy hello world as an OSGI service ", e);
        } catch (Exception e){
            log.error("hello world start-up failed",e);
        } catch (Throwable e){
            log.error("hello world start-up failed", e);
        }
    }

/*    public void setEventStatisticsService(EventStatisticsService eventStatisticsService) {
        HelloWorldServiceValueHolder.registerEventStatisticsService(eventStatisticsService);
    }

    public void unsetEventStatisticsService(EventStatisticsService eventStatisticsService) {
        HelloWorldServiceValueHolder.registerEventStatisticsService(null);
    }*/

/*    private void registerEventAdaptorTypes() {

        List<InputEventAdaptorFactory> inputEventAdaptorFactories = InputEventAdaptorServiceTrackerDS.inputEventAdaptorFactories;

        for (InputEventAdaptorFactory inputEventAdaptorFactory : inputEventAdaptorFactories) {
            ((org.wso2.carbon.event.input.adaptor.core.internal.CarbonHelloWorldService) InputEventAdaptorServiceValueHolder.getCarbonInputEventAdaptorService()).registerEventAdaptor(inputEventAdaptorFactory.getEventAdaptor());
        }
    }*/


}
