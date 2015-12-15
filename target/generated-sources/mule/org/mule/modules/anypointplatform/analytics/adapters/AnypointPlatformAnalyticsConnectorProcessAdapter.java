
package org.mule.modules.anypointplatform.analytics.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.anypointplatform.analytics.AnypointPlatformAnalyticsConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>AnypointPlatformAnalyticsConnectorProcessAdapter</code> is a wrapper around {@link AnypointPlatformAnalyticsConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-12-15T09:00:52-03:00", comments = "Build UNNAMED.2613.77421cc")
public class AnypointPlatformAnalyticsConnectorProcessAdapter
    extends AnypointPlatformAnalyticsConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<AnypointPlatformAnalyticsConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, AnypointPlatformAnalyticsConnectorCapabilitiesAdapter> getProcessTemplate() {
        final AnypointPlatformAnalyticsConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,AnypointPlatformAnalyticsConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, AnypointPlatformAnalyticsConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, AnypointPlatformAnalyticsConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
