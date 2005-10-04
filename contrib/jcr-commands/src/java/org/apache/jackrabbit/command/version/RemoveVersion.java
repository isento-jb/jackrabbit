/*
 * Copyright 2004-2005 The Apache Software Foundation or its licensors,
 *                     as applicable.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jackrabbit.command.version;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.jackrabbit.command.CommandHelper;

/**
 * remove a version from the versio history
 */
public class RemoveVersion implements Command
{
    /** logger */
    private static Log log = LogFactory.getLog(RemoveVersion.class);

    // ---------------------------- < keys >
    /** node path */
    private String pathKey = "path";

    /** version label key */
    private String nameKey = "name";

    /**
     * @inheritDoc
     */
    public boolean execute(Context ctx) throws Exception
    {
        String path = (String) ctx.get(this.pathKey);
        String versionName = (String) ctx.get(this.nameKey);
        if (log.isDebugEnabled())
        {
            log.debug("Remove version " + versionName + " from node " + path);
        }
        CommandHelper.getNode(ctx, path).getVersionHistory().removeVersion(
            versionName);
        return false;
    }

    /**
     * @return Returns the pathKey.
     */
    public String getPathKey()
    {
        return pathKey;
    }

    /**
     * @param pathKey
     *            The pathKey to set.
     */
    public void setPathKey(String pathKey)
    {
        this.pathKey = pathKey;
    }

    /**
     * @return Returns the versionNameKey.
     */
    public String getNameKey()
    {
        return nameKey;
    }

    /**
     * @param versionNameKey
     *            The versionNameKey to set.
     */
    public void setNameKey(String versionNameKey)
    {
        this.nameKey = versionNameKey;
    }
}
