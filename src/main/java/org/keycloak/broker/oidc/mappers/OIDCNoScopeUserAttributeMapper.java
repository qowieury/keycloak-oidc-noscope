package org.keycloak.broker.oidc.mappers;

import org.keycloak.broker.oidc.OIDCNoScopeIdentityProviderFactory;

public class OIDCNoScopeUserAttributeMapper extends UserAttributeMapper {
    public static final String[] COMPATIBLE_PROVIDERS = {OIDCNoScopeIdentityProviderFactory.PROVIDER_ID};

    @Override
    public String[] getCompatibleProviders() {
        return COMPATIBLE_PROVIDERS;
    }

    @Override
    public String getId() {
        return "oidc-noscope-user-attribute-mapper";
    }
}
