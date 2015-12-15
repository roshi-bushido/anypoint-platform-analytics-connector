
package org.mule.modules.anypointplatform.analytics.transformers;

import javax.annotation.Generated;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.modules.anypointplatform.analytics.AnypointPlatformAnalyticsConnector.EventFormat;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-12-15T09:00:52-03:00", comments = "Build UNNAMED.2613.77421cc")
public class AnypointPlatformAnalyticsConnectorEventFormatEnumTransformer
    extends AbstractTransformer
    implements DiscoverableTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;

    public AnypointPlatformAnalyticsConnectorEventFormatEnumTransformer() {
        registerSourceType(DataTypeFactory.create(String.class));
        setReturnClass(EventFormat.class);
        setName("AnypointPlatformAnalyticsConnectorEventFormatEnumTransformer");
    }

    protected Object doTransform(Object src, String encoding)
        throws TransformerException
    {
        EventFormat result = null;
        result = Enum.valueOf(EventFormat.class, ((String) src));
        return result;
    }

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

}
