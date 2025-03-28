package org.example.objectApi.CampaignsApi;

import org.openapitools.client.ApiException;
import org.openapitools.client.api.CampaignsApi;
import org.openapitools.client.model.ListSponsoredBrandsCampaignsRequestContent;
import org.openapitools.client.model.ListSponsoredBrandsCampaignsResponseContent;

import java.io.IOException;
import java.util.Map;

import static org.example.AuthUtils.CLIENT_ID_HEADER_NAME;
import static org.example.AuthUtils.CLIENT_SECRET_HEADER_NAME;
import static org.example.AuthUtils.PROFILE_ID_HEADER_NAME;
import static org.example.AuthUtils.REFRESH_TOKEN_HEADER_NAME;
import static org.example.AuthUtils.getRefreshedToken;

public class ListCampaignApi {
    public static ListSponsoredBrandsCampaignsResponseContent listCampaign(
            final CampaignsApi campaignsApi,
            final ListSponsoredBrandsCampaignsRequestContent listRequestContent,
            final Map<String, String> authMap)
            throws IOException, InterruptedException, ApiException {
        final ListSponsoredBrandsCampaignsResponseContent listResponseContent;
        try {
            campaignsApi.getApiClient().addDefaultHeader("Authorization",
                    getRefreshedToken(authMap.get(REFRESH_TOKEN_HEADER_NAME), authMap.get(CLIENT_ID_HEADER_NAME), authMap.get(CLIENT_SECRET_HEADER_NAME)));
            listResponseContent = campaignsApi.listSponsoredBrandsCampaigns(authMap.get(CLIENT_ID_HEADER_NAME), authMap.get(PROFILE_ID_HEADER_NAME), listRequestContent);
        } catch (final ApiException e) {
            System.out.println("Exception while listing campaign: " + e.getMessage()
                    + "\n Headers: " + e.getResponseHeaders()
                    + "\n Body: " + e.getResponseBody());
            throw e;
        }

        System.out.println("List Campaigns request: " + listRequestContent + ", response: " + listResponseContent);

        return listResponseContent;
    }
}
