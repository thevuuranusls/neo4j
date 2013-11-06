/**
 * Copyright (c) 2002-2013 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.kernel.api.direct;

import org.neo4j.kernel.api.index.SchemaIndexProvider;
import org.neo4j.kernel.api.labelscan.LabelScanStore;
import org.neo4j.kernel.impl.nioneo.store.StoreAccess;

public class SimpleDirectStoreAccess implements DirectStoreAccess
{
    private final StoreAccess nativeStores;
    private final LabelScanStore labelScanStore;
    private final SchemaIndexProvider indexes;

    public SimpleDirectStoreAccess( StoreAccess nativeStores, LabelScanStore labelScanStore, SchemaIndexProvider
            indexes )
    {
        this.nativeStores = nativeStores;
        this.labelScanStore = labelScanStore;
        this.indexes = indexes;
    }

    @Override
    public StoreAccess nativeStores()
    {
        return nativeStores;
    }

    @Override
    public LabelScanStore labelScanStore()
    {
        return labelScanStore;
    }

    @Override public SchemaIndexProvider indexes()
    {
        return indexes;
    }
}