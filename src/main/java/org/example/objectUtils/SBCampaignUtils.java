package org.example.objectUtils;

import org.openapitools.client.model.BudgetType;
import org.openapitools.client.model.CreateCampaign;
import org.openapitools.client.model.CreateOrUpdateEntityState;
import org.openapitools.client.model.CreateSponsoredBrandsCampaignsRequestContent;
import org.openapitools.client.model.DeleteSponsoredBrandsCampaignsRequestContent;
import org.openapitools.client.model.EntityState;
import org.openapitools.client.model.EntityStateFilter;
import org.openapitools.client.model.ListSponsoredBrandsCampaignsRequestContent;
import org.openapitools.client.model.ObjectIdFilter;
import org.openapitools.client.model.UpdateCampaign;
import org.openapitools.client.model.UpdateSponsoredBrandsCampaignsRequestContent;

import java.math.BigDecimal;
import java.util.List;

import static org.example.CommonUtils.generateName;

public class SBCampaignUtils {

    public static CreateSponsoredBrandsCampaignsRequestContent buildCreateSBCampaignsRequestContent() {
        final CreateSponsoredBrandsCampaignsRequestContent requestContent
                = new CreateSponsoredBrandsCampaignsRequestContent();
        requestContent.addCampaignsItem(buildCreateCampaign());

        return requestContent;
    }

    private static CreateCampaign buildCreateCampaign() {
        final CreateCampaign createCampaign = new CreateCampaign();
        createCampaign.setName(generateName("SB_CAMPAIGN"));
        createCampaign.setState(CreateOrUpdateEntityState.PAUSED);
        createCampaign.setBudget(100d);
        createCampaign.setBudgetType(BudgetType.LIFETIME);
        createCampaign.setStartDate("2025-05-01");
        createCampaign.setEndDate("2026-01-01");
        createCampaign.setSmartDefault(List.of("MANUAL"));
        return createCampaign;
    }

    public static UpdateSponsoredBrandsCampaignsRequestContent buildUpdateSBCampaignsRequestContent(final String campaignId) {
        final UpdateSponsoredBrandsCampaignsRequestContent requestContent
                = new UpdateSponsoredBrandsCampaignsRequestContent();
        requestContent.addCampaignsItem(buildUpdateCampaign(campaignId));

        return requestContent;
    }

    private static UpdateCampaign buildUpdateCampaign(final String campaignId) {
        final UpdateCampaign updateCampaign = new UpdateCampaign();
        updateCampaign.setCampaignId(campaignId);
        updateCampaign.setState(CreateOrUpdateEntityState.ENABLED);
        return updateCampaign;
    }

    public static DeleteSponsoredBrandsCampaignsRequestContent buildDeleteSBCampaignsRequestContent(final String campaignId) {
        final DeleteSponsoredBrandsCampaignsRequestContent requestContent
                = new DeleteSponsoredBrandsCampaignsRequestContent();

        final ObjectIdFilter idFilter = new ObjectIdFilter();
        idFilter.addIncludeItem(campaignId);

        requestContent.setCampaignIdFilter(idFilter);

        return requestContent;
    }

    public static ListSponsoredBrandsCampaignsRequestContent buildListSBCampaignsRequestContentIdFilter(
            final String campaignId) {
        final ObjectIdFilter idFilter = new ObjectIdFilter();
        idFilter.addIncludeItem(campaignId);

        final ListSponsoredBrandsCampaignsRequestContent requestContent
                = new ListSponsoredBrandsCampaignsRequestContent();
        requestContent.setCampaignIdFilter(idFilter);
        requestContent.setMaxResults(BigDecimal.valueOf(10));
        requestContent.setIncludeExtendedDataFields(true);

        return requestContent;
    }

    public static ListSponsoredBrandsCampaignsRequestContent buildListSBCampaignsRequestAllCampaigns() {
        final EntityStateFilter stateFilter = new EntityStateFilter();
        stateFilter.addIncludeItem(EntityState.ENABLED);
        stateFilter.addIncludeItem(EntityState.PAUSED);
        stateFilter.addIncludeItem(EntityState.ARCHIVED);

        final ListSponsoredBrandsCampaignsRequestContent requestContent
                = new ListSponsoredBrandsCampaignsRequestContent();
        requestContent.setStateFilter(stateFilter);
        requestContent.setMaxResults(BigDecimal.valueOf(10));
        requestContent.setIncludeExtendedDataFields(true);

        return requestContent;
    }
}
