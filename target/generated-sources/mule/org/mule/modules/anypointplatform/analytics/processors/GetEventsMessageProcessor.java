
package org.mule.modules.anypointplatform.analytics.processors;

import java.util.List;
import javax.annotation.Generated;
import org.codehaus.jettison.json.JSONArray;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.config.ConfigurationException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.registry.RegistrationException;
import org.mule.common.DefaultResult;
import org.mule.common.FailureType;
import org.mule.common.Result;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultPojoMetaDataModel;
import org.mule.common.metadata.DefaultSimpleMetaDataModel;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.OperationMetaDataEnabled;
import org.mule.common.metadata.datatype.DataType;
import org.mule.common.metadata.datatype.DataTypeFactory;
import org.mule.devkit.processor.DevkitBasedMessageProcessor;
import org.mule.modules.anypointplatform.analytics.AnypointPlatformAnalyticsConnector;
import org.mule.modules.anypointplatform.analytics.AnypointPlatformAnalyticsConnector.EventFormat;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * GetEventsMessageProcessor invokes the {@link org.mule.modules.anypointplatform.analytics.AnypointPlatformAnalyticsConnector#getEvents(java.lang.String, java.util.List, java.lang.String, java.lang.String, org.mule.modules.anypointplatform.analytics.AnypointPlatformAnalyticsConnector.EventFormat)} method in {@link AnypointPlatformAnalyticsConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-12-15T09:00:52-03:00", comments = "Build UNNAMED.2613.77421cc")
public class GetEventsMessageProcessor
    extends DevkitBasedMessageProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object apiId;
    protected String _apiIdType;
    protected Object fields;
    protected List<String> _fieldsType;
    protected Object startDate;
    protected String _startDateType;
    protected Object endDate;
    protected String _endDateType;
    protected Object format;
    protected EventFormat _formatType;

    public GetEventsMessageProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    @Override
    public void start()
        throws MuleException
    {
        super.start();
    }

    @Override
    public void stop()
        throws MuleException
    {
        super.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets apiId
     * 
     * @param value Value to set
     */
    public void setApiId(Object value) {
        this.apiId = value;
    }

    /**
     * Sets startDate
     * 
     * @param value Value to set
     */
    public void setStartDate(Object value) {
        this.startDate = value;
    }

    /**
     * Sets endDate
     * 
     * @param value Value to set
     */
    public void setEndDate(Object value) {
        this.endDate = value;
    }

    /**
     * Sets format
     * 
     * @param value Value to set
     */
    public void setFormat(Object value) {
        this.format = value;
    }

    /**
     * Sets fields
     * 
     * @param value Value to set
     */
    public void setFields(Object value) {
        this.fields = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws Exception
     */
    public MuleEvent doProcess(final MuleEvent event)
        throws Exception
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(null, false, event);
            final String _transformedApiId = ((String) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_apiIdType").getGenericType(), null, apiId));
            final List<String> _transformedFields = ((List<String> ) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_fieldsType").getGenericType(), null, fields));
            final String _transformedStartDate = ((String) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_startDateType").getGenericType(), null, startDate));
            final String _transformedEndDate = ((String) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_endDateType").getGenericType(), null, endDate));
            final EventFormat _transformedFormat = ((EventFormat) evaluateAndTransform(getMuleContext(), event, GetEventsMessageProcessor.class.getDeclaredField("_formatType").getGenericType(), null, format));
            Object resultPayload;
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class<? extends Exception>> getManagedExceptions() {
                    return null;
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((AnypointPlatformAnalyticsConnector) object).getEvents(_transformedApiId, _transformedFields, _transformedStartDate, _transformedEndDate, _transformedFormat);
                }

            }
            , this, event);
            event.getMessage().setPayload(resultPayload);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        return new DefaultResult<MetaData>(null, (Result.Status.SUCCESS));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(JSONArray.class)));
    }

    private MetaDataModel getPojoOrSimpleModel(Class clazz) {
        DataType dataType = DataTypeFactory.getInstance().getDataType(clazz);
        if (DataType.POJO.equals(dataType)) {
            return new DefaultPojoMetaDataModel(clazz);
        } else {
            return new DefaultSimpleMetaDataModel(dataType);
        }
    }

    public Result<MetaData> getGenericMetaData(MetaDataKey metaDataKey) {
        ConnectorMetaDataEnabled connector;
        try {
            connector = ((ConnectorMetaDataEnabled) findOrCreate(null, false, null));
            try {
                Result<MetaData> metadata = connector.getMetaData(metaDataKey);
                if ((Result.Status.FAILURE).equals(metadata.getStatus())) {
                    return metadata;
                }
                if (metadata.get() == null) {
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at AnypointPlatformAnalyticsConnector at getEvents retrieving was successful but result is null");
                }
                return metadata;
            } catch (Exception e) {
                return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
            }
        } catch (ClassCastException cast) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error getting metadata, there was no connection manager available. Maybe you're trying to use metadata from an Oauth connector");
        } catch (ConfigurationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (RegistrationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (IllegalAccessException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (InstantiationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (Exception e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        }
    }

}
