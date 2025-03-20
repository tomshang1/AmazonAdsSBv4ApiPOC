//package org.example.objectUtils;
//
//import org.openapitools.client.model.CreateExpressionType;
//import org.openapitools.client.model.CreateOrUpdateEntityState;
//import org.openapitools.client.model.CreateSponsoredBrandsTargetingClausesRequestContent;
//import org.openapitools.client.model.CreateTargetingClause;
//import org.openapitools.client.model.CreateTargetingExpressionPredicate;
//import org.openapitools.client.model.CreateTargetingExpressionPredicateType;
//import org.openapitools.client.model.DeleteSponsoredBrandsTargetingClausesRequestContent;
//import org.openapitools.client.model.EntityState;
//import org.openapitools.client.model.EntityStateFilter;
//import org.openapitools.client.model.ListSponsoredBrandsTargetingClausesRequestContent;
//import org.openapitools.client.model.ObjectIdFilter;
//import org.openapitools.client.model.UpdateSponsoredBrandsTargetingClausesRequestContent;
//import org.openapitools.client.model.UpdateTargetingClause;
//
//import java.util.List;
//
//public class SBTargetUtils {
//    public static CreateSponsoredBrandsTargetingClausesRequestContent buildCreateSBTargetsRequestContent(
//            final String campaignId,
//            final String adGroupId
//    ) {
//        final CreateSponsoredBrandsTargetingClausesRequestContent requestContent
//                = new CreateSponsoredBrandsTargetingClausesRequestContent();
//        requestContent.addTargetingClausesItem(createSponsoredBrandsCreateTarget(campaignId, adGroupId));
//
//        return requestContent;
//    }
//
//    private static CreateTargetingClause createSponsoredBrandsCreateTarget(
//            final String campaignId,
//            final String adGroupId) {
//        final CreateTargetingClause createTarget = new CreateTargetingClause();
//        createTarget.setState(CreateOrUpdateEntityState.PAUSED);
//        createTarget.setBid(null);
//        createTarget.setCampaignId(campaignId);
//        createTarget.setAdGroupId(adGroupId);
//        createTarget.setExpressionType(CreateExpressionType.MANUAL);
//        createTarget.setExpression(List.of(createTargetingExpressionPredicate()));
//        return createTarget;
//    }
//
//    private static CreateTargetingExpressionPredicate createTargetingExpressionPredicate() {
//        final CreateTargetingExpressionPredicate predicate = new CreateTargetingExpressionPredicate();
//        predicate.setType(CreateTargetingExpressionPredicateType.KEYWORD_GROUP_SAME_AS);
//        predicate.setValue("category");
//        return predicate;
//    }
//
//    public static UpdateSponsoredBrandsTargetingClausesRequestContent buildUpdateSBTargetsRequestContent(
//            final String targetId) {
//        final UpdateBrandsTargetingClausesRequestContent requestContent
//                = new UpdateSponsoredBrandsTargetingClausesRequestContent();
//        requestContent.addTargetingClausesItem(buildSponsoredBrandsUpdateTarget(targetId));
//
//        return requestContent;
//    }
//
//    private static UpdateTargetingClause buildSponsoredBrandsUpdateTarget(final String targetId) {
//        final UpdateTargetingClause createTarget = new UpdateTargetingClause();
//        createTarget.setState(CreateOrUpdateEntityState.ENABLED);
//        createTarget.setTargetId(targetId);
//        return createTarget;
//    }
//
//    public static DeleteSponsoredBrandsTargetingClausesRequestContent buildDeleteSBTargetsRequestContent(
//            final String targetId) {
//        final ObjectIdFilter idFilter = new ObjectIdFilter();
//        idFilter.addIncludeItem(targetId);
//
//        final DeleteSponsoredBrandsTargetingClausesRequestContent requestContent
//                = new DeleteSponsoredBrandsTargetingClausesRequestContent();
//        requestContent.setTargetIdFilter(idFilter);
//
//        return requestContent;
//    }
//
//    public static ListSponsoredBrandsTargetingClausesRequestContent buildListSBTargetsRequestContentIdFilter(
//            final String targetId
//    ) {
//        ObjectIdFilter idFilter = new ObjectIdFilter();
//        idFilter.addIncludeItem(targetId);
//
//        final ListSponsoredBrandsTargetingClausesRequestContent requestContent
//                = new ListSponsoredBrandsTargetingClausesRequestContent();
//        requestContent.setTargetIdFilter(idFilter);
//        requestContent.setMaxResults(10);
//        requestContent.setIncludeExtendedDataFields(true);
//
//        return requestContent;
//    }
//
//    public static ListSponsoredBrandsTargetingClausesRequestContent buildListSPTargetsRequestContentStateFilter() {
//        EntityStateFilter stateFilter = new EntityStateFilter();
//        stateFilter.addIncludeItem(EntityState.ENABLED);
//        stateFilter.addIncludeItem(EntityState.PAUSED);
//
//        final ListSponsoredBrandsTargetingClausesRequestContent requestContent
//                = new ListSponsoredBrandssTargetingClausesRequestContent();
//        requestContent.setStateFilter(stateFilter);
//        requestContent.setMaxResults(10);
//        requestContent.setIncludeExtendedDataFields(true);
//
//        return requestContent;
//    }
//}
