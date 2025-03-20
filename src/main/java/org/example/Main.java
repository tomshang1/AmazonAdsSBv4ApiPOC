package org.example;
import org.apache.commons.lang3.StringUtils;
import org.example.objectApi.AdGroupsApiService;
import org.example.objectApi.CampaignsApiService;
import org.openapitools.client.ApiException;
import org.openapitools.client.model.DeleteSponsoredBrandsCampaignsResponseContent;
import org.openapitools.client.model.EntityState;
import org.openapitools.client.model.ListSponsoredBrandsCampaignsResponseContent;
import org.openapitools.client.model.UpdateSponsoredBrandsCampaignsResponseContent;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import static org.example.AuthUtils.CLIENT_ID_HEADER_NAME;
import static org.example.AuthUtils.CLIENT_SECRET_HEADER_NAME;
import static org.example.AuthUtils.PROFILE_ID_HEADER_NAME;
import static org.example.AuthUtils.REFRESH_TOKEN_HEADER_NAME;
import static org.example.AuthUtils.getAccessTokenMap;
import static org.example.AuthUtils.getAdGroupsApi;
import static org.example.AuthUtils.getCampaignsApi;
import static org.example.AuthUtils.getProfileId;
import static org.example.AuthUtils.getRefreshedToken;
import static org.example.objectUtils.SBCampaignUtils.buildCreateSBCampaignsRequestContent;
import static org.example.objectUtils.SBCampaignUtils.buildDeleteSBCampaignsRequestContent;
import static org.example.objectUtils.SBCampaignUtils.buildListSBCampaignsRequestContentIdFilter;
import static org.example.objectUtils.SBCampaignUtils.buildUpdateSBCampaignsRequestContent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Main {
    // TO BE SET BY USER
    private final static String AUTH_CODE = null; // Change with new auth code to fetch profileId or refresh token
    private final static String PROFILE_ID_SCOPE = null; // Set this to fetched profileId! Don't need to refresh this
    public final static String REFRESH_TOKEN = null; // Set this with fetched refresh token! Don't need to refresh this
    private final static String CLIENT_ID = null; // Get from LWA account
    private final static String CLIENT_SECRET = null; // Get from LWA account
    // END

    private static final Map<String, String> AUTH_MAP = Map.of(
            CLIENT_ID_HEADER_NAME, CLIENT_ID,
            CLIENT_SECRET_HEADER_NAME, CLIENT_SECRET,
            PROFILE_ID_HEADER_NAME, PROFILE_ID_SCOPE,
            REFRESH_TOKEN_HEADER_NAME, REFRESH_TOKEN
    );

    private static final CampaignsApiService campaignsApiService = new CampaignsApiService(getCampaignsApi(), AUTH_MAP);
    private static final AdGroupsApiService adGroupsApiService = new AdGroupsApiService(getAdGroupsApi(), AUTH_MAP);
    //private static final TargetsApiService targetsApiService = new TargetsApiService(getTargetsApi(), AUTH_MAP);


    private static void testCampaignApiFunctionality() throws IOException, InterruptedException, ApiException {
        // Create Campaign with paused state
        final String campaignId = campaignsApiService.createCampaign(buildCreateSBCampaignsRequestContent());

        // Query Campaign
        final ListSponsoredBrandsCampaignsResponseContent listResponseContent
                = campaignsApiService.listCampaign(buildListSBCampaignsRequestContentIdFilter(campaignId));
        assertEquals(1, Objects.requireNonNull(listResponseContent.getCampaigns()).size());
        assertEquals(EntityState.PAUSED, Objects.requireNonNull(listResponseContent.getCampaigns()).get(0).getState());

        // Update Campaign with enabled state
        final UpdateSponsoredBrandsCampaignsResponseContent updateResponseContent
                = campaignsApiService.updateCampaign(buildUpdateSBCampaignsRequestContent(campaignId));
        assertNotNull(updateResponseContent.getCampaigns().getSuccess());
        assertEquals(1, updateResponseContent.getCampaigns().getSuccess().size());

        // Query Campaign
        final ListSponsoredBrandsCampaignsResponseContent updatedListResponseContent
                = campaignsApiService.listCampaign(buildListSBCampaignsRequestContentIdFilter(campaignId));
        assertEquals(1, Objects.requireNonNull(updatedListResponseContent.getCampaigns()).size());
        assertEquals(EntityState.ENABLED, Objects.requireNonNull(updatedListResponseContent.getCampaigns()).get(0).getState());

        // Delete Campaign with archived state
        final DeleteSponsoredBrandsCampaignsResponseContent deleteResponseContent
                = campaignsApiService.deleteCampaign(buildDeleteSBCampaignsRequestContent(campaignId));
        assertNotNull(deleteResponseContent.getCampaigns().getSuccess());
        assertEquals(1, deleteResponseContent.getCampaigns().getSuccess().size());

        // Query Campaign
        final ListSponsoredBrandsCampaignsResponseContent deletedListResponseContent
                = campaignsApiService.listCampaign(buildListSBCampaignsRequestContentIdFilter(campaignId));
        assertEquals(1, Objects.requireNonNull(updatedListResponseContent.getCampaigns()).size());
        assertNotNull(deletedListResponseContent.getCampaigns()); // Archived campaign does not show up in list call
    }

    // TODO: Implement targets
    // Targets APIs have a separate SDK for SB only, so for POC purposes, all SB targets implementation has been commented out
//    private static void testTargetApiFunctionality() throws IOException, InterruptedException, ApiException {
//        // Create Campaign with paused state
//        final String campaignId = campaignsApiService.createCampaign(buildCreateSBCampaignsRequestContent());
//
//        // Create AdGroup with paused state
//        final String adGroupId = adGroupsApiService.createAdGroup(buildCreateSBAdGroupRequestContent());
//
//        // Create Target with paused state
//        final String targetId = targetsApiService.createTarget(buildCreateSBTargetRequestContent());
//
//        // Query Target
//        final ListSponsoredBrandsTargetsResponseContent listResponseContent
//                = targetsApiService.listTarget(buildListSBTargetsRequestContentIdFilter(targetId));
//        assertEquals(1, Objects.requireNonNull(listResponseContent.getTargets()).size());
//        assertEquals(EntityState.PAUSED, Objects.requireNonNull(listResponseContent.getTargets()).get(0).getState());
//
//        // Update Target with enabled state
//        final UpdateSponsoredBrandsTargetsResponseContent updateResponseContent
//                = targetsApiService.updateTarget(buildUpdateSBTargetsRequestContent(targetId));
//        assertNotNull(updateResponseContent.getTargets().getSuccess());
//        assertEquals(1, updateResponseContent.getTargets().getSuccess().size());
//
//        // Query Target
//        final ListSponsoredBrandsTargetsResponseContent updatedListResponseContent
//                = targetsApiService.listTarget(buildListSBTargetsRequestContentIdFilter(targetId));
//        assertEquals(1, Objects.requireNonNull(updatedListResponseContent.getTargets()).size());
//        assertEquals(EntityState.ENABLED, Objects.requireNonNull(updatedListResponseContent.getTargets()).get(0).getState());
//
//        // Delete Target with archived state
//        final DeleteSponsoredBrandsTargetsResponseContent deleteResponseContent
//                = targetsApiService.deleteTarget(buildDeleteSBTargetsRequestContent(targetId));
//        assertNotNull(deleteResponseContent.getTargets().getSuccess());
//        assertEquals(1, deleteResponseContent.getTargets().getSuccess().size());
//
//        // Query Target
//        final ListSponsoredBrandsTargetsResponseContent deletedListResponseContent
//                = targetsApiService.listTarget(buildListSBTargetsRequestContentIdFilter(targetId));
//        assertEquals(1, Objects.requireNonNull(updatedListResponseContent.getTargets()).size());
//        assertNotNull(deletedListResponseContent.getTargets()); // Archived target does not show up in list call
//    // Delete Campaign with archived state
//    final DeleteSponsoredBrandsCampaignsResponseContent deleteResponseContent
//            = campaignsApiService.deleteCampaign(buildDeleteSBCampaignsRequestContent(campaignId));
//    assertNotNull(deleteResponseContent.getCampaigns().getSuccess());
//    assertEquals(1, deleteResponseContent.getCampaigns().getSuccess().size());
//    }

    public static void main(String[] args) throws IOException, InterruptedException, ApiException {
        if (StringUtils.isBlank(REFRESH_TOKEN)) {
            final Map<String, String> tokenMap = getAccessTokenMap(AUTH_CODE, CLIENT_ID, CLIENT_SECRET);
            System.out.println("PLEASE ADD VALUE TO REFRESH_TOKEN and try again: " + tokenMap.get(REFRESH_TOKEN_HEADER_NAME));
            return; // if refreshToken is not set, fetch it, print it to console, and return (since auth code can only be used once)
        }

        if (StringUtils.isBlank(PROFILE_ID_SCOPE)) {
            final String profileId = getProfileId(getRefreshedToken(REFRESH_TOKEN, CLIENT_ID, CLIENT_SECRET), CLIENT_ID);
            System.out.println("PLEASE ADD VALUE TO PROFILE_ID_SCOPE and try again: " + profileId);
            return; // if profileId is not set, fetch it, print it to console, and return (since auth code can only be used once)
        }

        testCampaignApiFunctionality();
//        testTargetApiFunctionality();
    }
}