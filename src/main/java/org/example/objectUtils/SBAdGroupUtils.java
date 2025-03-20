package org.example.objectUtils;

import org.openapitools.client.model.CreateAdGroup;
import org.openapitools.client.model.CreateOrUpdateEntityState;
import org.openapitools.client.model.CreateSponsoredBrandsAdGroupsRequestContent;

import static org.example.CommonUtils.generateName;

public class SBAdGroupUtils {
    public static CreateSponsoredBrandsAdGroupsRequestContent buildCreateSPAdGroupsRequestContent(final String campaignId) {
        final CreateSponsoredBrandsAdGroupsRequestContent requestContent
                = new CreateSponsoredBrandsAdGroupsRequestContent();
        requestContent.addAdGroupsItem(buildCreateAdGroup(campaignId));

        return requestContent;
    }

    private static CreateAdGroup buildCreateAdGroup(final String campaignId) {
        final CreateAdGroup adGroup = new CreateAdGroup();
        adGroup.setCampaignId(campaignId);
        adGroup.setName(generateName("SB_ADGROUP"));
        adGroup.setState(CreateOrUpdateEntityState.PAUSED);

        return adGroup;
    }
}
