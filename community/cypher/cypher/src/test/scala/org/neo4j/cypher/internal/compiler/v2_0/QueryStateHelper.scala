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
package org.neo4j.cypher.internal.compiler.v2_0

import org.neo4j.kernel.{GraphDatabaseAPI}
import org.neo4j.cypher.internal.spi.v2_0.TransactionBoundExecutionContext
import org.neo4j.cypher.internal.compiler.v2_0.pipes.{NullDecorator, QueryState}
import org.neo4j.kernel.impl.coreapi.ThreadToStatementContextBridge

object QueryStateHelper {
  def empty = new QueryState(null, null, Map.empty, NullDecorator)

  def queryStateFrom(db: GraphDatabaseAPI) = {
    val tx = db.beginTx()
    val statement = db.getDependencyResolver.resolveDependency(classOf[ThreadToStatementContextBridge]).statement()
    new QueryState(db, new TransactionBoundExecutionContext(db, tx, statement), Map.empty, NullDecorator)
  }
}