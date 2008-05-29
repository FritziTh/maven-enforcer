/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.maven.plugins.enforcer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.enforcer.rule.api.EnforcerRuleException;
import org.apache.maven.plugin.logging.Log;

// TODO: Auto-generated Javadoc
/**
 * This rule checks that no snapshots are included.
 * 
 * @author <a href="mailto:brianf@apache.org">Brian Fox</a>
 * @version $Id$
 */
public class RequireReleaseDeps
    extends AbstractBanDependencies
{

    /**
     * Checks the set of dependencies to see if any snapshots are included.
     * 
     * @param dependencies the dependencies
     * @param log the log
     * @return the sets the
     * @throws EnforcerRuleException the enforcer rule exception
     */
    protected Set checkDependencies( Set dependencies, Log log )
        throws EnforcerRuleException
    {
        Set foundExcludes = new HashSet();

        Iterator DependencyIter = dependencies.iterator();
        while ( DependencyIter.hasNext() )
        {
            Artifact artifact = (Artifact) DependencyIter.next();

            if ( artifact.isSnapshot() )
            {
                foundExcludes.add( artifact );
            }
        }

        return foundExcludes;
    }
}