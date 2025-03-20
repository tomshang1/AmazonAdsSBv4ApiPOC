//package org.example.objectApi;
//
//import org.example.objectApi.TargetsApi.CreateTargetApi;
//import org.example.objectApi.TargetsApi.DeleteTargetApi;
//import org.example.objectApi.TargetsApi.ListTargetApi;
//import org.example.objectApi.TargetsApi.UpdateTargetApi;
//import org.openapitools.client.ApiException;
//import org.openapitools.client.api.TargetingClausesApi;
//import org.openapitools.client.model.CreateSponsoredBrandsTargetingClausesRequestContent;
//import org.openapitools.client.model.DeleteSponsoredBrandsTargetingClausesRequestContent;
//import org.openapitools.client.model.DeleteSponsoredBrandsTargetingClausesResponseContent;
//import org.openapitools.client.model.ListSponsoredBrandsTargetingClausesRequestContent;
//import org.openapitools.client.model.ListSponsoredBrandsTargetingClausesResponseContent;
//import org.openapitools.client.model.UpdateSponsoredBrandsTargetingClausesRequestContent;
//import org.openapitools.client.model.UpdateSponsoredBrandsTargetingClausesResponseContent;
//
//import java.io.IOException;
//import java.util.Map;
//
//public class TargetsApiService {
//    private final TargetingClausesApi targetsApi;
//    private final Map<String, String> authMap;
//
//    public TargetsApiService(TargetingClausesApi targetsApi, Map<String, String> authMap) {
//        this.targetsApi = targetsApi;
//        this.authMap = authMap;
//    }
//
//    public String createTarget(final CreateSponsoredBrandsTargetingClausesRequestContent createRequestContent) throws IOException, InterruptedException, ApiException {
//        return CreateTargetApi.createTarget(targetsApi, createRequestContent, authMap);
//    }
//
//    public UpdateSponsoredBrandsTargetingClausesResponseContent updateTarget(final UpdateSponsoredBrandsTargetingClausesRequestContent updateRequestContent) throws IOException, InterruptedException, ApiException {
//        return UpdateTargetApi.updateTarget(targetsApi, updateRequestContent, authMap);
//    }
//
//    public DeleteSponsoredBrandsTargetingClausesResponseContent deleteTarget(final DeleteSponsoredBrandsTargetingClausesRequestContent deleteRequestContent) throws IOException, InterruptedException, ApiException {
//        return DeleteTargetApi.deleteTarget(targetsApi, deleteRequestContent, authMap);
//    }
//
//    public ListSponsoredBrandsTargetingClausesResponseContent listTarget(final ListSponsoredBrandsTargetingClausesRequestContent listRequestContent) throws IOException, InterruptedException, ApiException {
//        return ListTargetApi.listTarget(targetsApi, listRequestContent, authMap);
//    }
//}
