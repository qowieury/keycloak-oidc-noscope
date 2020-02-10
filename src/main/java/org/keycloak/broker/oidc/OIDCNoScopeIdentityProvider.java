/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.keycloak.broker.oidc;

import org.keycloak.models.KeycloakSession;

import java.util.Arrays;

public class OIDCNoScopeIdentityProvider extends OIDCIdentityProvider {
    public static final String SCOPE_OPENID = "";
    public OIDCNoScopeIdentityProvider(KeycloakSession session, OIDCIdentityProviderConfig config) {

        super(session, config);

        String defaultScope = config.getDefaultScope();
        String[] defaultScopeArr = defaultScope.split(" ");

        String[] newDefaultScopeArr = defaultScopeArr;
        if(defaultScopeArr[0].equals("openid")) {
            newDefaultScopeArr = Arrays.copyOfRange(defaultScopeArr, 1, defaultScopeArr.length);
        }

        String newScope = String.join(" ", newDefaultScopeArr);
        config.setDefaultScope(newScope.trim());
    }

}
