package org.example.objectApi;

import org.example.objectApi.CampaignsApi.CreateCampaignApi;
import org.example.objectApi.CampaignsApi.DeleteCampaignApi;
import org.example.objectApi.CampaignsApi.ListCampaignApi;
import org.example.objectApi.CampaignsApi.UpdateCampaignApi;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.CampaignsApi;
import org.openapitools.client.model.CreateSponsoredBrandsCampaignsRequestContent;
import org.openapitools.client.model.DeleteSponsoredBrandsCampaignsRequestContent;
import org.openapitools.client.model.DeleteSponsoredBrandsCampaignsResponseContent;
import org.openapitools.client.model.ListSponsoredBrandsCampaignsRequestContent;
import org.openapitools.client.model.ListSponsoredBrandsCampaignsResponseContent;
import org.openapitools.client.model.UpdateSponsoredBrandsCampaignsRequestContent;
import org.openapitools.client.model.UpdateSponsoredBrandsCampaignsResponseContent;

import java.io.IOException;
import java.util.Map;

public class CampaignsApiService {
    private final CampaignsApi campaignsApi;
    private final Map<String, String> authMap;

    public CampaignsApiService(CampaignsApi campaignsApi, Map<String, String> authMap) {
        this.campaignsApi = campaignsApi;
        this.authMap = authMap;
    }

    public String createCampaign(final CreateSponsoredBrandsCampaignsRequestContent createRequestContent) throws IOException, InterruptedException, ApiException {
        return CreateCampaignApi.createCampaign(campaignsApi, createRequestContent, authMap);
    }

    public UpdateSponsoredBrandsCampaignsResponseContent updateCampaign(final UpdateSponsoredBrandsCampaignsRequestContent updateRequestContent) throws IOException, InterruptedException, ApiException {
        return UpdateCampaignApi.updateCampaign(campaignsApi, updateRequestContent, authMap);
    }

    public DeleteSponsoredBrandsCampaignsResponseContent deleteCampaign(final DeleteSponsoredBrandsCampaignsRequestContent deleteRequestContent) throws IOException, InterruptedException, ApiException {
        return DeleteCampaignApi.deleteCampaign(campaignsApi, deleteRequestContent, authMap);
    }

    public ListSponsoredBrandsCampaignsResponseContent listCampaign(final ListSponsoredBrandsCampaignsRequestContent listRequestContent) throws IOException, InterruptedException, ApiException {
        return ListCampaignApi.listCampaign(campaignsApi, listRequestContent, authMap);
    }
}
