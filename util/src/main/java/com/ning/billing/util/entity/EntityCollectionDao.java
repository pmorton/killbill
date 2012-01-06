/*
 * Copyright 2010-2011 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.util.entity;

import org.skife.jdbi.v2.sqlobject.*;

import java.util.List;

/**
 * provides consistent semantics for entity collections
 * note: this is intended to be extended by an interface which provides @ExternalizedSqlViaStringTemplate3 and mappers
 * @param <T>
 */
public interface EntityCollectionDao<T extends Entity> {
    @SqlBatch
    public void save(@Bind("objectId") final String objectId,
                     @Bind("objectType") final String objectType,
                     @BindBean final List<T> entities);

    @SqlUpdate
    public void clear(@Bind("objectId") final String objectId,
                      @Bind("objectType") final String objectType);

    @SqlQuery
    public List<T> load(@Bind("objectId") final String objectId,
                        @Bind("objectType") final String objectType);

    @SqlUpdate
    public void test();
}
